/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.assessment01;


public class SummativeSums {
    
    static int counter = 1;
    
    public static void main(String[] args){
        
        //Declare our arrays...
        int[] array1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 }, array2 = { 999, -60, -77, 14, 160, 301 }, array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110,
            120, 130, 140, 150, 160, 170, 180, 190, 200, -99} ;
        
        sumArrays(array1);
        sumArrays(array2);
        sumArrays(array3);        
    }
    
    public static int sumArrays(int[] arr){
        
        //Method is pretty self explanatory. Initialize a sum at 0, loop through each item in an array and  add them to the sum. Keep track of which array with
        //a counter.
        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        System.out.println("#"+counter+" Array Sum: "+sum);
        counter++;
        return sum;
        
    }
}
