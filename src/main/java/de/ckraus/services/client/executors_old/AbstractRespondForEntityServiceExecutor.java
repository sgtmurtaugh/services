package de.ckraus.services.client.executors_old;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter( AccessLevel.PROTECTED)
public abstract class AbstractRespondForEntityServiceExecutor<O> extends AbstractRespondServiceExecutor<O> implements RespondForEntityServiceExecutor<O> {

    private HttpStatus httpStatus;


    /**
     * reset
     */
    protected void reset() {
        super.reset();

        this.setHttpStatus((HttpStatus) null);
    }

//    /**
//     * execute
//     * @param mapContainerParams
//     * @param <T>
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

}
