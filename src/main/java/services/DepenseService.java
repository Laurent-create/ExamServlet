package services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import dao.PrevisionDAO;
import models.Prevision;

public class DepenseService {
    public static Boolean CheckMontant(int id_prevision, BigDecimal Montant) throws SQLException {

        try (Connection conn = utils.DBConnection.getConn()) {
            Prevision prev = (Prevision) PrevisionDAO.getById(id_prevision);
            BigDecimal MontantPrev = prev.getMontant();
            int resultat = MontantPrev.compareTo(Montant);
            
            if (resultat == 1 || resultat==0 ) {
                prev.setMontant(MontantPrev.add(Montant.negate()));
                PrevisionDAO.update(prev, conn);
                return true;
            }

            return false;
        }
    }
}
