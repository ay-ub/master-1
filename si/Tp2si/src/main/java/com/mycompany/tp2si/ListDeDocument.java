/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp2si;

import java.util.ArrayList;

/**
 *
 * @author Ay-ob
 */
public class ListDeDocument {
   public ArrayList<Document> listDocs;

    public ListDeDocument(ArrayList<Document> listDocs) {
        this.listDocs = listDocs;
    }
   
   public ListDeDocument() {
      listDocs  = new ArrayList<>();
    }
   public void ajouterDoc(Document doc){
       listDocs.add(doc);
   }
   
   public void tousLesAuteurs(){
       for (Document docs : listDocs) {
           System.err.println(docs.numero);
           if(docs instanceof Livre){
               System.err.println(((Livre) docs).getAuteur());
           }
       }
   }
}
