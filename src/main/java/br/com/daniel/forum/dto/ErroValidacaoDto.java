package br.com.daniel.forum.dto;

public class ErroValidacaoDto {
	
	String campo;
	String mensagem;
	
	public ErroValidacaoDto(String campo, String mensagem) {
		
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	
}
