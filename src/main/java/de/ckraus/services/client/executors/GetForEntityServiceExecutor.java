package de.ckraus.services.client.executors;

import org.springframework.http.ResponseEntity;

/**
 * Extends {@link ServiceExecutor} with Parameter {@link ResponseEntity<O>}
 * @param <O> Response Bean
 */
public interface GetForEntityServiceExecutor<O> extends ServiceExecutor<ResponseEntity<O>> {

}
