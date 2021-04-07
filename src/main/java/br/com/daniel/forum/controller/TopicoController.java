package br.com.daniel.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniel.forum.dto.TopicoDto;
import br.com.daniel.forum.modelo.Curso;
import br.com.daniel.forum.modelo.Topico;
import br.com.daniel.forum.repository.TopicoRepository;

@RestController
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")	
	public List<TopicoDto> topicos(){
		
		List<Topico> topicos = topicoRepository.findAll();
		
		
		return TopicoDto.Converter(topicos);
	}

}
