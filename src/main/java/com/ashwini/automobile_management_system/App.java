package com.ashwini.automobile_management_system;

import java.util.Scanner;

/**
 * Automobile Management System
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        VehicleFactory vf=new VehicleFactory();
        Scanner sc=new Scanner(System.in);
        vf.openLine("||----- Wel Come to Ashwini's Automobile Management System------||");
        System.out.println("\nSelect option: ");
        System.out.println("1.Create Account");
        System.out.println("2.Login Account");
        int option=sc.nextInt();
        if(option==1) {
        	vf.createAccount();
        }
        else if(option==2) {
        	vf.login();
        }
        else {
        	System.out.println(".....Enter valid option.....");
        }
    }
}
