package de.ckraus.services.client.executors;

/**
 *
 */
public abstract class AbstractResponselessServiceExecutor extends AbstractServiceExecutor<Void> implements
        ResponselessServiceExecutor {


    @Override
    public Class<Void> getResponseType() {
        return Void.class;
    }

}
