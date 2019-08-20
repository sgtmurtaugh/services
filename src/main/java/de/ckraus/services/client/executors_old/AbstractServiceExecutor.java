package de.ckraus.services.client.executors_old;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter( AccessLevel.PROTECTED )
public abstract class AbstractServiceExecutor implements ServiceExecutorBase {

    private Map<String, Object> containerParams;
    private Throwable throwable;
    private boolean executed;
    private boolean executedSuccessfully;
    private Object[] serviceArgs;


    /**
     * init
     */
    protected void init( Map<String, Object> mapContainerParams ) {
        this.reset();

        this.setContainerParams( mapContainerParams );
    }

    /**
     * reset
     */
    protected void reset() {
        this.setContainerParams(null);
        this.setThrowable(null);
        this.setExecuted(false);
        this.setExecutedSuccessfully(false);
        this.setServiceArgs(null);
    }

    /**
     * isReallyPerformService
     * @return
     */
    public boolean isReallyPerformService() {
        return ( !this.isExecuted() );
    }

}
