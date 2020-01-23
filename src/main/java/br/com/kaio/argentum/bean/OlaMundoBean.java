package br.com.kaio.argentum.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class OlaMundoBean {
	
	private String mensagem = "Esta mensagem veio diretamente do bean";
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void botaoClicado() {
		System.out.println("Recebendo o nome do usuario: " + this.nome);
	}

	public String getMensagem() {
		return this.mensagem;
	}

}
