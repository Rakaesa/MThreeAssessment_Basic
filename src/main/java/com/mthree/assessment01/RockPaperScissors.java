/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.assessment01;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    //The simplest way to keep track of scores between the main and the method is by making them static.
    static int score1 = 0, score2 = 0, draws = 0;
    public static void main(String[] args){
        
        //Initialize all our variables, scanner, and random.
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int rounds, inp1, inp2;
        boolean playAgain = false;
        String response;
        
        System.out.println("Welcome to Rock Paper Scissors!");
        
        //A do-while loop will ensure that it runs at least once.
        do{
            //Reset the scores, in case the user has ran it more than once.
            score1 = 0;
            score2 = 0;
            draws = 0;
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
                if(!((inp1 = sc.nextInt()) == (int)inp1)){
                    System.out.println("Invalid entry. Please enter 1, 2, or 3. Exiting.");
                    System.exit(0);
                }
                inp2 = rand.nextInt(3)+1;
                //This method compares the two inputs and changes the scores accordingly.
                rockPaperScissors(inp1, inp2);
            }
            //Display the scores after n rounds
            System.out.println("User wins :"+score1);
            System.out.println("Computer wins: "+score2);
            System.out.println("Draws : "+draws);
            //Display who the victor is (if there is one!)
            if(score1>score2){
                System.out.println("User wins!!");
            }
            else if(score2>score1){
                System.out.println("Computer wins!!");
            }
            else if(score1==score2){
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
    public static void rockPaperScissors(int inp1, int inp2){
            
        System.out.println("User: "+inp1);
        System.out.println("Computer: "+inp2);
            switch(inp1){
                case 1:
                    if(inp2==2){
                    score2++;
                    System.out.println("Computer wins!");
                }
                else if(inp2==3){
                    score1++;
                    System.out.println("User wins!");
                }
                else{
                    draws++;
                    System.out.println("Draw!");
                }
                case 2:
                    if(inp2==1){
                    score1++;
                    System.out.println("User wins!");
                }
                else if(inp2==2){
                    draws++;
                    System.out.println("Draw!");
                }
                else{
                    score2++;
                    System.out.println("Computer wins!");
                }
                case 3:
                    if(inp2==1){
                    score2++;
                    System.out.println("Computer wins!");
                }
                else if(inp2==2){
                    score1++;
                    System.out.println("User wins!");
                }
                else{
                    draws++;
                    System.out.println("Draw!");
                }
                    //If anything other than 1, 2, or 3 are entered...
                default:
                    System.out.println("Invalid selection. Exiting.");
                    System.exit(0);
            }
    }
}
