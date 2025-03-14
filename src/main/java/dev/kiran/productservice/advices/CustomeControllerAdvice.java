package dev.kiran.productservice.advices;

import dev.kiran.productservice.dtos.ErrorDto;
import dev.kiran.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomeControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException(NullPointerException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Something went wrong");
        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto,
                HttpStatus.valueOf(500));
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Product not found, Plesae try again");
        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto,
                HttpStatus.valueOf(404));
        return responseEntity;
    }
}
