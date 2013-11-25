package br.com.provaveisnumeros;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ //
CarregarResultados_Test.class, //
		FiltraResultados_Test.class, //
		CalculaResultadoProvavel_Test.class //
})
public class AllTests {

}
