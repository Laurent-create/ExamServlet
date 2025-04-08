package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import Interface.BaseModel;
import dao.PrevisionDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormDepenseServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Vérification si userId est présent dans la session pour les actions de modification ou suppression
            if (req.getSession().getAttribute("userId") == null) {
                resp.sendRedirect("index.jsp");
                return;
            }
            List<BaseModel> previsions = PrevisionDAO.getAll();
            req.setAttribute("previsions", previsions);
            req.getRequestDispatcher("FormDep.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Erreur : " + e.getMessage());
        }
    }
}
