/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.text.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class save extends HttpServlet {

    
   public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         Date dNow = new Date( );
      SimpleDateFormat ft =   new SimpleDateFormat ("yyMMddHHmmss");
     String id1=ft.format(dNow);
        int status=0,mail=0;
        String name,msg="we are happy to say that you have registered successfully to our institute";
        
        name=request.getParameter("name");
        String email=request.getParameter("email");
       int estatus= totalcode.email(email);
       getinput g=new getinput();
        g.gid(id1);
        g.gname(name);
        g.gemail(email);
       if(estatus>0)
       {
        
    
        status=totalcode.saves(g);
      mail=totalcode.send(email,msg);
       }
 else
       {
            out.println("Email already exists");
         RequestDispatcher rd=request.getRequestDispatcher("index.html");
         rd.include(request, response);
       }
        if(mail>0)
        {
         out.println("mail has been sent<br>");
       
        }
       
     if(status>0)
     {
         out.println("Successfully Added");
         RequestDispatcher rd=request.getRequestDispatcher("index.html");
         rd.include(request, response);
         
     }  
    }

}
