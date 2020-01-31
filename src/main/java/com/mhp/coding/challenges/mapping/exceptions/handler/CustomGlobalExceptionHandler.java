package com.mhp.coding.challenges.mapping.exceptions.handler;

import com.mhp.coding.challenges.mapping.exceptions.ArticleNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArticleNotAvailableException.class)
    public ResponseEntity<CustomErrorResponse> customHandleInvalidDate(Exception ex, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        errors.setTitle(ex.getMessage());
        errors.setDescription("Article not in database.");

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
