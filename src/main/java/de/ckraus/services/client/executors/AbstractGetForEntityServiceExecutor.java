package de.ckraus.services.client.executors;

import org.springframework.http.ResponseEntity;

/**
 *
 * @param <O>
 */
public abstract class AbstractGetForEntityServiceExecutor<O> extends AbstractServiceExecutor<ResponseEntity<O>>
        implements GetForEntityServiceExecutor<O> {

}
