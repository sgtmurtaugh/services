package de.ckraus.services.client.executors_old;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Getter
@Setter( AccessLevel.PROTECTED)
public abstract class AbstractRespondServiceExecutor<O> extends AbstractServiceExecutor implements RespondServiceExecutor<O> {

    private O responseEntityBean;


    /**
     * init
     */
    protected void init( Map<String, Object> mapContainerParams ) {
        super.init( mapContainerParams );
    }

    /**
     * reset
     */
    protected void reset() {
        super.reset();

        this.setResponseEntityBean((O) null);
    }

//    /**
//     * execute
//     * @param mapContainerParams
//     * @return
//     */
//    public <T> T execute( Map<String, Object> mapContainerParams ) {
//        this.init(mapContainerParams);
//
//        T t = null;
//
//        ResponseEntity<O> responseEntity;
//
//        if ( this.isReallyPerformService() ) {
//            try {
//                responseEntity = this.callService();
//            } catch ( HttpServerErrorException hsee ) {
//                responseEntity = new ResponseEntity<>( null, hsee.getStatusCode() );
//                this.setThrowable(hsee);
//                hsee.printStackTrace();
//                // TODO
//            } catch ( RestClientException rce ) {
//                responseEntity = new ResponseEntity<>( null, HttpStatus.NOT_ACCEPTABLE );
//                this.setThrowable(rce);
//                rce.printStackTrace();
//                // TODO
//            }
//
//            // set Execution Flag
//            this.setExecuted( true );
//
//            // set HttpStatus
//            this.setHttpStatus(responseEntity);
//
//            // set ResponseEntity Bean
//            this.setResponseEntityBean(responseEntity);
//
//            // set Execution status by occured exception or returned HttpStatus
//            if ( null != this.getThrowable() ) {
//                this.setExecutedSuccessfully( Boolean.FALSE );
//            }
//            else {
//                this.setExecutedSuccessfully( this.getHttpStatus() );
//            }
//
//            // handle Service Response
//            t = handleServiceResponse();
//
//            // at least (after handleServiceResponse) store ResponseEntity Bean to scope
//            this.storeResponseEntityBean();
//        }
//        return t;
//    }

    @Tolerate
    protected void setResponseEntityBean(ResponseEntity<O> responseEntity) {
        if (null == responseEntity) {
            // TODO
        }
        else {
            this.setResponseEntityBean( responseEntity.getBody() );
        }
    }

    /**
     * TODO
     * @param <T>
     * @return
     */
    protected abstract <T> T handleServiceResponse();

    /**
     * storeResponseEntityBean
     * <p>Hook method</p>
     */
    public void storeResponseEntityBean() {
        if ( this.isExecuted()
                && this.isExecutedSuccessfully() ) {


        }
    }

}
