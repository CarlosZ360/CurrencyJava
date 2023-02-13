package arquitectura.software.demo.Exception;

import arquitectura.software.demo.dto.ResponseServiceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ServiceException {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseServiceDto> zeroException(IllegalArgumentException e) {
        ResponseServiceDto responseServiceDto = new ResponseServiceDto(null, false, e.getMessage());
        return ResponseEntity.badRequest().body(responseServiceDto);
    }
}
