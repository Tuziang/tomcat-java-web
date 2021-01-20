import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.*;

public class MailTest{

  public static void main(String[] args)throws Exception {
    Properties props = new Properties();
    props.put("mail.smtp.host", "localhost");
    
    Session session = Session.getDefaultInstance(props); 

    String toAddr="admin@mydomain.com";
    String fromAddr="admin@mydomain.com";

    Message msg = new MimeMessage(session);
    InternetAddress[] toAddrs =InternetAddress.parse(toAddr, false);
    msg.setRecipients(Message.RecipientType.TO, toAddrs);
    msg.setSentDate(new Date());     
    msg.setSubject("hello");
    msg.setFrom(new InternetAddress(fromAddr));
    msg.setText("How are you");

    Transport.send(msg);  	  
  }
}
