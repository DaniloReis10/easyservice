package util;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailApp {
	private Properties props;
	private Session session;
	public JavaMailApp(){
		props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

	 session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"alysson.chicoh@gmail.com", "87225760");
					}
				});

		/** Ativa Debug para sessão */
		session.setDebug(true);

	
	}
	
	public void enviar(String destinatario,String mensagem){
		
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("alysson.chicoh@gmail.com")); // Remetente

			Address[] toUser = InternetAddress // Destinatário(s)
					.parse("alysson_chico@hotmail.com");

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Easy Service");// Assunto
			message.setText(mensagem);
			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}	
	}
	
	
}
