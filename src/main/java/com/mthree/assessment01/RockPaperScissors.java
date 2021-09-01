/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.assessment01;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args){        
        //Initialize all our variables, scanner, and random.
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int rounds, inp1, inp2;
        int[] scores = {0,0,0};
        boolean playAgain = false;
        String response;
        
        System.out.println("Welcome to Rock Paper Scissors!");
        
        //A do-while loop will ensure that it runs at least once.
        do{
            //Reset the scores, in case the user has ran it more than once.
            scores[0]=0;
            scores[1]=0;
            scores[2]=0;
            //Ask the user for the # of rounds.
            System.out.println("Please enter a number of rounds between 1 and 10.");
            rounds = sc.nextInt();
            //Check that the entered rounds are between 1 and 10. If it isn't, exit program.
            if(rounds<1 || rounds>10){
                System.out.println("Invalid number of rounds entered. Program closing.");
                System.exit(0);
            }
            //Start the for loop for the rounds.
            for(int i = 0;i<rounds;i++){
                System.out.println("Player 1, enter 1 (Rock), 2(Paper), or 3(Scissors)!");
                if(!((inp1 = sc.nextInt()) == (int)inp1)||inp1<0||inp1>3){
                    System.out.println("Invalid entry. Please enter 1, 2, or 3. Exiting.");
                    System.exit(0);
                }
                inp2 = rand.nextInt(3)+1;
                //This method compares the two inputs and changes the scores accordingly.
                rockPaperScissors(inp1, inp2, scores);
            }
            //Display the scores after n rounds
            System.out.println("User wins :"+scores[1]);
            System.out.println("Computer wins: "+scores[2]);
            System.out.println("Draws : "+scores[0]);
            //Display who the victor is (if there is one!)
            if(scores[1]>scores[2]){
                System.out.println("User wins!!");
            }
            else if(scores[2]>scores[1]){
                System.out.println("Computer wins!!");
            }
            else if(scores[1]==scores[2]){
                System.out.println("A tie!!");
            }
            //Skip a line to get rid of the extra empty space. Without this, it automatically takes an empty space as the next input.
            sc.nextLine();
            //Ask the user if they'd like to play again, adjust the 'playAgain' flag accordingly.
            System.out.println("Do you want to play again? (Y/N)");
            response = sc.nextLine();
            if((response.equals("Y"))||(response.equals("y")))
                playAgain=true;
            else{
                playAgain=false;
                System.out.println(response);
                System.out.println("Thanks for playing!");
            }           
        }
        while(playAgain);            
    }
    public static void rockPaperScissors(int inp1, int inp2, int[] scores){        
        //These are arrays of pre-defined outcomes to rock paper scissors. [0] is rock, [1] is paper, [2] is scissors.
        int[] rock = {0,2,1};
        int[] paper = {1,0,2};
        int[] scissors = {2,1,0};
        int result = 0;
        System.out.println("User: "+inp1);
        System.out.println("Computer: "+inp2);
        //New and improved switch. Uses the correct array from the 3 above based on user selection (the case).
            switch(inp1){
                case 1:
                    result = rock[(inp2-1)];  
                    break;
                case 2:
                    result = paper[(inp2-1)];  
                    break;
                case 3:
                    result = scissors[(inp2-1)];
                    break;
            }
            scores[result]+=1;  
    }    
}
