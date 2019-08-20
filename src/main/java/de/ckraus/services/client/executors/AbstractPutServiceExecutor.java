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
public abstract class AbstractPutServiceExecutor<I> extends AbstractRequestedResponselessServiceExecutor<I> implements
        RequestedResponselessServiceExecutor<I> {

}
