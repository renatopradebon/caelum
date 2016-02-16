package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candlestick(10.0, 20.0, 20.0, 10.0, 10000.0, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dataNaoPodeSerNula() {
		new Candlestick(10.0, 25.0, 10.0, 10.0, 10000.0, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPodeExistirValorNegativo() {
		new Candlestick(-10.0, -25.0, -10.0, -10.0, -10000.0, null);
	}
}
