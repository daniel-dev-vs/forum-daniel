package br.com.daniel.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.daniel.forum.dto.TopicoDto;
import br.com.daniel.forum.form.TopicoForm;
import br.com.daniel.forum.modelo.Topico;
import br.com.daniel.forum.repository.CursoRepository;
import br.com.daniel.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")	
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping()
	public List<TopicoDto> topicos(String nomecurso){
		List<Topico> topicos;
		
		if(nomecurso == null)
		{
			 topicos = topicoRepository.findAll();
		}else {
			topicos = topicoRepository.findByCursoNome(nomecurso);
		}
				
		
		return TopicoDto.Converter(topicos);
	}
	
	
	
	@PostMapping()
	public ResponseEntity<TopicoDto> cadastrar(@Valid @RequestBody TopicoForm form, UriComponentsBuilder uriComponentsBuilder) {
		
		Topico topico = new Topico(form.getTitulo(),form.getMensagem(),form.converter(cursoRepository));				
		topicoRepository.save(topico);
		
		URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	
	
	@RequestMapping("/porcurso")	
	public List<TopicoDto> topicosPorCurso(){
		Long id = 1l;
		
		List<Topico> topicos = topicoRepository.carregarPorNome(id);
		
		
		return TopicoDto.Converter(topicos);
	}

}
