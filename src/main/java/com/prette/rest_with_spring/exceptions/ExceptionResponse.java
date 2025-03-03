package com.prette.rest_with_spring.exceptions;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
