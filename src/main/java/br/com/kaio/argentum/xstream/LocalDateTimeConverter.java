package br.com.kaio.argentum.xstream;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class LocalDateTimeConverter implements Converter {

	@Override
	public boolean canConvert(Class type) {
		
		return type.isAssignableFrom(LocalDateTime.class);
	}

	@Override
	public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
		LocalDateTime data = (LocalDateTime) object;
		ZonedDateTime dataComZona = data.atZone(ZoneOffset.systemDefault());
		long milis = dataComZona.toInstant().toEpochMilli();
		
		writer.startNode("time");
		writer.setValue(String.valueOf(milis));
		writer.endNode();
		
		writer.startNode("timezone");
		writer.setValue(dataComZona.getZone().toString());
		writer.endNode();

	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		reader.moveDown(); //entrar no Xml para pegar o valor
		String milis = reader.getValue();
		reader.moveUp();
		
		reader.moveDown(); //entrar no Xml para pegar o valor
		String timeZone = reader.getValue();
		reader.moveUp();
		
		long tempoEmMilis = Long.parseLong(milis); // convers�o de variaveis
		Instant tempo = Instant.ofEpochMilli(tempoEmMilis);
		 
		ZoneId zone = ZoneId.of(timeZone); // convers�o de variaveis
		ZonedDateTime dataComZona = ZonedDateTime.ofInstant(tempo, zone);
		
		LocalDateTime data = dataComZona.toLocalDateTime(); //convers�o de metodos
		
		return data;
	}

}
