package de.ckraus.services.client.executors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @param <I>
 */
@Getter
@Setter( AccessLevel.PROTECTED)
public abstract class PutServiceExecutorBase<I> extends RequestedResponselessServiceExecutorBase<I> implements
        RequestedResponselessServiceExecutor<I> {

}
