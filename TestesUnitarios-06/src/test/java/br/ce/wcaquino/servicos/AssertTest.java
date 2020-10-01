package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {
	
	@Test
	public void testAssert() {
	
		
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		Assert.assertEquals(1, 1);
		Assert.assertEquals(5.1, 5.1, 0.01);
		Assert.assertEquals(5.1234, 5.12, 0.01);
		
		int v1 = 8;
		Integer v2 = 8;
		
		Assert.assertEquals(v1, v2.intValue());
		Assert.assertEquals(Integer.valueOf(v1), v2);
		Assert.assertEquals("anderson", "anderson");
		Assert.assertTrue("anderson".equalsIgnoreCase("Anderson"));
		
		Usuario user1 = new Usuario("Anderson");
		Usuario user2 = new Usuario("Anderson");
		Usuario user3 = null;
		
		Assert.assertEquals(user1, user2);
		Assert.assertSame(user1, user1);
		
		Assert.assertTrue(user3 == null);
		Assert.assertNull(user3);
		
		Assert.assertNotEquals("joao", "gustavo");
		Assert.assertNotSame(user1, user2);
		Assert.assertNotNull(user2);
		
	}
}
