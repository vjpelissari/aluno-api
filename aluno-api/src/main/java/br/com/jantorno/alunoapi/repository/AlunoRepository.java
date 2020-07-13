package br.com.jantorno.alunoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.jantorno.alunoapi.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	public Aluno findByNome(String email);
	
}