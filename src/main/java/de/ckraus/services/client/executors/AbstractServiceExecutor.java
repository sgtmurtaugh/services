package de.ckraus.services.client.executors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

import java.util.Map;

@Getter
@Setter( AccessLevel.PROTECTED)
public abstract class AbstractServiceExecutor<O> implements ServiceExecutor<O> {

    private Map<String, Object> params;
    private boolean executed;
    private boolean failed;
    private O responseEntity;
    private Class<O> responseType;
    private Object[] serviceArgs;
    private Throwable throwable;

    /**
     *
     * @param mapContainerParams
     */
    protected void init( Map<String, Object> mapContainerParams ) {
        this.reset();

        this.setParams( mapContainerParams );
    }

    /**
     *
     */
    protected void reset() {
        this.setParams(null);
        this.setExecuted(false);
        this.setFailed(false);
        this.setResponseEntity(null);
        this.setServiceArgs(null);
        this.setThrowable(null);
    }

    @Override
    public boolean isReallyPerformService() {
        return (!this.isExecuted());
    }

    /**
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> T execute() {
        return this.execute(null);
    }

    /**
     *
     * @param mapContainerParams
     * @param <T>
     * @return
     */
    public <T> T execute( Map<String, Object> mapContainerParams ) {
        this.init(mapContainerParams);

        T t = null;

        O oResponseEntity;

        if ( this.isReallyPerformService() ) {
            try {
                oResponseEntity = this.callService();
            } catch ( HttpServerErrorException hsee ) {
                oResponseEntity = new ResponseEntity<>( null, hsee.getStatusCode() );
                this.setThrowable(hsee);
                hsee.printStackTrace();
                // TODO
            } catch ( RestClientException rce ) {
                oResponseEntity = new ResponseEntity<>( null, HttpStatus.NOT_ACCEPTABLE );
                this.setThrowable(rce);
                rce.printStackTrace();
                // TODO
            }

            // set Execution Flag
            this.setExecuted( true );

            // set HttpStatus
            this.setHttpStatus(oResponseEntity);

            // set ResponseEntity Bean
            this.setResponseEntity(oResponseEntity);

            // set Execution status by occured exception or returned HttpStatus
            if ( ( this.isExecuted() )
                    && ( null != this.getThrowable() ) ) {

                this.setFailed( Boolean.TRUE );
            }
            else {
                this.setFailed( this.getHttpStatus() );
            }

            // handle Service Response
            t = handleServiceResponse();

            // at least (after handleServiceResponse) store ResponseEntity Bean to scope
            this.storeResponseEntityBean();
        }
        return t;
    }

    /**
     *
     */
    public void storeResponseEntityBean() {
        if ( !this.isFailed() ) {
            // TODO
        }
    }

    /**
     * TODO
     * @param <T>
     * @return
     */
    protected abstract <T> T handleServiceResponse();

}
