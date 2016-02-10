package br.com.caelum.argentum.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

public class Negociacao {
	private final BigDecimal preco;
	private final BigDecimal quantidade;
	private final Calendar data;
	
	public Negociacao(BigDecimal d, BigDecimal i, Calendar data) {
		this.preco = d;
		this.quantidade = i;
		this.data = data;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return data;
	}
	
	public BigDecimal getVolume() {
		return preco.multiply(quantidade); 
	}
}
