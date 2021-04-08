package br.com.daniel.forum.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.daniel.forum.modelo.Curso;
import br.com.daniel.forum.repository.CursoRepository;

public class TopicoForm {
	
	@NotNull @NotEmpty
	String mensagem;
	
	@NotNull @NotEmpty
	
	String titulo;
	
	@NotNull @NotEmpty
	String curso;
	
	public TopicoForm() {}
	
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
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Curso converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(this.curso);
				
		return curso;
	}
	
}
