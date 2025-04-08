package models;

import java.math.BigDecimal;
import Interface.BaseModel;

public class Prevision implements BaseModel {
    private int id;
    private String libelle;
    private BigDecimal Montant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public BigDecimal getMontant() {
        return Montant;
    }
    
    public void setMontant(BigDecimal montant) {
        Montant = montant;
    }
}
