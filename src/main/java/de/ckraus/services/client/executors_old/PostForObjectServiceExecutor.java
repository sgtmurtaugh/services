package de.ckraus.services.client.executors_old;

/**
 *
 * @param <O> ResponseEntity Type
 */
public interface PostForObjectServiceExecutor<O> extends RespondForObjectServiceExecutor<O> {

    /**
     * getRequest
     * @return
     */
    Object getRequest();

}
