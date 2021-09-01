/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.assessment01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class DogGeneticcs {
    
    public static void main(String[] args){
        
        //Define all our variables, Scanner, and Random.
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int percentremaining = 100, numBreeds = 0;
        String name;
        List<String> breeds = new ArrayList<String>(Arrays.asList("Chihuahua", "St.Bernard", "Doberman", "Labrador Retriever", "Beagle", "Pug", "Poodle", "German Shepard", "Bulldog", "Rottweiler",
            "Yorkshire Terrier", "Boxer"));
        List<String> randomBreeds = new ArrayList<>();
        boolean found = false;
        
        //Ask user for their dog's name
        System.out.println("What is your dog's name?");
        name = sc.nextLine();
        System.out.println("Enter number of breeds (2-10).");
        if((numBreeds = sc.nextInt())<2||numBreeds>10){
            System.out.println("Invalid number entered.");
            System.exit(0);
        }
        int[] breedPercents = new int[numBreeds];
        System.out.println("Well then, I have this highly reliable report on "+name+"'s prestigious background right here.");
        
        //Begin a loop to randomly select 5 breeds from the previously defined list.
            for(int i=0; i<numBreeds; i++){
                int temp = rand.nextInt(breeds.size());
                //Check if the selected breed is already in the randomBreeds list.
                if(!randomBreeds.contains(breeds.get(temp)))
                randomBreeds.add(breeds.get(temp));
                //Here, if the breed was found, we simply subtract one from 'i' to re-run the same loop and get a new breed.
                else
                    i--;
            }
            //Next we need a loop to assign random percentages to each breed, adding up to 100.
            //Getting random percentages that add up to 100 is actually very hard without some complex algorithms.
            //With the simplest solution, we run the risk of getting some 0%'s.
            for(int i=0; i<numBreeds; i++){
                if(i!=(numBreeds-1)){
                breedPercents[i] = rand.nextInt(percentremaining);
                percentremaining -= breedPercents[i];
                }
                //This ensures that it adds up to 100%.
                else if(i==numBreeds-1)
                    breedPercents[i] = percentremaining;
            }
            //Finally, we want to print out all of the breeds and their corresponding percent.
            for(int i=0; i<numBreeds; i++){
                System.out.println(breedPercents[i]+"% "+randomBreeds.get(i));
            }            
            System.out.println("Wow, that's QUITE the dog!");       
    }    
}
