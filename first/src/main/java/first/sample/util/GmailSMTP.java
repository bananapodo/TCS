package first.sample.util;

import java.io.File;
//import java.security.Security;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class GmailSMTP {
 public static  String SMTP_HOST_NAME = "smtp.gmail.com";
 public static  String SMTP_PORT = "465";
 public static  String emailMsgTxt = "Gmail SMTP 서버를 사용한 JavaMail 테스트";
 public static  String emailSubjectTxt = "Gmail SMTP 테스트";
 public static  String emailFromAddress = "loboandzorra@gmail.com";
 public static  String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
 public static  String[] sendTo = { "mogki@naver.com"};

// public static void main(String args[]) throws Exception {
//  Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//  new GmailSMTP().sendSSLMessage(sendTo, emailSubjectTxt, emailMsgTxt, emailFromAddress);
//  System.out.println("Sucessfully Sent mail to All Users");
// }
 public static void sendSSLMessage(String recipients[], String subject,
 String message, String from) throws MessagingException {
  boolean debug = true;
  Properties props = new Properties();
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.auth", "true");
  props.put("mail.debug", "true");
  props.put("mail.smtp.port", "465");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.socketFactory.fallback", "false");
  
  Session session = Session.getDefaultInstance(props,
   new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
     return new PasswordAuthentication("loboandzorra", "1q2w#E$R");
    }
   }
  );
  session.setDebug(debug);
  Message msg = new MimeMessage(session);
  InternetAddress addressFrom = new InternetAddress(from);
  msg.setFrom(addressFrom);
  InternetAddress[] addressTo = new InternetAddress[recipients.length];
  for (int i = 0; i < recipients.length; i++) {
   addressTo[i] = new InternetAddress(recipients[i]);
  }
  msg.setRecipients(Message.RecipientType.TO, addressTo);
  // Setting the Subject and Content Type
  msg.setSubject(subject);

  //-텍스트만 전송하는 경우 아래의 2라인만 추가하면 된다. 
  // 그러나 텍스트와 첨부파일을 함께 전송하는 경우에는 아래의 2라인을 제거하고  
  // 대신에 그 아래의 모든 문장을 추가해야 한다.
  //-
  
  //msg.setContent(message, "text/plain;charset=KSC5601");
  //Transport.send(msg);
  
  //- 텍스트와 첨부파일을 함께 전송하는 경우에는 위의 2라인을 제거하고 아래의 모든 라인을 추가한다.*-
  // Create the message part
  BodyPart messageBodyPart = new MimeBodyPart();
 
  // Fill the message
  messageBodyPart.setText(emailSubjectTxt);
  Multipart multipart = new MimeMultipart();
  multipart.addBodyPart(messageBodyPart);
 
  // Part two is attachment
  messageBodyPart = new MimeBodyPart();
  File file = new File("C://config.txt");
  FileDataSource fds = new FileDataSource(file);
  messageBodyPart.setDataHandler(new DataHandler(fds));
  messageBodyPart.setFileName(fds.getName());
  multipart.addBodyPart(messageBodyPart);

  
  // 메일 로그
//// Put parts in message
  msg.setContent(multipart);
// 
////  // Send the message
  Transport.send(msg);
// 
  System.out.println("E-mail successfully sent!!"); 

 }
}
