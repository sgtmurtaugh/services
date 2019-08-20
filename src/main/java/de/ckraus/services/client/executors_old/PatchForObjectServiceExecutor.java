package de.ckraus.services.client.executors_old;

/**
 *
 * @param <O> ResponseEntity Type
 */
public interface PatchForObjectServiceExecutor<O> extends RespondForObjectServiceExecutor<O> {

    /**
     * getRequest
     * @return
     */
    Object getRequest();

}
