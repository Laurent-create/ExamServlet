package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

import dao.UserDAO;

public class LoginServlet extends HttpServlet {

    // Méthode doGet pour rediriger vers login.html
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Vérifier si la variable 'Pass' est présente dans l'URL
        String pass = req.getParameter("Pass");

        if (pass != null && !pass.isEmpty()) {
            // Si 'Pass' est présent et non vide, rediriger vers Accueil.jsp
            resp.sendRedirect("Accueil.jsp");
        } else {
            // Sinon, rediriger vers la page de connexion
            resp.sendRedirect("index.jsp");
        }
    }


    // Méthode doPost pour vérifier l'authentification de l'utilisateur
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer les données du formulaire de connexion
        String nom = req.getParameter("nom");
        String mdp = req.getParameter("mdp");

        try {
            // Vérifier les informations de connexion avec la base de données
            User user = UserDAO.getByUsernameAndPassword(nom, mdp);

            if (user != null) {
                // Si l'utilisateur existe et le mot de passe est correct
                // Créer une session pour cet utilisateur
                req.getSession().setAttribute("userId", user.getId());

                // Rediriger vers la page d'accueil
                resp.sendRedirect("Accueil.jsp");
            } else {
                resp.sendRedirect("Login");
            }
        } catch (Exception e) {
            resp.sendRedirect("Login");
        }
    }
}
