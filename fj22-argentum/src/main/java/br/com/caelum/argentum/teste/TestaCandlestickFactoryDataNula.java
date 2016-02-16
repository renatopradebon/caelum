package br.com.caelum.argentum.teste;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandlestickFactoryDataNula {

	public static void main(String[] args) {
		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(10.0, 5, null); 		

		List<Negociacao> negociacoes = Arrays.asList(negociacao1);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);		
		
		System.out.println(candle);

	}

}
