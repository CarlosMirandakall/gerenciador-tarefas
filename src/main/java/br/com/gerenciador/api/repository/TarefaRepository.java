package br.com.gerenciador.api.repository;

import br.com.gerenciador.api.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Long> {
}
