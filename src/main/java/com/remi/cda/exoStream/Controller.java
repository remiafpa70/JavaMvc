/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remi.cda.exoStream;

import com.philou.cda.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 77011-53-12
 */
public class Controller {
    
    private View vue;
    private Model model;

    public Controller(View vue, Model model) {
        
        // AGGREGATION  !
        this.vue = vue;
        this.model = model;
        
    }
    
    public void buildControls(){
        model.addObserver(vue);
        
        // Affectation de l'évènement sur le bouton
        vue.getBt1().addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent evt){
                
                //On incrémente le Model de 1
                model.plusOne();
                vue.getTextField().setText(String.valueOf(model.getNumber()));
            }
        });
    }
 }
