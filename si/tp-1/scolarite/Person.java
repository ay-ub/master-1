/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scolarite;

/**
 *
 * @author Ay-ob
 */
public class Person {

    protected String nom, prenom;
    protected int age;

    public Person(String Nom, String prenom, int age) {
        this.nom = Nom;
        this.prenom = prenom;
        this.age = age;
    }

    public Person() {
        System.out.println("insert init data.");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String Nom) {
        this.nom = Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("nom = " + nom + " ,prenom = " + prenom + " , age = " + age + "ans.");
    }

}
