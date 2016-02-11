package br.com.caelum.argentum.testes;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.caelum.argentum.modelo.CandleBuilder;
import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactory {
	
	public static void main(String[] args) {
		
		Calendar hoje = Calendar.getInstance();
		hoje.add(Calendar.MONTH, 1);
		
		Negociacao negociacao1 = new Negociacao(new BigDecimal("40.50"), new BigDecimal("100.00"), hoje);
		Negociacao negociacao2 = new Negociacao(new BigDecimal("45.00"), new BigDecimal("100.00"), hoje);
		Negociacao negociacao3 = new Negociacao(new BigDecimal("30.80"), new BigDecimal("100.00"), hoje);
		Negociacao negociacao4 = new Negociacao(new BigDecimal("42.30"), new BigDecimal("100.00"), hoje);
		Negociacao negociacao5 = new Negociacao(new BigDecimal("41.30"), new BigDecimal("100.00"), hoje);
		Negociacao negociacao6 = new Negociacao(new BigDecimal("39.30"), new BigDecimal("100.00"), hoje);
		
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, 
													 negociacao5, negociacao6);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
				
		System.out.println(candle);
	}

}
