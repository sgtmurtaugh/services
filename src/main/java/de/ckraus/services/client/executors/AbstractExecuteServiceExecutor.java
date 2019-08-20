package de.ckraus.services.client.executors;

import de.ckraus.services.ServiceUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;

/**
 *
 * @param <O>
 */
@Getter
@Setter( AccessLevel.PROTECTED)
public abstract class AbstractExecuteServiceExecutor<O> extends AbstractServiceExecutor<O> implements
        ExecuteServiceExecutor<O> {

    @Setter(AccessLevel.NONE)
    private final HttpMethod httpMethod;
    private RequestCallback requestCallback;
    private ResponseExtractor<O> responseExtractor;


    /**
     * Constructor
     * @param httpMethod
     */
    public AbstractExecuteServiceExecutor(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    @Tolerate
    protected void setFailed( HttpStatus httpStatus ) {
        this.setFailed( ServiceUtils.isExecutedSuccessfully( httpStatus ) );
    }

}
