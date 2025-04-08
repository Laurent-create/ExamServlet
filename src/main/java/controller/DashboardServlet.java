package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PrevisionDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Prevision;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("Dashboard.jsp");
        String query = "SELECT id_depense, id_prevision,SUM(Montant) AS montant FROM Depense GROUP BY id_prevision";
        List<List<Object>> lists = new ArrayList<>();

        try (Connection conn = utils.DBConnection.getConn();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id_prev = rs.getInt("id_prevision");
                    BigDecimal montant = rs.getBigDecimal("montant");
                    Prevision credit = (Prevision) PrevisionDAO.getById(id_prev, conn);
                    List<Object> row = new ArrayList<>();
                    row.add(credit);
                    row.add(montant);
                    System.out.println(montant);
                    lists.add(row);
                }
                req.setAttribute("list", lists);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rd.forward(req, res);
        
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    }   
}
