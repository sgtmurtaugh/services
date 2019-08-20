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
public abstract class AbstractPostForEntityServiceExecutor<O> extends AbstractRequestedServiceExecutor<Object,
        ResponseEntity<O>> implements PostForEntityServiceExecutor<O> {

}
