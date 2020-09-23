package com.mycompany.testcreaapi.collections;

import java.util.Comparator;

/**
 *
 * @author philou
 */
public class ComparePersonne implements Comparator<Personne>{

    @Override
    public int compare(Personne p1, Personne p2) {
        
        if(p1.getSolde() > p2.getSolde()){
        return 1;
        } 
        else {
        return -1;
        }
        
        
    }
    
}