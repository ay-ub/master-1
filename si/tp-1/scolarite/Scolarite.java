/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.scolarite;

/**
 *
 * @author Ay-ob
 */
public class Scolarite {

    public static void main(String[] args) {
        Person aziz = new Person("AZIZ", "kouider", 25);
        
        Etudient ayyoub = new Etudient("iL" ,"Ayyoub", "hadj-youcef", 24);
        Etudient mohamed = new Etudient("iL" ,"mohamed", "hadj-mohamed", 23);
                Etudient widad = new Etudient("isia" ,"widad", "meliani", 23);

        Prof prof = new Prof("Hadj Henni", "mohamed", 45);
        prof.addEtudient(ayyoub);
        prof.addEtudient(mohamed);
        prof.addEtudient(widad);

        prof.displayEtudient();
        
    }
}
