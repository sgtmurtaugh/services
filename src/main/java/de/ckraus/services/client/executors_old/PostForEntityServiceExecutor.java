package de.ckraus.services.client.executors_old;

/**
 *
 * @param <O> ResponseEntity Type
 */
public interface PostForEntityServiceExecutor<O> extends RespondForEntityServiceExecutor<O> {

    /**
     * getRequest
     * @return
     */
    Object getRequest();

}
