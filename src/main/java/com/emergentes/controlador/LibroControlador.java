/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.DAO.libroDAO;
import com.emergentes.DAO.libroDAOimple;
import com.emergentes.modelo.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nogal
 */
@WebServlet(name = "LibroControlador", urlPatterns = {"/LibroControlador"})
public class LibroControlador extends HttpServlet {

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            libroDAO dao = new libroDAOimple();
            String action=(request.getParameter("action")!=null )? request.getParameter("action"): "view";
            
            switch(action){
                case "add":
                    break;
                case "edit":
                    break;
                    case"delete":
                        break;
                    case "view": 
                        List<Libro> lista=dao.getAll();
                        request.setAttribute("libros",lista);
                        request.getRequestDispatcher("libros.jsp").forward(request, response);
                        break;
            }
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
   
}
