package dao;

import models.User;
import utils.DBConnection;
import Interface.BaseModel;
import Interface.InterfaceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements InterfaceDAO {

    // Create (Save a new User)
    public static void save(BaseModel model) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            save(model, conn);
        }
    }

    public static void save(BaseModel model, Connection conn) throws SQLException {
        User user = (User) model;
        String sql = "INSERT INTO users (nom, mdp) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getMdp()); // Assurez-vous de hasher le mot de passe avant de l'enregistrer
            stmt.executeUpdate();
        }
    }

    // Read (Get all Users)
    public static List<BaseModel> getAll() throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            return getAll(conn);
        }
    }

    public static List<BaseModel> getAll(Connection conn) throws SQLException {
        List<BaseModel> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setMdp(rs.getString("mdp")); // Le mot de passe récupéré est déjà stocké de manière sécurisée
                users.add(user);
            }
        }
        return users;
    }

    // Read (Get a single User by ID)
    public static BaseModel getById(int id) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            return getById(id, conn);
        }
    }

    public static BaseModel getById(int id, Connection conn) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setNom(rs.getString("nom"));
                    user.setMdp(rs.getString("mdp")); // Le mot de passe récupéré est déjà stocké de manière sécurisée
                    return user;
                }
            }
        }
        return null;
    }

    // Update (Modify an existing User)
    public static void update(BaseModel model) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            update(model, conn);
        }
    }

    public static void update(BaseModel model, Connection conn) throws SQLException {
        User user = (User) model;
        String sql = "UPDATE users SET nom = ?, mdp = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getMdp()); // Assurez-vous que le mot de passe est bien hashé avant de l'enregistrer
            stmt.setInt(3, user.getId());
            stmt.executeUpdate();
        }
    }

    // Delete (Remove a User by ID)
    public static void delete(BaseModel model) throws SQLException {
        try (Connection conn = DBConnection.getConn()) {
            delete(model, conn);
        }
    }

    public static void delete(BaseModel model, Connection conn) throws SQLException {
        User user = (User) model;
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();
        }
    }

    // Récupérer un utilisateur par son nom et son mot de passe
    public static User getByUsernameAndPassword(String nom, String mdp) throws SQLException {
        String sql = "SELECT * FROM users WHERE nom = ? AND mdp = ?";
        
        try (Connection conn = DBConnection.getConn();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setString(2, mdp);  // Assurez-vous que le mot de passe est bien haché avant cette vérification
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setNom(rs.getString("nom"));
                    user.setMdp(rs.getString("mdp"));
                    return user;
                }
            }
        }
        return null; // Si aucun utilisateur n'est trouvé
    }
}
