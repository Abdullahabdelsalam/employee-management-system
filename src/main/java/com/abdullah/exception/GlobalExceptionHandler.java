package com.abdullah.exception;

import com.abdullah.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(
            MethodArgumentNotValidException.class
    )

    public ResponseEntity<?>

    handleValidation(

            MethodArgumentNotValidException ex

    ){

        Map<String,String> errors

                =

                new HashMap<>();


        ex

                .getBindingResult()

                .getFieldErrors()

                .forEach(error->{

                    errors.put(

                            error.getField(),

                            error.getDefaultMessage()

                    );

                });


        return ResponseEntity

                .badRequest()

                .body(errors);

    }

    public class ResourceNotFoundException

            extends RuntimeException{

        public ResourceNotFoundException(

                String msg){

            super(msg);

        }

    }

    @ExceptionHandler(

            ResourceNotFoundException.class

    )
    public ResponseEntity<ApiResponse<?>>

    handleNotFound(

            ResourceNotFoundException ex

    ){

        return ResponseEntity

                .status(404)

                .body(

                        ApiResponse

                                .builder()

                                .success(false)

                                .message(ex.getMessage())

                                .build()

                );

    }

    public class EmailAlreadyExistsException

            extends RuntimeException{

        public EmailAlreadyExistsException(

                String message){

            super(message);

        }

    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> handleEmail(
            EmailAlreadyExistsException ex) {

        ApiResponse<Object> response =
                ApiResponse.builder()
                        .success(false)
                        .message(ex.getMessage())
                        .data(null)
                        .build();

        return ResponseEntity.badRequest().body(response);
    }
}
