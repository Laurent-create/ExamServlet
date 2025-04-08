package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import dao.PrevisionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Prevision;

public class PrevisionServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String libelle = req.getParameter("libelle");
            String montant = req.getParameter("montant");

            if (libelle == null || libelle.trim().isEmpty()) {
                req.getRequestDispatcher("FormPrev.jsp?error=missing_name").forward(req, resp);
                return;
            }

            BigDecimal price;
            try {
                price = new BigDecimal(montant);
                if (price.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                req.getRequestDispatcher("FormPrev.jsp?error=invalid_price").forward(req, resp);
                return;
            }

            Prevision prevision = new Prevision();
            prevision.setLibelle(libelle);
            prevision.setMontant(price);

            PrevisionDAO.save(prevision);

            resp.sendRedirect("FormPrev");
        } catch (SQLException e) {
            throw new ServletException("Erreur SQL : " + e.getMessage());
        }
    }
}
