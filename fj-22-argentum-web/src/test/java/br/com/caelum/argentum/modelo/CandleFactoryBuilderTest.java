package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandleFactoryBuilderTest {

	@Test
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
		new Candle(10.0, 20.0, 20.0, 10.0, 10000.0, Calendar.getInstance());
	}

}
