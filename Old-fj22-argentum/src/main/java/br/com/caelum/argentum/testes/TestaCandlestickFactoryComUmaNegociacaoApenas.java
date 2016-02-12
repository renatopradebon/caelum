package br.com.caelum.argentum.testes;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactoryComUmaNegociacaoApenas {

	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();
//		hoje.add(Calendar.MONTH, 1);
		
		Negociacao negociacao1 = new Negociacao(new BigDecimal("40.50"), new BigDecimal("100.00"), hoje);		
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);
				
		System.out.println(candle);

	}

}
