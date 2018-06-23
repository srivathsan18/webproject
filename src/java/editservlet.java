/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class editservlet extends HttpServlet {

  
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        try {
            getinput g=new getinput();
          String id=request.getParameter("fid");
          
          String name=request.getParameter("fname");
          String email=request.getParameter("femail");
          g.gid(id);
          g.gname(name);
          g.gemail(email);
          int i=totalcode.update(g);
          if(i>0)
          {
              out.println("updated successfully");
               response.sendRedirect("view");
          }
          else{
              out.println("sry not updated");
                response.sendRedirect("view");
          }
        }
        catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
    }
}