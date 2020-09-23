package com.mycompany.testcreaapi.collections;

import com.mycompany.testcreaapi.collections.Personne;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ziza
 */
public class TestList {
    
    
    
//---------------------------------------------------------------------------
    public static void perform(){
        
        List<Integer>  listeNombres = new ArrayList(); // wrapper classe       
        List<Personne>  listePersonnes = new ArrayList(); 
        
        // Feeding listeNombres
        for(int i=0; i<10; i++){
        listeNombres.add(random(0,100));
        }
        
        // Feeding listePersonnes
        for(int i=0; i<10; i++){
            //Personne p = new Personne("Personne"+i, random(0,1000));
            //listePersonnes.add(p);
            listePersonnes.add(new Personne("Personne"+i, random(0,1000)));
        }
        
        System.out.println("1-**************************************************");
        // Itérations sur une collection
        // classic
        for(int i=0; i<listeNombres.size(); i++){
            System.out.println(listeNombres.get(i));
        }
        
        for(int i=0; i<listePersonnes.size(); i++){
            System.out.print("Prénom = " + listePersonnes.get(i).getPrenom());
            System.out.println(" Capital = " + listePersonnes.get(i).getSolde());
        }
        
        
        System.out.println("2-**************************************************");

        for(int nb : listeNombres){
            System.out.println(nb);
        }
        
        for(Personne p : listePersonnes){
            System.out.print("Prénom = " + p.getPrenom());
            System.out.println(" Capital = " + p.getSolde());
        }
        
        System.out.println("3-**************************************************");

        Iterator<Integer> itNumbers = listeNombres.iterator();
        
        Iterator<Personne> itPersonnes = listePersonnes.iterator();
        
        while(itNumbers.hasNext()){
            System.out.println(itNumbers.next());
        }
        
        while(itPersonnes.hasNext()){
            Personne p = itPersonnes.next();
            System.out.print("Prénom = " + p.getPrenom());
            System.out.println(" Capital = " + p.getSolde());
        }        
        
        System.out.println("4-**************************************************");
        listeNombres.forEach(   (nb) -> {
            System.out.printf("Nombre = %d %n", nb);
        });
        
        listePersonnes.stream().forEach(   (personne) -> {
            System.out.printf("Nom = %s - Solde = %d %n", personne.getPrenom(), personne.getSolde());
        });
        
        System.out.println("4-**************************************************");

        listeNombres.stream()
                .filter(   nb -> nb > 50  )
                .forEach( nb -> {
                    System.out.printf("Nombre = %d %n", nb);
                });
        
        listePersonnes.stream()
                .filter( p -> p.getSolde() > 500 )
                .forEach( p -> {
                    
                    System.out.printf("Nom = %s - Solde = %d %n", p.getPrenom(), p.getSolde());
                
                } );
                
        System.out.println("5 -**************************************************");

        List<Integer> listeNombresBeyondFifty = listeNombres.stream()
                .filter( n -> n > 50)
                .collect(Collectors.toList());

        System.out.println(listeNombresBeyondFifty);
        
        System.out.println("6 -**************************************************");
        
        // map(traitement à effectuer pour MODIFIER l'élément) 
        List<Integer> listeNombresPlus100 = listeNombres.stream()
                .map( n -> n + 100)
                .collect(Collectors.toList());
        
        System.out.println(listeNombresPlus100);
        
    } // END perform()
 
    
//---------------------------------------------------------------------------  
    
    public static void perform2(){
        
        List<Integer>  listeNombres = new ArrayList(); // wrapper classe       
        List<Personne>  listePersonnes = new ArrayList(); 
        
        // Feeding listeNombres
        for(int i=0; i<10; i++){
        listeNombres.add(random(0,100));
        }
        
        // Feeding listePersonnes
        for(int i=0; i<10; i++){
            //Personne p = new Personne("Personne"+i, random(0,1000));
            //listePersonnes.add(p);
            listePersonnes.add(new Personne("Personne"+i, random(0,1000)));
        }
        
        // 1- Tri listePersonnes avec Collections.sort ==> objet dédié !!!
        // Collections.sort(listePersonnes,  new ComparePersonne()     );
        
        // 2- Tri listePersonnes avec Collections.sort ==> utilisation d'une classe anonyme
        Collections.sort(listePersonnes,  new Comparator<Personne>(){
    
            @Override
            public int compare(Personne p1, Personne p2) {
        
            if(p1.getSolde() > p2.getSolde()){
            return 1;
            } 
            else {
            return -1;
            }
        
        
        }
        });
        
        // 3- Tri listePersonnes avec Collections.sort ==> avec un lambda
        Collections.sort(listePersonnes,  (p1, p2) -> {
        
             if(p1.getSolde() > p2.getSolde()){
                    return 1;
                }else{return -1;}
        
        
        });
        
        System.out.println(listePersonnes);
        
        System.out.println("stream.sorted() -----------------------");
        
        // Avec la méthode intermédiare stream.sort()
        listePersonnes.stream()
                .sorted(new ComparePersonne())
                .forEach(   p -> {System.out.println(p.getSolde());}   );
        
        
    }
    
//---------------------------------------------------------------------------
    private static int random(double min, double max){
        return (int)((Math.random() * ( max - min+1 )) + min); 
    }

    
    
    
}
