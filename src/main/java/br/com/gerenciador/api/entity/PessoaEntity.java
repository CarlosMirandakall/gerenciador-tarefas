package br.com.gerenciador.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "pessoa_db", schema = "gerenciador_tarefa")
public class PessoaEntity implements Serializable {

	private static final long serialVersionUID = 2964589452865154542L;
	
	@Id
	@Column(name = "id")
	@SequenceGenerator(
			name = "pessoa_sequence_generator",
			sequenceName = "pessoa_id_seq",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "pessoa_sequence_generator")
	private Long id;

	@Column(name = "nome", nullable = false)
	private String name;

	@Column(name = "departamento", nullable = false)
	private String departamento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch = EAGER, orphanRemoval = true)
	private Set<TarefaEntity> tarefaEntities;

}