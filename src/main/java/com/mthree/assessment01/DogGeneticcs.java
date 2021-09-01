/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.assessment01;

import java.util.Scanner;
import java.util.Random;

public class DogGeneticcs {
    
    public static void main(String[] args){
        
        //Define all our variables, Scanner, and Random.
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int percentremaining = 100;
        String name;
        String[] breeds = {"Chihuahua", "St.Bernard", "Doberman", "Labrador Retriever", "Beagle", "Pug", "Poodle", "German Shepard", "Bulldog", "Rottweiler",
            "Yorkshire Terrier", "Boxer"};
        String[] randomBreeds = new String[5];
        int[] breedPercents = new int[5];
        boolean found = false;
        
        //Ask user for their dog's name
        System.out.println("What is your dog's name?");
        name = sc.nextLine();
        System.out.println("Well then, I have this highly reliable report on "+name+"'s prestigious background right here.");
        
        //Begin a loop to randomly select 5 breeds from the previously defined array.
            for(int i=0; i<5; i++){
                int temp = rand.nextInt(breeds.length);
                //This loop checks if the randomly selected breed is already in the array of selected breeds.
                //This would be far easier if we used a List instead of an Array, but I'm using what we've 'learned' up to now in the class.
                for(String s : randomBreeds){
                    if(s!= null && s.equals(temp))
                        found=true;
                }
                if(!found)
                randomBreeds[i] = breeds[temp];
                //Here, if the breed was found, we simply subtract one from 'i' to re-run the same loop and get a new breed.
                else
                    i--;
            }
            //Next we need a loop to assign random percentages to each breed, adding up to 100.
            //Getting 5 random percentages that add up to 100 is actually very hard without some complex algorithms.
            //With the simplest solution, we run the risk of getting some 0%'s.
            for(int i=0; i<5; i++){
                if(i!=4){
                breedPercents[i] = rand.nextInt(percentremaining);
                percentremaining -= breedPercents[i];
                }
                //This ensures that it adds up to 100%.
                else if(i==4)
                    breedPercents[i] = percentremaining;
            }
            //Finally, we want to print out all of the breeds and their corresponding percent.
            for(int i=0; i<5; i++){
                System.out.println(breedPercents[i]+"% "+randomBreeds[i]);
            }            
            System.out.println("Wow, that's QUITE the dog!");       
    }
    
}
