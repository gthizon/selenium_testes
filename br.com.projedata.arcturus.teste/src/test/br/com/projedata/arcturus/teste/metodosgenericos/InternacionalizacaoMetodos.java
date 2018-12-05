package br.com.projedata.arcturus.teste.metodosgenericos;

import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoAbrirIdiomas;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.botaoRecarregarMensagemConfirmacao;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.idiomaEspanhol;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.idiomaIngles;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.janelaAlterarIdioma;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.mensagemConfirmacaoIdiomaEspanhol;
import static br.com.projedata.arcturus.teste.webelements.PortalElementos.mensagemConfirmacaoIdiomaIngles;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class InternacionalizacaoMetodos {
	
	TesteGenerico teste;
	PortalMetodos portal;
	
	public InternacionalizacaoMetodos(TesteGenerico teste) {
		this.teste = teste;
	}
	
	public void alterarIdiomaParaEspanhol() {
		portal = new PortalMetodos(teste);
		teste.abrirMenuConfiguracoes();
		teste.acao.clicarNoElemento(botaoAbrirIdiomas);
		teste.espera.aguardarElementoEstarVisivel(janelaAlterarIdioma);
		teste.acao.clicarNoElemento(idiomaEspanhol);
		teste.espera.aguardarElementoDesaparecer(janelaAlterarIdioma);
		teste.espera.aguardarElementoEstarVisivel(mensagemConfirmacaoIdiomaEspanhol);
		teste.acao.clicarNoElemento(botaoRecarregarMensagemConfirmacao);
		teste.espera.aguardarElementoDesaparecer(mensagemConfirmacaoIdiomaEspanhol);
		teste.espera.aguardarSistemaCarregar();
		teste.espera.aguardarElementoEstarVisivel(portal.painelPortal("Más Usados"));
		teste.espera.aguardarElementoEstarVisivel(portal.painelPortal("Cumpleaños"));
		teste.espera.aguardarElementoEstarVisivel(portal.painelPortal("Empresa"));
		teste.espera.aguardarElementoEstarVisivel(portal.painelPortal("Favoritos"));
		teste.espera.aguardarElementoEstarVisivel(portal.painelPortal("Informes"));
	}
	
	public void alterarIdiomaParaIngles() {
		teste.abrirMenuConfiguracoes();
		teste.acao.clicarNoElemento(botaoAbrirIdiomas);
		teste.espera.aguardarElementoEstarVisivel(janelaAlterarIdioma);
		teste.acao.clicarNoElemento(idiomaIngles);
		teste.espera.aguardarElementoDesaparecer(janelaAlterarIdioma);
		teste.espera.aguardarElementoEstarVisivel(mensagemConfirmacaoIdiomaIngles);
		teste.acao.clicarNoElemento(botaoRecarregarMensagemConfirmacao);
		teste.espera.aguardarElementoDesaparecer(mensagemConfirmacaoIdiomaIngles);
		teste.espera.aguardarSistemaCarregar();
		teste.espera.aguardarElementoEstarVisivel(portal.painelPortal("Most Used"));
		teste.espera.aguardarElementoEstarVisivel(portal.painelPortal("Birthdays"));
		teste.espera.aguardarElementoEstarVisivel(portal.painelPortal("Company"));
		teste.espera.aguardarElementoEstarVisivel(portal.painelPortal("Favorites"));
		teste.espera.aguardarElementoEstarVisivel(portal.painelPortal("Reports"));
	}

}
