package br.com.projedata.arcturus.teste.testes;

import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.botaoAbrirRotinaModal;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.botaoCalendarioCampoData;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.botaoLovIdLista;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.botaoPermiteAlteracao;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.botaoPermiteExclusao;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.botaoPermiteInclusao;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.botaoabrirLovCampoListaBlocoMaster;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoCodigo;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoCodigoListaBlocoDetail;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoCodigoListaBlocoMaster;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoCodigoLov;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoComboBox;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoData;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoDataTabelaDinamica;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoDescricaoListaBlocoMaster;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoMultivalorado;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoNome;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoNomeBlocoDetail;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoNomeListaBlocoDetail;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoNumerico;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoQtde;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoQtdeItens;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoSituacao;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.campoValorBlocoMaster;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.descricaoCampoLovBlocoDetail;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.fecharRotinaModal;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.fecharRotinaPrincipal;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.maximizarRotinaModal;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.minimizarRotinaModal;
import static br.com.projedata.arcturus.teste.webelements.Teste02Elementos.rotinaModalCarregada;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.metodosgenericos.Teste02Metodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteRotinaTeste02 extends TesteGenerico {

	private Teste02Metodos teste02;
	LoginMetodos log;
	@Test(testName = "id: 1 - Abrir rotina")
	@Parameters(value = { "url", "login", "senha", "base" })
	public void abrirRotinaTeste02(String url, String loginTeste, String senha, String base) {
		log = new LoginMetodos(this);
		log.logar(loginTeste, senha, base);
		teste02 = new Teste02Metodos();
		rotina.selecionarRotina("teste02");
	}

	@Test(testName = "id: 2 - Verificar se metodo apos abrir rotina esta funcionando", dependsOnMethods = {"abrirRotinaTeste02"})
	public void testarEventoAposAbrirTela() {
		espera.aguardarAtributoDoElementoConterOValor(campoQtde, "value", "7");
		espera.aguardarAtributoDoElementoConterOValor(campoQtdeItens, "value", "18");
	}

	@Test(testName = "id: 3 - Criar registro sem alteração.", dependsOnMethods = { "testarEventoAposAbrirTela" })
	public void criarRegistroSemAlteracao() {
		acao.clicarNoElemento(rotina, rotina.botaoNovo);
		msg.aguardarMensagem("Registro deve ser informado ou excluído.");
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "id: 4 - Salvar registro sem alteração.", dependsOnMethods = { "criarRegistroSemAlteracao" })
	public void salvarRegistroSemAlteracao() {
		acao.clicarNoElemento(rotina, rotina.botaoSalvar);
		msg.aguardarMensagem("Nenhum registro alterado");
	}
	
	

	@Test(testName = "id: 5 - Excluir registro.", dependsOnMethods = { "salvarRegistroSemAlteracao" })
	public void excluirRegistro() {
		acao.escreverNoElemento(campoNome, "LUIZ");
		acao.clicarNoElemento(rotina, rotina.botaoExcluir);
		espera.aguardarElementoEstarVazio(campoNome);
	}

	@Test(testName = "id: 6 - Cancelar registro sem alteração.", dependsOnMethods = { "excluirRegistro" })
	public void cancelarRegistroSemAlteracao() {
		acao.limparElemento(campoNome);
		acao.escreverNoElemento(campoNome, "LUIZ");
		espera.aguardarAtributoDoElementoConterOValor(campoNome, "value", "LUIZ");
		espera.aguardarElementoEstarHabilitado(rotina.botaoCancelar);
		acao.clicarNoElemento(rotina, rotina.botaoCancelar);
		espera.aguardarElementoEstarVisivel(msg.naoConfirmacao);
		acao.clicarNoElemento(rotina, msg.naoConfirmacao);
		espera.aguardarElementoDesaparecer(msg.naoConfirmacao);
		espera.aguardarElementoEstarVazio(campoNome);
		
	}

	@Test(testName = "id: 7 - Cancelar registro sem alteração, selecionar opção sim.", dependsOnMethods = {
			"cancelarRegistroSemAlteracao" })
	public void cancelarRegistroSemAlteracaoOpcaoSim() {
		acao.limparElemento(campoNome);
		acao.escreverNoElemento(campoNome, "LUIZ");
		espera.aguardarAtributoDoElementoConterOValor(campoNome, "value", "LUIZ");
		espera.aguardarElementoEstarHabilitado(rotina.botaoCancelar);
		acao.clicarNoElemento(rotina, rotina.botaoCancelar);
		espera.aguardarElementoEstarVisivel(msg.simConfirmacao);
		acao.clicarNoElemento(msg.simConfirmacao);
		espera.aguardarElementoDesaparecer(msg.simConfirmacao);
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Informe um valor para o item Codigo.");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(msg.mensagemNotificacao);
	}

	@Test(testName = "id: 8 - Cancelar registro sem alteração, selecionar opção cancelar.", dependsOnMethods = {
			"cancelarRegistroSemAlteracaoOpcaoSim" })
	public void cancelarRegistroSemAlteracaoOpcaoCancelar() {
		acao.limparElemento(campoNome);
		acao.escreverNoElemento(campoNome, "LUIZ");
		espera.aguardarAtributoDoElementoConterOValor(campoNome, "value", "LUIZ");
		espera.aguardarElementoEstarHabilitado(rotina.botaoCancelar);
		acao.clicarNoElemento(rotina.botaoCancelar);
		espera.aguardarElementoEstarVisivel(msg.cancelarNotificacao);
		acao.clicarNoElemento(msg.cancelarNotificacao);
		espera.aguardarElementoDesaparecer(msg.cancelarNotificacao);
		rotina.aguardarProcessarRotina();
		espera.aguardarAtributoDoElementoConterOValor(campoNome, "value", "LUIZ");
	}

	@Test(testName = "id: 9 - Limpar registro.", dependsOnMethods = { "cancelarRegistroSemAlteracaoOpcaoCancelar" })
	public void limparRegistro() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		espera.aguardarElementoEstarVisivel(msg.naoConfirmacao);
		acao.clicarNoElemento(msg.naoConfirmacao);
		espera.aguardarElementoDesaparecer(msg.naoConfirmacao);
		espera.aguardarElementoEstarVazio(campoNome);
		espera.aguardarElementoEstarVazio(campoSituacao);
	}

	@Test(testName = "id: 10 - Consultar registro.", dependsOnMethods = { "limparRegistro" })
	public void consultarRegistroPorCodigo() {
		acao.escreverNoElemento(campoCodigo, "444");
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarAtributoDoElementoConterOValor(campoNome, "value", "REGISTRO 04");
		espera.aguardarAtributoDoElementoConterOValor(campoNomeBlocoDetail, 0, "value", "FILHO 04 04");
		espera.aguardarAtributoDoElementoConterOValor(campoNomeListaBlocoDetail, 3, "value", "Lista 04");
		espera.aguardarAtributoDoElementoConterOValor(descricaoCampoLovBlocoDetail, 0, "value", "Lista 04");
		espera.aguardarAtributoDoElementoConterOValor(descricaoCampoLovBlocoDetail, 1, "value", "Lista 02");
	}

	@Test(testName = "id: 11 - Consultar registro por código, verificar detalhes.", dependsOnMethods = {
			"consultarRegistroPorCodigo" })
	public void consultarRegistroPorCodigoDetalhe() {
		espera.aguardarAtributoDoElementoConterOValor(campoNomeBlocoDetail, 0, "value", "FILHO 04 04");
		espera.aguardarAtributoDoElementoConterOValor(campoNomeListaBlocoDetail, 3, "value", "Lista 04");
	}

	@Test(testName = "id: 12 - Consultar registro por código, verificar detalhes.", dependsOnMethods = {
			"consultarRegistroPorCodigoDetalhe" })
	public void consultarRegistroPorCodigoTabelaDinamica() {
		espera.aguardarAtributoDoElementoConterOValor(campoComboBox, "value", "S");
		espera.aguardarAtributoDoElementoConterOValor(campoNumerico, "value", "123,00");
		espera.aguardarAtributoDoElementoConterOValor(campoDataTabelaDinamica, "value", "22/03/2017");
		espera.aguardarAtributoDoElementoConterOValor(campoMultivalorado, 0, "value", "123");
		espera.aguardarAtributoDoElementoConterOValor(campoMultivalorado, 1, "value", "456");
		espera.aguardarAtributoDoElementoConterOValor(campoMultivalorado, 2, "value", "789");
		espera.aguardarAtributoDoElementoConterOValor(campoCodigoLov, 0, "value", "4");
		espera.aguardarAtributoDoElementoConterOValor(campoCodigoLov, 1, "value", "2");
		espera.aguardarAtributoDoElementoConterOValor(campoCodigoLov, 1, "value", "2");
		espera.aguardarAtributoDoElementoConterOValor(descricaoCampoLovBlocoDetail, 0, "value", "Lista 04");
		espera.aguardarAtributoDoElementoConterOValor(descricaoCampoLovBlocoDetail, 1, "value", "Lista 02");
		espera.aguardarAtributoDoElementoConterOValor(campoNomeListaBlocoDetail, 3, "value", "Lista 04");
	}

	@Test(testName = "id: 13 - Consultar todos os registros.", dependsOnMethods = {
			"consultarRegistroPorCodigoTabelaDinamica" })
	public void consultarTodosRegistros() {
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		espera.aguardarAtributoDoElementoConterOValor(campoCodigo, "value", "111");
	}

	@Test(testName = "id: 14 - Navegar para o próximo registro.", dependsOnMethods = { "consultarTodosRegistros" })
	public void navegarProximoRegistro() {
		acao.clicarNoElemento(rotina.botaoProximoRegistro);
		espera.aguardarAtributoDoElementoConterOValor(campoCodigo, "value", "222");
	}

	@Test(testName = "id: 15 - Navegar para próxima página.", dependsOnMethods = { "navegarProximoRegistro" })
	public void navegarProximaPagina() {
		acao.clicarNoElemento(rotina.botaoProximaPagina);
		espera.aguardarAtributoDoElementoConterOValor(campoCodigo, "value", "333");
	}

	@Test(testName = "id: 16 - Navegar para o registro anterior.", dependsOnMethods = { "navegarProximaPagina" })
	public void navegarRegistroAnterior() {
		acao.clicarNoElemento(rotina.botaoRegistroAnterior);
		espera.aguardarAtributoDoElementoConterOValor(campoCodigo, "value", "222");
	}

	@Test(testName = "id: 17 - Navegar para página anterior.", dependsOnMethods = { "navegarRegistroAnterior" })
	public void navegarPaginaAnterior() {
		acao.clicarNoElemento(rotina.botaoPaginaAnterior);
		espera.aguardarAtributoDoElementoConterOValor(campoCodigo, "value", "111");
	}

	@Test(testName = "id: 18 - Testar campo obrigatório.", dependsOnMethods = { "navegarPaginaAnterior" })
	public void campoObrigatorio() {
		acao.clicarNoElemento(rotina.botaoNovo);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVazio(campoCodigo);
		acao.escreverNoElemento(campoCodigo, "999");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		msg.aguardarMensagem("Informe um valor para o item Nome.");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Informe um valor para o item Nome.");
		acao.clicarNoElemento(botaoLovIdLista);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		espera.aguardarElementoEstarVisivel(By.xpath("//*[contains(@id,'janela-rotina')]//following::tbody/tr[1]/td[2]"));
		acao.clicarNoElemento(By.xpath("//*[contains(@id,'janela-rotina')]//following::tbody/tr[1]/td[2]"));
		espera.aguardarAtributoDoElementoConterOValor(campoDescricaoListaBlocoMaster, "value", "Lista 06");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoValorBlocoMaster, "56");
		acao.escreverNoElemento(campoNome, "123 456 789");
		acao.selecionarNoElemento(campoSituacao, "Inativo");
		acao.clicarNoElemento(campoNomeBlocoDetail, 0);
		acao.escreverNoElemento(campoNomeBlocoDetail, 0, "X");
		acao.clicarNoElemento(campoCodigoListaBlocoDetail, 0);
		acao.escreverNoElemento(campoCodigoListaBlocoDetail, 0, "3");
	}

	@Test(testName = "id: 19 - Testar campo obrigatório da tabela dinâmica.", dependsOnMethods = { "campoObrigatorio" })
	public void campoObrigatorioTabelaDinamica() {
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNumerico);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoNumerico, "444");
		acao.clicarNoElemento(rotina.botaoSalvar);
		msg.aguardarMensagem("Informe um valor para o item Campo LOV.");
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "id: 20 - Testar inserir registro.", dependsOnMethods = { "campoObrigatorioTabelaDinamica" })
	public void inserirRegistro() {
		acao.escreverNoElemento(campoCodigoLov, 0, "4");
		acao.selecionarNoElemento(campoComboBox, "Sim");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		msg.fecharMensagemNotificacao();
		acao.clicarNoElemento(botaoabrirLovCampoListaBlocoMaster);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		acao.clicarNoElemento(rotina.fecharLov);
		espera.aguardarElementoDesaparecer(rotina.lov);
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigo);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigo, "999");
		teclado.pressionarTeclaDeControle(Keys.F8);
		rotina.aguardarProcessarRotina();
		espera.aguardarAtributoDoElementoConterOValor(campoCodigo, "value", "999");
		espera.aguardarAtributoDoElementoConterOValor(campoValorBlocoMaster, "value", "56,00");
		espera.aguardarAtributoDoElementoConterOValor(campoSituacao, "value", "I");
		espera.aguardarAtributoDoElementoConterOValor(campoCodigoListaBlocoMaster, "value", "6");
		espera.aguardarAtributoDoElementoConterOValor(campoDescricaoListaBlocoMaster, "value", "Lista 06");
		espera.aguardarAtributoDoElementoConterOValor(campoNomeBlocoDetail, "value", "X");
		espera.aguardarAtributoDoElementoConterOValor(campoCodigoListaBlocoDetail, "value", "3");
		espera.aguardarAtributoDoElementoConterOValor(campoCodigoLov, 0, "value", "4");
		espera.aguardarAtributoDoElementoConterOValor(descricaoCampoLovBlocoDetail, 0, "value", "Lista 04");
		espera.aguardarAtributoDoElementoConterOValor(campoNumerico, "value", "444,00");
	}

	@Test(testName = "id: 21 - Excluir registro.", dependsOnMethods = { "inserirRegistro" })
	public void excluirRegistroInserido() {
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, campoCodigoListaBlocoDetail, 0);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, rotina.botaoExcluir);
		espera.aguardarElementoEstarVazio(campoCodigoListaBlocoDetail);
		acao.clicarNoElemento(rotina, rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		msg.fecharMensagemNotificacao();
		acao.clicarNoElemento(campoCodigo);
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigo, "999");
		teclado.pressionarTeclaDeControle(Keys.F8);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigo);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoExcluir);
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		rotina.limparCampoERealizarNovaConsulta();
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 22 - Testar bloco que não permite exluir registro.", dependsOnMethods = {
			"excluirRegistroInserido" })
	public void blocoNaoPermiteExclusao() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoPermiteExclusao);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigo);
		espera.aguardarElementoEstarVisivel(rotina.botaoExcluirDesabilitado);
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		espera.aguardarElementoEstarVisivel(msg.mensagemOperacaoNaoPermitida);
	}

	@Test(testName = "id: 23 - Testar se o bloco não permite alterar registro.", dependsOnMethods = {
			"blocoNaoPermiteExclusao" })
	public void blocoNaoPermiteAlteracao() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoPermiteAlteracao);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigo);
		rotina.aguardarProcessarRotina();
		acao.limparElemento(campoCodigo);
		testar.passouSeAtributoDoElementoNaoForNulo(campoCodigo, "value");
		teclado.pressionarTeclaDeControle(Keys.F10);
		msg.aguardarMensagem("Nenhum registro alterado");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Nenhum registro alterado");
	}

	@Test(testName = "id: 24 - Testar se o bloco não permite incluir registro.", dependsOnMethods = {
			"blocoNaoPermiteAlteracao" })
	public void blocoNaoPermiteInclusao() {
		acao.clicarNoElemento(botaoPermiteInclusao);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoCodigo);
		espera.aguardarElementoEstarVisivel(rotina.botaoNovoDesabilitado);
		teclado.pressionarTeclaDeControle(Keys.F10);
		msg.aguardarMensagem("Nenhum registro alterado");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Nenhum registro alterado");
		rotina.fecharRotina("teste02");
	}

	@Test(testName = "id: 25 - Testar o botao para abrir janela modal", dependsOnMethods = {
			"blocoNaoPermiteInclusao" })
	public void abrirModal() {
		rotina.selecionarRotina("teste02");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoAbrirRotinaModal);
		espera.aguardarElementoEstarVisivel(rotinaModalCarregada);
	}

	@Test(testName = "id: 26 - Verificar se nao permitira fechar a rotina com o modal aberto", dependsOnMethods = {
			"abrirModal" })
	public void tentarFecharRotinaComModalAberto() {
		acao.clicarNoElemento(minimizarRotinaModal);
		espera.aguardarElementoEstarVisivel(maximizarRotinaModal);
		acao.clicarNoElemento(fecharRotinaPrincipal);
		testar.passouSeElementoEstiverVisivel(fecharRotinaPrincipal);
	}

	@Test(testName = "id: 27 - Fechar a rotina Modal", dependsOnMethods = { "tentarFecharRotinaComModalAberto" })
	public void fecharRotinaModal() {
		espera.aguardarElementoEstarVisivel(minimizarRotinaModal);
		acao.clicarNoElemento(fecharRotinaModal);
		espera.aguardarElementoDesaparecer(fecharRotinaModal);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 28 - Testar formatacao campo valor numerico ao informar um valor com ponto (.)", dependsOnMethods = {
			"fecharRotinaModal" })
	public void valorCampoNumericoComPonto() {
		acao.clicarNoElemento(fecharRotinaPrincipal);
		espera.aguardarElementoDesaparecer(fecharRotinaPrincipal);
		rotina.selecionarRotina("teste02");
		rotina.aguardarProcessarRotina();
		rotina.limparCampoERealizarNovaConsulta();
		acao.limparElemento(campoValorBlocoMaster);
		acao.escreverNoElemento(campoValorBlocoMaster, "10.0");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		espera.aguardarAtributoDoElementoConterOValor(campoValorBlocoMaster, "value", "10,00");
	}

	@Test(testName = "id: 29 - Testar formatacao campo valor numerico ao informar um valor decimal com ponto (.)", dependsOnMethods = {
			"valorCampoNumericoComPonto" })
	public void valorCampoNumericoDecimalComPonto() {
		acao.limparElemento(campoValorBlocoMaster);
		acao.escreverNoElemento(campoValorBlocoMaster, "0.5");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		espera.aguardarAtributoDoElementoConterOValor(campoValorBlocoMaster, "value", "0,50");
	}

	@Test(testName = "id: 30 - Testar formatacao campo valor numerico milhar ao informar um valor decimal com ponto (.)", dependsOnMethods = {
			"valorCampoNumericoDecimalComPonto" }, enabled = true)
	public void valorCampoNumericoMilharComPonto() {
		acao.limparElemento(campoValorBlocoMaster);
		acao.escreverNoElemento(campoValorBlocoMaster, "1.000,00");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		espera.aguardarAtributoDoElementoConterOValor(campoValorBlocoMaster, "value", "1000,00");
	}

	@Test(testName = "id: 31 - Testar formatacao campo valor numerico milhar ao informar um valor decimal com virgula(,)", dependsOnMethods = {
			"valorCampoNumericoMilharComPonto" })
	public void valorCampoNumericoMilharComVirgual() {
		acao.limparElemento(campoValorBlocoMaster);
		acao.escreverNoElemento(campoValorBlocoMaster, "1,000");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		espera.aguardarAtributoDoElementoConterOValor(campoValorBlocoMaster, "value", "1,00");
	}

	@Test(testName = "id: 32 - Testar formatacao campo valor numerico decimal apenas com virgula", dependsOnMethods = {
			"valorCampoNumericoMilharComVirgual" })
	public void valorCampoNumericoApenasDecimal() throws InterruptedException {
		acao.limparElemento(campoValorBlocoMaster);
		acao.escreverNoElemento(campoValorBlocoMaster, ",5");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		espera.aguardarAtributoDoElementoConterOValor(campoValorBlocoMaster, "value", "0,50");
	}

	@Test(testName = "id: 33 - Testar formatacao campo valor numerico decimal apenas com ponto", dependsOnMethods = {
			"valorCampoNumericoApenasDecimal" })
	public void valorCampoNumericoApenasDecimalComPonto() throws InterruptedException {
		acao.limparElemento(campoValorBlocoMaster);
		acao.escreverNoElemento(campoValorBlocoMaster, ".5");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		espera.aguardarAtributoDoElementoConterOValor(campoValorBlocoMaster, "value", "0,50");
	}

	@Test(testName = "id: 34 - Testar formatacao campo valor numerico milhar apenas com ponto", dependsOnMethods = {
			"valorCampoNumericoApenasDecimalComPonto" }, enabled = true)
	public void valorCampoNumericoComMilhar() throws InterruptedException {
		acao.limparElemento(campoValorBlocoMaster);
		acao.escreverNoElemento(campoValorBlocoMaster, "1.000");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		espera.aguardarAtributoDoElementoConterOValor(campoValorBlocoMaster, "value", "1,00");
	}

	@Test(testName = "id: 35 - Testar se o componente botao abre ao teclar enter", dependsOnMethods = {
			"valorCampoNumericoComMilhar" })
	public void verificarSeComponenteBotaoAbreComEnter() throws InterruptedException {
		acao.posicionarFocoNoElemento(rotina, botaoAbrirRotinaModal);
		teclado.pressionarTeclaDeControle(Keys.ENTER);
		espera.aguardarElementoEstarVisivel(rotinaModalCarregada);
		acao.clicarNoElemento(fecharRotinaModal);
		espera.aguardarElementoDesaparecer(fecharRotinaModal);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 36 - Testar se o componente botao abre ao teclar espacebar", dependsOnMethods = {
			"verificarSeComponenteBotaoAbreComEnter" })
	public void verificarSeComponenteBotaoAbreComEspaco() throws InterruptedException {
		acao.posicionarFocoNoElemento(rotina, botaoAbrirRotinaModal);
		teclado.pressionarTeclaDeControle(Keys.SPACE);
		espera.aguardarElementoEstarVisivel(rotinaModalCarregada);
		acao.clicarNoElemento(fecharRotinaModal);
		espera.aguardarElementoDesaparecer(fecharRotinaModal);
		rotina.aguardarProcessarRotina();
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "id: 37 - Abrir lov pela lupa quando o bloco esta em modo consulta (F7)", dependsOnMethods = {
			"verificarSeComponenteBotaoAbreComEspaco" })
	public void abrirLovEmModoConsulta() throws InterruptedException {
		acao.clicarNoElemento(campoCodigoListaBlocoMaster);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		espera.aguardarElementoEstarVisivel(msg.naoConfirmacao);
		acao.clicarNoElemento(msg.naoConfirmacao);
		espera.aguardarElementoDesaparecer(msg.naoConfirmacao);
		espera.aguardarElementoEstarVazio(campoNome);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoabrirLovCampoListaBlocoMaster);
		espera.aguardarElementoEstarVisivel(rotina.lov);
		acao.clicarNoElemento(rotina.fecharLov);
		espera.aguardarElementoDesaparecer(rotina.lov);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
	}

	@Test(testName = "id: 38 - Testar utilizacao do Ctrl E nos campos input", dependsOnMethods = {
			"abrirLovEmModoConsulta" })
	public void utilizacaoCtrlE() {
		acao.clicarNoElemento(campoMultivalorado);
		String label = acao.localizarElemento(teste02.descricaoLabelCampo("//textarea[contains(@id,'.c_99997')]"))
				.getText();
		rotina.abrirEditorDeCampo(campoMultivalorado, label);
	}

	@Test(testName = "id: 39 - Abrir o modal do campo pelo ctrl e e inserir um valor", dependsOnMethods = {
			"utilizacaoCtrlE" })
	public void inseririValorNoCampoUtilizandoCtrlE() {
		espera.aguardarElementoEstarVisivel((teste02.janelaModalDoCampo("//textarea[contains(@id,'.c_99997')]")));
		acao.limparElemento(teste02.janelaModalDoCampo("//textarea[contains(@id,'.c_99997')]"));
		acao.escreverNoElemento(teste02.janelaModalDoCampo("//textarea[contains(@id,'.c_99997')]"), "1010");
		acao.clicarNoElemento(rotina.botaoConfirmar);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoForIgualA(campoMultivalorado, "value", "1010");
	}

	@Test(testName = "id: 40 - Verificar se ao alterar o registro pelo Ctrl E, se marcara como alterado", dependsOnMethods = {
			"inseririValorNoCampoUtilizandoCtrlE" })
	public void verificarSeMarcaRegistroComoAlteradoUtilizandoCtrlE() {
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		msg.fecharMensagemNotificacao();
		rotina.limparCampoERealizarNovaConsulta();
	}

	@Test(testName = "id: 41 - Verificar se o foco vai para o campo localizar da LOV", dependsOnMethods = {
			"verificarSeMarcaRegistroComoAlteradoUtilizandoCtrlE" })
	public void verificarFocoAposAbrirCampoLov() {
		acao.clicarNoElemento(botaoabrirLovCampoListaBlocoMaster);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(rotina.lov);
		testar.passouSeAtributoDoElementoFocadoFor("placeholder", "Localizar");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarElementoDesaparecer(rotina.lov);
	}

	@Test(testName = "id: 42 - Abrir editor de camop nao editavel pelo Ctrl E e verificar se nao deixa salvar", dependsOnMethods = {
			"verificarFocoAposAbrirCampoLov" })
	public void naoPermitirAlterarCampoNaoEditavelPeloCtrlE() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNomeListaBlocoDetail, 0);
		rotina.aguardarProcessarRotina();
		rotina.abrirEditorDeCampo(campoNomeListaBlocoDetail, "");
		espera.aguardarElementoEstarVisivel(
				teste02.janelaModalDoCampo("//input[contains(@id,'.arctesteitNomeLista')]"));
		acao.limparElemento(teste02.janelaModalDoCampo("//input[contains(@id,'.arctesteitNomeLista')]"));
		acao.escreverNoElemento(teste02.janelaModalDoCampo("//input[contains(@id,'.arctesteitNomeLista')]"), "teste");
		teclado.pressionarTeclaDeControle(Keys.F10);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(rotina.botaoConfirmar);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);

		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(
				By.xpath("//input[contains(@id,'.arctesteitNomeLista')]//following::div[@class='corpo']/textarea[1]"));
		testar.passouSeAtributoDoElementoForDiferenteDe(campoNomeListaBlocoDetail, "value", "teste");
	}

	@Test(testName = "id: 43 - Verificar se exibe mensagem pergutando se deseja salvar ao alterar campo pelo ctrl E", dependsOnMethods = {
			"naoPermitirAlterarCampoNaoEditavelPeloCtrlE" })
	public void perguntarSeDesejaSairSemSalvarCampoEditavelPeloCtrlE() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNome, 0);
		rotina.aguardarProcessarRotina();
		rotina.abrirEditorDeCampo(campoNome, "");
		espera.aguardarElementoEstarVisivel(teste02.janelaModalDoCampo("//input[contains(@id,'.arctesteNome')]"));
		acao.limparElemento(teste02.janelaModalDoCampo("//input[contains(@id,'.arctesteNome')]"));
		acao.escreverNoElemento(teste02.janelaModalDoCampo("//input[contains(@id,'.arctesteNome')]"), "teste");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Deseja descartar as alterações?");
		acao.clicarNoElemento(msg.simConfirmacao);
		espera.aguardarElementoDesaparecer(msg.simConfirmacao);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(
				By.xpath("//input[contains(@id,'.arctesteNome')]//following::div[@class='corpo']/textarea[1]"));
		testar.passouSeAtributoDoElementoForDiferenteDe(campoNome, "value", "teste");
	}

	@Test(testName = "id: 44 - Abrir editor de camop nao editavel pelo Ctrl E e verificar se nao deixa salvar", dependsOnMethods = {
			"perguntarSeDesejaSairSemSalvarCampoEditavelPeloCtrlE" })
	public void permitirAlterarCampoEditavelPeloCtrlE() {
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(campoNome, 0);
		rotina.aguardarProcessarRotina();
		rotina.abrirEditorDeCampo(campoNome, "");
		espera.aguardarElementoEstarVisivel(teste02.janelaModalDoCampo("//input[contains(@id,'.arctesteNome')]"));
		acao.limparElemento(teste02.janelaModalDoCampo("//input[contains(@id,'.arctesteNome')]"));
		acao.escreverNoElemento(teste02.janelaModalDoCampo("//input[contains(@id,'.arctesteNome')]"), "teste");
		acao.clicarNoElemento(rotina.botaoConfirmar);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(rotina.botaoConfirmar);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);

		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(
				By.xpath("//input[contains(@id,'.arctesteNome')]//following::div[@class='corpo']/textarea[1]"));
		testar.passouSeAtributoDoElementoForIgualA(campoNome, "value", "teste");
	}

	@Test(testName = "id: 45 - Selecionar uma data pelo calendario e salvar. Verificar se evento do campo sera disparado.", dependsOnMethods = {
			"permitirAlterarCampoEditavelPeloCtrlE" })
	public void selecionarDataPeloCalendarioEVerificarEventoViaComando() throws InterruptedException {
		acao.clicarNoElemento(campoData);
		acao.limparElemento(campoData);
		acao.escreverNoElemento(campoData, "15102017");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoFocadoFor(campoCodigo);
		acao.clicarNoElemento(campoData);
		rotina.aguardarProcessarRotina();
		acao.limparElemento(campoData);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(botaoCalendarioCampoData);
		espera.aguardarElementoEstarVisivel(rotina.selecionarDia("10"));
		acao.clicarNoElemento(rotina.selecionarDia("10"));
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer(rotina.componenteCalendario);
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoFocadoFor(campoCodigo);
		acao.clicarNoElemento(rotina.botaoSalvar);
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		msg.fecharMensagemNotificacao();
	}

	@Test(testName = "id: 46 - Fechar a rotina Principal", dependsOnMethods = { "selecionarDataPeloCalendarioEVerificarEventoViaComando" })
	public void fecharRotinaPrincipal() throws InterruptedException {
		acao.clicarNoElemento(fecharRotinaPrincipal);
		rotina.confirmarFecharRotina();
		espera.aguardarElementoDesaparecer(fecharRotinaPrincipal);
	}

	@Test(testName = "id: 47 - Verificar expansao de textArea", dependsOnMethods = {
			"fecharRotinaPrincipal" }, enabled = true)
	public void textAreaExpansivel() {
		rotina.selecionarRotina("teste02");
		String textArea = "teste teste teste teste teste teste teste teste teste teste teste"
				+ " teste teste teste teste teste teste teste teste teste teste teste teste teste "
				+ "teste teste teste teste teste teste teste teste teste teste teste teste teste teste teste"
				+ "teste teste teste teste teste teste teste teste teste teste teste teste teste teste teste";
		
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		acao.escreverNoElemento(campoCodigo, "444");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		String tamanhoInicial = acao.localizarElemento(campoMultivalorado).getCssValue("height");
		acao.escreverNoElemento(campoMultivalorado, textArea);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		String tamanhoAlterado = acao.localizarElemento(campoMultivalorado).getCssValue("height");
		testar.passouSeValorNaoContem(tamanhoInicial, tamanhoAlterado);
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F4);
		espera.aguardarElementoEstarVisivel(msg.simConfirmacao);
		acao.clicarNoElemento(msg.naoConfirmacao);
		espera.aguardarElementoDesaparecer(msg.simConfirmacao);
		rotina.aguardarProcessarRotina();
	}
	
	@Test(testName = "id: 48 - Testar passagem de foco com o tab pelos campos da tabela dinamica.", 
			dependsOnMethods = {"textAreaExpansivel" })
	public void testarPassagemDeFocoTabelaDinamica() {
		rotina.selecionarRotina("teste02");
		rotina.limparCampoERealizarNovaConsulta();
		acao.clicarNoElemento(campoNumerico);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		testar.passouSeElementoFocadoFor(campoDataTabelaDinamica);
		teclado.pressionarTeclaDeControle(Keys.TAB);
		testar.passouSeElementoFocadoFor(campoComboBox);
	}
	
	@Test(testName = "id: 49 - Testar consulta utilizando operador maior ou igual.", 
			dependsOnMethods = {"testarPassagemDeFocoTabelaDinamica" })
	public void testarConsultaComOperadorMaiorOuIgual() {
		acao.clicarNoElemento(campoValorBlocoMaster);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigo, ">=666");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		String valorAtual = acao.retornarValorDoElemento(campoCodigo);
		teclado.pressionarTeclaDeControle(Keys.ARROW_UP);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorContem(valorAtual, acao.retornarValorDoElemento(campoCodigo));
		teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorContem(acao.retornarValorDoElemento(campoCodigo), "777");
	}
	
	@Test(testName = "id: 50 - Testar consulta utilizando operador maior", 
			dependsOnMethods = {"testarConsultaComOperadorMaiorOuIgual" })
	public void testarConsultaComOperadorMaior() {
		acao.clicarNoElemento(campoValorBlocoMaster);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigo, ">666");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		String valorAtual = acao.retornarValorDoElemento(campoCodigo);
		teclado.pressionarTeclaDeControle(Keys.ARROW_UP);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorContem(valorAtual, acao.retornarValorDoElemento(campoCodigo));
		testar.passouSeValorContem(acao.retornarValorDoElemento(campoCodigo), "777");
		teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoForNulo(campoCodigo, "value");
	}
	
	@Test(testName = "id: 51 - Testar consulta utilizando operador menor ou igual", 
			dependsOnMethods = {"testarConsultaComOperadorMaior" })
	public void testarConsultaComOperadorMenorOuIgual() {
		acao.clicarNoElemento(campoValorBlocoMaster);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigo, "<=222");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		String valorAtual = acao.retornarValorDoElemento(campoCodigo);
		teclado.pressionarTeclaDeControle(Keys.ARROW_UP);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorContem(valorAtual, acao.retornarValorDoElemento(campoCodigo));
		testar.passouSeValorContem(acao.retornarValorDoElemento(campoCodigo), "111");
		teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoForNulo(campoCodigo, "value");
	}
	
	@Test(testName = "id: 52 - Testar consulta utilizando operador menor", 
			dependsOnMethods = {"testarConsultaComOperadorMenorOuIgual" })
	public void testarConsultaComOperadorMenor() {
		acao.clicarNoElemento(campoValorBlocoMaster);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigo, "<222");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		String valorAtual = acao.retornarValorDoElemento(campoCodigo);
		teclado.pressionarTeclaDeControle(Keys.ARROW_UP);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorContem(valorAtual, acao.retornarValorDoElemento(campoCodigo));
		testar.passouSeValorContem(acao.retornarValorDoElemento(campoCodigo), "111");
		teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoForNulo(campoCodigo, "value");
	}
	
	@Test(testName = "id: 53 - Testar consulta utilizando operador diferente", 
			dependsOnMethods = {"testarConsultaComOperadorMenor" })
	public void testarConsultaComOperadorDiferente() {
		acao.clicarNoElemento(campoValorBlocoMaster);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento(campoCodigo, "!222");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		String valorAtual = acao.retornarValorDoElemento(campoCodigo);
		teclado.pressionarTeclaDeControle(Keys.ARROW_UP);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorContem(valorAtual, acao.retornarValorDoElemento(campoCodigo));
		testar.passouSeValorContem(acao.retornarValorDoElemento(campoCodigo), "111");
		teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoContem(campoCodigo, "value", "333");
	}
	
	@Test(testName = "id: 54 - Testar consulta utilizando operador maior campo data", 
			dependsOnMethods = {"testarConsultaComOperadorDiferente" })
	public void testarConsultaComMacroCampoData() {
		acao.clicarNoElemento("arctesteDataCadastro");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento("arctesteDataCadastro", ">=05/05/2015");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		String valorAtual = acao.retornarValorDoElemento("arctesteDataCadastro");
		teclado.pressionarTeclaDeControle(Keys.ARROW_UP);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorContem(valorAtual, acao.retornarValorDoElemento("arctesteDataCadastro"));
		testar.passouSeValorContem(acao.retornarValorDoElemento("arctesteDataCadastro"), "05/05/2015");
		teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		rotina.aguardarProcessarRotina();
		teclado.pressionarTeclaDeControle(Keys.ARROW_DOWN);
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoForNulo("arctesteDataCadastro", "value");
	}
	
}
