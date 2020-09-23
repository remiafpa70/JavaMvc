/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signal.philou.cda.pattern3.personnage;

import java.util.List;

/**
 *
 * @author 77011-53-12
 */
public class Personne {

    /**
     * @return the celibataire
     */
    public boolean isCelibataire() {
        return celibataire;
    }

    /**
     * @param celibataire the celibataire to set
     */
    public void setCelibataire(boolean celibataire) {
        this.celibataire = celibataire;
    }

    /**
     * @return the divorce
     */
    public boolean isDivorce() {
        return divorce;
    }

    /**
     * @param divorce the divorce to set
     */
    public void setDivorce(boolean divorce) {
        this.divorce = divorce;
    }

    /**
     * @return the listePersonnes
     */
    public List<Personne> getListePersonnes() {
        return listePersonnes;
    }

    /**
     * @param listePersonnes the listePersonnes to set
     */
    public void setListePersonnes(List<Personne> listePersonnes) {
        this.listePersonnes = listePersonnes;
    }
    private boolean celibataire;
    private boolean divorce;
        private List<Personne> listePersonnes;


    
}
