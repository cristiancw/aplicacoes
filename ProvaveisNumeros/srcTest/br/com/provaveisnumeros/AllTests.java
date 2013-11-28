package br.com.provaveisnumeros;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ //
CarregarResultados_Test.class, //
		FiltrarResultados_Test.class, //
		BuscaFrequencia_Test.class, //
		CalcularCombinacao_Test.class //
})
public class AllTests {

}
