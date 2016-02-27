package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandleFactoryBuilderTest {

	@Test(expected=IllegalArgumentException.class)
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {

		new CandleBuilder().comFechamento(20.0).comAbertura(10.0)
		.comMinimo(20.0).comMaximo(10.0).comVolume(1000.0).comData(Calendar.getInstance())
		.geraCandle();
	}
}