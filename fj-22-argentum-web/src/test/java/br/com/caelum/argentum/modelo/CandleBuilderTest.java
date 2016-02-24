package br.com.caelum.argentum.modelo;

import org.junit.Test;

public class CandleBuilderTest {

	@Test(expected=IllegalStateException.class)
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
		
		new CandleBuilder()//.comFechamento(10.0).comAbertura(8.0)
				//.comMinimo(5.0).comMaximo(12.0).comVolume(35.0).comData(Calendar.getInstance())
				.geraCandle();
		
	}
}
