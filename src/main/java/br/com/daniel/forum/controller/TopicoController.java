package br.com.daniel.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniel.forum.dto.TopicoDto;
import br.com.daniel.forum.modelo.Curso;
import br.com.daniel.forum.modelo.Topico;

@RestController
public class TopicoController {
	
	@RequestMapping("/topicos")	
	public List<TopicoDto> topicos(){
		
		Topico topico = new Topico("Dúvida","Duvida sobre o spring.", new Curso("Java","Programação"));
		
		
		return TopicoDto.Converter(Arrays.asList(topico, topico, topico));
	}

}
