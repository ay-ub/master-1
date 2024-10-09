/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scolarite;

/**
 *
 * @author Ay-ob
 */
public class Etudient extends Person {

    private String ine;

    public Etudient(String ine, String nom, String prenom, int age) {
        super(nom, prenom, age);
        this.ine = ine;
    }

    public Etudient(String ine) {
        this.ine = ine;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    @Override
    public void display() {
        System.out.print("ine = " + this.ine + " , ");
        super.display();

    }

}
