package first.sample.util;


import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
 
import java.io.*;
import java.util.*;
 
public class Gmail
{
 public static void main(String[] args) 
 {
  Properties p = new Properties();
  p.put("mail.smtp.user", "loboandzorra@gmail.com"); // Google계정 아이디@gmail.com으로 설정
  p.put("mail.smtp.host", "smtp.gmail.com");
  p.put("mail.smtp.port", "465");
  p.put("mail.smtp.starttls.enable","true");
  p.put("mail.smtp.auth", "true");
 
  p.put("mail.smtp.debug", "true");
  p.put("mail.smtp.socketFactory.port", "465"); 
  p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
  p.put("mail.smtp.socketFactory.fallback", "false");
 
  //Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
 
  try {
   Authenticator auth = new SMTPAuthenticator();
   Session session = Session.getInstance(p, auth);
   session.setDebug(true); // 메일을 전송할 때 상세한 상황을 콘솔에 출력한다.
 
   //session = Session.getDefaultInstance(p);
   MimeMessage msg = new MimeMessage(session);
   String message = "Gmail SMTP 서버를 이용한 JavaMail 테스트";
   msg.setSubject("Gmail SMTP 서버를 이용한 JavaMail 테스트");
   Address fromAddr = new InternetAddress("loboandzorra@gmail.com"); // 보내는 사람의 메일주소
   msg.setFrom(fromAddr);
   Address toAddr = new InternetAddress("mogki@naver.com");  // 받는 사람의 메일주소
   msg.addRecipient(Message.RecipientType.TO, toAddr); 
   /*
   msg.setContent(message, "text/plain;charset=KSC5601");
   System.out.println("Message: " + msg.getContent());
   Transport.send(msg);
   */
   BodyPart messageBodyPart = new MimeBodyPart();
    
   // Fill the message
   messageBodyPart.setText("Java Mail API를 이용하여 첨부파일을 테스트합니다.");
   Multipart multipart = new MimeMultipart();
   multipart.addBodyPart(messageBodyPart);
   
   // Part two is attachment
   messageBodyPart = new MimeBodyPart();
   File file = new File("C:/T.txt");
   FileDataSource fds = new FileDataSource(file);
   messageBodyPart.setDataHandler(new DataHandler(fds));
   messageBodyPart.setFileName(fds.getName());
   multipart.addBodyPart(messageBodyPart);
   
   // Put parts in message
   msg.setContent(multipart, "text/plain;charset=KSC5601");
   
   // Send the message
   Transport.send(msg);
   System.out.println("Gmail SMTP서버를 이용한 메일보내기 성공");
  }
  catch (Exception mex) { // Prints all nested (chained) exceptions as well 
   System.out.println("I am here??? ");
   mex.printStackTrace(); 
  } 
 }
 
 private static class SMTPAuthenticator extends javax.mail.Authenticator {
 
  public PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication("loboandzorra", "1q2w#E$R"); // Google id, pwd
  }
 } 
}
