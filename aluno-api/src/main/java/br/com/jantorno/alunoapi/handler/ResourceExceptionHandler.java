package br.com.jantorno.alunoapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.jantorno.alunoapi.domain.DetalhesErro;
import br.com.jantorno.alunoapi.services.exceptions.*;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(AlunoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleProdutoNaoEncontradoException
							(AlunoNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O aluno não foi encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.alunoapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(NomeAlunoExistenteException.class)
	public ResponseEntity<DetalhesErro> handleNomeAlunoExistenteException
							(NomeAlunoExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("O nome do aluno existente.");
		erro.setMensagemDesenvolvedor("http://erros.alunoapi.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
}