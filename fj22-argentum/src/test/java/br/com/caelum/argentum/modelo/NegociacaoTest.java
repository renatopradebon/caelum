package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

import junit.framework.Assert;

public class NegociacaoTest {

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

}
