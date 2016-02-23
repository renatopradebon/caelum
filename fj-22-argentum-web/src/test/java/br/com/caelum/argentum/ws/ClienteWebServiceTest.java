package br.com.caelum.argentum.ws;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;


public class ClienteWebServiceTest {

	public static void main(String[] args) throws FileNotFoundException {		
		
		List<Negociacao> negociacoes = new ClienteWebService().getNegociacoes();
		
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		stream.setMode(XStream.NO_REFERENCES);

		PrintStream out = new PrintStream(new File(System.getProperty("user.dir") + "/src/test/xml/negociacao3.xml"));
		out.println(stream.toXML(negociacoes));
	}
}