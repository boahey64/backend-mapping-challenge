package com.mhp.coding.challenges.mapping.exceptions.handler;

import com.mhp.coding.challenges.mapping.exceptions.ArticleNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArticleNotAvailableException.class)
    public ResponseEntity<CustomErrorResponse> customHandleInvalidDate(Exception ex) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        errors.setTitle(ex.getMessage());
        errors.setDescription("Article not in database.");

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotImplementedException.class)
    public ResponseEntity<CustomErrorResponse> customHandleNotImplemented(Exception ex) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setStatus(HttpStatus.NOT_FOUND.value());
        errors.setTitle("Method '" + ex.getStackTrace()[0].getMethodName() + "' of block '" +  ex.getStackTrace()[0].getFileName() + "' is not implemented yet." );
        errors.setDescription("Mapping method of block is not implemented.");

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
