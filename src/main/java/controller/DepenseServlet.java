package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Interface.BaseModel;
import dao.DepenseDAO;
import dao.PrevisionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Depense;
import models.Prevision;
import services.DepenseService;

public class DepenseServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id_prevision = req.getParameter("id_prevision");
            String Montant = req.getParameter("Montant");
            String date_depense = req.getParameter("date_depense");

            // Vérification des champs obligatoires
            if (id_prevision == null || id_prevision.trim().isEmpty()) {
                List<BaseModel> previsions = PrevisionDAO.getAll();
                req.setAttribute("previsions", previsions);
                req.getRequestDispatcher("FormDep.jsp?error=missing_prevision").forward(req, resp);
                return;
            }

            BigDecimal price;
            try {
                price = new BigDecimal(Montant);
                if (price.compareTo(BigDecimal.ZERO) <= 0) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                List<BaseModel> previsions = PrevisionDAO.getAll();
                req.setAttribute("previsions", previsions);
                req.getRequestDispatcher("FormDep.jsp?error=invalid_price").forward(req, resp);
                return;
            }

            int id_prev = Integer.parseInt(id_prevision);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDep = format.parse(date_depense); // Date actuelle
            Prevision prev = (Prevision) PrevisionDAO.getById(id_prev);

            if (!DepenseService.CheckMontant(id_prev, price)) {
                List<BaseModel> previsions = PrevisionDAO.getAll();
                req.setAttribute("previsions", previsions);
                req.getRequestDispatcher("FormDep.jsp?error=invalid_montant").forward(req, resp);
                return;
            }

            Depense depense = new Depense();
            depense.setMontant(price);
            depense.setDate_depense(dateDep);
            depense.setPrevision(prev);

            DepenseDAO.save(depense);
            resp.sendRedirect("FormDep");
        } catch (SQLException e) {
            throw new ServletException("Erreur SQL : " + e.getMessage());
        } catch (ParseException e) {
            throw new ServletException("Erreur SQL : " + e.getMessage());
        }
    }
}
