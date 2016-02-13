package br.com.caelum.argentum.modelo;
import java.util.Calendar;

public final class Negociacao {
	
	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negociacao(double preco, int quantidade, Calendar data) {
		// adiciona uma exceção quando a data for nula
		if(data == null) {
			throw new IllegalArgumentException("Data não pode ser nula.");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;				
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		// retorna um clone do atributo para que ele seja imutavel
		return (Calendar) this.data.clone();
	} 
	
	public double getVolume() {
		return preco * quantidade;
	}
}