package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {
	
	private int intervalo;

	public MediaMovelPonderada(int intervalo) {
		this.intervalo = intervalo;
	}

	public double calcula(int posicao, SerieTemporal serie) {
		
		double soma = 0.0;
		int peso = intervalo;
		int somaPeso = 0;
		
		for (int i = posicao; i > (posicao - intervalo); i--) {			
			Candle c = serie.getCandle(i);
			soma += c.getFechamento() * peso;
			somaPeso += peso;
			peso--;			
		}
		
//		System.out.println("posicao "+posicao);
//		System.out.println("soma "+soma);
//		System.out.println("somaPeso" + somaPeso);
		
		return soma / somaPeso;
	}
	
	@Override
	public String toString() {
		return "MMP de Fechamento";
	}
}