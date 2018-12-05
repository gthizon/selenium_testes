package br.com.projedata.arcturus.teste.webelements;

import org.openqa.selenium.By;

public class Pwkf007Elementos {

	public static By rotinaAberta = By.xpath("//p[contains(text(),'WKF007')]//following::li[contains(@class,'info-navegacao')]//child::span[contains(text(),'1/')]");
	public static By selecionaRotina = By.xpath("//*[contains(@id,'pwkf007')]");
	public static By campoOsPrimeiraLinha = By.xpath("//input[contains(@name,'repassesNumeroOs') and @posicao=0]");
	public static By filtroNumeroOs = By.xpath("//input[contains(@name,'numeroOs')]");
	public static By filtroCriticidade1 = By.xpath("//select[contains(@name,'criticidade') and @indice=0]");
	public static By botaoAddFiltroCriticidade = By.xpath("//select[contains(@name,'criticidade')]//following::i[@class='fa fa-plus'][1]");
	public static By filtroCriticidade2 = By.xpath("//select[contains(@name,'criticidade') and @indice=1]");
	public static By filtroDetalhes = By.xpath("//input[contains(@name,'.detalhes')]");
	public static By filtroOrdem = By.xpath("//select[contains(@name,'.ordemColuna')]");
	public static By filtroSentido = By.xpath("//select[contains(@name,'.ordemSentido')]");
	public static By filtroSituacaoOS = By.xpath("//select[contains(@name,'.situacaoos')]");
	public static By barraRolagemAtivaResumoDeOss = By.xpath("//arc-campo[contains(@codigo,'.botaoNaoLida')]//following::div[12][@class='barra-rolagem proxima-pagina']");
	public static By barraRolagemDesabilitadaResumoDeOss = By.xpath("//arc-campo[contains(@codigo,'.botaoNaoLida')]//following::div[12][@class='barra-rolagem proxima-pagina' and @disabled='disabled']");
	public static By barraRolagemAtivaListaDeOss = By.xpath("//arc-campo[contains(@codigo,'.botaoNaoLida')]//following::div[5][@class='barra-rolagem proxima-pagina']");
	public static By barraRolagemDesabilitadaListaDeOss = By.xpath("//arc-campo[contains(@codigo,'.botaoNaoLida')]//following::div[5][@class='barra-rolagem proxima-pagina' and @disabled='disabled']");
	public static By resumoTotalOssPrioridadeBaixa = By.xpath("//div[contains(@idetiqueta,'resumoTotal')]//preceding::input[1][contains(@name,'resumoBaixa')]");
	public static By botaoListarOssPrioridadeBaixa = By.xpath("//arc-campo[contains(@codigo,'botaoTotal')]//preceding::button[1][contains(@name,'botaoBaixa')]");
	public static By campoSequenciaUltimoRegistro = By.xpath("//input[contains(@name,'.repassesSequencia') and @posicao = 16]");
	public static By botaoAbrirOsWkf008 = By.xpath("//button[contains(@name,'abrirOs') and @posicao='0']");
	public static By botaoResgatar = By.xpath("//button[@data-original-title='Resgatar' and @posicao=0]");
	public static By filtroUsuarios = By.xpath("//input[contains(@name,'.usuario') and contains(@class,'lov el-campo-lov-campo')]");
	public static By filtroCodigoCorrentista = By.xpath("//input[contains(@name,'correntista') and contains(@class,'lov')]");
	public static By botaoFiltrarCorrentistas = By.xpath("//input[contains(@name,'correntista') and contains(@class,'lov')]//following::button[@title='Os valores serão filtrados']");
	public static By botaoNaoFiltrarCorrentistas = By.xpath("//input[contains(@name,'correntista') and contains(@class,'lov')]//following::button[@title='Os valores serão excluídos']");
	public static By filtroNomeCorrentista = By.xpath("//input[contains(@name,'correntista_aux')]");
	public static By filtroDataAberturaOsInicio = By.xpath("//input[contains(@name,'dataos') and @indice=0]");
	public static By filtroDataAberturaOsFim = By.xpath("//input[contains(@name,'dataos') and @indice=1]");
	public static By botaoEnvelopeFechado = By.xpath("//button[contains(@name, 'repassesMarcarLida') and @posicao=0]");
	public static By botaoEnvelopeAberto = By.xpath("//button[contains(@name, 'repassesMarcarNaoLida') and @posicao=0]");
	public static By filtroContemAcao = By.xpath("//input[contains(@name,'contemAcao')]");
	public static By filtroAcaoAtual = By.xpath("//input[contains(@name,'atividadeAcao')]");
	public static By campoAcaoQuadroResumoAcoes = By.xpath("//input[contains(@name, 'resumoAcao') and @posicao=0]");
	public static By campoAcaoQuadroResumoAcoesLinha2 = By.xpath("//input[contains(@name, 'resumoAcao') and @posicao=1]");
	public static By botaoAbrirOsWkf008SelecionarPosicao = By.xpath("//button[contains(@name,'abrirOs')]");
	public static By campoCriticidadeSelecionarPosicao = By.xpath("//input[contains(@id,'repassesCriticidade')]");
	public static By fecharRotina = By.xpath("//p[contains(text(),'WKF007')]//following::*[@title='Fechar']");
	public static By botaoMostraFiltros = By.xpath("//button[contains(@class,'filtro')]");
	public static By telaFiltros = By.xpath("//div[@id='$filtros']");
	public static By filtroUsuario = By.xpath("//input[contains(@id,'usuario-1-0')]");
	
}
