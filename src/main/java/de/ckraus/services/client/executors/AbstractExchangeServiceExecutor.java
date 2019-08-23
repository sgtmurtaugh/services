package de.ckraus.services.client.executors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;

/**
 *
 * @param <I>
 * @param <O>
 */
@Getter
@Setter( AccessLevel.PROTECTED)
public abstract class AbstractExchangeServiceExecutor<I, O> extends AbstractRequestedServiceExecutor<I, O> implements
        ExchangeServiceExecutor<I, O> {

    @Setter(AccessLevel.NONE)
    private final HttpMethod httpMethod;

    /**
     * Constructor
     * @param httpMethod
     */
    public AbstractExchangeServiceExecutor(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

}
