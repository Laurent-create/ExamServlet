package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interface.BaseModel;
import Interface.InterfaceDAO;
import models.Prevision;
import utils.DBConnection;

public class PrevisionDAO implements InterfaceDAO {
    // Create (Save a new Prevision)
    public static void save(BaseModel model) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            save(model, conn);
        }
    }

    public static void save(BaseModel model, Connection conn) throws SQLException {
        Prevision prevision = (Prevision) model;
        String sql = "INSERT INTO Prevision (libelle, Montant) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prevision.getLibelle());
            stmt.setBigDecimal(2, prevision.getMontant());
            stmt.executeUpdate();
        }
    }

    // Read (Get all Prevision)
    public static List<BaseModel> getAll() throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            return getAll(conn);
        }
    }

    public static List<BaseModel> getAll(Connection conn) throws SQLException {
        List<BaseModel> previsions = new ArrayList<>();
        String sql = "SELECT * FROM Prevision";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Prevision prevision = new Prevision();
                prevision.setId(rs.getInt("id_prevision"));
                prevision.setLibelle(rs.getString("libelle"));
                prevision.setMontant(rs.getBigDecimal("Montant"));

                previsions.add(prevision);
            }
        }

        return previsions;
    }

    // Read (Get a single Prevision by ID)
    public static BaseModel getById(int id) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            return getById(id, conn);
        }
    }

    public static BaseModel getById(int id, Connection conn) throws SQLException {
        String sql = "SELECT * FROM Prevision WHERE id_prevision = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Prevision prevision = new Prevision();
                    prevision.setId(rs.getInt("id_prevision"));
                    prevision.setLibelle(rs.getString("libelle"));
                    prevision.setMontant(rs.getBigDecimal("Montant"));

                    return prevision;
                }
            }
        }
        return null;
    }

    // Delete (Remove a Prevision by ID)
    public static void delete(BaseModel model) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            delete(model, conn);
        }
    }

    public static void delete(BaseModel model, Connection conn) throws SQLException {
        Prevision prevision = (Prevision) model;
        String sql = "DELETE FROM Prevision WHERE id_prevision = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, prevision.getId());
            stmt.executeUpdate();
        }
    }

    // Update (Modify an existing Employee)
    public static void update(BaseModel model) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            update(model, conn);
        }
    }

    public static void update(BaseModel model, Connection conn) throws SQLException {
        Prevision prevision = (Prevision) model;
        String sql = "UPDATE Prevision SET libelle = ?, Montant = ? WHERE id_prevision = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prevision.getLibelle());
            stmt.setObject(2, prevision.getMontant());
            stmt.setInt(3, prevision.getId());
            stmt.executeUpdate();
        }
    }
}
