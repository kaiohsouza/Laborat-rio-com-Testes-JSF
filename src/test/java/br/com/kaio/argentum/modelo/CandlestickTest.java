package br.com.kaio.argentum.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

import junit.framework.Assert;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void testMinimoMaiorQueMaximo() {
		
		CandleBuilder builder = new CandleBuilder();
		
		Candlestick candle = builder.comAbertura(10.0).comFechamento(30.0).comMaximo(15.0).
				comMinimo(25.0).comVolume(100).comData(LocalDateTime.now()).geraCandle();
	}

}
