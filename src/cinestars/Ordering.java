/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinestars;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Claudinea de Almeida
 */
public class Ordering extends Order{
    
            //Declaration of the attributes in the class Ordering 
            private String orders, again, paymentType;
            private int quantities;
            private double totalPrice;
            private TicketType ticketType; // add the enum to the method
            private String nameMovies;
            private int totalTickets;
            private String cardnumber;

            //method to create a new order with parameters userId, ArrayList of user, ArrayList of Movies, ArrayList of order
            public void Ordering(int userId, ArrayList<User> user, ArrayList<Movies> movies, ArrayList<Order> order) 
           {
            //instance of new logic class   
            Logic logic = new Logic();
            //checking the Movies available  and returning the index of the movie   
            int idm=logic.CheckMovies(movies);
            
            //showing the options to order the movies which are Child, Adult, Senior and quit.   
            System.out.println("\n\n                       ### CineStars - Ticket System ### ");
            System.out.println("\n              =====================================================  ");
            System.out.println("                |     1 - Child (0 - 12 years) - 40% of discount     | ");
            System.out.println("                |     2 - Adult (18+ years)                          | ");
            System.out.println("                |     3 - Senior (65+ years)   - 20% of discount     | ");
            System.out.println("                |     0 - Quit                                       | ");
            System.out.println("                ====================================================\n ");

            //instance of the new scanner class
            Scanner sc = new Scanner(System.in);
            
            //initializing the variable totalTickets with the value zero
            totalTickets=0;
          
            //do while loop to control how many tickets the user will buy
            do {
            
            //printing message to the user to type the option
            System.out.println(" ");
            System.out.print("\"--- Enter your option ---\" ");
            //reading from the keyboard and inserting into the variable orders
            orders = sc.nextLine();

            //use a switch case instead of the if else pattern
            //it will use the enum class to calculate the discount
            switch (orders.toLowerCase()) {
              case "1":
                //this will insert into the variable ticketType the value of child ticket with discount  
                ticketType = TicketType.child;
                break;

              case "3":
                //this will insert into the variable ticketType the value of senior ticket with discount  
                ticketType = TicketType.senior;
                break;

              default:
                  //this will insert into the variable ticketType the value of adult ticket without discount  
                ticketType = TicketType.adult;
                break;
            }

            //printing message to the user to type the number of the tickets
            System.out.print("\"--- Enter the number of tickets: ---\" ");
            //reading from the keyboard and inserting in the variable quantities
            quantities = Integer.parseInt(sc.nextLine());
            
            //calculing the totalTickets
            totalTickets =totalTickets+quantities;
                        
            //calculing the totalPrice
            totalPrice += ticketType.getPrice(movies,idm) * quantities;
            
            // %s will be replaced with the string value of ticketType, %.2f means it will be replaced with a decimal, round to decimals 
            System.out.printf("You are purchasing for each %s ticket  at %.2f \n", ticketType, ticketType.getPrice(movies,idm));

            //asking to the user if she/him want to continue shopping
            System.out.print("\"--- Do you want to continue shopping?  (Y/N) : ---\" ");
            //reading from the keyboard and inserting in the variable again
            again = sc.nextLine();
          }
          //while again is equal y this loop will be repete
          while (again.equalsIgnoreCase("y"));

          //printing the total price of this transaction
          System.out.println(" ");
          System.out.printf("Total Price    : $%.2f \n", totalPrice);
          
          
          //checking payment type
          //asking to the user if she/him want to pay by card
          System.out.print("\"--- Do you want to pay by card?  (Y/N) : ---\" ");
          //reading from the keyboard and inserting in the variable paymentType
          paymentType = sc.nextLine();
          
          //checking if answer from user is YES or NOT (Y/N)
          if (paymentType.equalsIgnoreCase("y")){
              //if the user wants to pay by card the card will be collect from the user class using getCardnumber
              for(int i=0;i<user.size();i++){
                  //checking if the user id is equal the value of the variable userId
                  if(user.get(i).getId()==userId){
                    cardnumber ="by card ("+user.get(i).getCardnumber()+")";
                  }
              }
              
          }else{
              //if the user do not want to pay by card it will register "by cash"
              cardnumber = "by cash";
          }
          
                          
          //getting and formating atual date
          SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
          String result = out.format(new Date());
          
          //getting the title of the movie
          for(int i=0;i<movies.size();i++){
              if(idm==i){
                  nameMovies= movies.get(i).getTitle();
               
              }
          }
         
                  
          //formating the decimal number with 2 values after '.'
          DecimalFormat df = new DecimalFormat("0.##");
          String dx = df.format(totalPrice);
          
          //setting order class the values from this transaction
          Order ordering = new Order(result,nameMovies,totalTickets,userId,Double.parseDouble(dx),cardnumber);
                         
          //adding new order into arraylist of order
          order.add(ordering);
                                     
          //printing the order
           System.out.println("");
           System.out.printf(ordering.printOrder());
          
          //exporting to file
           logic.printFile(order);
        }

   
}
