package br.com.caelum.argentum.bean;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandleFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;
import sun.invoke.empty.Empty;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {
		
	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	private String nomeMedia;
	private String nomeIndicadorBase;
	
	public ArgentumBean() {		
		this.negociacoes = new ClienteWebService().getNegociacoes();
		
		geraGrafico();
	}

	public void geraGrafico() {
		List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		
		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 7, serie.getUltimaPosicao());
		geradorGrafico.plotaIndicador(defineIndicador());
		
		this.modeloGrafico = geradorGrafico.getModeloGrafico();
	}
	
	private Indicador defineIndicador()  {
		Integer intervalo = 3;
		 
		if (naoSelecionouValores()) {
			return new MediaMovelSimples(intervalo, new IndicadorFechamento());
		}
		
		try {
			String pacote = "br.com.caelum.argentum.indicadores.";
			
			Class<?> classeIndicadorBase = Class.forName(pacote + nomeIndicadorBase);
			Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();
			
			Class<?> classeMedia = Class.forName(pacote + nomeMedia);
			Constructor<?> construtorMedia = classeMedia.getConstructor(int.class, Indicador.class);
			Indicador indicador = (Indicador) construtorMedia.newInstance(intervalo, indicadorBase);			
			
			return indicador;		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}

	public boolean naoSelecionouValores() {
		return (nomeIndicadorBase == null) || (nomeMedia == null) || 
			   (nomeIndicadorBase.isEmpty()) || (nomeMedia.isEmpty());
	}

	public ChartModel getModeloGrafico() {
		return modeloGrafico;
	}

	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}
	
	public String getNomeMedia() {
		return nomeMedia;
	}

	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}

	public String getNomeIndicadorBase() {
		return nomeIndicadorBase;
	}
	
	public void setNomeIndicadorBase(String nomeIndicadorBase) {
		this.nomeIndicadorBase = nomeIndicadorBase;
	}
}
