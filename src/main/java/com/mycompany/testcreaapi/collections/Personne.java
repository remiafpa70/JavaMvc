package com.mycompany.testcreaapi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ziza
 */
public class Personne {
    
    private String prenom;
    private int solde; 
    private Personne conjoint;
    private List<Personne> listeAmis;

    public Personne(String prenom) {
        this.prenom = prenom;
        conjoint = null;
        listeAmis = new ArrayList(); // LinkedList       
    }
    public Personne(String prenom, int solde) {
        this.prenom = prenom;
        this.solde = solde;
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
        
        //System.out.println("Amis de " + this.getPrenom() + );
        
        String retour = "Prénom = " + this.getPrenom();
        retour += " Conjoint = ";
        
        retour += (this.getConjoint() != null)?this.getConjoint().getPrenom():"Célibataire";
        
        
        retour += " Solde = " + getSolde();
        
        
        
        retour += " Amis (" + this.listeAmis.size() + ") = ";
        
        Iterator<Personne> it = this.getListeAmis().iterator();
        
        while(it.hasNext())
            retour += it.next().getPrenom() + ", ";
        
        return retour;
        
    }

    /**
     * @return the solde
     */
    public int getSolde() {
        return solde;
    }

    /**
     * @param solde the solde to set
     */
    public void setSolde(int solde) {
        this.solde = solde;
    }
       
    
}