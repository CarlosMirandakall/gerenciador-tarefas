package br.com.gerenciador.api.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "tarefa_db", schema = "gerenciador_tarefa")
public class TarefaEntity {

    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "terefa_sequence_generator",
            sequenceName = "tarefa_id_seq",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tarefa_sequence_generator")
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "prazo", nullable = false)
    private Integer prazo;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "duracao", nullable = false)
    private Integer duracao;

    @ManyToOne
    //@JoinColumn(name="pessoa_id", nullable=false)
    private PessoaEntity pessoa;
}
