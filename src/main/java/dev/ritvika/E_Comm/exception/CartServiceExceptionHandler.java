package dev.ritvika.E_Comm.exception;

import dev.ritvika.E_Comm.controller.CartController;
import dev.ritvika.E_Comm.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartServiceExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(CartNotFoundException ce) {
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                ce.getMessage(),
                400
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RandomException.class)
    public ResponseEntity handleCartRandomException(RandomException re) {
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                re.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
