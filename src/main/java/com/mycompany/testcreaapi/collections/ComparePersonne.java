package com.mycompany.testcreaapi.collections;

import java.util.Comparator;

/**
 *
 * @author philou
 */
public class ComparePersonne implements Comparator<Personne>{

    @Override
    public int compare(Personne p1, Personne p2) {
        
        if(p1.getpointsFidelite() > p2.getpointsFidelite()){
        return 1;
        } 
        else {
        return -1;
        }
        
        
    }
    
}
