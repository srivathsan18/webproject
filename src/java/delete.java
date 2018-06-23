/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author srivathsan
 */
public class delete extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        getinput g=new getinput();
            try {
                PrintWriter out = response.getWriter();
          
           String id=request.getParameter("fid");
             
                  
         int i= totalcode.delete(id);
          if(i>0)
          {
              
             response.sendRedirect("view");
          }
            }
          catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
        }
    }
