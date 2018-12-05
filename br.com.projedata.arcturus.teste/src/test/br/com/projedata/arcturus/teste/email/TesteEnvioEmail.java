//package br.com.projedata.arcturus.teste.email;
//
//import java.io.File;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//
///**
// * Testes de envio de e-mail. <br>
// * - Testar envio sem ssl, sem autentiacao; <br>
// * - Testar envio com ssl, sem autenticacao; <br>
// * - Testar envio sem ssl, com autenticacao; <br>
// * - Testar envio com ssl, com autenticacao; <br>
// * - Testar envio com ssl, com autenticacao, com anexo;
// * 
// * @author Douglas Cachoeira
// *
// */
//public class TesteEnvioEmail {
//
//	@Test
//	public void testarEnvioEmailSemSslSemAutenticacao() throws Excecao {
//		Email email = criarEmailPadrao("SemSslSemAutenticacao");
//		try {
//			EnvioEmail.enviar(criarConfig(false, false), email);
//			Assert.assertTrue(false, "Foi possível enviar um email sem SSL e sem autenticação.");
//		} catch (Exception ex) {
//		}
//	}
//
//	@Test(dependsOnMethods = { "testarEnvioEmailSemSslSemAutenticacao" })
//	public void testarEnvioEmailComSslSemAutenticacao() throws Excecao {
//		Email email = criarEmailPadrao("ComSslSemAutenticacao");
//		try {
//			EnvioEmail.enviar(criarConfig(true, false), email);
//			Assert.assertTrue(false, "Foi possível enviar um email sem autenticação.");
//		} catch (Exception ex) {
//		}
//	}
//
//	@Test(dependsOnMethods = { "testarEnvioEmailComSslSemAutenticacao" })
//	public void testarEnvioEmailSemSslComAutenticacao() throws Excecao {
//		Email email = criarEmailPadrao("SemSslComAutenticacao");
//		EnvioEmail.enviar(criarConfig(false, true), email);
//	}
//
//	@Test(dependsOnMethods = { "testarEnvioEmailSemSslComAutenticacao" })
//	public void testarEnvioEmailComSslComAutenticacao() throws Excecao {
//		Email email = criarEmailPadrao("ComSslComAutenticacao");
//		EnvioEmail.enviar(criarConfig(true, true), email);
//	}
//
//	@Test(dependsOnMethods = { "testarEnvioEmailComSslComAutenticacao" })
//	public void testarEnvioEmailComAnexo() throws Excecao {
//		Email email = criarEmailPadrao("ComAnexo");
//		ClassLoader classLoader = getClass().getClassLoader();
//		File file = new File(classLoader.getResource("anexo.log").getFile());
//		AnexoEmail imagem = new AnexoEmail("anexto.log", file.getAbsolutePath());
//		imagem.setIdentificacao("anx01");
//		email.getAnexos().add(imagem);
//		EnvioEmail.enviar(criarConfig(true, true), email);
//	}
//
//	@BeforeTest
//	public void beforeTest() {
//
//	}
//
//	private Email criarEmailPadrao(String assunto) {
//		Email email = new Email();
//		email.setRemetente("Email do Teste <no-reply@projedata.com.br>");
//		email.setDestinatario("Testador Arcturus <no-reply@projedata.com.br>");
//		email.setAssunto("Assunto do Email " + assunto);
//		email.setConteudo("Conteudo do email");
//		return email;
//	}
//
//	private EmailConfig criarConfig(boolean ssl, boolean autenticacao) {
//		EmailConfig config = new EmailConfig();
//		config.setServidor("mail.projedata.com.br");
//		config.setPorta(25);
//		if (ssl) {
//			config.setPorta(587);
//			config.setSsl(true);
//		}
//		if (autenticacao) {
//			config.setUsuarioAutenticacao("no-reply@projedata.com.br");
//			config.setSenhaAutenticacao("no-123-reply");
//		}
//		return config;
//	}
//
//}
