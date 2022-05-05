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

import com.poo.input.AlunoInput;
import com.poo.model.Aluno;
import com.poo.repositories.AlunoRepository;
import com.poo.service.AlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@PostMapping (value = "/cadastro")
	public ResponseEntity<Aluno> newAluno(@RequestBody AlunoInput alunoInput) {
		Aluno aluno = alunoService.newAluno(alunoInput);
		return ResponseEntity.ok(aluno);
	}
	
	@GetMapping
	public ResponseEntity<List<Aluno>> getAlunos(){
		List<Aluno> alunos = alunoService.getAlunos();
		return ResponseEntity.ok(alunos);
	}
	
	@GetMapping (value = "/{alunoId}")
	public ResponseEntity<Aluno> getAluno(@PathVariable Long alunoId) {
		Aluno aluno = alunoService.getAluno(alunoId);
		return ResponseEntity.ok(aluno);
	}
	
	@GetMapping (value = "/sortName")
	public ResponseEntity<List<Aluno>> findOrderByName(){
		List<Aluno> alunos = alunoRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
		return ResponseEntity.ok(alunos);
	}

	@GetMapping (value = "/sortTurma_id")
	public ResponseEntity<List<Aluno>> findOrderByTurma_id(){
		List<Aluno> alunos = alunoRepository.findAll(Sort.by(Sort.Direction.ASC,"turma_id"));
		return ResponseEntity.ok(alunos);
	}
}


