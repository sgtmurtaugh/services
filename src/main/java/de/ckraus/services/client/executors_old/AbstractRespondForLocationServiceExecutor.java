package de.ckraus.services.client.executors_old;

import java.net.URI;

public abstract class AbstractRespondForLocationServiceExecutor extends AbstractRespondServiceExecutor<URI> implements RespondForLocationServiceExecutor {


//    /**
//     * execute
//     * @param mapContainerParams
//     * @return
//     */
//    public URI execute( Map<String, Object> mapContainerParams ) {
//        this.init(mapContainerParams);
//
//        URI uri = null;
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

    /**
     * TODO
     * @param <T>
     * @return
     */
    protected abstract <T> T handleServiceResponse();

}
