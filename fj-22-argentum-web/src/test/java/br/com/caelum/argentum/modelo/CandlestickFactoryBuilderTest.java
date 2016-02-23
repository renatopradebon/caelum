package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickFactoryBuilderTest {

	@Test
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
		new Candlestick(10.0, 20.0, 20.0, 10.0, 10000.0, Calendar.getInstance());
	}

}
