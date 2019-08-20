package de.ckraus.services.client.executors;

import org.springframework.http.ResponseEntity;

/**
 * Extends {@link ServiceExecutor} with Parameter {@link ResponseEntity<O>}
 * @param <O> Response Bean
 */
public interface PostForEntityServiceExecutor<O> extends RequestedServiceExecutor<Object, ResponseEntity<O>> {

}
