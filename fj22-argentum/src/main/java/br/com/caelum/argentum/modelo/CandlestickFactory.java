package br.com.caelum.argentum.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {
	
	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		
		BigDecimal maximo = negociacoes.get(0).getPreco();
		BigDecimal minimo = negociacoes.get(0).getPreco();
		
		BigDecimal volume = new BigDecimal("0");
		
		int cont = 0;
		
		for (Negociacao negociacao : negociacoes) {
			
			volume = volume.add(negociacao.getVolume());
			
			System.out.println("passada " + cont + " = " + negociacao.getVolume().toString());
			cont++;
			if (negociacao.getPreco().compareTo(maximo) > 0) {				
				maximo = negociacao.getPreco();
			} else if (maximo.compareTo(negociacao.getPreco()) > 0) {
				minimo = negociacao.getPreco();
			}
		}
		
		BigDecimal abertura = negociacoes.get(0).getPreco();
		BigDecimal fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
	
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
}
