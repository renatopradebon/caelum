package br.com.caelum.argentum.modelo;
import java.util.Calendar;

import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("negociacao")
public final class Negociacao {
	
	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negociacao(double preco, int quantidade, Calendar data) {
		if(data == null) {
			throw new IllegalArgumentException("Data não pode ser nula.");
		}
		
		if(preco <= 0) {
			throw new IllegalArgumentException("Preço deve ser maior que zero.");
		}
		
		if(quantidade <= 0) {
			throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
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

	@Override
	public String toString() {
		return "Negociacao [preco=" + preco + ", quantidade=" + quantidade + ", data=" + data + "]";
	}		
}