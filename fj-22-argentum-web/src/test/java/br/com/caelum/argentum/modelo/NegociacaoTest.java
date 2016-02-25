package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import junit.framework.Assert;

public class NegociacaoTest {

	@SuppressWarnings("deprecation")
	@Test
	public void dataDaNegociacaoEhImutavel() {
		// se criar um negocio no dia 15...
		Calendar hoje = Calendar.getInstance();
		
		hoje.set(Calendar.DAY_OF_MONTH, 15);
		
		Negociacao negociacao = new Negociacao(10, 5, hoje);
		
		// ainda que eu tente mudar a data para 20...
		negociacao.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		// ele continua no dia 15.
		Assert.assertEquals(15, negociacao.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
		new Negociacao(10.0, 6, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComPrecoNulo() {
		new Negociacao(0, 6, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComQuantidadeNula() {
		new Negociacao(10.0, 0, Calendar.getInstance());
	}
	
	@Test
	public void mesmoMilissengundoEhdoMesmoDia() {
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		
		Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
		// utilizando gregory calendar (ano, mes, dia, hora, minuto
		Calendar manha = new GregorianCalendar(2016, 2, 17, 8, 30);
		Calendar tarde = new GregorianCalendar(2016, 2, 17, 15, 30)	;
		
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
		// utilizando gregory calendar (ano, mes, dia, hora, minuto
		Calendar data1 = new GregorianCalendar(2016, 2, 17, 8, 30);
		Calendar data2 = new GregorianCalendar(2016, 3, 17, 15, 30)	;
		
		Negociacao negociacao = new Negociacao(40.0, 100, data1);
		Assert.assertFalse(negociacao.isMesmoDia(data2));
	}
	
	@Test
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
		// utilizando gregory calendar (ano, mes, dia, hora, minuto
		Calendar data1 = new GregorianCalendar(2017, 2, 17, 8, 30);
		Calendar data2 = new GregorianCalendar(2016, 2, 17, 15, 30)	;
		
		Negociacao negociacao = new Negociacao(40.0, 100, data1);
		Assert.assertFalse(negociacao.isMesmoDia(data2));
	}
}
