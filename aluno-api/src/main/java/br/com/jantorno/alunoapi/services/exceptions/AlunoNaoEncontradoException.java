package br.com.jantorno.alunoapi.services.exceptions;

public class AlunoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public AlunoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public AlunoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}