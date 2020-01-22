package br.com.kaio.argentum.modelo;

import java.time.LocalDateTime;

public class Candlestick {
	
	private final double maximo;
	private final double minimo;
	private final double abertura;
	private final double fechamento;
	private final double volume;
	private final LocalDateTime data;
	
	public Candlestick(double maximo, double minimo, double abertura, double fechamento, double volume,
			LocalDateTime data) {
		this.maximo = maximo;
		this.minimo = minimo;
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.volume = volume;
		this.data = data;
	}
	
	public double getMaximo() {
		return maximo;
	}
	public double getMinimo() {
		return minimo;
	}
	public double getAbertura() {
		return abertura;
	}
	public double getFechamento() {
		return fechamento;
	}
	public double getVolume() {
		return volume;
	}
	public LocalDateTime getData() {
		return data;
	}
	
	public boolean isAlta() {
		return this.fechamento > this.abertura;
	}
	
	public boolean isbaixa() {
		return this.fechamento < this.abertura;
	}

}
