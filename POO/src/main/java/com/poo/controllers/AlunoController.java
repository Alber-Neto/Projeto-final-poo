package com.poo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.input.AlunoInput;
import com.poo.model.Aluno;
import com.poo.service.AlunoService;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	
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
	
	@DeleteMapping (value = "/delete/{alunoId}")
	public ResponseEntity<Aluno> delAluno(@PathVariable Long alunoId) {
		Aluno aluno = alunoService.delAluno(alunoId);
		return ResponseEntity.ok(aluno);
	}
	
	
}


