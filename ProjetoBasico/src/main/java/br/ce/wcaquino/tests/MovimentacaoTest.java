package br.ce.wcaquino.tests;

import static br.ce.wcaquino.utils.DataUtils.obterDataComDiferencaDias;
import static br.ce.wcaquino.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;


public class MovimentacaoTest extends BaseTest{
	
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.selecionarComboTipoDaMovimentacao("Receita");
		movPage.inserirDataDaMovimentacao(obterDataFormatada(new Date()));
		movPage.inserirDataDoPagamento(obterDataFormatada(new Date()));
		movPage.inserirDescricao("Pagamento realizado");
		movPage.inserirInteressado("Wendel Santos");
		movPage.inserirValor("1000");
		movPage.selecionarConta("Conta para movimentacoes");
		movPage.selecionarSituacaoPago();
		movPage.salvar();
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", movPage.obterMensagemDeSucesso());
	}
	
	@Test
	public void test2_CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		
//		Assert.assertEquals("Data da Movimenta��o � obrigat�rio", erros.get(0));
//		Assert.assertTrue(erros.contains("Data da Movimenta��o � obrigat�rio"));
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero")));		
		Assert.assertEquals(6, erros.size());		
	}
	
	@Test
	public void test3_InserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		movPage.selecionarComboTipoDaMovimentacao("Receita");
		
		Date dataFutura = obterDataComDiferencaDias(5); 
		
		movPage.inserirDataDaMovimentacao(obterDataFormatada(dataFutura));
		movPage.inserirDataDoPagamento(obterDataFormatada(dataFutura));
		movPage.inserirDescricao("Pagamento realizado");
		movPage.inserirInteressado("Wendel Santos");
		movPage.inserirValor("1000");
		movPage.selecionarConta("Conta para movimentacoes");
		movPage.selecionarSituacaoPago();
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		Assert.assertTrue(erros.contains("Data da Movimenta��o deve ser menor ou igual � data atual"));		
		Assert.assertEquals(1, erros.size());	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
