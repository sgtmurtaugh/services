package de.ckraus.services.client.executors;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

/**
 * Extends {@link ServiceExecutor} with Parameter {@code <O>}
 * @param <I> Request Entity Bean
 * @param <O> Response Entity Bean
 */
public interface ExchangeServiceExecutor<I, O> extends RequestedServiceExecutor<I, O> {

    /**
     *
     * @return
     */
    HttpMethod getHttpMethod();

    /**
     *
     * @return
     */
    HttpStatus getHttpStatus();

}
