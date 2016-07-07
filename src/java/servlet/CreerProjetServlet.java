/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Projet;

/**
 *
 * @author Vladimir
 */
@WebServlet(name = "CreerProjetServlet", urlPatterns = {"/creerProjet"})
public class CreerProjetServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     String VUE_CrP = "WEB-INF/formProjet.jsp";
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(VUE_CrP).forward(request, response);
       
    }
    
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String nom = request.getParameter("nom");
            double prix = Double.parseDouble(request.getParameter("prix"));
            Projet projet = new Projet(null, id_promotion, id_createur, sujet, titre, date_creation, date_limite );
            projet.insert();
            request.setAttribute("message", "Produit ajouté sous le n" + projet.getId());
        } catch (SQLException ex) {
            Logger.getLogger(CreerProjetServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("erreur", ex.getMessage());
        }
        request.getRequestDispatcher("WEB-INF/fromProduit.jsp").forward(request, response);

    }

}
