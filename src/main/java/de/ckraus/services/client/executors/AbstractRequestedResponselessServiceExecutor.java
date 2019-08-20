package de.ckraus.services.client.executors;

/**
 *
 */
public abstract class AbstractRequestedResponselessServiceExecutor<I> extends AbstractRequestedServiceExecutor<I,
        Void> implements ResponselessServiceExecutor {


    @Override
    public Class<Void> getResponseType() {
        return Void.class;
    }

}
