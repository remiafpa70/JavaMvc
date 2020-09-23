/*
http://www.itformations.com/campus

user: afpa
pass: afpa

*/


package com.philou.cda.pattern2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author philou
 */
public class Signal implements IObservable{
    
    private String name;
    private boolean vert;
    private List<IObserver> listeObservers;

    public Signal(String name) {
        
        vert = false;
        this.name = name;
        listeObservers = new ArrayList();
        
    }

    @Override
    public void addObserver(IObserver obs) {
        listeObservers.add(obs);
    }

    @Override
    public void removeObserver(IObserver obs) {
        
         listeObservers.remove(obs);
        
    }
    
    public void notifier(){
        // On parcours la liste d'observateurs afin qu'ils se mettent à jour
        listeObservers.forEach(  (o)-> {   o.refresh(this);   }      );
    }
    
    
    
    
    
    ////////////////////////////////////////////////////
    /**
     * @return the vert
     */
    public boolean isVert() {
        return vert;
    }

    /**
     * @param vert the vert to set
     */
    public void setVert(boolean vert) {
        this.vert = vert;
        notifier();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    
    
    
    
}
