package br.com.alura.enviadorEmail.enviadorEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	
	
	/**
	 * É necessário configurar as variáveis do sistema. 
	 * Exemplo no Linux:
	 * echo 'export EMAIL_LISTA_VIP="<email>"' >> ~/.profile
	 * echo 'export SENHA_EMAIL_LISTA_VIP="<senha>"' >> ~/.profile
	 * @param nome
	 * @param emailConvidado
	 */
	public void enviar(String nome, String emailConvidado){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(
            		new DefaultAuthenticator(
            				System.getenv("EMAIL_LISTA_VIP"), 
            				System.getenv("SENHA_EMAIL_LISTA_VIP")
            				));
            email.setSSLOnConnect(true);

            email.setFrom(System.getenv("EMAIL_LISTA_VIP"));
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + nome + ". Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(emailConvidado);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
