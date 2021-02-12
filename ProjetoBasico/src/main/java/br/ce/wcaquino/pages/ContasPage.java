package br.ce.wcaquino.pages;

import java.util.Random;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ContasPage extends BasePage {

	public void setNomeRandom(String nome) {
		Random gerador = new Random();
		int numero = 0;
		for (int i = 0; i <= 100; i++) {
			numero = gerador.nextInt(100);
		}
		escreve("nome", nome + numero);
	}

	public void setNome(String nome) {
		escreve("nome", nome);
	}
	
	public void limparNome() {
		 limparCampo("nome");
	}

	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}

	public String obterMensagemDeSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	public String obterMensagemDeErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
		
	public void clicarAlterarConta(String conta) {
		obterCelula("Conta", conta,"Ações", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
		
	}

	public void clicarExcluirConta(String conta) {
		obterCelula("Conta", conta, "Ações", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}
	
}
