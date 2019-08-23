package de.ckraus.services.client.executors;

/**
 *
 */
public abstract class RequestedResponselessServiceExecutorBase<I> extends RequestedServiceExecutorBase<I,
        Void> implements ResponselessServiceExecutor {


    @Override
    public Class<Void> getResponseType() {
        return Void.class;
    }

}
