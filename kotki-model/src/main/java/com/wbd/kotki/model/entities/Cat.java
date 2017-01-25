package com.wbd.kotki.model.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "KOTY", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_KOTA" }) })
public class Cat {
	@Id
	@GeneratedValue
	@Column(name = "ID_KOTA")
	private Long id;
	@Column(name = "DATA_URODZENIA")
	private Date birthdayDate;
	@Column(name = "IMIE")
	private String name;
	@Column(name = "PLEC")
	private Character sex;
	@Column(name = "KOMPLET_LAPEK")
	private Character pawns;
	@Column(name = "STERYLIZACJA")
	private Character sterizlization;
	@Column(name = "WZROK")
	private Character sight;
	@ManyToOne
	@JoinColumn(name = "ID_RASY")
	private Race race;
	@Column(name = "ID_ODDZIALU")
	private Long idOddzial;
	@ManyToOne
	@JoinColumn(name = "ID_KLIENTA")
	private Client owner;
	
	@PreRemove
	private void prepareToRemove(){
		race.getCats().remove(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public Character getPawns() {
		return pawns;
	}

	public void setPawns(Character pawns) {
		this.pawns = pawns;
	}

	public Character getSterizlization() {
		return sterizlization;
	}

	public void setSterizlization(Character sterizlization) {
		this.sterizlization = sterizlization;
	}

	public Character getSight() {
		return sight;
	}

	public void setSight(Character sight) {
		this.sight = sight;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Long getIdOddzial() {
		return idOddzial;
	}

	public void setIdOddzial(Long idOddzial) {
		this.idOddzial = idOddzial;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthdayDate == null) ? 0 : birthdayDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pawns == null) ? 0 : pawns.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((sight == null) ? 0 : sight.hashCode());
		result = prime * result + ((sterizlization == null) ? 0 : sterizlization.hashCode());
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
		Cat other = (Cat) obj;
		if (birthdayDate == null) {
			if (other.birthdayDate != null)
				return false;
		} else if (!birthdayDate.equals(other.birthdayDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pawns == null) {
			if (other.pawns != null)
				return false;
		} else if (!pawns.equals(other.pawns))
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (sight == null) {
			if (other.sight != null)
				return false;
		} else if (!sight.equals(other.sight))
			return false;
		if (sterizlization == null) {
			if (other.sterizlization != null)
				return false;
		} else if (!sterizlization.equals(other.sterizlization))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cat [id=" + id + ", birthdayDate=" + birthdayDate + ", name=" + name + ", sex=" + sex + ", pawns="
				+ pawns + ", sterizlization=" + sterizlization + ", sight=" + sight + ", race=" + race + "]";
	}

}
