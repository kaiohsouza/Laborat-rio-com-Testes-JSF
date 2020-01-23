package br.com.kaio.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.kaio.argentum.modelo.GeradorDeSerie;
import br.com.kaio.argentum.modelo.SerieTemporal;
import junit.framework.Assert;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimplesDeCandle() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1 ,2 ,3 ,4 ,5 ,6); 
		
		MediaMovelPonderada mms = new MediaMovelPonderada();	
		
		Assert.assertEquals(14.0/6, mms.calcula(2, serie) ,0.000001);
		Assert.assertEquals(20.0/6, mms.calcula(3, serie) ,0.000001);
		Assert.assertEquals(26.0/6, mms.calcula(4, serie) ,0.000001);
		Assert.assertEquals(32.0/6, mms.calcula(5, serie) ,0.000001);

	}

}
