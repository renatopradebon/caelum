package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {
	
	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;
	
	private boolean chamouAbertura;
	private boolean chamouFechamento;
	private boolean chamouMinimo;
	private boolean chamouMaximo;
	private boolean chamouVolume;
	private boolean chamouData;
	
	public CandleBuilder() {
		chamouAbertura = false;
		chamouFechamento = false;
		chamouMinimo = false;
		chamouMaximo = false;
		chamouVolume = false;
		chamouData = false;
	}
	
	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		chamouAbertura = true;
		return this;
	}
	
	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		chamouFechamento = true;
		return this;
	}
	
	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		chamouMinimo = true;
		return this;
	}
	
	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		chamouMaximo = true;
		return this;
	}
	
	public CandleBuilder comVolume(double volume) {		
		this.volume = volume;
		chamouVolume = true;
		return this;
	}
	
	public CandleBuilder comData(Calendar data) {
		this.data = data;
		chamouData = true;
		return this;
	}
	
	public boolean verificaSeChamouTodosOsMetodos() {
		return chamouAbertura && chamouData 
				&& chamouFechamento && chamouMaximo 
				&& chamouMinimo && chamouVolume ? true : false;
	}
	
	public Candle geraCandle() { 
		
		if (verificaSeChamouTodosOsMetodos() == false) {			
			throw new IllegalStateException("Obrigatório passar todos os parâmetros.");
		} else {
			return new Candle(abertura, fechamento, minimo, maximo,
					volume, data);
		}
	}
		
}
