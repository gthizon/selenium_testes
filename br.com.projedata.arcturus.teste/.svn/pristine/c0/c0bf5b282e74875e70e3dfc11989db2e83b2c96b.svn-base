package br.com.projedata.arcturus.teste.metodosgenericos;

import static br.com.projedata.arcturus.teste.webelements.PainelRelatoriosElementos.abrirPasta;
import static br.com.projedata.arcturus.teste.webelements.PainelRelatoriosElementos.botaoAdicionarPasta;
import static br.com.projedata.arcturus.teste.webelements.PainelRelatoriosElementos.botaoConfirmarGrupo;
import static br.com.projedata.arcturus.teste.webelements.PainelRelatoriosElementos.botaoMoverParaPasta;
import static br.com.projedata.arcturus.teste.webelements.PainelRelatoriosElementos.campoNomeGrupo;
import static br.com.projedata.arcturus.teste.webelements.PainelRelatoriosElementos.modalAlterarGrupo;
import static br.com.projedata.arcturus.teste.webelements.PainelRelatoriosElementos.modalSelecionarGrupo;
import static br.com.projedata.arcturus.teste.webelements.PainelRelatoriosElementos.navegarParaPastaSeguinte;
import static br.com.projedata.arcturus.teste.webelements.PainelRelatoriosElementos.selecionarGrupo;
import static br.com.projedata.arcturus.teste.webelements.PainelRelatoriosElementos.selecionarPastaParaMoverRelatorio;

import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class PainelRelatoriosMetodos {
	
	private TesteGenerico teste;

	public PainelRelatoriosMetodos(TesteGenerico teste) {
		this.teste = teste;
	}
	
	public void criarPasta(String nomePasta) {
		teste.espera.aguardarElementoEstarVisivel(botaoAdicionarPasta);
		teste.acao.clicarNoElemento(botaoAdicionarPasta);
		teste.espera.aguardarElementoEstarVisivel(modalAlterarGrupo);
		teste.acao.escreverNoElemento(campoNomeGrupo, nomePasta);
		teste.acao.clicarNoElemento(botaoConfirmarGrupo);
		teste.espera.aguardarElementoDesaparecer(botaoConfirmarGrupo);
		teste.espera.aguardarElementoEstarVisivel(selecionarGrupo(nomePasta));
		
	}
	
	public void moverRelatorioParaPastaCriada(String relatorio, String grupo) {
		teste.espera.aguardarElementoEstarVisivel(botaoMoverParaPasta(relatorio));
		teste.acao.clicarNoElemento(botaoMoverParaPasta(relatorio));
		teste.espera.aguardarElementoEstarVisivel(modalSelecionarGrupo);
		teste.acao.clicarNoElemento(selecionarPastaParaMoverRelatorio(grupo));
		teste.espera.aguardarElementoDesaparecer(modalSelecionarGrupo);
		teste.testar.passouSeElementoNaoExistir(botaoMoverParaPasta(relatorio));
		teste.acao.clicarNoElemento(abrirPasta(grupo));
		teste.espera.aguardarElementoEstarVisivel(botaoMoverParaPasta(relatorio));
	}
	
	public void moverRelatorioParaPastaCriadaComSubNivel(String relatorio, String pastaPrincipal, String pastaDestino) {
		teste.acao.clicarNoElemento(botaoMoverParaPasta(relatorio));
		teste.espera.aguardarElementoEstarVisivel(modalSelecionarGrupo);
		teste.espera.aguardarElementoEstarVisivel(navegarParaPastaSeguinte(pastaPrincipal));
		teste.acao.clicarNoElemento(navegarParaPastaSeguinte(pastaPrincipal));
		teste.espera.aguardarElementoEstarVisivel(selecionarPastaParaMoverRelatorio(pastaDestino));
		teste.acao.clicarNoElemento(selecionarPastaParaMoverRelatorio(pastaDestino));
		teste.espera.aguardarElementoDesaparecer(modalSelecionarGrupo);
		teste.testar.passouSeElementoNaoExistir(botaoMoverParaPasta(relatorio));
		teste.acao.clicarNoElemento(abrirPasta(pastaDestino));
		teste.espera.aguardarElementoEstarVisivel(botaoMoverParaPasta(relatorio));
	}

}
