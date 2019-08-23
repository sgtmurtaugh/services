package de.ckraus.services.client.executors;

import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 *
 * @param <O> Response Bean
 */
public interface ServiceExecutor<O> {


    /**
     *
     * @return
     */
    O callService();

    /**
     *
     * @return
     */
    <T> T execute();

    /**
     *
     * @param mapContainerParams
     * @return
     */
    <T> T execute( Map<String, Object> mapContainerParams );

    /**
     *
     * @return
     */
    HttpStatus getHttpStatus();

    /**
     *
     * @return
     */
    Map<String, Object> getParams();

    /**
     *
     * @return
     */
    O getResponseEntity();

    /**
     *
     * @return
     */
    Class<O> getResponseType();

    /**
     *
     * @return
     */
    Object[] getServiceArgs();

    /**
     *
     * @return
     */
    Throwable getThrowable();

    /**
     *
     * @return
     */
    boolean isExecuted();

    /**
     *
     * @return
     */
    boolean isFailed();

    /**
     *
     * @return
     */
    boolean isReallyPerformService();

}
