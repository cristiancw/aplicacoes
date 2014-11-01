package br.com;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.provaveisnumeros.BuscaFrequencia_Test;
import br.com.provaveisnumeros.CalcularCombinacao_Test;
import br.com.provaveisnumeros.FiltrarResultados_Test;
import br.com.provaveisnumeros.ProvaveisNumeros_Test;
import br.com.provaveisnumeros.parse.CarregarResultados_Test;

@RunWith(Suite.class)
@SuiteClasses({ //
CarregarResultados_Test.class, //
		FiltrarResultados_Test.class, //
		BuscaFrequencia_Test.class, //
		CalcularCombinacao_Test.class, //
		ProvaveisNumeros_Test.class //
})
public class AllTests {

}
