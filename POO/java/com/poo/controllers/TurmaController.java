package com.poo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.input.TurmaInput;
import com.poo.model.Turma;
import com.poo.repositories.TurmaRepository;
import com.poo.service.TurmaService;

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {
	
	@Autowired
	TurmaService turmaService;
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@PostMapping (value = "/cadastro")
	public ResponseEntity<Turma> newTurma(@RequestBody TurmaInput turmaInput) {
		Turma turma = turmaService.newTurma(turmaInput);
		return ResponseEntity.ok(turma);
	}
	
	@GetMapping
	public ResponseEntity<List<Turma>> getTurmas(){
		List<Turma> turma = turmaService.getTurmas();
		return ResponseEntity.ok(turma);
	}
	
	@GetMapping (value = "/{turmaId}")
	public ResponseEntity<Turma> getTurma(@PathVariable Long turmaId) {
		Turma turma = turmaService.getTurma(turmaId);
		return ResponseEntity.ok(turma);
	}	
	
	@GetMapping (value = "/sortId")
	public ResponseEntity<List<Turma>> findOrderById(){
		List<Turma> turma = turmaRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
		return ResponseEntity.ok(turma);
	}
	
	@GetMapping (value = "/sortName")
	public ResponseEntity<List<Turma>> findOrderByName(){
		List<Turma> turma = turmaRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
		return ResponseEntity.ok(turma);
	}

}
