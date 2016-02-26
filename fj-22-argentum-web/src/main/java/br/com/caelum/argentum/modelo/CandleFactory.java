package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandleFactory {

	public Candle constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		
		double minimo = negociacoes.isEmpty() ? 0 : Double.MAX_VALUE;
		double maximo = 0;		
		double volume = 0;

		for (Negociacao negociacao : negociacoes) {

			volume += negociacao.getVolume();

			double preco = negociacao.getPreco();
			if (preco > maximo) {
				maximo = preco;
			}
			
			if (preco < minimo) {
				minimo = preco;
			}			
		} 

		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size() - 1).getPreco();
		
		return new Candle(abertura, fechamento, minimo, maximo, volume, data);
	}

	public List<Candle> constroiCandles(List<Negociacao> todasNegociacoes) {
		List<Candle> candles = new ArrayList<Candle>();
		
		List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		
		Calendar dataAtual = todasNegociacoes.get(0).getData();
		
		for (Negociacao negociacao : todasNegociacoes) {
			// se ordem dos candles não for crescente
			if (negociacao.getData().before(dataAtual)) {
				throw new IllegalStateException("negociações em ordem errada");
			}
			// se a data for diferente do ultimo candle
			if(!negociacao.isMesmoDia(dataAtual)) {
				criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
				
				negociacoesDoDia = new ArrayList<Negociacao>();
				dataAtual = negociacao.getData();
			}
			negociacoesDoDia.add(negociacao);
		}
		
		criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);		

		return candles;
	}

	private void criaEGuardaCandle(List<Candle> candles, List<Negociacao> negociacoesDoDia, Calendar dataAtual) {
		Candle candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);				
		candles.add(candleDoDia);
	}
}
