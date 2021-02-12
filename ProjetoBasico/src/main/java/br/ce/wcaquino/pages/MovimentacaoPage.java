package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.wcaquino.core.BasePage;

public class MovimentacaoPage extends BasePage {
	
	public void selecionarComboTipoDaMovimentacao(String tipo) {
		selecionarComboPorTextoVisivel("tipo", tipo);
	}
	
	public void inserirDataDaMovimentacao(String data) {
		escreve("data_transacao", data);
	}
	
	public void inserirDataDoPagamento(String data) {
		escreve("data_pagamento", data);
	}

	public void inserirDescricao(String descricao) {
		escreve("descricao", descricao);
	}

	public void inserirInteressado(String interessado) {
		escreve("interessado", interessado);
	}
	
	public void inserirValor(String valor) {
		escreve("valor", valor);
	}
	
	public void selecionarConta(String conta) {
		selecionarComboPorTextoVisivel("conta", conta);
	} 
	
	public void selecionarSituacaoPago() {
		clicarRadio("status_pago");
	}
	
	public void selecionarSituacaoPendente() {
		clicarRadio("status_pendente");
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemDeSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}	
	
	public List<String> obterErros(){
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>();		
		for (WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;

	}
	
	
	
}
