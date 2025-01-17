package br.caelum.argentum.reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;
import junit.framework.Assert;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
	
		String xmlDeTeste = "<list>" +
								"<negociacao>" +
									"<preco>43.5</preco>" +
									"<quantidade>1000</quantidade>" +
									"<data>" +
										"<time>1322233344455</time>" +
									"</data>" +
									"</negociacao>" +
							"</list>";
				
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);		
		
		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco(), 0.00001);
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());		
	}

	@Test
	public void carregaXmlComZeroNegociacoes() {
	
		String xmlDeTeste = "<list></list>";
				
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);		
			
		Assert.assertTrue("lista vazia", negociacoes.isEmpty());		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void carregaXmlComPrecoNulo() {
	
		String xmlDeTeste = "<list>" +
								"<negociacao>" +
									"<quantidade>1000</quantidade>" +
									"<data>" +
										"<time>1322233344455</time>" +
									"</data>" +
								"</negociacao>" +
							"</list>";
				
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		System.out.println(negociacoes.toString());
//		assertEquals(0, negociacoes.size());
	}
}
