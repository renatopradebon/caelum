package br.com.caelum.argentum.indicadores;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimplesDeCandlesComTresDias() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		MediaMovelPonderada mmp = new MediaMovelPonderada(3, new IndicadorAbertura());
		
		// ex: calcula(2): 1*1 + 2*2 +3*3 = 14. Divide por 6, da 14/6
		Assert.assertEquals(14.0 / 6, mmp.calcula(2, serie), 0.00001);				
		Assert.assertEquals(20.0 / 6, mmp.calcula(3, serie), 0.00001);
		Assert.assertEquals(26.0 / 6, mmp.calcula(4, serie), 0.00001);
		Assert.assertEquals(32.0 / 6, mmp.calcula(5, serie), 0.00001);
	}
	
	@Test
	public void sequenciaSimplesDeCandlesComCincoDias() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		MediaMovelPonderada mmp = new MediaMovelPonderada(5, new IndicadorFechamento());
		
		// ex: calcula(2): 1*1 + 2*2 +3*3 = 14. Divide por 6, da 14/6
		Assert.assertEquals(55.0 / 15, mmp.calcula(4, serie), 0.00001);				
		Assert.assertEquals(70.0 / 15, mmp.calcula(5, serie), 0.00001);
		Assert.assertEquals(85.0 / 15, mmp.calcula(6, serie), 0.00001);
		Assert.assertEquals(100.0 / 15, mmp.calcula(7, serie), 0.00001);
	}

}
