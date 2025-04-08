package Interface;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO {

    // Méthode pour enregistrer une entité (Create)
    static void save(BaseModel entity) throws SQLException {
        throw new UnsupportedOperationException("Not implemented");
    }

    // Méthode pour récupérer toutes les entités (Read All)
    static List<BaseModel> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not implemented");
    }

    // Méthode pour récupérer une entité par son ID (Read by ID)
    static BaseModel getById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not implemented");
    }

    // Méthode pour mettre à jour une entité (Update)
    static void update(BaseModel entity) throws SQLException {
        throw new UnsupportedOperationException("Not implemented");
    }

    // Méthode pour supprimer une entité (Delete)
    static void delete(BaseModel entity) throws SQLException {
        throw new UnsupportedOperationException("Not implemented");
    }

    // Méthode pour récupérer toutes les entités avec pagination (Read All with Pagination)
    static List<BaseModel> getAllWithPagination(int id, int count) throws SQLException {
        throw new UnsupportedOperationException("Not implemented");
    }
}
