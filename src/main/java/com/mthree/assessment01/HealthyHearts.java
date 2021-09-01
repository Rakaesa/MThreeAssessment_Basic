/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.assessment01;

import java.util.Scanner;


public class HealthyHearts {
    
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
        double age, max_hr, target_hr1, target_hr2;
        
        System.out.println("What is your age?");
        age = sc.nextInt();
        max_hr = 220 - age;
        target_hr1 = .5*max_hr;
        target_hr2 = .85*max_hr;
        System.out.println("Your maximum heart rate should be "+Double.toString(Math.round(max_hr))+" beats per minute.");
        System.out.println("Your target HR Zone is "+Double.toString(Math.round(target_hr1))+" - "+Double.toString(Math.round(target_hr2))+" beats per minute");
    }
}
