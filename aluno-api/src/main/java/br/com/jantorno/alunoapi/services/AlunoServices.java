package br.com.jantorno.alunoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.jantorno.alunoapi.domain.Aluno;
import br.com.jantorno.alunoapi.repository.AlunoRepository;
import br.com.jantorno.alunoapi.services.exceptions.AlunoNaoEncontradoException;
import br.com.jantorno.alunoapi.services.exceptions.NomeAlunoExistenteException;

@Service
public class AlunoServices {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}
	
	public Aluno buscar(Long id) {
		Aluno aluno = this.alunoRepository.findById(id).orElse(null);
		
		if(aluno == null) {
			throw new AlunoNaoEncontradoException("O aluno não foi encontrado.");
		}
		return aluno;
	}
	
	public Aluno salvar(Aluno aluno) {
		
		Aluno aluno_pesquisado = alunoRepository.findByNome(aluno.getNome());

		if (aluno_pesquisado != null) {
			throw new NomeAlunoExistenteException("O nome do aluno já encontra-se cadastrado.");
		}
		aluno.setId(null);
		return alunoRepository.save(aluno);
	}
	
	public void deletar(Long id) {
		try {
			alunoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new AlunoNaoEncontradoException("O aluno não foi encontrado.");
		}
	}
	
	public void atualizar(Aluno aluno) {
		
		// O aluno tem que existir para ser atualizado
        this.verificarExistencia(aluno);
				
		// Valida se o nome ja esta cadastrado para ou aluno
		this.validarNomeUpdate(aluno);

		alunoRepository.save(aluno);
	}
	
	private void verificarExistencia(Aluno aluno) {
		buscar(aluno.getId());
	}
	
	private void validarNomeUpdate(Aluno aluno) {
        
		Aluno alunoPesquisa = alunoRepository.findByNome(aluno.getNome());

		if ((alunoPesquisa != null) && (alunoPesquisa.getId() != aluno.getId())) {
			throw new NomeAlunoExistenteException("O nome do aluno já encontra-se cadastrado.");
		}
	}
	
	
}