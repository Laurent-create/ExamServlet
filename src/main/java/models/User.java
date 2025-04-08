package models;

import Interface.BaseModel;

public class User implements BaseModel {
    private int id;
    private String nom;
    private String mdp;

    // Constructeurs
    public User() {}

    public User(String nom, String mdp) {
        this.nom = nom;
        this.mdp = mdp;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
