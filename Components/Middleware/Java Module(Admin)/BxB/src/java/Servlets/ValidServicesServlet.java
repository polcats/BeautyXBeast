/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Servlets.DbManipulators.TableConnect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vash
 */
@WebServlet(name = "ValidServicesServlet", urlPatterns = {"/ValidServicesServlet"})
public class ValidServicesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
    }

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
        HttpSession session = request.getSession(false);
        try{
            String userName = session.getAttribute("UserName").toString();
        }catch(NullPointerException exc){
            String redirect = response.encodeRedirectURL("SessionExpired.jsp");
            response.sendRedirect(redirect);
            return;
        }
        try {
            processRequest(request, response);
            TableConnect connection = new TableConnect();
            String query = "SELECT  * FROM services";
            String categories = "SELECT DISTINCT category FROM services";
            ResultSet results = connection.queryFromDatabase(query);
            ResultSet category = connection.queryFromDatabase(categories);
            request.setAttribute("results",results);
            request.setAttribute("bean","services");
            
            ArrayList<String> cats = new ArrayList<> ();
            
            while(category.next()){
                cats.add(category.getString(1));
            }
            
            request.setAttribute("categories",cats);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("ConvertResultSetServlet");
            dispatcher.forward(request,response);
                    
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ValidServicesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
