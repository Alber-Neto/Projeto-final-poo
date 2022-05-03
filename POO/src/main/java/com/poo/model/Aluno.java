package com.poo.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "aluno", schema = "public")
public class Aluno implements Serializable {
	
	private static final long serialVersionUID=1;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	private Turma turma;
	
	public Aluno() {
	}

	public Aluno(Long id, String name, Turma turma) {
		this.id = id;
		this.name = name;
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, turma);
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
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && turma == other.turma;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", name=" + name + ", turma=" + turma + "]";
	}
	
	
}
