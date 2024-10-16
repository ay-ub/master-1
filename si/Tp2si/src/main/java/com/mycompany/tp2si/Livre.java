/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp2si;

/**
 *
 * @author Ay-ob
 */
public class Livre extends Document {

    private String auteur;
    private int nbrPage;

    public Livre(String auteur, int nbrPage, String numero, String titre) {
        super(numero, titre);
        this.auteur = auteur;
        this.nbrPage = nbrPage;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbrPage() {
        return nbrPage;
    }

    public void setNbrPage(int nbrPage) {
        this.nbrPage = nbrPage;
    }

    @Override
    public String toString() {
        return super.toString() + "auteur=" + auteur + ", nbrPage=" + nbrPage;
    }
}
