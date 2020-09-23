
package com.philou.cda.pattern2;

/**
 *
 * @author philou
 */
public class TestObserver {
    
    public static void perform(){
        
        Voiture bmw = new Voiture("BMW");
        Voiture rolls = new Voiture("Rolls Royce");
        Pieton bob = new Pieton("Bob");
        Pieton monika = new Pieton("Monika");
        
        Signal feu1 = new Signal("FEU 1");
        Signal feu2 = new Signal("FEU 2");
        Pluie averse1 = new Pluie("Averse 1");
        Pluie ouragan = new Pluie("Ouragan !");
        
        
        // La bmw réagit au feu 2
        feu2.addObserver(bmw);
        feu1.addObserver(rolls);
        feu2.setVert(true);
        feu2.setVert(false);
        feu1.setVert(true);
        
        // Bob et Monika se prend l'ouragan
        System.out.println(" ************************************");
        System.out.println(" ************************************");
        ouragan.addObserver(bob);
        ouragan.addObserver(monika);
        ouragan.addObserver(rolls);
        ouragan.setRaining(true);
        System.out.println(" ************************************");
        ouragan.setRaining(false);
        //ouragan.setRaining(false);
        System.out.println(" ************************************");
        ouragan.removeObserver(monika);
        ouragan.setRaining(true);
        //System.out.println("************************************");
        //ouragan.setRaining(true);
        //averse1.setRaining(true);
        
        
    }
    
    
}
