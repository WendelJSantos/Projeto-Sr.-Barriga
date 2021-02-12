package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.HomePage;
import br.ce.wcaquino.pages.MenuPage;

public class SaldoTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	HomePage page = new HomePage();
	
	@Test
	public void testSaldoDaConta() {
		menuPage.acessarTelaHome();
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}
	

}
