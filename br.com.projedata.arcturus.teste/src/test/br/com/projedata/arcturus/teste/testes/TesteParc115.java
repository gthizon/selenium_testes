package br.com.projedata.arcturus.teste.testes;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import br.com.projedata.arcturus.teste.metodosgenericos.LoginMetodos;
import br.com.projedata.arcturus.teste.recursos.TesteGenerico;

public class TesteParc115 extends TesteGenerico {

	LoginMetodos login;
	String idAtu;
	String idCasoTeste;
	String anexo1 = "/projedata/anexos/peixe.png";

	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 1 - Abrir Parc115")
	public void abrirParc115(String usuario, String senha, String base) {
		login = new LoginMetodos(this);
		login.logar(usuario, senha, base);
		rotina.selecionarRotina("arc115");
	}
	
	@Test(testName = "id: 2 - Inserir atualização", dependsOnMethods = {"abrirParc115"})
	public void inserirAtualizacao() {
		acao.selecionarNoElementoPeloValor("arcatualizacaoDificuldade", "A");
		acao.selecionarNoElementoPeloValor("arcatualizacaoPrioridade", "A");
		acao.escreverNoElemento("arcatualizacaoDescricaoTecnica", "teste automatizado");
		acao.escreverNoElemento("arcatualizacaoDescricaoTeste", "teste automatizado");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		idAtu = acao.retornarValorDoElemento("arcatualizacaoId");
		acao.selecionarAba("abaDescUsuarios");
		espera.aguardarElementoEstarVisivel("arcatualizacaoDescricaoCliente");
		acao.escreverNoElemento("arcatualizacaoDescricaoCliente", "teste automatizado");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 3 - Inserir descrição para usuários", dependsOnMethods = {"inserirAtualizacao"})
	public void inserirDescricaoParaUsuarios() {
		acao.escreverNoElemento("arcatualizacaoDescricaoAceitarFechar-1", "teste automatizado");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento(rotina, "arcatualizacaodescrotChaveRotina-1");
		acao.escreverNoElemento("arcatualizacaodescrotChaveRotina-1", "parc105");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		acao.selecionarNoElementoPeloValor("arcatualizacaodescrotConfirmacaoLeitura-1", "S");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 4 - Verificar se não permite alterar campos da atualização. Apenas Dificuldade, prioridade e descrições", dependsOnMethods = {"inserirDescricaoParaUsuarios"})
	public void verificarSeNaoPermiteAlterarCamposDaAtualizacao() {
		acao.limparElemento("arcatualizacaoId");
		acao.limparElemento("arcatualizacaoDataCriacao");
		acao.limparElemento("arcatualizacaoNomeUsuarioCriacao");
		acao.limparElemento("arcatualizacaoNomeAcaoAtual");
		acao.limparElemento("dataAcaoAtual");
		acao.limparElemento("arcatualizacaoNomeUsuarioAtual");
		acao.escreverNoElemento("arcatualizacaoVersaoGerada", "teste");
		acao.escreverNoElemento("arcatualizacaoDataLancamento", "teste");
		
		testar.passouSeAtributoDoElementoNaoForNulo("arcatualizacaoId", "value");
		testar.passouSeAtributoDoElementoNaoForNulo("arcatualizacaoDataCriacao", "value");
		testar.passouSeAtributoDoElementoNaoForNulo("arcatualizacaoNomeUsuarioCriacao", "value");
		testar.passouSeAtributoDoElementoNaoForNulo("arcatualizacaoNomeAcaoAtual", "value");
		testar.passouSeAtributoDoElementoNaoForNulo("dataAcaoAtual", "value");
		testar.passouSeAtributoDoElementoNaoForNulo("arcatualizacaoNomeUsuarioAtual", "value");
		testar.passouSeAtributoDoElementoForNulo("arcatualizacaoVersaoGerada", "value");
		testar.passouSeAtributoDoElementoForNulo("arcatualizacaoDataLancamento", "value");
	}
	
	@Test(testName = "id: 5 - Ao cadastrar a atualização, deverá inserir o repasse incial para o usuário que cadastrou", dependsOnMethods = {"verificarSeNaoPermiteAlterarCamposDaAtualizacao"})
	public void inserirRepasseInicial() {
		acao.selecionarAba("abaRepasses");
		espera.aguardarElementoEstarVisivel("arcatualizacaoacaoDataHora");
		testar.passouSeAtributoDoElementoContem("arcatualizacaoacaoNomeRemetente-1", "value", acao.retornarValorDoElemento("arcatualizacaoNomeUsuarioAtual"));
		testar.passouSeAtributoDoElementoContem("arcatualizacaoacaoNomeDestino-1", "value", acao.retornarValorDoElemento("arcatualizacaoNomeUsuarioAtual"));
		testar.passouSeAtributoDoElementoContem("arcatualizacaoacaoDescricaoAcao-1", "value", acao.retornarValorDoElemento("arcatualizacaoNomeAcaoAtual"));
		testar.passouSeAtributoDoElementoContem("arcatualizacaoacaoDetalhes-1", "value", "Desenvolver atualização");
	}
	
	@Test(testName = "id: 6 - Inserir dependência", dependsOnMethods = {"inserirRepasseInicial"})
	public void inserirDependencia() {
		acao.selecionarAba("abaDependencias");
		espera.aguardarElementoEstarVisivel("arcatualizacaodependenciaIdAtualizacao-1");
		acao.abrirLov(rotina, "arcatualizacaodependenciaIdAtualizacao-1");
		rotina.filtrarESelecionarValorNaLov("Desenvolver");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 7 - Inserir tarefa", dependsOnMethods = {"inserirDependencia"})
	public void inserirTarefa() {
		acao.clicarNoElemento(rotina, "arcatualizacaotarefaNomeUsuarioDesignado-1");
		acao.abrirLov(rotina, "arcatualizacaotarefaNomeUsuarioDesignado-1");
		rotina.filtrarESelecionarValorNaLov("Gustavo");
		acao.escreverNoElemento("arcatualizacaotarefaDescricao-1", "Teste automatizado");
		acao.escreverNoElemento("arcatualizacaotarefaTempoEstimado-1", "10");
		acao.escreverNoElemento("arcatualizacaotarefaDataPrevisao-1", rotina.retornarDataAtual());
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		espera.aguardarElementoEstarHabilitado("botaoTarefaAberta-1");
		acao.clicarNoElemento("botaoTarefaAberta-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("botaoTarefaOk-1");
		espera.aguardarElementoDesaparecer("botaoTarefaAberta-1");
		acao.clicarNoElemento("botaoTarefaOk-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("botaoTarefaAberta-1");
		espera.aguardarElementoDesaparecer("botaoTarefaOk-1");
		acao.clicarNoElemento(rotina, "arcatualizacaotarefaNomeUsuarioDesignado-1");
	}
	
	@Test(testName = "id: 8 - Excluir tarefa", dependsOnMethods = {"inserirTarefa"})
	public void excluirTarefa() {
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 9 - Inserir novo incidente", dependsOnMethods = {"excluirTarefa"})
	public void inserirIncidente() {
		acao.selecionarAba("abaIncidentes");
		espera.aguardarElementoEstarVisivel("botaoNovo-1");
		acao.clicarNoElemento("botaoNovo-1");
		espera.aguardarElementoEstarVisivel(By.xpath("//p[contains(text(),'Cadastro de Incidentes')]"));
		String funcionalidade = "pven999";
		acao.clicarNoElemento(rotina, "arcincidenteFuncionalidade");
		acao.escreverNoElemento("arcincidenteFuncionalidade", funcionalidade);
		acao.selecionarNoElementoPeloValor("arcincidenteTipo", "IG");
		acao.escreverNoElemento("arcincidenteIdUsuarioAtr", "27");
		teclado.pressionarTeclaDeControle(Keys.TAB);
		rotina.aguardarProcessarRotina();
		testar.passouSeValorDoElementoSelecionadoFor("arcincidenteIdSituacao", "Aberto");
		acao.clicarNoElemento(rotina,"arcincidenteDescricao-1");
		acao.escreverNoElemento("arcincidenteDescricao-1", "incidente teste");
		acao.abrirLov(rotina, "arcincidenteIdFatogerador");
		rotina.filtrarESelecionarValorNaLov("comunicação");
		acao.abrirLov(rotina, "arcincidenteIdCausa");
		rotina.filtrarESelecionarValorNaLov("CASI");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento(By.xpath("//p[contains(text(),'Incidentes')]//following::*[@title='Fechar' or @title='Cerrar' or @title='Close']"));
		espera.aguardarElementoDesaparecer("arcincidenteIdCausa");
		espera.aguardarAtributoDoElementoConterOValor("arcincidenteFuncionalidade-1", "value", funcionalidade);
		
		testar.passouSeAtributoDoElementoContem("arcincidenteFuncionalidade-1", "value", funcionalidade);
		testar.passouSeValorDoElementoSelecionadoFor("arcincidenteDescSituacao-1", "Aberto");
		testar.passouSeElementoEstiverHabilitado("botaoEditar-1");
	}
	
	@Test(testName = "id: 10 - Editar incidente", dependsOnMethods = {"inserirIncidente"})
	public void editarIncidente() {
		acao.clicarNoElemento("botaoEditar-1");
		espera.aguardarElementoEstarVisivel(By.xpath("//p[contains(text(),'Cadastro de Incidentes')]"));
		acao.clicarNoElemento(rotina, "arcincidenteIdMotivonegado-1");
		teclado.pressionarTeclaDeControle(Keys.F9);
		testar.passouSeElementoNaoExistir(rotina.lov);
	}	
	
	@Test(testName = "id: 11 - Editar incidente", dependsOnMethods = {"editarIncidente"})
	public void selecionarMotivoNegadoIncidente() {
		acao.selecionarNoElemento("arcincidenteIdSituacao-1", "Negado");
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoContem("arcincidenteOsCadastrada-1", "readonly", "true");
		acao.abrirLov(rotina, "arcincidenteIdMotivonegado-1");
		rotina.filtrarESelecionarValorNaLov("nova");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarHabilitado("arcincidenteOsCadastrada-1");
	}
	
	@Test(testName = "id: 12 - Selecionar o motivo negado Cadastrar Nova OS e verificar se solicitará informar a OS", dependsOnMethods = {"selecionarMotivoNegadoIncidente"})
	public void testarInformarNovaOS() {
		acao.clicarNoElemento(rotina, rotina.botaoSalvar);
		msg.aguardarMensagem("Informe o número da OS cadastrada.");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento("arcincidenteOsCadastrada", "999");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento(By.xpath("//p[contains(text(),'Incidentes')]//following::*[@title='Fechar' or @title='Cerrar' or @title='Close']"));
		espera.aguardarElementoDesaparecer("arcincidenteIdCausa");
		rotina.aguardarProcessarRotina();
		testar.passouSeValorDoElementoSelecionadoFor("arcincidenteDescSituacao-1", "Negado");
	}
	
	@Test(testName = "id: 13 - Inserir rotina suite de testes", dependsOnMethods = {"testarInformarNovaOS"})
	public void cadastrarSuiteTeste() {
		acao.selecionarAba("abaTestes");
		acao.abrirLov(rotina, "arccasotesteIdRotina-1");
		rotina.filtrarESelecionarValorNaLov("parc010");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 14 - Inserir cenários de testes", dependsOnMethods = {"cadastrarSuiteTeste"})
	public void cadastrarCenariosTestes() {
		acao.clicarNoElemento(rotina, "arccasotesteDescricaoCenario-1");
		acao.escreverNoElemento("arccasotesteDescricaoCenario-1", "Cenário de teste 1");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento(rotina, "arccasotesteDescricaoCenario-2");
		acao.escreverNoElemento("arccasotesteDescricaoCenario-2", "Cenário de teste 2");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 15 - Cadastrar casos de testes", dependsOnMethods = {"cadastrarCenariosTestes"})
	public void cadastrarCasosTestes() {
		acao.clicarNoElemento(rotina, "arccasotesteDescricaoCenario-1");
		acao.clicarNoElemento(rotina, "arccasotesteEntrada-1");
		acao.escreverNoElemento("arccasotesteEntrada-1", "caso de teste 1 cenário 1 entrada");
		acao.escreverNoElemento("arccasotesteSaida-1", "caso de teste 1 cenário 1 saida");
		acao.clicarNoElemento(rotina, "arccasotesteEntrada-2");
		acao.escreverNoElemento("arccasotesteEntrada-2", "caso de teste 2 cenário 1 entrada");
		acao.escreverNoElemento("arccasotesteSaida-2", "caso de teste 2 cenário 1 saida");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		espera.aguardarElementoEstarHabilitado("botaoPendente-1");
		espera.aguardarElementoEstarHabilitado("botaoPendente-2");
		espera.aguardarElementoEstarHabilitado("botaoManual-1");
		espera.aguardarElementoEstarHabilitado("botaoManual-2");
		
		acao.clicarNoElemento(rotina, "arccasotesteDescricaoCenario-2");
		acao.clicarNoElemento(rotina, "arccasotesteEntrada-1");
		acao.escreverNoElemento("arccasotesteEntrada-1", "caso de teste 1 cenário 2 entrada");
		acao.escreverNoElemento("arccasotesteSaida-1", "caso de teste 1 cenário 2 saida");
		acao.clicarNoElemento(rotina, "arccasotesteEntrada-2");
		acao.escreverNoElemento("arccasotesteEntrada-2", "caso de teste 2 cenário 2 entrada");
		acao.escreverNoElemento("arccasotesteSaida-2", "caso de teste 2 cenário 2 saida");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		espera.aguardarElementoEstarHabilitado("botaoPendente-1");
		espera.aguardarElementoEstarHabilitado("botaoPendente-2");
		espera.aguardarElementoEstarHabilitado("botaoManual-1");
		espera.aguardarElementoEstarHabilitado("botaoManual-2");
	}
	
	@Test(testName = "id: 16 - Alterar teste para automatizado", dependsOnMethods = {"cadastrarCasosTestes"})
	public void alterarTipoTesteParaAutomatizado() {
		acao.clicarNoElemento(rotina, "botaoManual-1");
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Caso de teste marcado como Automatizado!");
		espera.aguardarElementoNaoEstarVisivel("botaoManual-1");
		espera.aguardarElementoEstarVisivel("botaoAutomatizado-1");
		idCasoTeste = acao.retornarValorDoElemento("arccasotesteId-1");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer("botaoAutomatizado-1");
	}
	
	@Test(testName = "id: 17 - Listar testes automatizados", dependsOnMethods = {"alterarTipoTesteParaAutomatizado"})
	public void listarTestesAutomatizados() {
		acao.clicarNoElemento(rotina,"arcsuitetesteFiltroTeste-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("botaoAutomatizado-1");
		testar.passouSeValoresForemIguais(idCasoTeste, acao.retornarValorDoElemento("arccasotesteId-1"));
		acao.clicarNoElemento(rotina,"arcsuitetesteFiltroTeste-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer("botaoAutomatizado-1");
	}
	
	@Test(testName = "id: 18 - testar alteração status do caso de teste", dependsOnMethods = {"listarTestesAutomatizados"})
	public void alterarStatusCasoTeste() {
		acao.clicarNoElemento(rotina, "arccasotesteDescricaoCenario-1");
		acao.clicarNoElemento(rotina, "arccasotesteEntrada-1");
		acao.clicarNoElemento(rotina, "botaoPendente-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		espera.aguardarElementoEstarVisivel("botaoPassou-1");
		
		acao.clicarNoElemento(rotina, "botaoPassou-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		espera.aguardarElementoEstarVisivel("botaoFalhou-1");
		
		acao.clicarNoElemento(rotina, "botaoFalhou-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		espera.aguardarElementoEstarVisivel("botaoPulou-1");
		
		acao.clicarNoElemento(rotina, "botaoPulou-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		espera.aguardarElementoEstarVisivel("botaoPassou-1");
	}
	
	@Test(testName = "id: 19 - Excluir caso de teste", dependsOnMethods = {"alterarStatusCasoTeste"})
	public void excluirCasoTeste() {
		acao.clicarNoElemento(rotina, "arccasotesteDescricaoCenario-2");
		acao.clicarNoElemento(rotina, "arccasotesteEntrada-2");
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		
		acao.clicarNoElemento(rotina, "arccasotesteDescricaoCenario-1");
		acao.clicarNoElemento(rotina, "arccasotesteEntrada-2");
		acao.clicarNoElemento(rotina, "botaoPendente-2");
		rotina.aguardarProcessarRotina();
	}
	
	@Test(testName = "id: 20 - Carregar cenários de testes existentes", dependsOnMethods = {"excluirCasoTeste"})
	public void carregarCenariosDeTeste() {
		acao.clicarNoElemento(rotina, "arccasotesteIdRotina-2");
		acao.abrirLov(rotina, "arccasotesteIdRotina-2");
		rotina.filtrarESelecionarValorNaLov("parc009");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento("botaoCarregarCenarios-2");
		rotina.aguardarProcessarRotina();
		espera.aguardarAtributoDoElementoConterOValor("arccasotesteDescricaoCenario-1", "value", "Geral");
		espera.aguardarAtributoDoElementoConterOValor("arccasotesteEntrada-1", "value", "Inserir nova biblioteca");
		espera.aguardarAtributoDoElementoConterOValor("arccasotesteSaida-1", "value", "Deverá salvar corretamente");
		espera.aguardarAtributoDoElementoConterOValor("arccasotesteEntrada-2", "value", "Excluir uma biblioteca");
		espera.aguardarAtributoDoElementoConterOValor("arccasotesteSaida-2", "value", "Deverá excluir corretamente.");
		
		acao.clicarNoElemento(rotina, "arccasotesteEntrada-1");
		acao.clicarNoElemento(rotina, "botaoPendente-1");
		acao.clicarNoElemento(rotina, "arccasotesteEntrada-2");
		acao.clicarNoElemento(rotina, "botaoPendente-2");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarMensagemDesaparecer();
	}
	
	@Test(testName = "id: 21 - Adicionar clientes na atualização", dependsOnMethods = {"carregarCenariosDeTeste"})
	public void vincularClientesNaAtualizacao() {
		espera.aguardarElementoEstarVisivel("arcatualizacaoBotaoAddCliente");
		acao.clicarNoElemento(rotina, "arcatualizacaoBotaoAddCliente");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("arcatualizacaoclienteIdCliente-1");
		acao.abrirLov(rotina, "arcatualizacaoclienteIdCliente-1");
		rotina.filtrarESelecionarValorNaLov("cliente");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento("arcatualizacaoclienteBotaoConfirmar-1");
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoDesaparecer("arcatualizacaoclienteIdCliente-1");
		espera.aguardarElementoEstarVisivel(By.xpath("//label[text()='Clientes (1)']"));
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
	}
	
	@Test(testName = "id: 22 - Gerar binário da atualização", dependsOnMethods = {"vincularClientesNaAtualizacao"})
	public void gerarBinarioAtualizacao() {
		acao.clicarNoElemento("abrirOpcoes");
		espera.aguardarElementoEstarVisivel("gerarBinario");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento("gerarBinario");
		msg.aguardarMensagem("Arquivo binário atualizado!");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		rotina.aguardarProcessarRotina();
	}
	
	@Test(testName = "id: 23 - Vincular correção a atualização", dependsOnMethods = {"gerarBinarioAtualizacao"})
	public void vincularCorrecaoNaAtualizacao() {
		acao.clicarNoElemento(rotina, "arcatualizacaoId");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento("arcatualizacaoId", "19");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento("abrirOpcoes");
		espera.aguardarElementoEstarVisivel("arcatualizacaoBotaoAdicionarCorrecao");
		acao.clicarNoElemento("arcatualizacaoBotaoAdicionarCorrecao");
		rotina.aguardarLovProcessar();
		rotina.filtrarESelecionarValorNaLov(idAtu);
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Correção adicionada.");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Correção adicionada.");
		acao.clicarNoElemento(rotina, "arcatualizacaoId");
		acao.clicarNoElemento(rotina.botaoLimparConsulta);
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento("arcatualizacaoId", idAtu);
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("arcatualizacaoCorrecao");
		testar.passouSeAtributoDoElementoContem("arcatualizacaoCorrecao", "value", "19");
	}
	
	@Test(testName = "id: 24 - Desvincular correção a atualização", dependsOnMethods = {"vincularCorrecaoNaAtualizacao"})
	public void desvincularCorrecaoNaAtualizacao() {
		acao.clicarNoElemento("abrirOpcoes");
		espera.aguardarElementoEstarVisivel("arcatualizacaoBotaoExcluirCorrecao");
		acao.clicarNoElemento("arcatualizacaoBotaoExcluirCorrecao");
		msg.aguardarMensagem("Deseja desvincular");
		acao.clicarNoElemento(msg.simConfirmacao);
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Alteração realizada com sucesso");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Correção adicionada.");
	}
	
	@Test(testName = "id: 25 - Adicionar repasse atualização fila única", dependsOnMethods = {"desvincularCorrecaoNaAtualizacao"})
	public void adicionarRepasseFilaUnicaAtualizacao() {
		acao.clicarNoElemento("botaoDev");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("idAcao");
		acao.selecionarNoElemento("idAcao", "Lançar Atualização");
		rotina.aguardarProcessarRotina();
		acao.escreverNoElemento("campoDescricao-1", "teste automação");
		acao.clicarNoElemento(rotina, "botaoConfirmar");
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Repasse realizado com sucesso!");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Repasse realizado com sucesso!");
		testar.passouSeAtributoDoElementoForNulo("arcatualizacaoNomeUsuarioAtual", "value");
		testar.passouSeElementoEstiverVisivel("botaoLancar");
	}
	
	@Test(testName = "id: 26 - Adicionar repasse atualização fila única", dependsOnMethods = {"adicionarRepasseFilaUnicaAtualizacao"})
	public void adicionarRepasseParaOutroUsuario() {
		acao.clicarNoElemento("botaoLancar");
		espera.aguardarElementoEstarVisivel(msg.naoConfirmacao);
		acao.clicarNoElemento(msg.naoConfirmacao);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("idAcao");
		acao.selecionarNoElemento("idAcao", "Avaliar Incidentes");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "idDestino-1");
		acao.abrirLov(rotina, "idDestino-1");
		rotina.filtrarESelecionarValorNaLov("LEONARDO");
		acao.clicarNoElemento(rotina, "campoDescricao-1");
		acao.escreverNoElemento("campoDescricao-1", "teste automação");
		acao.clicarNoElemento(rotina, "botaoConfirmar");
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Repasse realizado com sucesso!");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		msg.aguardarMensagemDesaparecer("Repasse realizado com sucesso!");
	}
	
	@Test(testName = "id: 27 - Resgatar atualização", dependsOnMethods = {"adicionarRepasseParaOutroUsuario"})
	public void resgatarAtualizacao() {
		acao.clicarNoElemento("abrirOpcoes");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento("botaoResgatar");
		msg.aguardarMensagem("Confirma resgate");
		acao.clicarNoElemento(msg.simConfirmacao);
		espera.aguardarElementoDesaparecer("botaoResgatar");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		testar.passouSeAtributoDoElementoContem("arcatualizacaoNomeUsuarioAtual", "value", "Usuario");
	}
	
	@Test(testName = "id: 28 - Tentar realizar um repasse com um usuário sem permissão para repassar", dependsOnMethods = {"resgatarAtualizacao"})
	public void testarRepassarAtualizacaoSemPermissao() {
		sairPortal();
		login.logarSemAlterarIdioma("leo", "guth055", "desenvolvimento");
		rotina.selecionarRotina("arc115");
		acao.clicarNoElemento(rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "botaoBug");
		msg.aguardarMensagem("Sem permissão para alterar essa atualização!");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
		acao.clicarNoElemento("abrirOpcoes");
		msg.aguardarMensagem("Sem permissão para alterar essa atualização!");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarElementoDesaparecer(msg.okNotificacao);
	}
	
	@Test(testName = "id: 29 - Tentar alterar atualização com um usuário sem permissão para repassar", dependsOnMethods = {"testarRepassarAtualizacaoSemPermissao"})
	public void testarAlterarAtualizacaoSemPermissao() {
		acao.selecionarNoElementoPeloValor("arcatualizacaoDificuldade", "B");
		acao.clicarNoElemento(rotina, rotina.botaoSalvar);
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Sem permissão para alterar essa atualização!");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		sairPortal();
	}
	
	@Parameters(value = { "login", "senha", "base" })
	@Test(testName = "id: 30 - Não permitir repassar atualização já finalizada lançada", dependsOnMethods = {"testarAlterarAtualizacaoSemPermissao"})
	public void testarNaoPermitirRepassarAtualizacaoFinalizada(String usuario, String senha, String base) {
		login.logar(usuario, senha, base);
		rotina.selecionarRotina("arc115");
		acao.clicarNoElemento(rotina, rotina.botaoLimparConsulta);
		acao.escreverNoElemento("arcatualizacaoId", "19");
		acao.clicarNoElemento(rotina, rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "botaoFinalizado");
		msg.aguardarMensagem("Esta atualização já foi lançada!");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarMensagemDesaparecer();
	}
	
	@Test(testName = "id: 31 - Adicionar anexo ao repasse", dependsOnMethods = {"testarNaoPermitirRepassarAtualizacaoFinalizada"})
	public void adicionarAnexoNoRepasse() throws AWTException, InterruptedException {
		acao.clicarNoElemento(rotina, rotina.botaoConsultar);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento("botaoBug");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("idAcao");
		acao.selecionarNoElemento("idAcao", "Validar");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "idDestino");
		acao.abrirLov(rotina, "idDestino");
		rotina.filtrarESelecionarValorNaLov("Usuario");
		acao.escreverNoElemento("campoDescricao-1", "teste automação");
		acao.clicarNoElemento(rotina, "anexosRepasse-1");
		acao.escreverNoElemento(By.xpath("//input[contains(@name,'anexosRepasse-1-0-aux') and @type='file']"), anexo1);
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "botaoConfirmar");
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Repasse realizado com sucesso!");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarMensagemDesaparecer();
		rotina.aguardarProcessarRotina();
		testar.passouSeElementoEstiverHabilitado("arcatualizacaoacaoExibirAnexos-1");
		acao.clicarNoElemento("arcatualizacaoacaoExibirAnexos-1");
		espera.aguardarElementoEstarVisivel("arcatualizacaoacaoarqNomeArquivo-1");
		testar.passouSeAtributoDoElementoContem("arcatualizacaoacaoarqNomeArquivo-1", "value", "peixe.png");
		acao.clicarNoElemento(rotina, "botaoFecharJanelaAnexos");
		rotina.aguardarProcessarRotina();
	}
	
	@Test(testName = "id: 33 - Adicionar rotina na atualização", dependsOnMethods = {"adicionarAnexoNoRepasse"})
	public void adicionarRotinaNaAtualizacao() throws AWTException, InterruptedException {
		acao.selecionarAba("abaInfoDev");
		rotina.aguardarProcessarRotina();
		acao.selecionarAba("abaDevRotinas");
		espera.aguardarElementoEstarVisivel("arcatualizacaorotinaIdVersaoRotina-1");
		acao.clicarNoElemento(rotina, "arcatualizacaorotinaIdVersaoRotina-1");
		acao.abrirLov(rotina, "arcatualizacaorotinaIdVersaoRotina-1");
		rotina.filtrarESelecionarValorNaLov("128");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 34 - Adicionar rotina na atualização que esteja vinculada a outra atualização", dependsOnMethods = {"adicionarRotinaNaAtualizacao"})
	public void adicionarRotinaNaAtualizacaoQueJaEstejaEmOutraAtualizacao() throws AWTException, InterruptedException {
		acao.clicarNoElemento(rotina, "arcatualizacaorotinaIdVersaoRotina-2");
		acao.abrirLov(rotina, "arcatualizacaorotinaIdVersaoRotina-2");
		rotina.filtrarESelecionarValorNaLov("pwkf007");
		acao.clicarNoElemento(rotina, rotina.botaoSalvar);
		msg.aguardarMensagem("Rotina pwkf007 em uso na atualização");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarMensagemDesaparecer();
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
	}
	
	@Test(testName = "id: 35 - Adicionar objeto de negócio na atualização", dependsOnMethods = {"adicionarRotinaNaAtualizacaoQueJaEstejaEmOutraAtualizacao"})
	public void adicionarObjetoNegocioNaAtualizacao() throws AWTException, InterruptedException {
		acao.selecionarAba("abaDevObjetosNegocio");
		espera.aguardarElementoEstarVisivel("arcatualizacaoobjetonegocioIdObjetoVersao-1");
		acao.clicarNoElemento(rotina, "arcatualizacaoobjetonegocioIdObjetoVersao-1");
		acao.abrirLov(rotina, "arcatualizacaoobjetonegocioIdObjetoVersao-1");
		rotina.filtrarESelecionarValorNaLov("LLSFET");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
	}
	
	@Test(testName = "id: 36 - Adicionar objeto de negócio que esteja em outra atualização na atualização", dependsOnMethods = {"adicionarObjetoNegocioNaAtualizacao"})
	public void adicionarObjetoNegocioNaAtualizacaoQueJaEstejaEmOutraAtualizacao() throws AWTException, InterruptedException {
		espera.aguardarElementoEstarVisivel("arcatualizacaoobjetonegocioIdObjetoVersao-2");
		acao.clicarNoElemento(rotina, "arcatualizacaoobjetonegocioIdObjetoVersao-2");
		acao.abrirLov(rotina, "arcatualizacaoobjetonegocioIdObjetoVersao-2");
		rotina.filtrarESelecionarValorNaLov("LLSFET");
		acao.clicarNoElemento(rotina, rotina.botaoSalvar);
		msg.aguardarMensagem("Objeto de Negócio LLSFET em uso na atualização");
		acao.clicarNoElemento(msg.okNotificacao);
		espera.aguardarMensagemDesaparecer();
		teclado.pressionarConjuntoDeTeclasDeControle(Keys.SHIFT, Keys.F6);
		rotina.aguardarProcessarRotina();
	}
	
	@Test(testName = "id: 37 - Adicionar objeto de banco de dados na atualização", dependsOnMethods = {"adicionarObjetoNegocioNaAtualizacaoQueJaEstejaEmOutraAtualizacao"})
	public void adicionarObjetoDeBancoDeDadosNaAtualizacao() throws AWTException, InterruptedException {
		acao.selecionarAba("abaDevObjetosBanco");
		espera.aguardarElementoEstarVisivel("arcatualizacaoobjetobancoIdObjetoBanco-1");
		acao.clicarNoElemento(rotina, "arcatualizacaoobjetobancoIdObjetoBanco-1");
		acao.abrirLov(rotina, "arcatualizacaoobjetobancoIdObjetoBanco-1");
		rotina.filtrarESelecionarValorNaLov("procedure");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		rotina.limparCampoERealizarNovaConsulta();
	}
	
	@Test(testName = "id: 38 - Editar comando do objeto de banco de dados na atualização", dependsOnMethods = {"adicionarObjetoDeBancoDeDadosNaAtualizacao"})
	public void EditarObjetoDeBancoDeDadosNaAtualizacao() throws AWTException, InterruptedException {
		acao.clicarNoElemento(rotina, "botaoEditarComandoObjBanco-1");
		espera.aguardarElementoEstarVisivel("comandoBanco-1");
		acao.limparElemento("comandoBanco-1");
		acao.escreverNoElemento("comandoBanco-1", "Teste automação");
		acao.clicarNoElemento(rotina, "botaoConfirmarComando-1");
		espera.aguardarElementoDesaparecer("comandoBanco-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarMensagemDesaparecer();
		acao.clicarNoElemento(rotina, "arcatualizacaoobjetobancoIdObjetoBanco-1");
		rotina.limparCampoERealizarNovaConsulta();
		acao.clicarNoElemento(rotina, "botaoEditarComandoObjBanco-1");
		espera.aguardarElementoEstarVisivel("comandoBanco-1");
		testar.passouSeAtributoDoElementoContem("comandoBanco-1", "value", "Teste automação");
		acao.limparElemento("comandoBanco-1");
		acao.escreverNoElemento("comandoBanco-1", "Teste");
		acao.clicarNoElemento(rotina, "botaoConfirmarComando-1");
		espera.aguardarElementoDesaparecer("comandoBanco-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel(msg.mensagemRegistrosAlterados);
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarMensagemDesaparecer();
	}
	
	@Test(testName = "id: 39 - Inserir comando de banco de dados na atualização", dependsOnMethods = {"EditarObjetoDeBancoDeDadosNaAtualizacao"})
	public void inserirComandoDeBanco() throws AWTException, InterruptedException {
		acao.selecionarAba("abaDevComandosBanco");
		espera.aguardarElementoEstarVisivel("botaoInserirComando-1");
		acao.clicarNoElemento(rotina, "botaoInserirComando-1");
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("campoSeparador");
		acao.escreverNoElemento("campoSeparador", ";");
		acao.clicarNoElemento(rotina, "editarComandoAbaComandos");
		acao.escreverNoElemento("editarComandoAbaComandos", "select * from dual; insert into teste values (1, 2, 3); select teste from dual"); 
		acao.clicarNoElemento(rotina, "botaoConfirmarJanelaComandos");
		espera.aguardarElementoDesaparecer("campoSeparador");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "arcatualizacaocomandoComando-1");
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		String totalComandos = rotina.totalRegistros();
		testar.passouSeValoresForemIguais(totalComandos, "3");
		acao.clicarNoElemento(rotina, "botaoInserirComando-1");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "editarComandoAbaComandos");
		acao.escreverNoElemento("editarComandoAbaComandos", "select * from"); 
		acao.clicarNoElemento(rotina, "botaoConfirmarJanelaComandos");
		espera.aguardarElementoDesaparecer("campoSeparador");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "arcatualizacaocomandoComando-1");
		rotina.aguardarProcessarRotina();
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		totalComandos = rotina.totalRegistros();
		testar.passouSeValoresForemIguais(totalComandos, "4");
	}
	
	@Test(testName = "id: 40 - Acessar a aba todos e ordenar as modificações", dependsOnMethods = {"inserirComandoDeBanco"})
	public void ordenarModificacoesAbaTodos() throws AWTException, InterruptedException {
		acao.selecionarAba("abaDevTodos");
		espera.aguardarElementoEstarVisivel("todasmodificacoes_auxBotaoRecarregarTodos");
		acao.clicarNoElemento(rotina, "todasmodificacoes_auxOrdem-5");
		acao.limparElemento("todasmodificacoes_auxOrdem-5");
		acao.escreverNoElemento("todasmodificacoes_auxOrdem-5", "1");
		acao.clicarNoElemento(rotina, "todasmodificacoes_auxOrdem-4");
		acao.limparElemento("todasmodificacoes_auxOrdem-4");
		acao.escreverNoElemento("todasmodificacoes_auxOrdem-4", "2");
		acao.clicarNoElemento(rotina, "todasmodificacoes_auxOrdem-3");
		acao.limparElemento("todasmodificacoes_auxOrdem-3");
		acao.escreverNoElemento("todasmodificacoes_auxOrdem-3", "3");
		acao.clicarNoElemento(rotina, "todasmodificacoes_auxOrdem-2");
		acao.limparElemento("todasmodificacoes_auxOrdem-2");
		acao.escreverNoElemento("todasmodificacoes_auxOrdem-2", "4");
		acao.clicarNoElemento(rotina, "todasmodificacoes_auxOrdem-1");
		acao.limparElemento("todasmodificacoes_auxOrdem-1");
		acao.escreverNoElemento("todasmodificacoes_auxOrdem-1", "5");
		rotina.salvarEAguardarMensagemRegistrosAlterados();
		acao.clicarNoElemento("todasmodificacoes_auxBotaoRecarregarTodos");
		rotina.aguardarProcessarRotina();
		testar.passouSeAtributoDoElementoContem("todasmodificacoes_auxOrdem-6", "value", "5");
		testar.passouSeAtributoDoElementoContem("todasmodificacoes_auxOrdem-5", "value", "4");
		testar.passouSeAtributoDoElementoContem("todasmodificacoes_auxOrdem-4", "value", "4");
		testar.passouSeAtributoDoElementoContem("todasmodificacoes_auxOrdem-3", "value", "3");
		testar.passouSeAtributoDoElementoContem("todasmodificacoes_auxOrdem-2", "value", "2");
		testar.passouSeAtributoDoElementoContem("todasmodificacoes_auxOrdem-1", "value", "1");
	}
	
	
	@Test(testName = "id: 41 - Inserir modificação de cadastro pai (arclista)", dependsOnMethods = {"ordenarModificacoesAbaTodos"}, enabled = true)
	public void inserirModificacaoCadastroPai() throws AWTException, InterruptedException {
		acao.selecionarAba("abaInfoDev");
		espera.aguardarElementoEstarVisivel("abaDevModificacoes");
		acao.selecionarAba("abaDevModificacoes");
		espera.aguardarElementoEstarVisivel("arcatualizacaomodcadastroBotaoInserirModificacao");
		acao.clicarNoElemento(rotina, "arcatualizacaomodcadastroBotaoInserirModificacao");
		rotina.aguardarLovProcessar();
		rotina.filtrarESelecionarValorNaLov("ARCLISTA");
		espera.aguardarRotinaCarregada("ARC117");
		acao.clicarNoElemento(rotina, "botaoAddModificacao-1");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "botaoAddModificacao-2");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "tabelacomparativaBotaoSalvarAlteracoes");
		msg.aguardarMensagem("Salvar as modificações selecionadas?");
		acao.clicarNoElemento(msg.simConfirmacao);
		espera.aguardarMensagemDesaparecer();
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Modificações de cadastro adicionadas na atualização com sucesso!");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarMensagemDesaparecer();
	}
	
	@Test(testName = "id: 42 - Inserir modificação de cadastro filha (arclistaval)", dependsOnMethods = {"inserirModificacaoCadastroPai"}, enabled = true)
	public void inserirModificacaoCadastroFilha() throws AWTException, InterruptedException {
		acao.clicarNoElemento(rotina, "arcatualizacaomodcadastroBotaoInserirModificacao");
		rotina.aguardarLovProcessar();
		acao.escreverNoElemento(rotina.filtrarLov, "ARCLISTAVAL");
		espera.aguardarElementoEstarVisivel(rotina.selecionarValorLov("ARCLISTAVAL"));
		acao.clicarNoElemento(rotina.selecionarValorLov("ARCLISTAVAL"));
		rotina.aguardarLovProcessar();
		rotina.filtrarESelecionarValorNaLov("Correntista");
		espera.aguardarRotinaCarregada("ARC117");
		acao.clicarNoElemento(rotina, "botaoAddModificacao-1");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "botaoAddModificacao-2");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "tabelacomparativaBotaoSalvarAlteracoes");
		msg.aguardarMensagem("Salvar as modificações selecionadas?");
		acao.clicarNoElemento(msg.simConfirmacao);
		espera.aguardarMensagemDesaparecer();
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Modificações de cadastro adicionadas");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarMensagemDesaparecer();
	}
	
	@Test(testName = "id: 44 - Adicionar modificação por rotina", dependsOnMethods = {"inserirModificacaoCadastroFilha"}, enabled = true)
	public void inserirModificacaoPorRotina() throws AWTException, InterruptedException {
		acao.clicarNoElemento("botaoInserirModificacaoPorRotina");
		rotina.aguardarLovProcessar();
		acao.escreverNoElemento(rotina.filtrarLov, "pteste02");
		espera.aguardarElementoEstarVisivel(rotina.selecionarValorLov("pteste02"));
		acao.clicarNoElemento(rotina.selecionarValorLov("pteste02"));
		rotina.aguardarLovProcessar();
		rotina.filtrarESelecionarValorNaLov("ARCLISTA");
		acao.clicarNoElemento(rotina, "botaoAddModificacao-1");
		rotina.aguardarProcessarRotina();
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "tabelacomparativaBotaoSalvarAlteracoes");
		msg.aguardarMensagem("Salvar as modificações selecionadas?");
		acao.clicarNoElemento(msg.simConfirmacao);
		espera.aguardarMensagemDesaparecer();
		rotina.aguardarProcessarRotina();
		msg.aguardarMensagem("Modificações de cadastro adicionadas na atualização com sucesso!");
		teclado.pressionarTeclaDeControle(Keys.ESCAPE);
		espera.aguardarMensagemDesaparecer();
	}
	
	@Test(testName = "id: 43 - Excluir todas as modificações", dependsOnMethods = {"inserirModificacaoPorRotina"}, enabled = true)
	public void excluirModificaoesDaAtualizacao() throws AWTException, InterruptedException {
		acao.selecionarAba("abaDevTodos");
		espera.aguardarElementoEstarVisivel("todasmodificacoes_auxBotaoRecarregarTodos");
		acao.clicarNoElemento("todasmodificacoes_auxItem-1");
		rotina.aguardarProcessarRotina();
		acao.excluirTodosOsRegistrosDeUmBloco(teclado, rotina, "todasmodificacoes_auxItem-1");
	}

	@Test(testName = "id: 32 - Cancelar atualização", dependsOnMethods = {"excluirModificaoesDaAtualizacao"}, enabled = true)
	public void cancelarAtualizacao() throws AWTException, InterruptedException {
		acao.clicarNoElemento(rotina, "abrirOpcoes");
		rotina.aguardarProcessarRotina();
		acao.clicarNoElemento(rotina, "botaoCancelarAtualizacao");
		msg.aguardarMensagem("Confirma cancelamento");
		acao.clicarNoElemento(msg.simConfirmacao);
		espera.aguardarMensagemDesaparecer();
		espera.aguardarElementoDesaparecer(msg.simConfirmacao);
		rotina.aguardarProcessarRotina();
		espera.aguardarElementoEstarVisivel("botaoCancelado");
	}
}
