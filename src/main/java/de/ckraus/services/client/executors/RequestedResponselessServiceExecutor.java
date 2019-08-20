package de.ckraus.services.client.executors;

/**
 * Extends {@link ServiceExecutor}
 * @param <I>
 */
public interface RequestedResponselessServiceExecutor<I> extends ResponselessServiceExecutor,
        RequestedServiceExecutor<I, Void> {

}
