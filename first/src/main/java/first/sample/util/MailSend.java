package first.sample.util;

import java.security.Security;
import first.sample.util.GmailSMTP;

public class MailSend {
	 public static  String SMTP_HOST_NAME = "smtp.gmail.com";
	 public static  String SMTP_PORT = "465";
	 public static  String emailMsgTxt = "Gmail SMTP 서버를 사용한 JavaMail 테스트";
	 public static  String emailSubjectTxt = "Gmail SMTP 테스트";
	 public static  String emailFromAddress = "loboandzorra@gmail.com";
	 public static  String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	 public static  String[] sendTo = { "mogki@naver.com"};

	public static void main(String args[]) throws Exception {
		  Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		  GmailSMTP gmailSMTP = new GmailSMTP();
		  
		  gmailSMTP.sendSSLMessage(sendTo, emailSubjectTxt, emailMsgTxt, emailFromAddress);
		  System.out.println("Sucessfully Sent mail to All Users");
		 }
}
