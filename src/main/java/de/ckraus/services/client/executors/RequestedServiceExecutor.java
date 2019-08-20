package de.ckraus.services.client.executors;

/**
 * Extends {@link ServiceExecutor} with Parameter {@code <O>}
 * @param <I> Request Entity Bean
 * @param <O> Response Entity Bean
 */
public interface RequestedServiceExecutor<I, O> extends ServiceExecutor<O> {

    /**
     *
     * @return
     */
    I getRequestObject();

}
