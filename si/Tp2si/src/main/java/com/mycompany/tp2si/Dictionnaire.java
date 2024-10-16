/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp2si;

/**
 *
 * @author Ay-ob
 */
public class Dictionnaire extends Document {

    private String langue;
    private int nbrTonne;

    public Dictionnaire(String langue, int nbrTonne, String numero, String titre) {
        super(numero, titre);
        this.langue = langue;
        this.nbrTonne = nbrTonne;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getNbrTonne() {
        return nbrTonne;
    }

    public void setNbrTonne(int nbrTonne) {
        this.nbrTonne = nbrTonne;
    }

    @Override
    public String toString() {
        return super.toString() +   "langue=" + langue + ", nbrTonne=" + nbrTonne;
    }
   
}
