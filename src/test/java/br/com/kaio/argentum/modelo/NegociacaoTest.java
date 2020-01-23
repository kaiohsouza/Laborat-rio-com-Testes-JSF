package br.com.kaio.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Test;

import junit.framework.Assert;

public class NegociacaoTest {

	@Test(expected=IllegalArgumentException.class)
	public void negociacaoComPrecoNegativo(){
		new Negociacao(-20.0, 2, LocalDateTime.now());		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void negociacaoComDataNula(){
		new Negociacao(20.0, 2, null);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void negociacaoComQuantidadeNulaOuNegativa(){
		new Negociacao(20.0, 0, LocalDateTime.now());		
	}
	
	@Test
	public void mesmoSegundoEhMesmoDia(){
		LocalDateTime hoje =  LocalDateTime.now();
		LocalDateTime agora = hoje;
		
		Negociacao negociacao = new Negociacao(10.0, 4, hoje);
		
		Assert.assertTrue(negociacao.isMesmoDia(agora));	
	}
	
	@Test
	public void horasDiferentesEhMesmoDia(){
		LocalDateTime hoje =  LocalDateTime.of(2016, 04, 04, 11, 00);
		LocalDateTime agora = LocalDateTime.of(2016, 04, 04, 12, 00);
		
		Negociacao negociacao = new Negociacao(10.0, 4, hoje);
		
		Assert.assertTrue(negociacao.isMesmoDia(agora));
		
	}
	
	@Test
	public void mesesDiferentesNaoEhMesmoDia(){
		LocalDateTime hoje =  LocalDateTime.of(2016, 04, 04, 11, 00);
		LocalDateTime agora = LocalDateTime.of(2016, 03, 04, 12, 00);
		
		Negociacao negociacao = new Negociacao(10.0, 4, hoje);
		
		Assert.assertFalse(negociacao.isMesmoDia(agora));
		
	}
	
	@Test
	public void anosDiferentesNaoEhMesmoDia(){
		LocalDateTime hoje =  LocalDateTime.of(2017, 04, 04, 11, 00);
		LocalDateTime agora = LocalDateTime.of(2016, 04, 04, 12, 00);
		
		Negociacao negociacao = new Negociacao(10.0, 4, hoje);
		
		Assert.assertFalse(negociacao.isMesmoDia(agora));
		
	}

}

