package de.ckraus.services.client.executors;

/**
 *
 */
public abstract class ResponselessServiceExecutorBase extends ServiceExecutorBase<Void> implements
        ResponselessServiceExecutor {


    @Override
    public Class<Void> getResponseType() {
        return Void.class;
    }

}
