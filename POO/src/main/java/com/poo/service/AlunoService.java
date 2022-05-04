package com.poo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.input.AlunoInput;
import com.poo.model.Aluno;
import com.poo.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public Aluno newAluno(AlunoInput alunoInput) {
		Aluno aluno = new Aluno();
		aluno.setName(alunoInput.getName());
		aluno.setEmail(alunoInput.getEmail());
		aluno.setTurma(alunoInput.getTurma());
		return alunoRepository.save(aluno);	
	}
	
	public List<Aluno> getAlunos(){
		return alunoRepository.findAll(); 
	}
	
	public Aluno getAluno(Long alunoId) {
		Optional<Aluno> aluno = alunoRepository.findById(alunoId);
		if(aluno.isPresent())
			return aluno.get();
		else
			return null;
	}
	
	
}
