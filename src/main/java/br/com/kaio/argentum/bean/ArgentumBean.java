package br.com.kaio.argentum.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.kaio.argentum.modelo.Negociacao;
import br.com.kaio.argentum.ws.ClientWebservice;

@ViewScoped
@ManagedBean
public class ArgentumBean implements Serializable{
	
	private List<Negociacao> negociacoes;

	public ArgentumBean(){
		this.negociacoes = new ClientWebservice().getNegociacoes();
	}
	
	public List<Negociacao> getNegociacoes(){
		return this.negociacoes;
		
	}	
}
