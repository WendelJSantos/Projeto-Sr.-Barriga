package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta() {		
		clicarLink("Contas");
		clicarLink("Adicionar");		
	}

	public void acessarTelaListarConta() {		
		clicarLink("Contas");
		clicarLink("Listar");		
	}
	
	public void acessarTelaHome() {
		clicarLink(By.linkText("Home"));		
	}
	
	public void acessarTelaInserirMovimentacao() {
		clicarLink(By.linkText("Criar Movimentação"));		
	}
	
	public void acessarTelaResumoMensal() {
		clicarLink(By.linkText("Resumo Mensal"));		
	}
	
	
	
}
