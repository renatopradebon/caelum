package br.com.caelum.argentum.teste;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactoryQuantidadeNegativa {

	public static void main(String[] args) {

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(30,-100,hoje); 		

		List<Negociacao> negociacoes = Arrays.asList(negociacao1);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

		System.out.println(candle);
	}
}
