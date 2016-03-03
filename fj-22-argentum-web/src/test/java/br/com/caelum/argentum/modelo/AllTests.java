package br.com.caelum.argentum.modelo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.caelum.argentum.indicadores.MediaMovelPonderadaTest;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.indicadores.MediaMovelSimplesTest;
import br.com.caelum.argentum.reader.LeitorXMLTest;
import br.com.caelum.argentum.ws.ClienteWebService;
import br.com.caelum.argentum.ws.ClienteWebServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ CandleBuilderTest.class, CandleFactoryBuilderTest.class, CandleFactoryTest.class, CandleTest.class,
		NegociacaoTest.class, SerieTemporalTest.class, LeitorXMLTest.class, ClienteWebServiceTest.class, 
		MediaMovelSimplesTest.class, MediaMovelPonderadaTest.class })
public class AllTests {

}
