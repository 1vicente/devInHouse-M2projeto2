package devInHouse.M2projeto2.exception;

import devInHouse.M2projeto2.dto.ErroValidacaoDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TrataErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> trataErro404(EntityNotFoundException ex) {
        String erro = "Não encontrado";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoDTO>> trataErro400(MethodArgumentNotValidException ex) {
        List<FieldError> erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(
                erros.stream().map(ErroValidacaoDTO::new).collect(Collectors.toList()));
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> trataErro404(DataIntegrityViolationException ex) {
        String erro = ex.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
}
