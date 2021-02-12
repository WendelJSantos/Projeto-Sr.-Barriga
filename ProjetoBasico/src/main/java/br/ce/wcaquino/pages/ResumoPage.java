package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ResumoPage extends BasePage {
	
	public void excluirMovimentacao() {
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMensagemDeSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}	
	
	public String obterTabelaVazia() {		
		return obterTexto(By.xpath("//tbody"));
	}	
	
	public void selecionarAno (String ano) {
		selecionarComboPorTextoVisivel("ano", ano);
	}
	
	public void buscar() {
		clicarBotao(By.xpath("//input[@value='Buscar']"));
	}

}
