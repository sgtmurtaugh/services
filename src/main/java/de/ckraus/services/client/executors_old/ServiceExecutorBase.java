package de.ckraus.services.client.executors_old;

import java.util.Map;

/**
 *
 */
public interface ServiceExecutorBase {

    /**
     * getContainerParams
     * @return
     */
    Map<String, Object> getContainerParams();

    /**
     * getServiceArgs
     * @return
     */
    Object[] getServiceArgs();

    /**
     * isExecuted
     * @return
     */
    boolean isExecuted();

    /**
     * isExecutedSuccessfully
     * @return
     */
    boolean isExecutedSuccessfully();

    /**
     * isReallyPerformService
     * @return
     */
    boolean isReallyPerformService();

}
