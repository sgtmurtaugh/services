package de.ckraus.services.client.executors_old;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;

import java.util.Map;

/**
 *
 * @param <I> RequestEntity Bean
 * @param <O> ResponseEntity Type
 */
@Getter
@Setter( AccessLevel.PROTECTED )
@SuppressWarnings({"WeakerAccess"})
public abstract class AbstractExchangeServiceExecutor<I, O> extends AbstractRespondForEntityServiceExecutor<O> implements ExchangeServiceExecutor<I, O> {

//    private Map<String, Object> containerParams;
//    private Throwable throwable;
//    private boolean executed;
//    private boolean executedSuccessfully;

    @Setter(AccessLevel.NONE)
    private final HttpMethod httpMethod;

    private HttpStatus httpStatus;
    private I requestEntityBean;
    private O responseEntityBean;
    private Object[] serviceArgs;


    /**
     * Constructor
     * @param httpMethod
     */
    public AbstractExchangeServiceExecutor(HttpMethod httpMethod) {
        super();
        this.httpMethod = httpMethod;
    }


    /**
     * init
     */
    protected void init( Map<String, ?> mapContainerParams ) {
        this.reset();
        this.initRequestEntityBean();
    }

    /**
     * initRequestEntityBean
     */
    protected abstract void initRequestEntityBean();

    /**
     * reset
     */
    protected void reset() {
        this.setContainerParams(null);
        this.setThrowable(null);
        this.setExecuted(false);
        this.setExecutedSuccessfully(false);
        this.setHttpStatus( ( HttpStatus ) null);
        this.setRequestEntityBean(null);
        this.setResponseEntityBean((O) null);
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

        ResponseEntity<O> responseEntity;

        if ( this.isReallyPerformService() ) {
            try {
                responseEntity = this.callService();
            } catch ( HttpServerErrorException hsee ) {
                responseEntity = new ResponseEntity<>( null, hsee.getStatusCode() );
                this.setThrowable(hsee);
                hsee.printStackTrace();
                // TODO
            } catch ( RestClientException rce ) {
                responseEntity = new ResponseEntity<>( null, HttpStatus.NOT_ACCEPTABLE );
                this.setThrowable(rce);
                rce.printStackTrace();
                // TODO
            }

            // set Execution Flag
            this.setExecuted( true );

            // set HttpStatus
            this.setHttpStatus(responseEntity);

            // set ResponseEntity Bean
            this.setResponseEntityBean(responseEntity);

            // set Execution status by occured exception or returned HttpStatus
            if ( null != this.getThrowable() ) {
                this.setExecutedSuccessfully( Boolean.FALSE );
            }
            else {
                this.setExecutedSuccessfully( this.getHttpStatus() );
            }

            // handle Service Response
            t = handleServiceResponse();

            // at least (after handleServiceResponse) store ResponseEntity Bean to scope
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
            // nothing to do...
        }
        else
        if (httpStatus.is5xxServerError()) {
            // nothing to do...
        }
        else {
            // nothing to do...
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

    @Tolerate
    protected void setResponseEntityBean(ResponseEntity<O> responseEntity) {
        O o = null;

        if (null == responseEntity) {
// TODO
        }
        else {
            this.setResponseEntityBean( o = responseEntity.getBody() );
        }
    }

    /**
     * TODO
     * @param <T>
     * @return
     */
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
