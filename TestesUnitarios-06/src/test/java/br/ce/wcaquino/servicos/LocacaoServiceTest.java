package br.ce.wcaquino.servicos;


import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Test
	public void testLocacaoService() {
		
		//Scenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Anderson");
		Filme filme = new Filme("God Father", 3, 5.0);
		
		//Action
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//ATENTION: Assert.assertThat deprecated on JUnit version 4.13
		
		//Verify
		assertThat(locacao.getValor(), is(equalTo(5.0)));
		assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		assertThat(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
		
	}

}
