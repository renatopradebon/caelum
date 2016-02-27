package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {
	
	private int intervalo;
	private Indicador outroIndicador;

	public MediaMovelSimples(int intervalo, Indicador outroIndicador) {
		this.intervalo = intervalo;
		this.outroIndicador = outroIndicador;
	}
	
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		
		for (int i = posicao; i > posicao - intervalo; i--) {
			soma += outroIndicador.calcula(posicao, serie);
		}
		
		return soma / intervalo;
	}
	
	@Override
	public String toString() {
		return "MMS de Fechamento";
	}
	
}