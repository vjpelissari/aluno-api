package br.com.jantorno.alunoapi.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jantorno.alunoapi.domain.Aluno;
import br.com.jantorno.alunoapi.services.AlunoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/aluno")
@Api(value = "API Rest Alunos")
@CrossOrigin(origins="*")
public class AlunoResources {

		@Autowired
		private AlunoServices alunoServices;
		
		@RequestMapping(method=RequestMethod.GET)
		@ApiOperation(value="Retorna a lista de todos os alunos cadastrados.")
		public ResponseEntity<List<Aluno>> listar() {
			return ResponseEntity.status(HttpStatus.OK).body(alunoServices.listar());
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		@ApiOperation(value="Retorna a busca um aluno.")
		public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
			Aluno aluno = alunoServices.buscar(id);
			CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);
			return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(aluno);
		}
		
		@RequestMapping(method = RequestMethod.POST)
		@ApiOperation(value="Salva um aluno.")
		public ResponseEntity<Void> salvar(@Valid @RequestBody Aluno aluno) {
			aluno = alunoServices.salvar(aluno);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(aluno.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		@ApiOperation(value="Remove um aluno.")
		public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
			alunoServices.deletar(id);
			return ResponseEntity.noContent().build();
		}
			
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		@ApiOperation(value="Atualiza um aluno.")
		public ResponseEntity<Void> atualizar(@RequestBody Aluno aluno, 
				@PathVariable("id") Long id) {
			aluno.setId(id);
			alunoServices.atualizar(aluno);
			return ResponseEntity.noContent().build();
		}
	}