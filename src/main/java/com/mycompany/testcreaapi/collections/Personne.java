package com.mycompany.testcreaapi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author philou
 */
public class Personne {
    
    private String nom;
    private int pointsFidelite; 
    private Personne conjoint;
    private List<Personne> listeAmis;

    public Personne(String nom) {
        this.nom = nom;
        conjoint = null;
        listeAmis = new ArrayList(); // LinkedList       
    }
    public Personne(String nom, int pointsFidelite) {
        this.nom = nom;
        this.pointsFidelite = pointsFidelite;
        conjoint = null;
        listeAmis = new ArrayList(); // LinkedList       
    }
    
    public void marriage(Personne p){
        
        // On vérifie le célibat
        if(this.getConjoint() == null && p.getConjoint() == null){
            this.setConjoint(p);
            p.setConjoint(this);
        }
        
    }
    
    public void divorce(Personne p){
        
        // Déjà marrié ? Avec la bonne personne ?
        if(this.getConjoint() != null && this.getConjoint() == p){
            this.setConjoint(null);
            p.setConjoint(null);
        }
        
    }
    
    public void gagneAmi(Personne nouvelAmi){
        
        // N'est pas déjà son ami ?
        if(!getListeAmis().contains(nouvelAmi)){ 
            
            getListeAmis().add(nouvelAmi);
            nouvelAmi.getListeAmis().add(this);
            
            // TENDANCIEUX ! (pas bien !)
            //nouvelAmi.gagneAmi(this);
        }
    }
    
    public void perdAmi(Personne ancienAmi){
        
        // Ils sont déjà amis ?
        
        // PRESOMPTUEUX ! (pas bien)
        // if(getListeAmis().contains(ancienAmi) ){
        
        if(getListeAmis().contains(ancienAmi) && ancienAmi.getListeAmis().contains(this)){ 
            getListeAmis().remove(ancienAmi);
            ancienAmi.getListeAmis().remove(this);
        }
        
        
    }

    
    /**
     * @return the nom
     */
    public String getnom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setnom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the conjoint
     */
    public Personne getConjoint() {
        return conjoint;
    }

    /**
     * @param conjoint the conjoint to set
     */
    public void setConjoint(Personne conjoint) {
        this.conjoint = conjoint;
    }

    /**
     * @return the listeAmis
     */
    public List<Personne> getListeAmis() {
        return listeAmis;
    }

    /**
     * @param listeAmis the listeAmis to set
     */
    public void setListeAmis(List<Personne> listeAmis) {
        this.listeAmis = listeAmis;
    }
    
    @Override
    public String  toString(){
        
        //System.out.println("Amis de " + this.getnom() + );
        
        String retour = "Prénom = " + this.getnom();
        retour += " Conjoint = ";
        
        retour += (this.getConjoint() != null)?this.getConjoint().getnom():"Célibataire";
        
        
        retour += " pointsFidelite = " + getpointsFidelite();
        
        
        
        retour += " Amis (" + this.listeAmis.size() + ") = ";
        
        Iterator<Personne> it = this.getListeAmis().iterator();
        
        while(it.hasNext())
            retour += it.next().getnom() + ", ";
        
        return retour;
        
    }

    /**
     * @return the pointsFidelite
     */
    public int getpointsFidelite() {
        return pointsFidelite;
    }

    /**
     * @param pointsFidelite the pointsFidelite to set
     */
    public void setpointsFidelite(int pointsFidelite) {
        this.pointsFidelite = pointsFidelite;
    }
       
    
}
