package de.ckraus.services;

import org.springframework.http.HttpStatus;

/**
 *
 */
public class ServiceUtils {

    /**
     * Constructor
     */
    private ServiceUtils() {
        super();
    }

    /**
     *
     * @param httpStatus
     * @return
     */
    public static boolean isExecutedSuccessfully( HttpStatus httpStatus ) {
        boolean bIsExecutedSuccessfully = false;

        if (null == httpStatus) {
            httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
        }

        if (httpStatus.is1xxInformational()) {
            bIsExecutedSuccessfully = true;
        }
        else
        if (httpStatus.is2xxSuccessful()) {
            bIsExecutedSuccessfully = true;
        }
        else
        if (httpStatus.is3xxRedirection()) {
            bIsExecutedSuccessfully = true;
        }
        else
        if (httpStatus.is4xxClientError()) {
            // nothing to do...
        }
        else
        if (httpStatus.is5xxServerError()) {
            // nothing to do...
        }
        else {
            // nothing to do...
        }

        return bIsExecutedSuccessfully;
    }


}
