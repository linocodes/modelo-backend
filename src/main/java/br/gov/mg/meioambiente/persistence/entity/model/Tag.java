package br.gov.mg.meioambiente.persistence.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import br.gov.mg.meioambiente.persistence.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tag")
@DynamicUpdate
public class Tag extends BaseEntity<Long> {

	private static final long serialVersionUID = -7655961997031546542L;

	@Id
	@Column(name = "tag_id")
	@SequenceGenerator(name = "tag", sequenceName = "seq_tag", allocationSize = 1)
	@GeneratedValue(generator = "tag", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	@Size(max = 20)
	private String name;

	@Column(nullable = false)
	@Size(max = 20)
	private String sobrenome;

}