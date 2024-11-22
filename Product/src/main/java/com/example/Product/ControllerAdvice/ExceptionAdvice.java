package com.example.Product.ControllerAdvice;

import com.example.Product.CustomeException.InvalidIdException;
import com.example.Product.CustomeException.InvalidResponse;
import com.example.Product.CustomeException.NoProductFound;
import com.example.Product.Dtos.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvice {

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<String> handleException(InvalidIdException e)
    {
        ErrorResponseDto error= new ErrorResponseDto();
        error.setMessage("Invalid ID");
        return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);}

    @ExceptionHandler(NoProductFound.class)
    public ResponseEntity<String> handleException(NoProductFound e)
    {
        ErrorResponseDto error= new ErrorResponseDto();
        error.setMessage("Failed to Find product, received empty response.");
        return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidResponse.class)
    public ResponseEntity<String> handleException(InvalidResponse e)
    {
        ErrorResponseDto error= new ErrorResponseDto();
        error.setMessage("Failed to create product, received empty response.");
        return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }


}
