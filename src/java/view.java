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
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class view extends HttpServlet {

   
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<style> table, th, td {border: 1px solid black}  h4{\n" +
"          color:blueviolet;\n" +
"      }\n" +
"     body{\n" +
"       background-color: #474e5d; /* Dark Blue */\n" +
"      color: #ffffff;\n" +
"\n" +
"     }"
                + " h4{\n" +
"          color:orange;\n" +
"      }"
                + " h3{\n" +
"          color:white;\n" +
"      }");
        
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<br><a href=index.html><h4>logout</h4></a>");
        try{
            
       Connection  con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample007","sri","sri");

       PreparedStatement ps=con.prepareStatement("select * from sample00");
        ResultSet rs=ps.executeQuery();
        
        out.println("<table style='width:100%' > <th><h4>id</h4></th> <th><h4> name</h4> </th><th><h4>email</h4></th><th><h4>edit</h4></th><th><h4>delete</h4></th>");
        while(rs.next())
        {
            out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td> <a href='editservletpre?fid="+rs.getString(1)+"'><h4 style='color:white'>edit</h3></a></td><td><a href='delete?fid="+rs.getString(1)+"'><h4 style='color:white'>delete</h4></a></td> </tr>");
        }
        con.close();
       out.print("</table><br>");
       
       
        }
        
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        out.println("</body>");
        out.println("</html>");
         
       
    }
}