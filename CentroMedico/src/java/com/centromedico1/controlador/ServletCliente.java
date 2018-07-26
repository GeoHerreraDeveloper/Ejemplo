/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.centromedico1.controlador;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Date;
import java.text.SimpleDateFormat;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.centromedico1.dao.ClienteDAO;
import com.centromedico1.modelo.Cliente;
/**
 * @author Geo
 */
public class ServletCliente extends HttpServlet {
        
        
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
            
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             Cliente clienten = new Cliente ();
             ClienteDAO procesosDao = new ClienteDAO (); 
             String cui = request.getParameter("cui");
             String pnombre = request.getParameter("pnombre");
             String snombre = request.getParameter("snombre");
             String papellido = request.getParameter("papellido");
             String sapellido = request.getParameter("sapellido");
             String genero = request.getParameter("genero");
             String fechaNacimiento= request.getParameter("fecha");
             String direccion = request.getParameter("direccion");
             String telefono = request.getParameter("telefono");
             String email = request.getParameter("email");
             String codcliente= request.getParameter("codcliente");
             
           
              clienten.setCui(Integer.parseInt(cui));
              clienten.setpNombre(pnombre);
              clienten.setpApellido(papellido);
              clienten.setsNombre(snombre);
              clienten.setsApellido(sapellido);
              clienten.setGenero(genero);
              clienten.setFechaNacimiento(fechaNacimiento);
              clienten.setDireccion(direccion);
              clienten.setTelefono(Integer.parseInt(telefono));
              clienten.setEmail(email);
              clienten.setCod_cliente(Integer.parseInt(codcliente));
                
              String respuesta = procesosDao.registrarNuevoCliente(clienten);

          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(respuesta); 
            out.println("</body>");
            out.println("</html>");
        }    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
                processRequest(request, response);
           
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
                processRequest(request, response);
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
