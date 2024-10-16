/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tp2si;

/**
 *
 * @author Ay-ob
 */
public class Bibiotheque {

    public static void main(String[] args) {
        Livre livre1 = new Livre("ayoub", 100, "Livre 1", "livre 1 titre");
        Livre livre2 = new Livre("AZIZ", 100, "Livre 2", "livre 2 titre");
        Livre livre3 = new Livre("YOUCEF", 100, "Livre 3", "livre 3 titre");
        Livre livre4 = new Livre("MOHAMED", 100, "Livre 4", "livre 4 titre");

        Dictionnaire dict1 = new Dictionnaire("ar", 200, "dic 1", "dic 1 titre");
        Dictionnaire dict2 = new Dictionnaire("ar", 100, "dic 2", "dic 1 titre");
        Dictionnaire dict3 = new Dictionnaire("EN", 130, "dic 3", "dic 3 titre");
        Dictionnaire dict4 = new Dictionnaire("FR", 300, "dic 3", "dic 4 titre");
        Dictionnaire dict5 = new Dictionnaire("ar", 230, "dic 3", "dic 5 titre");

        ListDeDocument listDocs = new ListDeDocument();
        
        listDocs.ajouterDoc(livre1);
        listDocs.ajouterDoc(dict1);
        listDocs.ajouterDoc(livre2);
        listDocs.ajouterDoc(livre3);
        listDocs.ajouterDoc(dict2);
        listDocs.ajouterDoc(dict3);
        listDocs.ajouterDoc(livre4);
        listDocs.ajouterDoc(dict4);
        listDocs.ajouterDoc(dict5);
        listDocs.tousLesAuteurs();
    }
}
