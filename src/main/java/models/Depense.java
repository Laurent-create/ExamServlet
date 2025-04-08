package models;

import java.math.BigDecimal;
import java.util.Date;

import Interface.BaseModel;

public class Depense implements BaseModel{
    private int id;
    private Prevision prevision;
    private BigDecimal Montant;
    private Date date_depense;
    
    public Date getDate_depense() {
        return date_depense;
    }

    public void setDate_depense(Date date_depense) {
        this.date_depense = date_depense;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public BigDecimal getMontant() {
        return Montant;
    }

    public void setMontant(BigDecimal montant) {
        Montant = montant;
    }

    public Prevision getPrevision() {
        return prevision;
    }

    public void setPrevision(Prevision prevision) {
        this.prevision = prevision;
    }
}
