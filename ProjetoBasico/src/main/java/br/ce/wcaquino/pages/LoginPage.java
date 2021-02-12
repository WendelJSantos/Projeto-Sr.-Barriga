package br.ce.wcaquino.pages;

import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class LoginPage extends BasePage{
	
	public void acessarTelaInicial() {
		getDriver().get("https://srbarriga.herokuapp.com/");	
		getDriver().manage().window().maximize();
	}
	
	public void setEmail(String email) {
		escreve("email", email);
	}
	
	public void setSenha(String senha) {
		escreve("senha", senha);
	}
	
	public void entrar() {
		clicarBotaoPorTexto("Entrar");
	}
	
	public void logar(String email, String senha) {
		acessarTelaInicial();
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	
	public void resetar() {
		clicarLink(By.linkText("reset"));
	}

}
