/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinestars;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Claudinea de Almeida
 */
public class SetUp {
    
    
    //setting up the users using pre-definide arrays, with name, surname, age, card number, email and password
      
    String[] name = {"Billy","Bob","Dave","Jane","Mary","Joe","Chris","Peter","Greg","Kethlen","Caroline"};
    String[] surname = {"McQueen","Andrews","Caine","Gahan","Scully","Victory","Bale","Oconnell","Crithley"};
       int[] age ={10,12,14,16,18,21,25,35,40,50,65,70};
    String[] cardnumber ={"4037 3456 2345 2132","1012 4578 6987 4587","1001 1547 8957 1458","2005 1458 1254 2554","3505 8974 5412 5874"};
    String[] email ={"@gmail.com","@hotmail.com","@sansung.com","@cct.ie"};
    String[] passw ={"a123","b123","c123","d123","e123"};
        
    //instance of Random class to generate data based in the arrays up
    Random generate = new Random();
    
    
    //method to build users using the arrays up and the method Random
    //the data generate will be into a ArrayList of User
    public ArrayList<User> buildUser(ArrayList<User> user)  
    {
        //for loop to define the amount of users
        for(int i=0;i<5;i++ ) 
       {
            //instance of User class
            User usernew = new User();
            //setting the user ID
            usernew.setId(Integer.valueOf(i+1));
            //setting the User name using name and surname arrays
            usernew.setName(name[generate.nextInt(name.length)]+" "+
                          surname[generate.nextInt(surname.length)]);
            //setting the User age using the age array
            usernew.setAge(Integer.valueOf(age[generate.nextInt(age.length)]));
            //setting the User card number using the cardnumber array
            usernew.setCardnumber(cardnumber[generate.nextInt(cardnumber.length)]);
            //setting the User email using surname and email arrays
            usernew.setEmail(surname[generate.nextInt(surname.length)]+
                               email[generate.nextInt(email.length)]);
            //setting the User password using the passw array
            usernew.setPassword(passw[generate.nextInt(passw.length)]);
            
            //adding the user to the ArrayList
            user.add(usernew);
          
       } 
        /** Printing the user inserted*/
        for(User c : user) {
           System.out.println(c);
        }  
       
        //add admin
        //instance of Admin User class
        User usernew = new User(999,"Admin");
        user.add(usernew);
        
     
        
        //return the ArrayList user
        return user;
    }
    
    //method to build movies using the txt file
     public ArrayList<Movies> buildMovies(ArrayList<Movies> movies)  {
        
     
        //Declaration of the variables in the class LeitordoArquivo and initialization of them        
       
        String title="";       //Ad Astra
        String genre="";       //fiction
        int    agerated=0;     //12vyears
        String releasedate=""; //18 September 2019
        String showingin="";   //2d, 3d
        String runningtime=""; //123 minutes  
        String basedon="";     //book xxx
        String cast="";        //Brad Pitt, Tommy Lee Jones, Ruth Negga, Donald Sutherland
        String description=""; //Astronaut Roy McBride (Brad Pitt) travels to the outer edges of the solar system to find his missing father...  
        String director="";    //xxx
        double price=0.0;      //10.0

        if (!movies.isEmpty()){
                 movies.clear();
        }
        //creating a ArrayList named linha
        ArrayList<String> linha = new ArrayList<>();
        
        //try cacth to avoid problems with the file
       try {
           
            //instance of the Scanner to open the file movies.txt
            Scanner scann = new Scanner(new File("movies.txt"));
        
            //initialization of the variable i
            int i=0;
            
            //while the scann is not finish
            while(scann.hasNext()){

                //insert into the arraylist linha from the file
                linha.add(scann.nextLine());
                i++;
            }     
                      
            //loop for to manipulate the linha ArrayList
            for(int k=0;k < linha.size();k++){
                
                //getting data for each line
                String str = linha.get(k);
                //spliting the lines in rows if it find a ';'
                String[] campos = str.split(";");
     
                //for loop to get each specific data from the array campos
                for(int j = 0;j < campos.length;j++)
                {
                       //getting the information for each position and setting in there specific variable
                       if (j==0){
                            title = campos[j].trim();
                       }else if(j==1){
                            genre = campos[j].trim();
                       }else if(j==2){
                           agerated = Integer.parseInt(campos[j]);
                       }else if(j==3){
                          releasedate = campos[j].trim();
                       }else if(j==4){
                          showingin = campos[j].trim();
                       }else if(j==5){
                          runningtime = campos[j].trim();
                       }else if(j==6){
                          basedon = campos[j].trim();
                       }else if(j==7){
                          cast = campos[j].trim();
                       }else if(j==8){
                          description = campos[j].trim();
                       }else if(j==9){
                          director = campos[j].trim();
                       }else if(j==10){
                           price = Double.valueOf(campos[j]);
                       }
  
                 }
               
             
              
                //instance and setting values imported from the file to the class
                Movies current = new Movies(title,genre,agerated,releasedate,showingin,runningtime,basedon,cast,description,director,price);
                //adding the data in the ArrayList movies
              
                movies.add(current);
                
                //printing to the screen the list of movies
                System.out.println(current.toString());

            }
               
        //in case of error it will show this message bellow    
        }catch (Exception e) {
		System.out.println("Can not find the file!");
		
        }
        //returning the ArrayList movies
        return movies;
    }
    
    
    
     //method to build orders importing from the txt file
     public ArrayList<Order> buildOrders(ArrayList<Order> order)  {
        
     
        //Declaration of the variables in the class LeitordoArquivo and initialization of them        
        String date="";
        String movie="";
        int quantity=0;
        int userid=0;
        double totalPrice=0.0;
        String paymentType="";

        //creating a ArrayList linha
        ArrayList<String> linha = new ArrayList<>();
       
        //try cacth to avoid problems with the file
        try {
           
            //instance of the Scanner to open the file order.txt
            Scanner scann = new Scanner(new File("order.txt"));
        
            //initialization of the variable i
            int i=0;
            
            //while the scann is not finish
            while(scann.hasNext()){

                //insert into the arraylist linha from the file
                linha.add(scann.nextLine());
                i++;
            }     
                      
            //loop for to manipulate the linha ArrayList
            for(int k=0;k < linha.size();k++){
                
                //getting data for each line
                String str = linha.get(k);
                //spliting the lines in rows if it find a ';'
                String[] campos = str.split(";");
     
                 //for loop to get each specific data from the array campos
                for(int j = 0;j < campos.length;j++)
                {
                       //getting the information for each position and setting in there specific variable
                       if (j==0){
                            date = campos[j].trim();
                       }else if(j==1){
                            movie = campos[j].trim();
                       }else if(j==2){
                           quantity = Integer.parseInt(campos[j]);
                       }else if(j==3){
                          userid = Integer.parseInt(campos[j]);
                       }else if(j==4){
                          totalPrice = Double.parseDouble(campos[j]);
                       }else if(j==5){
                          paymentType = campos[j].trim();
                       }
  
                 }
               
             
              
                //instance and setting values imported from the file to the class
                Order current = new Order(date,movie,quantity,userid,totalPrice,paymentType);
               //adding the data in the ArrayList order
                order.add(current);
                //printing to the screen the list of movies
                System.out.println(current.toString());

            }
               
         //in case of error it will show this message bellow       
        }catch (Exception e) {
		
            System.out.println("Can not find the file!");

        }
        //returning the ArrayList movies
        return order;
    }
}
