package br.ce.wcaquino.tests;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.ResumoPage;

public class ResumoTest extends BaseTest {

	MenuPage menuPage = new MenuPage();
	ResumoPage resumoPage = new ResumoPage();

	@Test
	public void test1_ExcluirMovimentacao() {
		menuPage.acessarTelaResumoMensal();
		resumoPage.excluirMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemDeSucesso());
	}

	@Test
	public void test2_ResumoMensal() {
		menuPage.acessarTelaResumoMensal();
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());

		resumoPage.selecionarAno("2016");
		resumoPage.buscar();
		
		List<WebElement> elementosEncontrados = DriverFactory.getDriver().findElements(By.xpath("//table[@id='tabelaSaldo']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
		
		// Assert.assertEquals("", resumoPage.obterTabelaVazia());

		/*try {
			DriverFactory.getDriver().findElement(By.xpath("//table[@id='tabelaSaldo']/tbody/tr"));
			Assert.fail();
		} catch (NoSuchElementException e) {

		}
		
		List<WebElement> elementosEncontrados = DriverFactory.getDriver().findElements(By.xpath("//table[@id='tabelaSaldo']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());*/
	}
}