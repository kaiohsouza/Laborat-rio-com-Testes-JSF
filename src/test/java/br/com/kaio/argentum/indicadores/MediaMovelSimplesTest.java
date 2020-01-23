package br.com.kaio.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.kaio.argentum.modelo.GeradorDeSerie;
import br.com.kaio.argentum.modelo.SerieTemporal;
import junit.framework.Assert;

public class MediaMovelSimplesTest {

	@Test
	public void sequenciaSimplesDeCandle() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1 ,2 ,3 ,4 ,3 ,4 ,5); 
		
		MediaMovelSimples mms = new MediaMovelSimples();	
		
		Assert.assertEquals(2.0, mms.calcula(2, serie) ,0.000001);
		Assert.assertEquals(3.0, mms.calcula(3, serie) ,0.000001);
		Assert.assertEquals(10.0/3, mms.calcula(4, serie) ,0.000001);
		Assert.assertEquals(11.0/3, mms.calcula(5, serie) ,0.000001);
		Assert.assertEquals(4.0, mms.calcula(6, serie) ,0.000001);
	}

}
