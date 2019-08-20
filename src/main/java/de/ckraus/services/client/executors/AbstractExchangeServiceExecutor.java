package de.ckraus.services.client.executors;

import de.ckraus.services.ServiceUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    private HttpStatus httpStatus;


    /**
     * Constructor
     * @param httpMethod
     */
    public AbstractExchangeServiceExecutor(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    @Override
    protected void reset() {
        super.reset();

        this.setHttpStatus( (HttpStatus ) null );
    }

    @Tolerate
    protected void setFailed( HttpStatus httpStatus ) {
        this.setFailed( ServiceUtils.isExecutedSuccessfully( httpStatus ) );
    }

    @Tolerate
    protected void setHttpStatus( ResponseEntity<O> responseEntity) {
        if (null == responseEntity) {

        }
        else {
            HttpStatus httpStatus = responseEntity.getStatusCode();

            if (null == httpStatus) {

            }
            else {
                this.setHttpStatus( httpStatus );
            }
        }
    }

}
