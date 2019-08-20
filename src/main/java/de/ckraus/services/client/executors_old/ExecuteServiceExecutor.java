package de.ckraus.services.client.executors_old;

import org.springframework.http.HttpStatus;

/**
 *
 * @param <I> RequestEntity Bean
 * @param <O> ResponseEntity Type
 */
public interface ExecuteServiceExecutor<I, O> extends RespondForObjectServiceExecutor<O> {
// TODO: s. RestTemplate execute Methods
    /**
     * getHttpStatus
     * @return
     */
    HttpStatus getHttpStatus();

    /**
     * getRequestEntityBean
     * @return
     */
    I getRequestEntityBean();

}
