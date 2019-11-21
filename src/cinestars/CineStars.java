/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinestars;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Claudinea de Almeida
 */
public class CineStars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        
             //welcome window
             JOptionPane.showMessageDialog(null, "Wellcome to the CineStars!" , "Alert!", JOptionPane.INFORMATION_MESSAGE);
        
             //instance of user class with ArrayList
             ArrayList<User> user = new ArrayList<User>();
             
             //instance of setup class 
             SetUp setup = new SetUp();
             System.out.println("\n ----- Setting up the Users -----\n");
             //calling the method buildUser
             user=setup.buildUser(user);
            
             //instance of Movies class with ArrayList 
             ArrayList<Movies> movies = new ArrayList<Movies>();
             
             System.out.println("\n ----- Setting up the movies -----\n");
             //calling the method buildMovies which import data from the file
             movies=setup.buildMovies(movies);
             
             //instance of Order class with ArrayList 
             ArrayList<Order> orders = new ArrayList<Order>();
             
             System.out.println("\n ----- Setting up the orders -----\n");
              //calling the method buildOrders which import data from the file
             orders=setup.buildOrders(orders);
             
             //instance of Logic class 
             Logic logic = new Logic();
             System.out.println("\n ----- Login of the user -----\n");
             //calling the method userLogin to login the user
             int validUser=logic.userLogin(user);
            
             //instance of Menu class 
             Menu menu = new Menu();
             //calling the method started to show the Menu to the user
             menu.started(validUser,user,movies,orders);
             
             
             
             
           
    }
    
}
