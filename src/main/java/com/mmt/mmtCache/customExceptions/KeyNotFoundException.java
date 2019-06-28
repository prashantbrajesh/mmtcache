package com.mmt.mmtCache.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by braj on 19/05/19.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "key not found")
public class KeyNotFoundException extends RuntimeException {

}


