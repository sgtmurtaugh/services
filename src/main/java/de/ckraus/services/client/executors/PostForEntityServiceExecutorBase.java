package de.ckraus.services.client.executors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

/**
 *
 * @param <O>
 */
@Getter
@Setter( AccessLevel.PROTECTED)
public abstract class PostForEntityServiceExecutorBase<O> extends RequestedServiceExecutorBase<Object,
        ResponseEntity<O>> implements PostForEntityServiceExecutor<O> {

}
