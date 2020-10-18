package com.espark.adarsh.exception.handler;

import com.espark.adarsh.bean.ApiResponseBean;
import com.espark.adarsh.exception.ResourceNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseBean<Map<String, String>>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        ApiResponseBean<Map<String, String>> responseBean = new ApiResponseBean<>();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        responseBean.setData(errors);
        return new ResponseEntity<ApiResponseBean<Map<String, String>>>(responseBean, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConversionFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponseBean<String>> handleConnversion(RuntimeException ex) {
        ApiResponseBean<String> responseBean = new ApiResponseBean<>();
        responseBean.setMessage(ex.getMessage());
        responseBean.setError(ex.getLocalizedMessage());
        return new ResponseEntity<ApiResponseBean<String>>(responseBean, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiResponseBean<String>> handleResourceNotFound(ResourceNotFound ex) {
        ApiResponseBean<String> responseBean = new ApiResponseBean<>();
        responseBean.setMessage(ex.getMessage());
        responseBean.setError(ex.getLocalizedMessage());
        return new ResponseEntity<ApiResponseBean<String>>(responseBean, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiResponseBean<String>> handleException(Exception ex) {
        ApiResponseBean<String> responseBean = new ApiResponseBean<>();
        responseBean.setMessage(ex.getMessage());
        responseBean.setError(ex.getLocalizedMessage());
        return new ResponseEntity<ApiResponseBean<String>>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}