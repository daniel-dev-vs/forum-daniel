package br.com.daniel.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.daniel.forum.modelo.StatusTopico;
import br.com.daniel.forum.modelo.Topico;

public class DetalhesTopicoDto {
	
	private Long id;
	private String titulo;
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}

	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDto> respostas;
	
	public DetalhesTopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		this.respostas = new ArrayList<RespostaDto>();
		this.respostas = topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList());
	}
	
}
