package br.com.projedata.arcturus.teste.metodosgenericos;

import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.atalhoFerramentas;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.botaoAcessarAtualizador;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.botaoCancelarAtualizacao;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.botaoConfirmarRepasse;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.botaoEnviarAtualizacao;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.botaoVoltarAoPortal;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.campoAcao;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.campoDestinoRepasse;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.campoDetalhesRepasse;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.cancelarReservarRotina;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.historicoDisponivelParaTestes;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.idAtualizacao;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.idAtualizacaoDesabilitada;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.janelaConfirmacao;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.janelaRepasse;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.listaOpcoesAtalhoFerramentas;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.mensagemAtualizacaoCancelada;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.mensagemConfirmaCancelarAtualizacao;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.mensagemRotinaEmUso;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.mensagemSucesso;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.menuAtualizacoes;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.reservarRotina;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.resgatarAtualizacao;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.simConfirmacao;
import static br.com.projedata.arcturus.teste.webelements.AtualizadorElementos.subMenuAtualizacoes;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.botaoConfirmarCriarNovoObjeto;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.botaoNovoObjeto;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.campoNomeNovoObjeto;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.campoTipoNovoObjeto;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.janelaCriarNovoObjeto;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.mensagemConfirmaCriacaoObjeto;
import static br.com.projedata.arcturus.teste.webelements.ObjetoNegocioAtualizadorElementos.nomeObjeto;
import static br.com.projedata.arcturus.teste.webelements.RotinasAtualizadorElementos.simNotificacao;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;
import br.com.projedata.arcturus.teste.testes.TesteAtualizador;
import br.com.projedata.arcturus.teste.webelements.PortalElementos;

public class AtualizadorMetodos {
	
	private TesteGenerico teste;
	
	public AtualizadorMetodos(TesteGenerico teste) {
		this.teste = teste;
	}
	
	public void deslogarPortal(WebDriver driver) throws AWTException, InterruptedException {
		teste.navegador.irParaNovaUrlEmNovaAba("url" +"/#/login");
		
	}
	
	public void acessarAtualizador(WebDriver driver) {
		teste.acao.clicarNoElemento(teste.menuConfiguracoes);
		teste.espera.aguardarElementoEstarVisivel(botaoAcessarAtualizador);
		teste.espera.aguardarElementoEstarVisivel(teste.menuConfiguracoesAberto);
		teste.acao.clicarNoElemento(botaoAcessarAtualizador);
		teste.navegador.trocarDeAba();
		teste.espera.aguardarElementoEstarVisivel(atalhoFerramentas);
	}

	public void voltarAoPortal() {
		teste.acao.clicarNoElemento(atalhoFerramentas);
		teste.espera.aguardarElementoEstarVisivel(listaOpcoesAtalhoFerramentas);
		teste.acao.clicarNoElemento(botaoVoltarAoPortal);
		teste.espera.aguardarElementoEstarVisivel(PortalElementos.localizarRotina);
		teste.espera.aguardarSistemaCarregar();
	}

	public void realizarRepasseParaUsuario(String repasse, String destino) {
		teste.msg.fecharNotificacaoCantoDaTela();
		teste.espera.aguardarElementoEstarVisivel(botaoEnviarAtualizacao);
		teste.mouse.scrollParaElemento(botaoEnviarAtualizacao);
		teste.acao.clicarNoElemento(botaoEnviarAtualizacao);
		teste.espera.aguardarElementoEstarVisivel(janelaRepasse);
		teste.acao.selecionarNoElemento(campoAcao, repasse);
		teste.acao.selecionarNoElemento(campoDestinoRepasse, destino);
		teste.acao.escreverNoElemento(campoDetalhesRepasse, "Teste automação Repasse");
		teste.acao.clicarNoElemento(botaoConfirmarRepasse);
		teste.espera.aguardarElementoEstarVisivel(mensagemSucesso);
		teste.msg.fecharMensagemNotificacao();
		teste.espera.aguardarElementoDesaparecer(mensagemSucesso);
	}

