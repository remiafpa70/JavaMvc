package com.philou.cda.pattern2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author philou
 */
public class Pluie implements IObservable{
    
    private String name;
    private boolean raining;
    private List<IObserver> listeObservers;

    public Pluie(String name) {
        
        raining = false;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the raining
     */
    public boolean isRaining() {
        return raining;
    }

    /**
     * @param raining the raining to set
     */
    public void setRaining(boolean raining) {
        this.raining = raining;
        notifier();
    }
    
}
