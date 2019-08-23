package de.ckraus.services.client.executors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;

/**
 *
 * @param <O>
 */
@Getter
@Setter( AccessLevel.PROTECTED)
public abstract class ExecuteServiceExecutorBase<O> extends ServiceExecutorBase<O> implements
        ExecuteServiceExecutor<O> {

    @Setter(AccessLevel.NONE)
    private final HttpMethod httpMethod;
    private RequestCallback requestCallback;
    private ResponseExtractor<O> responseExtractor;


    /**
     * Constructor
     * @param httpMethod
     */
    public ExecuteServiceExecutorBase( HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

}
