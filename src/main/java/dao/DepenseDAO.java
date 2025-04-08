package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Interface.BaseModel;
import models.Depense;
import models.Prevision;
import utils.DBConnection;

public class DepenseDAO {
    // Create (Save a new Depense)
    public static void save(BaseModel model) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            save(model, conn);
        }
    }

    public static void save(BaseModel model, Connection conn) throws SQLException {
        Depense depense = (Depense) model;
        String sql = "INSERT INTO Depense (id_prevision, Montant, date_depense) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, depense.getPrevision().getId());
            stmt.setBigDecimal(2, depense.getMontant());
            stmt.setTimestamp(3, new Timestamp(depense.getDate_depense().getTime()));
            stmt.executeUpdate();
        }
    }

    // Read (Get all Depense)
    public static List<BaseModel> getAll() throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            return getAll(conn);
        }
    }

    public static List<BaseModel> getAll(Connection conn) throws SQLException {
        List<BaseModel> depenses = new ArrayList<>();
        String sql = "SELECT * FROM Depense";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Depense depense = new Depense();
                depense.setId(rs.getInt("id_depense"));
                depense.setMontant(rs.getBigDecimal("Montant"));
                depense.setDate_depense(rs.getTimestamp("date_depense"));

                // Récupérer le compte associé
                int id_prevision = rs.getInt("id_prevision");
                Prevision prevision = (Prevision) PrevisionDAO.getById(id_prevision, conn);
                depense.setPrevision(prevision);

                depenses.add(depense);
            }
        }
        return depenses;
    }

    // Read (Get a single Depense by ID)
    public static BaseModel getById(int id) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            return getById(id, conn);
        }
    }

    public static BaseModel getById(int id, Connection conn) throws SQLException {
        String sql = "SELECT * FROM Depense WHERE id_depense = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Depense depense = new Depense();
                    depense.setId(rs.getInt("id_depense"));
                    depense.setMontant(rs.getBigDecimal("Montant"));
                    depense.setDate_depense(rs.getTimestamp("date_depense"));

                    // Récupérer le compte associé
                    int id_prevision = rs.getInt("id_prevision");
                    Prevision prevision = (Prevision) PrevisionDAO.getById(id_prevision, conn);
                    depense.setPrevision(prevision);

                    return depense;
                }
            }
        }
        return null;
    }

    // Delete (Remove a Depense by ID)
    public static void delete(BaseModel model) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            delete(model, conn);
        }
    }

    public static void delete(BaseModel model, Connection conn) throws SQLException {
        Depense depense = (Depense) model;
        String sql = "DELETE FROM Depense WHERE id_depense = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, depense.getId());
            stmt.executeUpdate();
        }
    }
}
