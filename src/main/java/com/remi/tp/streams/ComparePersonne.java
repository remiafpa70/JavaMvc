package com.remi.tp.streams;

import com.mycompany.testcreaapi.collections.*;
import java.util.Comparator;

/**
 *
 * @author philou
 */
public class ComparePersonne implements Comparator<Clients>{

    @Override
    public int compare(Clients p1, Clients p2) {
        
        if(p1.getpointsFidelite() > p2.getpointsFidelite()){
        return 1;
        } 
        else {
        return -1;
        }
        
        
    }
    
}
