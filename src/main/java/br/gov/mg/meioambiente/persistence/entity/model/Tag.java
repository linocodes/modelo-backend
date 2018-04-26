package br.gov.mg.meioambiente.persistence.entity.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import br.gov.mg.meioambiente.persistence.entity.BaseEntity;

@Entity
@Table(name = "tag")
@DynamicUpdate
@AttributeOverride(name = "id", column = @Column(name = "tag_id", nullable = false))
//@SequenceGenerator(sequenceName = "customer_tag", allocationSize = 1, name = "SEQ_TAG")
public class Tag extends BaseEntity<Long> {

	private static final long serialVersionUID = -7655961997031546542L;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String sobrenome;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tag [name=" + name + ", sobrenome=" + sobrenome + "]";
	}
	
	

}