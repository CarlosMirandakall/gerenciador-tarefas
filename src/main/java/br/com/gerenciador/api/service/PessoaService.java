package br.com.gerenciador.api.service;

import br.com.gerenciador.api.entity.PessoaEntity;
import br.com.gerenciador.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.net.URISyntaxException;
import java.util.Objects;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Transactional
	public PessoaEntity adicionar(PessoaEntity pessoaEntity) throws URISyntaxException {
		if (Objects.nonNull(pessoaEntity)) {
			PessoaEntity result = repository.save(pessoaEntity);
			return result;
		}
		return null;
	}
	
	@Transactional
	public void remover(Long id) {
		repository.deleteById(id);
	}

	@Transactional
	public PessoaEntity alterPessoa(PessoaEntity pessoa) {
		if (Objects.nonNull(pessoa)) {
			repository.save(pessoa);
		}
		return null;
	}

}
