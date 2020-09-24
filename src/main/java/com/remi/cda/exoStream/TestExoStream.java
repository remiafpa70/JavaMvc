/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remi.cda.exoStream;

import com.philou.cda.swing.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author 77011-53-12
 */
public class TestExoStream {
    
    public static void perform(){
        
        //Meilleurs comportement de m'aapli swi,g notamment quand on le redimenssionne, ...
        SwingUtilities.invokeLater(()->{
        try{
            
            Model model = new Model();
            View vue = new View();
            Controller controller = new Controller(vue, model);
            
            controller.buildControls();
            
        }
        catch (Exception e){
        }
        });
    }
    
}
