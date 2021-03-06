package br.com.kaio.argentum.ws;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.omg.CORBA.portable.InputStream;

import br.com.kaio.argentum.modelo.Negociacao;
import br.com.kaio.argentum.reader.LeitorXml;

public class ClientWebservice {
	
	 	public static final String URL_WEBSERVICES = "https://argentumws-spring.herokuapp.com/negociacoes";
	
	HttpURLConnection connection = null;
	
	public List<Negociacao> getNegociacoes(){
		
		try {
			URL url = new URL(URL_WEBSERVICES);
			connection = (HttpURLConnection) url.openConnection(); 
			
			java.io.InputStream content = connection.getInputStream();
			return new LeitorXml().carrega(content);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally {
			connection.disconnect();
		}
		
	}
	
	public static void main(String[] args) {
		
		ClientWebservice ws = new ClientWebservice();
		List<Negociacao> negociacoes = ws.getNegociacoes();
		
		for (Negociacao negociacao : negociacoes) {
			System.out.println(negociacao.getPreco());
			
		}
	}

}
