package br.com.daniel.forum.dto;

import java.time.LocalDateTime;

import br.com.daniel.forum.modelo.Resposta;

public class RespostaDto {
	private Long id;
	private LocalDateTime dataCriacao;
	private String mensagem;
	private String nomeAutor;
	
	public RespostaDto(Resposta resposta) {
		this.id = resposta.getId();
		this.dataCriacao = resposta.getDataCriacao();
		this.mensagem = resposta.getMensagem();
		this.nomeAutor = resposta.getAutor().getNome();
	}
	public Long getId() {
		return id;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public String getMensagem() {
		return mensagem;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
}
