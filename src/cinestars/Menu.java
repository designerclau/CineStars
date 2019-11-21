/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinestars;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Claudinea de Almeida
 */
public class Menu {
    
    //default constructor
    public Menu(){}
    
     // method started will show the option in the main menu
    //it will receive validuser, Arraylist of user, ArrayList of movies and ArrayList of orders as parameters
     public static void started(int validuser,ArrayList<User> user, ArrayList<Movies> movies, ArrayList<Order> orders) {
        //initialize the variable option with zero 
	int option = 0;
      
        //creating and initialize de variable resposta with "n"
        String resposta="n";
        
        //do while loop
	do {
                //main menu
		System.out.println("\n\n                ### CineStars - Ticket System ### ");
		System.out.println("\n                =================================  ");
		System.out.println("                |     1 - Create a new order    | ");
		System.out.println("                |     2 - List the films        | ");
		System.out.println("                |     3 - View previous orders  | ");
                
                //if the user is 999 it will show the option to edit films
                if (validuser == 999){
                    System.out.println("                |     4 - Edit films            | ");
                }
               
		System.out.println("                |     0 - Quit                  | ");
		System.out.println("                =================================\n ");

                
                //instance of scanner class
                Scanner sc = new Scanner(System.in);
                //reading from the keyboard
                option = sc.nextInt();
	
		System.out.print("\n");
                
                //swich option will execute the part of the code case the user type the specific value
                //if the user type 1, the case 1: will be executed
		switch (option) {
		case 1:{
                        System.out.println("Create a new order");
                        //instance of logic class
                        Logic logic = new Logic();
                        //instance of ordering class
                        Ordering ordering = new Ordering();
                        //calling the method Ordering with the validuser, user, movies and orders as parameters
                        ordering.Ordering(validuser,user,movies,orders);
                        
                        //variable resposta receives the value n
                        
                        resposta="n";
                        //code default to finish the case 1
			break;
                        
                        
                }
		case 2:{
			System.out.println("List the films");
                        //for loop to print the movies in the screen fro the ArrayList movies
                         for(int i=0;i<movies.size();i++) {
                            System.out.println(movies.get(i).printMovie());
                         }  
                        //variable resposta receives the value n 
                        resposta="n";
                        //code default to finish the case 2
			break;
                }
		case 3:{
			System.out.println("View previous orders");
                        //for loop to print the orders in the screen fro the ArrayList orders
                        for(int i=0;i<orders.size();i++) {
                            //check if the user in the ArrayList of orders is equal to the validuser and print she/he orders
                            if (orders.get(i).getUser()==validuser){
                                System.out.println(orders.get(i).printOrder());
                            }
                         } 
                        //variable resposta receives the value n 
                        resposta="n";
                        //code default to finish the case 3
			break;
                }
                case 4:{
                        //this option is only valid for user id 999 password Admin (Administrator of the system)
                        if (validuser == 999){
			   System.out.println("Edit films");
                           //instance of the class logic
                           Logic logic = new Logic();
                           //calling the method editMovies with ArrayList movies as a parameter
                           logic.editMovies(movies);
                        }else{
                             //show to the user this message if the user is not the administrator of the system
                             System.out.println("Invalid option!");
                             //code default to finish the case 4
			     break;
                        }
                        //variable resposta receives the value n 
                        resposta="n";
                        //code default to finish the case 4
			break;
                }
		case 0:{
                        System.out.println("Are you sure you wish to close this program? (Yes/No)");
                        //reading from keyboard if the user want to close the program
                        String option2 = sc.next();
                        if(option2.equalsIgnoreCase("Yes")){
                            //variable resposta receives the value y 
                            resposta="y";
                            //code default to finish the case 0
                            break;
                        }else{
                            //variable resposta receives the value n 
                            resposta="n";
                            //code default to finish the case 0
                            break;
                        }
                }
                     
		default:{
                        //if the user type wrong option will show this message
			System.out.println("Invalid option!");
			break;
		}
             }
        //while the value of the variable resposta is different of the "y" this menu will be showing        
	} while (!resposta.equalsIgnoreCase("y"));
    }
}
