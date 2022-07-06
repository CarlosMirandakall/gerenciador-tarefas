package br.com.gerenciador.api.controller;

import br.com.gerenciador.api.constants.ConstantsPath;
import br.com.gerenciador.api.entity.PessoaEntity;
import br.com.gerenciador.api.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping(value = ConstantsPath.PATH_GERENCIADOR_TEREFA_PESSOA)
@Api(tags = {"Pessoa"})
public class PessoaController {
	
	@Autowired
	private PessoaService service;

	@ApiOperation(value = "Realiza o cadastro de um pessoa.")
	@ApiResponses({ @ApiResponse(code = 201, message = "Ok", response = PessoaEntity.class),
			@ApiResponse(code = 404, message = "Pessoa não encontrada", response = String.class),
			@ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
	@PostMapping(value = "/pessoas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> createPessoa(@RequestBody PessoaEntity pessoa) throws URISyntaxException {
		PessoaEntity pessoaEntity = service.adicionar(pessoa);
		if (pessoa != null) {
			return new ResponseEntity<>(pessoaEntity, HttpStatus.OK);
		}
		return new ResponseEntity<>("Problemas ao cadastrar pessoa!", HttpStatus.BAD_REQUEST);
    }

	@ApiOperation(value = "Realiza o cadastro de um pessoa.")
	@ApiResponses({ @ApiResponse(code = 201, message = "Ok", response = PessoaEntity.class),
			@ApiResponse(code = 404, message = "Pessoa não encontrada", response = String.class),
			@ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
	@PutMapping(value = "/pessoas/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> alterPessoa(@RequestBody PessoaEntity pessoa) throws URISyntaxException {
		PessoaEntity pessoaEntity = service.alterPessoa(pessoa);
		if (pessoaEntity != null) {
			return new ResponseEntity<>(pessoaEntity, HttpStatus.OK);
		}
		return new ResponseEntity<>("Problemas ao atualizar pessoa!", HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Realiza o cadastro de um perfil de consumidor para um usuário.")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = String.class),
			@ApiResponse(code = 404, message = "Usuário não encontrado", response = String.class),
			@ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class), })
	@DeleteMapping(value = "/pessoas/{id}")
	public ResponseEntity<?> deletePessoa(@PathVariable("id") Long id) {
		service.remover(id);
		return new ResponseEntity<>("Planeta removido com sucesso!", HttpStatus.OK);
    }

}
