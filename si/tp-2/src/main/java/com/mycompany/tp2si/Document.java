/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp2si;
/**
 *
 * @author Ay-ob
 */
public class Document {

    protected String numero;
    protected String titre;

    public Document(String numero, String titre) {
        this.numero = numero;
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", titre=" + titre;
    }

    

}
