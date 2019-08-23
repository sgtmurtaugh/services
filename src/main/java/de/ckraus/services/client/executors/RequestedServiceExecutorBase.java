package de.ckraus.services.client.executors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 *
 * @param <I>
 * @param <O>
 */
@Getter
@Setter( AccessLevel.PROTECTED)
public abstract class RequestedServiceExecutorBase<I, O> extends ServiceExecutorBase<O> implements
        RequestedServiceExecutor<I, O> {

    private I requestObject;

    protected abstract I initRequestObject();

    @Override
    protected void init( Map<String, Object> mapContainerParams ) {
        super.init( mapContainerParams );

        this.setRequestObject( this.initRequestObject() );
    }
}
