/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author srivathsan
 */
public class editservletpre extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {PrintWriter out = response.getWriter(); 
           String id=request.getParameter("fid");
             getinput g=new getinput();
          String sid=request.getParameter("fid");
          
         g= totalcode.set(id);
    out.println("<head>  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
 out.println( "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
 out.println( "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
  out.println("<style> h4{color:blueviolet;}"+
   "  body { background-color: #474e5d; /* Dark Blue */color: #ffffff;}"+
 " </style>"
            + "</head>");

         
         out.println("<form action='editservlet' method='post'>");
         out.println("<table>");
        out.print("<tr><td>id:</td><td><h5 style=\"color:goldenrod\"><input type='number' name='fid' value='"+g.did()+"'readonly>Unchanged</h5></td></tr><br>");
         out.print("<tr><td>name:</td><td><h5 style=\"color:goldenrod\"><input type='text' name='fname' value='"+g.dname()+"'></h5></td></tr><br>");
         out.print("<tr><td>email:</td><td><h5 style=\"color:goldenrod\"><input type='email' name='femail' value='"+g.demail()+"'></h5></td></tr><br>");
         out.println("</table>");
         out.print("<input type='submit' class='btn btn-warning' value='update'>");
         out.print(" </form>");
                  

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
}