package br.com.caelum.argentum.modelo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {
	private final BigDecimal abertura;
	private final BigDecimal fechamento;
	private final BigDecimal minimo;
	private final BigDecimal maximo;
	private final BigDecimal volume;
	private final Calendar data;
	
	public Candlestick(BigDecimal abertura, BigDecimal fechamento, BigDecimal minimo, 
			           BigDecimal maximo, BigDecimal volume, Calendar data) {
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public BigDecimal getAbertura() {
		return abertura;
	}

	public BigDecimal getFechamento() {
		return fechamento;
	}

	public BigDecimal getMinimo() {
		return minimo;
	}

	public BigDecimal getMaximo() {
		return maximo;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}
	
	public String getDataFormatada() {			
		return new SimpleDateFormat("dd/MM/yyyy").format(getData().getTime());			
	}
	
	public boolean isAlta() {
		return (this.abertura.compareTo(this.fechamento) > 0) ? true : false;
	}
	
	public boolean isBaixa() {
		return (this.fechamento.compareTo(this.abertura) > 0) ? true : false;
	}

	@Override
	public String toString() {
		return "Candlestick [Abertura=" + abertura + ", Fechamento=" + fechamento + ", Mínimo=" + minimo + ", Máximo="
				+ maximo + ", Volume=" + volume.toString() + ", data=" + getDataFormatada() + "]";	
	}
}
