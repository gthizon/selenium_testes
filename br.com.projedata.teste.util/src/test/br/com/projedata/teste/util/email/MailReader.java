package br.com.projedata.teste.util.email;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

public class MailReader {

	private String tipoServidor;

	public MailReader(String tipoServidor, String server, int port, boolean ssl) {

		System.setProperty("mail.mime.base64.ignoreerrors", "true");
		this.tipoServidor = tipoServidor;

		if ("imap".equalsIgnoreCase(tipoServidor)) {
			configIMAP(server, port, ssl);
		} else if ("pop3".equalsIgnoreCase(tipoServidor)) {
			configPOP3(server, port, ssl);
		}
	}

	public Store connect(String username, String senha) {

		try {
			Session session = Session.getInstance(System.getProperties());
			Store store = session.getStore(tipoServidor);
			store.connect(username, senha);
			return store;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void configIMAP(String server, int port, boolean ssl) {

		if (ssl) {
			installCert(server, port);
		}

		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		{
			// IMAP provider
			if (ssl) {
				props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
				props.setProperty("mail.imap.socketFactory.fallback", "false");
			}
			props.setProperty("mail.imap.host", server);
			props.setProperty("mail.imap.port", String.valueOf(port));
			props.setProperty("mail.imap.socketFactory.port", String.valueOf(port));
		}
	}

	private void configPOP3(String server, int port, boolean ssl) {
		if (ssl) {
			installCert(server, port);
		}

		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties();
		{
			// POP3 provider
			if (ssl) {
				props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
				props.setProperty("mail.pop3.socketFactory.fallback", "false");
			}
			props.setProperty("mail.pop3.host", server);
			props.setProperty("mail.pop3.port", String.valueOf(port));
			props.setProperty("mail.pop3.socketFactory.port", String.valueOf(port));
		}
	}

	private void installCert(String server, int port) {
		PrintStream outOld = System.out;
		try {
			System.setOut(new PrintStream(new StringBufferOutPutStream(new StringBuffer())));

			InstallCert.main(new String[] { server + ":" + port });

			Properties props = System.getProperties();
			{
				props.setProperty("sun.security.ssl.allowUnsafeRenegotiation", "true");
				props.setProperty("javax.net.ssl.trustStoreType", "JKS");
				props.setProperty("javax.net.ssl.trustStore", "jssecacerts.jks");
				props.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			System.setOut(outOld);
		}
	}

	public String recuperarLoginOuSenha(Store store, String emailDir) {

		try {
			Folder folder = null;

			Folder[] f = store.getDefaultFolder().list();
			for (Folder fd : f) {
				if (fd.getName().equals("recuperarSenha")) {
					folder = fd;
				}
			}

			folder.open(Folder.READ_WRITE);

			try {
				String conteudoEmail = null;
				String assuntoEmail = null;
				String linkEmail = null;
				Message msg[] = folder.getMessages();

				for (int i = 0; i < msg.length; i++) {
					try {
						MimeMultipart mmt = (MimeMultipart) msg[i].getContent();
						assuntoEmail = msg[i].getSubject().toString();
						for (int x = 0; x < mmt.getCount(); x++) {
							BodyPart bodyPart = mmt.getBodyPart(x);

							if (bodyPart.getContentType().contains("TEXT")) {
								conteudoEmail = bodyPart.getContent().toString();
							}
						}
					} catch (Exception ex) {
						throw new RuntimeException(ex);
					} finally {
						msg[0].setFlag(Flag.DELETED, true);
					}
				}
				if (assuntoEmail.contains("Recuperação de Senha")) {
					linkEmail = conteudoEmail.substring(conteudoEmail.lastIndexOf("=\"") + 2,
							conteudoEmail.lastIndexOf("\">"));
				} else {
					linkEmail = conteudoEmail.substring(conteudoEmail.lastIndexOf("<u>") + 3,
							conteudoEmail.lastIndexOf("</u>"));
				}

				return linkEmail;

			} finally {
				folder.close(true);
				store.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean verificarRelatorioEnviadoPorAgendamento(Store store, String emailDir) {
		boolean retorno = false;
		try {
			Folder folder = null;

			Folder[] f = store.getDefaultFolder().list();
			for (Folder fd : f) {
				if (fd.getName().equals("agendamentoRelatorio")) {
					folder = fd;
				}
			}

			folder.open(Folder.READ_WRITE);

			try {
				int j = 0;
				String assuntoEmail = "";
				Message msg[] = folder.getMessages();
				while ((msg == null || msg.length == 0) && j < 30) {
					msg = folder.getMessages();
					Thread.sleep(300);
					j++;
				}
				for (int i = 0; i < msg.length; i++) {
					assuntoEmail = msg[i].getSubject().toString();
					msg[i].setFlag(Flag.DELETED, true);
					if (assuntoEmail.contains("Iniview - Agendamento:")) {
						retorno = true;
					}
				}
			} finally {
				folder.close(true);
				store.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return retorno;
	}
	
	public boolean verificarRelatorioEnviadoPorEmail(Store store, String emailDir) {
		boolean retorno = false;
		try {
			Folder folder = null;

			Folder[] f = store.getDefaultFolder().list();
			for (Folder fd : f) {
				if (fd.getName().equals("agendamentoRelatorio")) {
					folder = fd;
				}
			}

			folder.open(Folder.READ_WRITE);

			try {
				int j = 0;
				String assuntoEmail = "";
				Message msg[] = folder.getMessages();
				while ((msg == null || msg.length == 0) && j < 30) {
					msg = folder.getMessages();
					Thread.sleep(300);
					j++;
				}
				for (int i = 0; i < msg.length; i++) {
					assuntoEmail = msg[i].getSubject().toString();
					msg[i].setFlag(Flag.DELETED, true);
					if (assuntoEmail.contains("teste relatório imagem")) {
						retorno = true;
					}
				}
			} finally {
				folder.close(true);
				store.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return retorno;
	}

	/** Verificar para criar o certificado **/
	public static void criarCertificado()
			throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException {

		KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
		trustStore.load(null);
		InputStream fis = null;
		BufferedInputStream bis = new BufferedInputStream(fis);

		CertificateFactory cf = CertificateFactory.getInstance("X.509");

		while (bis.available() > 0) {
			java.security.cert.Certificate cert = cf.generateCertificate(bis);
			trustStore.setCertificateEntry("fiddler" + bis.available(), cert);
		}
	}
}