package br.com.jantorno.alunoapi.services.exceptions;

public class NomeAlunoExistenteException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NomeAlunoExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public NomeAlunoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}