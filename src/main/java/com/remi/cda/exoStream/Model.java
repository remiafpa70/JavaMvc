/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remi.cda.exoStream;

import com.philou.cda.swing.*;
import com.philou.cda.pattern2.IObservable;
import com.philou.cda.pattern2.IObserver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 77011-53-12
 */
public class Model implements IObservable {
    
    private int number;
    private List<IObserver> listeObservateurs;
    
    
    public Model(){
        listeObservateurs = new  ArrayList();
    }
    
       public void plusOne(){
        ++number;
    }
    
    public void plusTen(){
        number += 10;
    }
    
        public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void addObserver(IObserver obs) {
       listeObservateurs.add(obs); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeObserver(IObserver obs) {
        listeObservateurs.remove(obs); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifier() {
        listeObservateurs.stream().forEach( (o) -> { //To change body of generated methods, choose Tools | Templates.
                o.refresh(this);
        });
    
    }
}
