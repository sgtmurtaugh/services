package de.ckraus.services.client.executors_old;

import java.util.Map;

/**
 *
 */
public interface RespondServiceExecutor<O> extends ServiceExecutorBase {

    /**
     * callService
     * @return
     */
    O callService();

    /**
     * execute
     * @param mapContainerParams
     * @return
     */
    O execute( Map<String, Object> mapContainerParams );

}
