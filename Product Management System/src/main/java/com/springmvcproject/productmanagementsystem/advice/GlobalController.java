package com.springmvcproject.productmanagementsystem.advice;

import com.springmvcproject.productmanagementsystem.exception.ProductNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalController   {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex , WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({IllegalStateException.class})
    public ResponseEntity<?> handleIllegalStateException(IllegalStateException ex ,WebRequest request){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.CONFLICT);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>  handleGlobalException(Exception ex ,WebRequest request){
        return new ResponseEntity<>("An Unexpected Error Occurred :"+ ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
