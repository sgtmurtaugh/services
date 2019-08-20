package de.ckraus.services.client.executors_old;

import org.springframework.http.ResponseEntity;

/**
 *
 * @param <O> ResponseEntity Type
 */
public interface RespondForEntityServiceExecutor<O> extends RespondServiceExecutor<ResponseEntity<O>> {

    /**
     * getResponseEntityBean
     * @return
     */
    O getResponseEntityBean();

    /**
     * getResponseEntityType
     * @return
     */
    Class<O> getResponseEntityType();

}
