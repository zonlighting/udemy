package ssv.com.udemy.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ssv.com.udemy.services.ResourceNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptonHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request){
        return new ResponseEntity<Object>("Rescource Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
