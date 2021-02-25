package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.dto.GlobalError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(FizzException.class)
  public ResponseEntity<GlobalError> responseFizz(FizzException ex){
      GlobalError e = new GlobalError(ex.getMessage(), ex.getErrorReason());
      return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
  }

    @ExceptionHandler(BuzzException.class)
    public ResponseEntity<GlobalError> responseBuzz(BuzzException ex){
        GlobalError e = new GlobalError(ex.getMessage(), ex.getErrorReason());
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FizzBuzzException.class)
    public ResponseEntity<GlobalError> responseFizzBuzz(FizzBuzzException ex){
        GlobalError e = new GlobalError(ex.getMessage(), ex.getErrorReason());
        return new ResponseEntity<>(e, HttpStatus.INSUFFICIENT_STORAGE);
    }
}
