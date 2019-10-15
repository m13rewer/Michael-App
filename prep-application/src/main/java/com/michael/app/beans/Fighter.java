package com.michael.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="FIGHTERS")
@Component
@Scope(scopeName="prototype")
//@CrossOrigin(origins="http://localhost:4200")
//@JsonInclude(Include.NON_EMPTY)
public class Fighter {
	
	@Id
	@GeneratedValue(generator="ID", strategy=GenerationType.SEQUENCE)	
	@SequenceGenerator(name="ID", sequenceName="SEQ_FIGHTERS", allocationSize=1)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="origin_id", referencedColumnName="ID")
	private Origin origin;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tiers_id", referencedColumnName="ID")
	private Tier tier;
	
	public Fighter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fighter(Integer id, String name, Origin origin, Tier tier) {
		super();
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.tier = tier;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Tier getTier() {
		return tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((tier == null) ? 0 : tier.hashCode());
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
		Fighter other = (Fighter) obj;
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
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (tier == null) {
			if (other.tier != null)
				return false;
		} else if (!tier.equals(other.tier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fighter [id=" + id + ", name=" + name + ", origin=" + origin + ", tier=" + tier + "]";
	}
	
}
