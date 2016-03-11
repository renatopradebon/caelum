package br.com.caelum.argentum.ws;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.argentum.modelo.Negociacao;
import junit.framework.Assert;

public class ClienteWebServiceTest {
	
	@Test
	public void TestXML() throws FileNotFoundException {		
		
		List<Negociacao> negociacoes = new ClienteWebService().getNegociacoes();
		
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		stream.setMode(XStream.NO_REFERENCES);

		File arquivoXml = new File(System.getProperty("user.dir") + "/src/test/xml/negociacao.xml");

		PrintStream out = new PrintStream(arquivoXml);
		out.println(stream.toXML(negociacoes));
		
		Assert.assertTrue(arquivoXml.length() > 0);
		Assert.assertTrue(arquivoXml.exists());
	}
}