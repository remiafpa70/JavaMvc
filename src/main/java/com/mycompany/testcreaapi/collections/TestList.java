package com.mycompany.testcreaapi.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author philou
 */
public class TestList {
    
    
    
//---------------------------------------------------------------------------
    public static void perform(){
        
        List<Integer>  listePointsFidelite = new ArrayList(); // wrapper classe       
        List<Personne>  listeClients = new ArrayList(); 
        
        // Feeding listePointsFidelite
        for(int i=0; i<10; i++){
        listePointsFidelite.add(random(0,100));
        }
        
        // Feeding listeClients
        for(int i=0; i<10; i++){
            //Personne p = new Personne("Personne"+i, random(0,1000));
            //listeClients.add(p);
            listeClients.add(new Personne("Personne"+i, random(0,1000)));
        }
        
        System.out.println("1-**************************************************");
        // Itérations sur une collection
        // classic
        for(int i=0; i<listePointsFidelite.size(); i++){
            System.out.println(listePointsFidelite.get(i));
        }
        
        for(int i=0; i<listeClients.size(); i++){
            System.out.print("Prénom = " + listeClients.get(i).getnom());
            System.out.println(" Capital = " + listeClients.get(i).getpointsFidelite());
        }
        
        
        System.out.println("2-**************************************************");

        for(int nb : listePointsFidelite){
            System.out.println(nb);
        }
        
        for(Personne p : listeClients){
            System.out.print("Prénom = " + p.getnom());
            System.out.println(" Capital = " + p.getpointsFidelite());
        }
        
        System.out.println("3-**************************************************");

        Iterator<Integer> itNumbers = listePointsFidelite.iterator();
        
        Iterator<Personne> itPersonnes = listeClients.iterator();
        
        while(itNumbers.hasNext()){
            System.out.println(itNumbers.next());
        }
        
        while(itPersonnes.hasNext()){
            Personne p = itPersonnes.next();
            System.out.print("Prénom = " + p.getnom());
            System.out.println(" Capital = " + p.getpointsFidelite());
        }        
        
        System.out.println("4-**************************************************");
        listePointsFidelite.forEach(   (nb) -> {
            System.out.printf("Nombre = %d %n", nb);
        });
        
        listeClients.stream().forEach(   (personne) -> {
            System.out.printf("Nom = %s - pointsFidelite = %d %n", personne.getnom(), personne.getpointsFidelite());
        });
        
        System.out.println("4-**************************************************");

        listePointsFidelite.stream()
                .filter(   nb -> nb > 50  )
                .forEach( nb -> {
                    System.out.printf("Nombre = %d %n", nb);
                });
        
        listeClients.stream()
                .filter( p -> p.getpointsFidelite() > 500 )
                .forEach( p -> {
                    
                    System.out.printf("Nom = %s - pointsFidelite = %d %n", p.getnom(), p.getpointsFidelite());
                
                } );
                
        System.out.println("5 -**************************************************");

        List<Integer> listePointsFideliteBeyondFifty = listePointsFidelite.stream()
                .filter( n -> n > 50)
                .collect(Collectors.toList());

        System.out.println(listePointsFideliteBeyondFifty);
        
        System.out.println("6 -**************************************************");
        
        // map(traitement à effectuer pour MODIFIER l'élément) 
        List<Integer> listePointsFidelitePlus100 = listePointsFidelite.stream()
                .map( n -> n + 100)
                .collect(Collectors.toList());
        
        System.out.println(listePointsFidelitePlus100);
        
    } // END perform()
 
    
//---------------------------------------------------------------------------  
    
    public static void perform2(){
        
        List<Integer>  listePointsFidelite = new ArrayList(); // wrapper classe       
        List<Personne>  listeClients = new ArrayList(); 
        
        // Feeding listePointsFidelite
        for(int i=0; i<10; i++){
        listePointsFidelite.add(random(0,100));
        }
        
        // Feeding listeClients
        for(int i=0; i<10; i++){
            //Personne p = new Personne("Personne"+i, random(0,1000));
            //listeClients.add(p);
            listeClients.add(new Personne("Personne"+i, random(0,1000)));
        }
        
        // 1- Tri listeClients avec Collections.sort ==> objet dédié !!!
        // Collections.sort(listeClients,  new ComparePersonne()     );
        
        // 2- Tri listeClients avec Collections.sort ==> utilisation d'une classe anonyme
        Collections.sort(listeClients,  new Comparator<Personne>(){
    
            @Override
            public int compare(Personne p1, Personne p2) {
        
            if(p1.getpointsFidelite() > p2.getpointsFidelite()){
            return 1;
            } 
            else {
            return -1;
            }
        
        
        }
        });
        
        // 3- Tri listeClients avec Collections.sort ==> avec un lambda
        Collections.sort(listeClients,  (p1, p2) -> {
        
             if(p1.getpointsFidelite() > p2.getpointsFidelite()){
                    return 1;
                }else{return -1;}
        
        
        });
        
        System.out.println(listeClients);
        
        System.out.println("stream.sorted() -----------------------");
        
        // Avec la méthode intermédiare stream.sort()
        listeClients.stream()
                .sorted(new ComparePersonne())
                .forEach(   p -> {System.out.println(p.getpointsFidelite());}   );
        
        
    }
    
//---------------------------------------------------------------------------
    private static int random(double min, double max){
        return (int)((Math.random() * ( max - min+1 )) + min); 
    }

    
    
    
}

