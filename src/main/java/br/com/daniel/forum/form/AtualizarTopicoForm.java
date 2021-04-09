package br.com.daniel.forum.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.daniel.forum.modelo.Topico;
import br.com.daniel.forum.repository.TopicoRepository;

public class AtualizarTopicoForm {
	@NotNull @NotEmpty
	String mensagem;
	
	@NotNull @NotEmpty	
	String titulo;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Topico atualizar(Long id,TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getOne(id);
		topico.setTitulo(this.getTitulo());
		topico.setMensagem(this.getMensagem());
					
		return topico;
	}
	
}
