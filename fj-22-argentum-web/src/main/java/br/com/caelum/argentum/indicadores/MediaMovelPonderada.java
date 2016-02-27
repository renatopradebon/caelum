package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {
	
	private int intervalo;
	private Indicador outroIndicador;

	public MediaMovelPonderada(int intervalo, Indicador outroIndicador) {
		this.intervalo = intervalo;
		this.outroIndicador = outroIndicador;
	}

	public double calcula(int posicao, SerieTemporal serie) {
		
		double soma = 0.0;
		int peso = intervalo;
		int somaPeso = 0;
		
		for (int i = posicao; i > (posicao - intervalo); i--) {					
			soma += outroIndicador.calcula(posicao, serie) * peso;
			somaPeso += peso;
			peso--;			
		}
		
		return soma / somaPeso;
	}
	
	@Override
	public String toString() {
		return "MMP de Fechamento";
	}
}