package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormPrevisionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Vérification si userId est présent dans la session pour les actions de modification ou suppression
            if (req.getSession().getAttribute("userId") == null) {
                resp.sendRedirect("idenx.jsp");
                return;
            }
            req.getRequestDispatcher("FormPrev.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Erreur : " + e.getMessage());
        }
    }
}
