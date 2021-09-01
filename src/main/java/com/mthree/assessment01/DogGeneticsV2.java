/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.assessment01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class DogGeneticsV2 {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int generations, breedsNum = 0, breedSelect = 1, count = 0;
        
        HashMap<Integer, String> breeds = new HashMap<Integer, String>();
        breeds.put(1,"Chihuaha");
        breeds.put(2,"St.Bernard");
        breeds.put(3,"Doberman");
        breeds.put(4,"Labrador Retriever");
        breeds.put(5,"Beagle");
        breeds.put(6,"Pug");
        breeds.put(7, "Poodle");
        breeds.put(8, "German Shepard");
        breeds.put(9, "Yorkshire Terrier");
        breeds.put(10, "Boxer");
        
        System.out.println("How many generations of ancestry?");
        generations = sc.nextInt();
        if(Math.pow(generations, 2)>=breeds.size())
            breedsNum = rand.nextInt(breeds.size())+1;
        else
            breedsNum = rand.nextInt((int)Math.pow(generations,2))+1;
        
        ArrayList<Integer> randomBreeds = new ArrayList<Integer>(breedsNum);
        
        for(int i = 0; i<breedsNum; i++){
              breedSelect = rand.nextInt(breeds.size())+1;
              if(!randomBreeds.contains(breedSelect))
                  randomBreeds.add(i, breedSelect);
              else
                  i--;
        }
        int[] ancestors = new int[(int)Math.pow(2,generations)];
        HashMap<Integer, Integer> breedCounts = new HashMap<Integer,Integer>();
        for(int i: ancestors){
            ancestors[i] = randomBreeds.get(rand.nextInt(randomBreeds.size()));
            if(!breedCounts.containsKey(ancestors[i]))
                breedCounts.put(ancestors[i], 1);
            else{
                count = breedCounts.get(ancestors[i]);
                breedCounts.put(ancestors[i], count + 1);
            }
        }
        System.out.println("Your dog is ");
        breedCounts.forEach((k, v)->{
            System.out.print(((double)(v/(Math.pow(2,generations)))*100)+"% "+breeds.get(k)+", ");
            
        });
        
    }
    
}
