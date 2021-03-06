package com.poo.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "aluno", schema = "public")
public class Aluno implements Serializable {
	
	private static final long serialVersionUID=1;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	public Aluno() {
	}

	public Aluno(Long id, String name, String email, Turma turma) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.turma = turma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, email, turma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(email, other.email) && turma == other.turma;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", name=" + name + ", email " + email + ", turma=" + turma + "]";
	}
	
	
}
