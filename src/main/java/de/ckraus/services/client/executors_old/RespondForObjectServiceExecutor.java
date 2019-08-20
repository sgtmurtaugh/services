package de.ckraus.services.client.executors_old;

/**
 *
 * @param <O>
 */
public interface RespondForObjectServiceExecutor<O> extends RespondServiceExecutor<O> {

    /**
     * getResponseEntityBean
     * @return
     */
    O getResponseEntityBean();

    /**
     * getResponseEntityType
     * @return
     */
    Class<O> getResponseEntityType();

}
