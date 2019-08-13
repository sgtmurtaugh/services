package de.ckraus.services.client.executors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 *
 * @param <I> RequestEntity Bean
 * @param <O> ResponseEntity Type
 */
@Getter
@Setter( AccessLevel.PROTECTED )
@SuppressWarnings({"WeakerAccess"})
public abstract class AbstractServiceExecutor<I, O> implements ServiceExecutor<I, O> {

    private Map<String, Object> containerParams;
    private boolean executed;
    private boolean executedSuccessfully;
    private HttpStatus httpStatus;
    private I requestEntityBean;
    private O responseEntityBean;
    private Object[] serviceArgs;

    /**
     * init
     */
    protected void init( Map<String, ?> mapContainerParams ) {
        this.reset();
    }

    /**
     * reset
     */
    protected void reset() {
        this.setContainerParams(null);
        this.setExecuted(false);
        this.setExecutedSuccessfully(false);
        this.setHttpStatus( ( HttpStatus ) null);
        this.setRequestEntityBean(null);
        this.setRequestEntityBean(null);
        this.setServiceArgs(null);
    }

    /**
     * execute
     * @param mapContainerParams
     * @param <T>
     * @return
     */
    public <T> T execute( Map<String, ?> mapContainerParams ) {
        this.init(mapContainerParams);

        T t = null;

        if ( this.isReallyPerformService() ) {
            ResponseEntity<O> responseEntity = this.callService();

            // set Execution Flag
            this.setExecuted( true );

            // set HttpStatus
            this.setHttpStatus(responseEntity);

            // set Execution status
            this.setExecutedSuccessfully( this.getHttpStatus() );

            // handle Service Response
            t = handleServiceResponse();

            // store ResponseEntity Bean to Scope
            this.storeResponseEntityBean();
        }
        return t;
    }

    @Tolerate
    protected void setExecutedSuccessfully( HttpStatus httpStatus ) {
        boolean bIsExecutedSuccessfully = false;

        if (null == httpStatus) {
            httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
        }

        if (httpStatus.is1xxInformational()) {
            bIsExecutedSuccessfully = true;
        }
        else
        if (httpStatus.is2xxSuccessful()) {
            bIsExecutedSuccessfully = true;
        }
        else
        if (httpStatus.is3xxRedirection()) {
            bIsExecutedSuccessfully = true;
        }
        else
        if (httpStatus.is4xxClientError()) {
            bIsExecutedSuccessfully = false;
        }
        else
        if (httpStatus.is5xxServerError()) {
            bIsExecutedSuccessfully = false;
        }
        else {
            bIsExecutedSuccessfully = false;
        }

        this.setExecutedSuccessfully( bIsExecutedSuccessfully );
    }

    @Tolerate
    protected void setHttpStatus(ResponseEntity<O> responseEntity) {
        if (null == responseEntity) {

        }
        else {
            HttpStatus httpStatus = responseEntity.getStatusCode();

            if (null == httpStatus) {

            }
            else {
                this.setHttpStatus( httpStatus );
            }
        }
    }

    protected abstract <T> T handleServiceResponse();

    /**
     * isReallyPerformService
     * @return
     */
    public boolean isReallyPerformService() {
        return ( !this.isExecuted() );
    }

    /**
     * storeResponseEntityBean
     */
    public void storeResponseEntityBean() {
        if ( this.isExecuted()
                && this.isExecutedSuccessfully() ) {


        }
    }
}
