package de.ckraus.services.client.executors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 *
 * @param <I> RequestEntity Bean
 * @param <O> ResponseEntity Type
 */
public interface ServiceExecutor<I, O> {

    /**
     * callService
     * @return
     */
    ResponseEntity<O> callService();

    /**
     * execute
     * @param mapContainerParams
     * @param <T>
     * @return
     */
    <T> T execute( Map<String, ?> mapContainerParams );

    /**
     * getContainerParams
     * @return
     */
    Map<String, Object> getContainerParams();

    /**
     * getHttpStatus
     * @return
     */
    HttpStatus getHttpStatus();

    /**
     * getServiceArgs
     * @return
     */
    Object[] getServiceArgs();

    /**
     * isExecuted
     * @return
     */
    boolean isExecuted();

    /**
     * isExecuteSuccessfully
     * @return
     */
    boolean isExecuteSuccessfully();

    /**
     * isReallyPerformService
     * @return
     */
    boolean isReallyPerformService();

    /**
     * getRequestEntityBean
     * @return
     */
    I getRequestEntityBean();

    /**
     * getResponseEntityBean
     * @return
     */
    O getResponseEntityBean();

    /**
     * getResponseEntityType
     * @return
     */
    Class<O> getResponseEntityType();

}
