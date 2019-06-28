package com.mmt.mmtCache.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by braj on 19/05/19.
 */
public @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "value not Int")
class BadRequestException extends RuntimeException {

}
