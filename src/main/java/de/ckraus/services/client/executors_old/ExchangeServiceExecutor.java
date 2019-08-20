package de.ckraus.services.client.executors_old;

/**
 *
 * @param <I> RequestEntity Bean
 * @param <O> ResponseEntity Type
 */
public interface ExchangeServiceExecutor<I, O> extends RespondForEntityServiceExecutor<O> {

    /**
     * getRequestEntityBean
     * @return
     */
    I getRequestEntityBean();

}
