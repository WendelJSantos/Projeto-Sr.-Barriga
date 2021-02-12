package br.ce.wcaquino.core;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void escreve(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}

	public void escreveBy(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public void limparCampo(String id_campo) {
		getDriver().findElement(By.id(id_campo)).clear();
	}

	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

	public void clicarRadio(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}

	public boolean isRadioMarcado(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).isSelected();
	}

	public boolean isRadioMarcado(By by) {
		return getDriver().findElement(by).isSelected();
	}

	/**************************** COMBO ************************/

	public void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='" + radical + "_label']/../..//span"));
		clicarRadio(By.xpath("//*[@id='" + radical + "_items']/li[.='" + valor + "']"));
	}

	public void selecionarComboPorTextoVisivel(String id_campo, String valor) {
		new Select(getDriver().findElement(By.id(id_campo))).selectByVisibleText(valor);
	}

	public void selecionarComboPorTextoVisivel(By by, String valor) {
		new Select(getDriver().findElement(by)).selectByVisibleText(valor);
	}

	public String obterPrimeiraOpcaoSelecionada(String id_campo) {
		return new Select(getDriver().findElement(By.id(id_campo))).getFirstSelectedOption().getText();

	}

	public boolean isValorDoCombo(String id_campo, String valorEsperado) {
		Select combo = new Select(getDriver().findElement(By.id(id_campo)));
		List<WebElement> opcoes = combo.getOptions();
		boolean encontrou = false;
		for (WebElement option : opcoes) {
			if (option.getText().equals(valorEsperado)) {
				encontrou = true;
			}
		}
		return encontrou;
	}

	public void clicarBotao(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarBotaoPorTexto(String texto) {
		getDriver().findElement(By.xpath("//button[.='"+texto+"']")).click();;
	}

	public void clicarLink(String id) {
		getDriver().findElement(By.linkText(id)).click();
	}

	public void clicarLink(By by) {
		getDriver().findElement(by).click();
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public String obterTexto(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getText();
	}

	public String obterValorDoAtributo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

	public void encontrarId(String id) {
		getDriver().findElement(By.id(id));
	}

	public int obterQuantidadeDeItensSelecionados(String id_campo) {
		WebElement elemento_id = getDriver().findElement(By.id(id_campo));
		Select combo = new Select(elemento_id);
		List<WebElement> opcoes = combo.getAllSelectedOptions();
		opcoes = combo.getAllSelectedOptions();
		return opcoes.size();
	}

	public void alternarParaFrame(String frame) {
		getDriver().switchTo().frame(frame);
	}

	public void alternarParaAlert() {
		getDriver().switchTo().alert();
	}

	public void alternarParaPaginaPrincipal() {
		getDriver().switchTo().defaultContent();
	}

	public String obterTextoAlert() {
		return getDriver().switchTo().alert().getText();
	}

	public void confirmarAlert() {
		getDriver().switchTo().alert().accept();
	}

	public void recusarAlert() {
		getDriver().switchTo().alert().dismiss();
	}

	public void alertaObterTextoEAceita() {
		getDriver().switchTo().alert().getText();
		getDriver().switchTo().alert().accept();
	}

	public void alternarWindowComParametro(String window) {
		getDriver().switchTo().window(window);
	}

	public void alternarWindowSemReferencia() {
		getDriver().switchTo().window("");
	}

	public void fecharAba() {
		getDriver().close();
	}

	/**************************************
	 * JAVA SCRIPT
	 ********************************/

	public Object executarJS(String cmd, Object param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(cmd, param);
	}

	/************************************** TABELA ********************************/

	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		// procurar a coluna do registro
		// *[@id='elementosForm:tableUsuarios']//th
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+ idTabela +"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);

		// encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);

		// descobrir em qual coluna está o botão desejado
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

		// clicar no botão da celula encontrada
		WebElement celula = tabela.findElement(By.xpath("//tr[" + idLinha + "]/td[" + idColunaBotao + "]"));
		return celula;

	}
	
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();

	}

	public int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + idColuna + "]"));
		int idLinha = -1;
		for (int i = 0; i < linhas.size(); i++) {
			if (linhas.get(i).getText().equals(valor)) {
				idLinha = i + 1;
				break;
			}
		}
		return idLinha;
	}

	public int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for (int i = 0; i < colunas.size(); i++) {
			if (colunas.get(i).getText().equals(coluna)) {
				idColuna = i + 1;
				break;
			}
		}
		return idColuna;
	}

}
