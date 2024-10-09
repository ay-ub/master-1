/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scolarite;

import java.util.ArrayList;



/**
 *
 * @author Ay-ob
 */
public class Prof extends Person{
    private ArrayList<Etudient> etudientsList ;

    public Prof(String Nom, String prenom, int age) {
        super(Nom, prenom, age);
        etudientsList = new ArrayList<>();
    }
 
    
   public void addEtudient(Etudient etud){
        etudientsList.add(etud);
    }

    public ArrayList<Etudient> getEtudients() {
        return etudientsList;
    }

    public void setEtudients(ArrayList<Etudient> etudients) {
        this.etudientsList = etudients;
    }

   public void displayEtudient() {
       System.out.println("=============================== start Etudient List ===============================");
        for (Etudient etudiant : etudientsList) {
            etudiant.display();
        }
        System.out.println("=============================== end Etudient List =================================");
    }
}