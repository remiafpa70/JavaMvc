package com.mycompany.testcreaapi.collections;

/**
 *
 * @author philou
 */
@FunctionalInterface
public interface ITax {
    
    // Retourne le prix final du produit
    double applyTax(double price);

}


// @FunctionalInterface
// non obligatoire - garanti le check par le compilateur
