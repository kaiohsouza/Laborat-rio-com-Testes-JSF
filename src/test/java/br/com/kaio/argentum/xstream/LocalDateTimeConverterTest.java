package br.com.kaio.argentum.xstream;

import java.time.LocalDateTime;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.kaio.argentum.modelo.Negociacao;
import junit.framework.Assert;

public class LocalDateTimeConverterTest {

	@Test
	public void TesteConversorXmlLocalDateTime() {
		 LocalDateTime hoje = LocalDateTime.of(2016, 04, 04, 12, 00);
		 
		Negociacao negociacao = new Negociacao(10.0, 4, hoje);
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("negociacao", Negociacao.class);
		xstream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		String xmlConvertido = xstream.toXML(negociacao);
		
		String xmlEsperado =
				"<negociacao>\n"
	    		+"	<preco>10.0</preco>\n"
	    		+"	<quantidade>4</quantidade>\n" 
	    		+"	<data>\n"
	    		+"		<time>1459782000000</time>\n"
	    		+"		<timezone>America/Sao_Paulo</timezone>\n"
	    		+"		</data>\n"
	    		+"</negociacao>";
	}
	@Test
	public void TesteConversorLocalDateTimeXml() {
		
		String xml =
				"<negociacao>\n"
	    		+"	<preco>10.0</preco>\n"
	    		+"	<quantidade>4</quantidade>\n" 
	    		+"	<data>\n"
	    		+"		<time>1459782000000</time>\n"
	    		+"		<timezone>America/Sao_Paulo</timezone>\n"
	    		+"		</data>\n"
		  		+"</negociacao>";
		
		XStream xstream = new XStream(new DomDriver());
		xstream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		xstream.alias("negociacao", Negociacao.class);
		
		Negociacao negociacaoGerada = (Negociacao) xstream.fromXML(xml);
		
		LocalDateTime hoje = LocalDateTime.of(2016, 04, 04, 12, 00);	 
		Negociacao negociacaoEsperada = new Negociacao(10.0, 4, hoje);
		
		Assert.assertEquals(negociacaoEsperada, negociacaoGerada);
		
	}

}
