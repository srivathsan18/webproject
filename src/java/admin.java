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
import javax.servlet.RequestDispatcher;
/**
 *
 * @author srivathsan
 */
public class admin extends HttpServlet {

   
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
                PrintWriter out = response.getWriter(); 
            
            
       
            String name=request.getParameter("admin");
            String pass=request.getParameter("pass");
            if(name.equals("admin")&&pass.equals("admin")){
                response.sendRedirect("view");
                
            }
            else
            {
                out.println("password incorrect");
              RequestDispatcher rd=request.getRequestDispatcher("index.html"); 
              rd.include(request, response);
            }
        }
        catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
    }

}