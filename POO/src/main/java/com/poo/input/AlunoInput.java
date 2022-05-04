package com.poo.input;

import java.util.Objects;

import com.poo.model.Turma;

public class AlunoInput {
	private Long id;
	private String name;
	private String email;
	private Turma turma;
	
	public AlunoInput(Long id, String name,String email, Turma turma) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.turma = turma;
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
		AlunoInput other = (AlunoInput) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(email, other.email) && turma == other.turma;
	}

	@Override
	public String toString() {
		return "AlunoInput [id=" + id + ", name=" + name + ", email " + email + ", turma=" + turma + "]";
	}
	
	
}
