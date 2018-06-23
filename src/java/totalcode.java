
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class totalcode  {

     static Connection connection()
    {
        Connection con=null;
    try {
 
   con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample007","sri","sri");
   
}
    
    catch(Exception e)
    {
       System.out.println(e.getMessage()); 
    }
    return con;
    }
  static int  saves(getinput g)
   {
       int status =0;
     try
     {
     
      Connection con=totalcode.connection();
      PreparedStatement ps=con.prepareStatement("insert into sample00 values(?,?,?)");
      ps.setString(1,g.did());
      ps.setString(2,g.dname());
      ps.setString(3,g.demail());
    status=  ps.executeUpdate();
    con.close();
     }
     catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
     return status;
   }
  static getinput set(String id)
  {
      int status=0;
      getinput g=new getinput();
      try
      {
        
      Connection con=totalcode.connection();
      PreparedStatement ps=con.prepareStatement("select * from  sample00 where fid=?");
      ps.setString(1,id);
      ResultSet rs=ps.executeQuery();
      if(rs.next())
      {
          g.gid(rs.getString(1));
          g.gname(rs.getString(2));
          g.gemail(rs.getString(3));
      }
          
      }
      catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
      return g;
  }
  static int update(getinput g)
  {
      int status=0;
      try
      {
          Connection con=totalcode.connection();
      PreparedStatement ps=con.prepareStatement("update sample00 set fname=? ,femail=? where fid=?");
      ps.setString(3,g.did());
      ps.setString(2,g.demail());
      ps.setString(1,g.dname());
      int i=ps.executeUpdate();
      if(i>0)
      {
        status=1;
      }
      
      }
      catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
      return status;
  }
  static int delete(String g)
  {
      int status=0;
      try
      {
          Connection con=totalcode.connection();
      PreparedStatement ps=con.prepareStatement("delete from sample00 where fid=?");
      ps.setString(1,g);
      int i=ps.executeUpdate();
      if(i>0)
      {
        status=1;
      }
      
      }
      catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
      return status;
  }
  public static int  send(String to,String msg){  
          String from="your email"; 
          String password="your password";
          String sub="email subject";
          
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);     
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
            return 1; 
    }  
  static int email(String em)
  {
      int status=1;
     try
      {
        
      Connection con=totalcode.connection();
      PreparedStatement ps=con.prepareStatement("select * from  sample00 where femail=?");
      ps.setString(1,em);
      ResultSet rs=ps.executeQuery();
      if(rs.next())
      {
         status= 0;
      } 
      }
      catch(Exception e){
          System.out.println(e.getMessage());
              }
      return status;
  }
  
}
