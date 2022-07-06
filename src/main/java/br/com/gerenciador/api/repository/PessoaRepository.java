package br.com.gerenciador.api.repository;

import java.util.List;

import br.com.gerenciador.api.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
	
	public List<PessoaEntity> findByName(String nome);

}
