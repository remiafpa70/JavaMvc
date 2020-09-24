package com.remi.tp.streams;

import com.mycompany.testcreaapi.collections.*;
import com.mycompany.testcreaapi.collections.ITax;
import java.util.function.Function;

/**
 *
 * @author philou
 */
public class TestFunctional {
    
    public static void perform(){
        
        // PUISSANCE DU TRUC:
        // IMPLANTATION DE METHODES A LA VOLEE
        // UNE MEME METHODE PEUT AVOIR DES RESPONSABILITES DIFFERENTES D UNE LIGNE A L AUTRE
        // PARMI LES 'CHAMPIONS' du fonctionnel : javascript - python ... et qqpart ... java
        
    // Comme Itax est une interface fonctionnelle (méthode unique), 
    // 'taxeA20' DEVIENT UNE REFERENCE SUR SON IMPLANTATION !
    // COMME VALEUR POUR UN OBJET DE TYPE 'ITax' ON A L'IMPLANTATION DE SA METHODE (et non pas une valeur 'classique'
    ITax taxeA20;
    ITax taxeA10; 
    
    // Possibilité d'avoir la définition d'une méthode à droite d'une affectation !
    // L'implantation de la méthode applyTax() se retrouve référencée par 'taxeA20'
    // Ressemble à une fonction anonyme (mais c'est l'implantation de applyTax() !)
    taxeA20 = (price) -> price + (price * 0.2); // 20%
    taxeA10 = (price) -> price + (price * 0.1); // 10%
    
    
    // Ici, on utilise la méthode 'applyTax()' avec une implantation logée dans 'taxeA20' et/ou taxeA10
    System.out.println("20% sur un produit qui vaut 10 = " + taxeA20.applyTax(10)); // 12.0
    System.out.println("10% sur un produit qui vaut 10 = " + taxeA10.applyTax(10)); // 11.0
    System.out.println("20% sur un produit qui vaut 100 = " + taxeA20.applyTax(100)); // 120.0
    
    // CHANGEMENT D4IMPLANTATION A LA VOLEE (TRES FORT !)
    taxeA20 = (price) -> price + 20; // 20%
    
    System.out.println("20 sur un produit qui vaut 10 = " + taxeA20.applyTax(10)); // 30.0
    System.out.println("20 sur un produit qui vaut 100 = " + taxeA20.applyTax(100)); // 120.0
    
    ITax taxe1; 
    ITax taxe2;
    
    taxe1 = (price) -> price - 5; //
    taxe2 = (price) -> price - 10; //
    
    System.out.println( uneMethode(taxe1, 5.0) );
    System.out.println( uneMethode(taxe2, 5.0) );
    System.out.println( uneMethode((price) -> price - 100, 5.0) );
    
    
    // Pas besoin d'interface
    // Pas forcément besoin d'une interface
    Function<String, Integer> maFonction = x -> x.length();
    
    Integer nbLetters = maFonction.apply("mkyong");
    
    System.out.println("Nb letters dans SIM" + maFonction.apply("SIM")); //3

    System.out.println(nbLetters);//6
    
    
    
    } // end perform()
    
    
    //--------------------------------------------------------------------------
    public static double uneMethode(ITax fonctionTaxe, double price){
        
        return fonctionTaxe.applyTax(price);
        
    }
    
}
