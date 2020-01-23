package br.com.kaio.argentum.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
public class CandlestickFactoryTest {

	@Test
	public void sequenciaDeNegociacoesSimples() {
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao negociacao1 = new Negociacao(40.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(20.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(35.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.geraCandleParaData(negociacoes, hoje);
		
		Assert.assertEquals(20.0, candle.getMinimo(), 0.0001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.0001);
		Assert.assertEquals(40.0, candle.getAbertura(), 0.0001);
		Assert.assertEquals(35.0, candle.getFechamento(), 0.0001);
		Assert.assertEquals(14000.0, candle.getVolume(), 0.0001);
	}

	@Test
	public void verificacaoDeUmaNegociacao() {
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao negociacao1 = new Negociacao(40.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.geraCandleParaData(negociacoes, hoje);
		
		Assert.assertEquals(40.0, candle.getMinimo(), 0.0001);
		Assert.assertEquals(40.0, candle.getMaximo(), 0.0001);
		Assert.assertEquals(40.0, candle.getAbertura(), 0.0001);
		Assert.assertEquals(40.0, candle.getFechamento(), 0.0001);
		Assert.assertEquals(4000.0, candle.getVolume(), 0.0001);
	}
	
	@Test
	public void verificacaoDevalorZero() {
		LocalDateTime hoje = LocalDateTime.now();
			
		List<Negociacao> negociacoes = new ArrayList<>();
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.geraCandleParaData(negociacoes, hoje);
		
		Assert.assertEquals(0.0, candle.getMinimo(), 0.0001);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.0001);
		Assert.assertEquals(0.0, candle.getAbertura(), 0.0001);
		Assert.assertEquals(0.0, candle.getFechamento(), 0.0001);
		Assert.assertEquals(0.0, candle.getVolume(), 0.0001);
	}
	
	@Test
	public void negociacaoDeTresDiasDiferentes() {
		
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao negociacao1 = new Negociacao(20.0, 4, hoje);
		Negociacao negociacao2 = new Negociacao(10.0, 3, hoje);
		Negociacao negociacao3 = new Negociacao(15.0, 2, hoje);
		
		LocalDateTime amanha = hoje.plusDays(1);
		
		Negociacao negociacao4 = new Negociacao(25.0, 1, amanha);
		Negociacao negociacao5 = new Negociacao(40.0, 3, amanha);
		
		LocalDateTime depois = amanha.plusDays(1);
		
		Negociacao negociacao6 = new Negociacao(25.0, 7, depois);
		Negociacao negociacao7 = new Negociacao(30.0, 8, depois);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1,negociacao2,negociacao3,
										 negociacao4,negociacao5,negociacao6,negociacao7);
		
		CandlestickFactory fabrica = new CandlestickFactory();

		List<Candlestick> candlesticks = fabrica.constroiCandles(negociacoes);
		
		Assert.assertTrue(negociacoes.get(0).isMesmoDia(candlesticks.get(0).getData()));
		Assert.assertTrue(negociacoes.get(3).isMesmoDia(candlesticks.get(1).getData()));
		Assert.assertTrue(negociacoes.get(5).isMesmoDia(candlesticks.get(2).getData()));
		
		Assert.assertEquals(140.0, candlesticks.get(0).getVolume(), 0.0001);
		Assert.assertEquals(10.0, candlesticks.get(0).getMinimo(), 0.0001);
		Assert.assertEquals(20.0, candlesticks.get(0).getMaximo(), 0.0001);
		Assert.assertEquals(20.0, candlesticks.get(0).getAbertura(), 0.0001);
		Assert.assertEquals(15.0, candlesticks.get(0).getFechamento(), 0.0001);
		
	}

}
