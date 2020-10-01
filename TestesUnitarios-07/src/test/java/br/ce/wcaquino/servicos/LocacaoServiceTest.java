package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Test
	public void testLocacaoService() throws Exception {

		// Scenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Anderson");
		Filme filme = new Filme("God Father", 0, 5.0);

		// try {

		// Action
		Locacao locacao = service.alugarFilme(usuario, filme);

		// Verify
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));

		// } catch (Exception e) {
		// e.printStackTrace();
		// Assert.fail("Nao deveria mostrar excecao.");
		// }

	}

}
