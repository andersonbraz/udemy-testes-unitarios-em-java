package br.ce.wcaquino.servicos;


import java.util.Date;

import org.junit.Assert;
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
		
		//Verify
		Assert.assertTrue(service.getClass() == LocacaoService.class);
		Assert.assertTrue(locacao.getValor() == 5.0);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}

}