	public void realizarRepasseFilaUnica(String repasse) {
		teste.teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		teste.mouse.scrollParaElemento(botaoEnviarAtualizacao);
		teste.msg.fecharNotificacaoCantoDaTela();
		teste.acao.clicarNoElemento(botaoEnviarAtualizacao);
		teste.espera.aguardarElementoEstarVisivel(janelaRepasse);
		teste.acao.selecionarNoElemento(campoAcao, repasse);
		teste.acao.escreverNoElemento(campoDetalhesRepasse, "Teste automação Repasse");
		teste.acao.clicarNoElemento(botaoConfirmarRepasse);
		teste.espera.aguardarElementoEstarVisivel(mensagemSucesso);
		teste.teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		teste.espera.aguardarElementoDesaparecer(mensagemSucesso);
	}
	
	public void cancelarAtualizacaoParaDesbloquearRotina() {
		String mensagem = teste.acao.localizarElemento(mensagemRotinaEmUso).getText();
		teste.msg.fecharMensagemNotificacao();
		teste.espera.aguardarElementoDesaparecer(teste.msg.fecharMensagemNotificacao);
		teste.espera.aguardarElementoEstarVisivel(reservarRotina);
		teste.acao.clicarNoElemento(cancelarReservarRotina);
		String lastWord = mensagem.substring(mensagem.lastIndexOf(" ") + 1);
		teste.espera.aguardarElementoDesaparecer(cancelarReservarRotina);
		teste.espera.aguardarElementoSerClicavel(menuAtualizacoes);
		teste.acao.clicarNoElemento(menuAtualizacoes);
		teste.acao.escreverNoElemento(idAtualizacao, lastWord);
		teste.teclado.pressionarTeclaDeControle(Keys.ENTER);
		teste.espera.aguardarElementoEstarVisivel(idAtualizacaoDesabilitada);
		if (teste.acao.localizarElementos(historicoDisponivelParaTestes).size() != 0) {
			teste.teclado.pressionarTeclaDeControle(Keys.ESCAPE);
			teste.msg.fecharNotificacaoCantoDaTela();
			teste.mouse.scrollParaElemento(resgatarAtualizacao);
			teste.acao.clicarNoElemento(resgatarAtualizacao);
			teste.espera.aguardarElementoEstarVisivel(janelaConfirmacao);
			teste.acao.clicarNoElemento(simConfirmacao);
			teste.espera.aguardarElementoEstarVisivel(mensagemSucesso);
			teste.msg.fecharMensagemNotificacao();
			teste.teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		}
		teste.mouse.scrollUp();
		teste.acao.clicarNoElemento(subMenuAtualizacoes);
		teste.espera.aguardarElementoEstarVisivel(botaoCancelarAtualizacao);
		teste.acao.clicarNoElemento(botaoCancelarAtualizacao);
		teste.espera.aguardarElementoEstarVisivel(mensagemConfirmaCancelarAtualizacao);
		teste.acao.clicarNoElemento(simConfirmacao);
		teste.espera.aguardarElementoDesaparecer(mensagemConfirmaCancelarAtualizacao);
		teste.espera.aguardarElementoEstarVisivel(mensagemAtualizacaoCancelada);
		teste.acao.clicarNoElemento(menuAtualizacoes);
		teste.acao.escreverNoElemento(idAtualizacao, TesteAtualizador.numeroAtualizacao);
		teste.teclado.pressionarTeclaDeControle(Keys.ENTER);
		teste.espera.aguardarElementoEstarVisivel(idAtualizacaoDesabilitada);
	}
	
	public By mensagemOsEmUso(String numeroOs) {
		return By.xpath("//*[contains(text(),'Ordem de serviço número " + numeroOs + " em uso na atualização')]");
	}
	
	public void criarObjeto() throws InterruptedException{
		teste.acao.clicarNoElemento(botaoNovoObjeto);
		teste.espera.aguardarElementoEstarVisivel(janelaCriarNovoObjeto);
		Thread.sleep(200);

		nomeObjeto = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		teste.acao.escreverNoElemento(campoNomeNovoObjeto, nomeObjeto);
		Thread.sleep(200);
		teste.acao.selecionarNoElemento(campoTipoNovoObjeto, "Tabela");
		Thread.sleep(400);
		teste.acao.clicarNoElemento(botaoConfirmarCriarNovoObjeto);
		teste.espera.aguardarElementoEstarVisivel(mensagemConfirmaCriacaoObjeto);
		teste.espera.aguardarElementoSerClicavel(simNotificacao);
		teste.acao.clicarNoElemento(simNotificacao);
		Thread.sleep(500);
		teste.espera.aguardarElementoDesaparecer(mensagemConfirmaCriacaoObjeto);
	}

}
