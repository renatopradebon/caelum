package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class CandleTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candle(10.0, 20.0, 20.0, 10.0, 10000.0, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dataNaoPodeSerNula() {
		new Candle(10.0, 25.0, 10.0, 10.0, 10000.0, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoPodeExistirValorNegativo() {
		new Candle(-10.0, -25.0, -10.0, -10.0, -10000.0, null);
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {
		Candle candle = new Candle(10.0, 10.0, 15.0, 20.0, 10000.0, Calendar.getInstance());
		
		Assert.assertEquals(true, candle.isAlta());
		
	}
}
