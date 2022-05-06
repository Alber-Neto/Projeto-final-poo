package com.poo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.input.TurmaInput;
import com.poo.model.Turma;
import com.poo.repositories.TurmaRepository;


@Service
public class TurmaService {
	
	@Autowired
	TurmaRepository turmaRepository;
	
	public Turma newTurma(TurmaInput turmaInput) {
		Turma turma = new Turma();
		turma.setName(turmaInput.getName());	
		return turmaRepository.save(turma);	
	}
	
	public List<Turma> getTurmas(){
		return turmaRepository.findAll(); 
	}
	
	public Turma getTurma(Long turmaId) {
		Optional<Turma> turma = turmaRepository.findById(turmaId);
		if(turma.isPresent())
			return turma.get();
		else
			return null;
	}
	
	public Turma delTurma(Long turmaId) {
		Optional<Turma> turma = turmaRepository.findById(turmaId);
		if(turma.isPresent()) {
			turmaRepository.delete(turma.get());
			return turma.get();
		}
		else {
			return null;
		}
	}
}
