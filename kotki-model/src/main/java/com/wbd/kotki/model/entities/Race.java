package com.wbd.kotki.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "RASY", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_RASY" }),
		@UniqueConstraint(columnNames = { "NAZWA" }) })
public class Race {
	@Id
	@SequenceGenerator(name="SEQ_GEN", sequenceName="RASY_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
	@Column(name = "ID_RASY", nullable=false, unique=true)
	private Long id;
	@Column(name = "NAZWA",nullable=false, unique=true)
	private String raceName;
	@OneToMany(mappedBy = "race")
	private Set<Cat> cats = new HashSet<Cat>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public Set<Cat> getCats() {
		return cats;
	}

	public void setCats(Set<Cat> cats) {
		this.cats = cats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((raceName == null) ? 0 : raceName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Race other = (Race) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (raceName == null) {
			if (other.raceName != null)
				return false;
		} else if (!raceName.equals(other.raceName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", raceName=" + raceName + "]";
	}

}
