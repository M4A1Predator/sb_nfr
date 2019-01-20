package com.gamitology.nfr.controller;

import com.gamitology.nfr.NfrApplication;
import com.gamitology.nfr.exception.ApiError;
import com.gamitology.nfr.exception.MyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LogManager.getLogger(NfrApplication.class);

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");

        logger.error(((ServletWebRequest)request).getRequest().getRequestURI().toString() + " : " + ex.getLocalizedMessage());

        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({MyException.class})
    public ResponseEntity<Object> handleMyException(MyException ex, WebRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.CONFLICT, ex.getLocalizedMessage(), "Unstable mental");

        logger.error(((ServletWebRequest)request).getRequest().getRequestURI().toString() + " : " + ex.getLocalizedMessage());

        return new ResponseEntity<Object>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}
