package br.com.daniel.forum.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.daniel.forum.dto.ErroValidacaoDto;

@RestControllerAdvice
public class ErroValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroValidacaoDto> handle(MethodArgumentNotValidException exception) {
		
		List<ErroValidacaoDto> erros = new ArrayList<ErroValidacaoDto>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(x -> {
			String mensagem = messageSource.getMessage(x, LocaleContextHolder.getLocale());
			
			ErroValidacaoDto erro = new ErroValidacaoDto(x.getField(),mensagem); 
			
			erros.add(erro);
		});
		
		return erros;
		
	}

}
