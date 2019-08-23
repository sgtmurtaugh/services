package de.ckraus.services.client.executors;

import org.springframework.http.ResponseEntity;

/**
 *
 * @param <O>
 */
public abstract class GetForEntityServiceExecutorBase<O> extends ServiceExecutorBase<ResponseEntity<O>>
        implements GetForEntityServiceExecutor<O> {

}
