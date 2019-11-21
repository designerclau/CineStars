/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinestars;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Claudinea de Almeida
 */
public class Logic {
    
    
 
    //mehtod to validate integer values
    public boolean validateInt(float number){
        //if the number is integer return true
        if(number == (int)number)
           return true;
        else
           //if the number is not integer return false 
           return false;
    }
    
    //method to validate password with regular expression
    public boolean validatePassword(String pass){
        //regular expression will validate letters and numbers, starting with letters
        //if the pass variable match with the expression it will return true
        if (pass.matches("[a-zA-Z_].*[a-zA-Z0-9_]")){
            return true;
        }else{
             //if the pass variable not match with the expression it will return false
            return false;
        }
    }
    
    //method to validate email with regular expression
    public boolean validateEmail(String email){
        //creating the boolean variable isEmailIdValid and initialize it with false
        boolean isEmailIdValid = false;
        //if the email is not null and it length is bigger than zero
        if (email != null && email.length() > 0) {
            //regular expression
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            //method pattern to check the regular expression
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            //instance of Matcher method
            Matcher matcher = pattern.matcher(email);
            //if the value passed by parameter matche with the regular expression the variable isEmailIdValid receives true
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        //return the value in the variable isEmailIdValid
        return isEmailIdValid;
    }
    
    //method to validate text with regular expression
    public boolean validateText(String text){
        //creating the boolean variable isTextValid and initialize it with false
        boolean isTextValid = false;
        //if the text is not null and it length is bigger than zero
        if (text != null && text.length() > 0) {
            //regular expression
            String expression = "\\[A-Z\\]\\[a-z\\]{3,}";
            //method pattern to check the regular expression
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            //instance of Matcher method
            Matcher matcher = pattern.matcher(text);
            //if the value passed by parameter matche with the regular expression the variable isTextValid receives true
            if (matcher.matches()) {
                isTextValid = true;
            }
        }
        //return the value in the variable isTextValid
        return isTextValid;
    }
      
    //method to validate name with regular expression
    public boolean validateName(String text){
        //creating the boolean variable isTextValid and initialize it with false
        boolean isTextValid = false;
        //if the text is not null and it length is bigger than zero
        if (text != null && text.length() > 0) {
            //regular expression
            String expression = "^(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*(?: (?:(?:e|y|de(?:(?: la| las| lo| los))?|do|dos|da|das|del|van|von|bin|le) )?(?:(?:(?:d'|D'|O'|Mc|Mac|al\\-))?(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+|(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*))+(?: (?:Jr\\.|II|III|IV))?$";
            //method pattern to check the regular expression
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            //instance of Matcher method
            Matcher matcher = pattern.matcher(text);
            //if the value passed by parameter matche with the regular expression the variable isTextValid receives true
            if (matcher.matches()) {
                isTextValid = true;
            }
        }
        //return the value in the variable isTextValid
        return isTextValid;
    }

    //method to validate name with regular expression
    public boolean validateCard(String text){
        //creating the boolean variable isCardValid and initialize it with false
        boolean isCardValid = false;
        //if the text is not null and it length is bigger than zero
        if (text != null && text.length() > 0) {
            //regular expression
            String expression = "[0-9]{16}";
            //method pattern to check the regular expression
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            //instance of Matcher method
            Matcher matcher = pattern.matcher(text);
            //if the value passed by parameter matches with the regular expression the variable isCardValid receives true
            if (matcher.matches()) {
                isCardValid = true;
            }
        }
        //return the value in the variable isCardValid
        return isCardValid;
    }
      
    //method created to login the user  
    public int userLogin(ArrayList<User> user){
        //instance of the new scanner
        Scanner sc1 = new Scanner(System.in);
        //creating and initializing the variable validuser 
        int validuser=0;
        //asking to the user if she/he is registered in the system
        System.out.print("\"--- Are you registered in the system? (Y/N) ---\" ");
        //reading from the Keyboard
        String resgister = sc1.nextLine();
        //if the user type "Y" it means Yes
        if (resgister.equalsIgnoreCase("y")){

              //the method validateUser will be called and the ArrayList of the user will be passed by parameter
              //the result will be stored in variable validuser
              validuser=validateUser(user);

              //if validuser is equal zero it means that the user is not registered in the system
              if (validuser==0){
                //show the message to the user  
                System.out.println("\"--- User is not registered in this system ---\" ");
                System.out.println(" ");
                System.out.println("\"--- Registring the user in this system ---\" ");
                System.out.println(" ");
                
                //call the method addUser to add a new user
                addUser(user);
                //getting the total of users
                int totalUser = user.size();
                //getting the id of the user
                validuser=user.get(totalUser-1).getId();
              }
       }else{
            //call the method addUser to add a new user
            addUser(user); 
            
            //getting the total of users
            int totalUser = user.size();
            //getting the id of the user
            validuser=user.get(totalUser-1).getId();
         }
        //returning the value in the variable validuser
       return validuser;
    }
      
    //method created to validate the user 
    public int validateUser(ArrayList<User> user){
         
         //creating and initializing the variable validuser 
         boolean validuser = false;
         //creating and initializing the variable returnuser 
         int returnuser=0;

         //instance of the new scanner
         Scanner sc1 = new Scanner(System.in);
         //asking the user to type she/he id
         System.out.print("\"--- Please enter with your id ---\" ");
         //reading from the keyboard
         int iduser = sc1.nextInt();
         //calling the method validateInt to check the id of the user
         boolean result = validateInt(iduser);
         //while the result is false will show the message invalid to the user and it will ask to the user type again
         while (result == false){
            System.out.print("\"--- Id is not valid. Try again ---\" ");
            //reading from the keyboard
            iduser = sc1.nextInt();
            //checking the iduser with the method validateInt
            result = validateInt(iduser);
         }

         //asking the user to type she/he password
         System.out.print("\"--- Please enter with your password ---\" ");
         //reading from the keyboard
         String passw = sc1.next();
         //calling the method validatePassword to check the id of the user
         result = validatePassword(passw);
         //while the result is false will show the message invalid to the user and it will ask to the user type again
         while (result == false){
            System.out.print("\"--- Password not valid. Try again ---\" ");
            //reading from the keyboard
            passw = sc1.next();
            //checking the iduser with the method validateInt
            result = validatePassword(passw);
         }
         
        
         //checking user id and password is in the system
         for(int i=0;i<user.size();i++){
             //checking user id and password is in the system
             if (user.get(i).getId()==iduser && user.get(i).getPassword().equals(passw))
             {
                //if the id and password match it will be printed to the user
                System.out.println(user.get(i).printUser());
                //the variable returnuser will receive the iduser
                returnuser=iduser;
                //validuser receives true
                validuser=true;
             }

        }
     //return the value in the variable returnuser
     return returnuser;
   }
    
   //method created to add a new user 
    public ArrayList<User> addUser(ArrayList<User> user){
        //creating and initializing the variable validuser
        boolean validuser = false;

         //instance of the new scanner
        Scanner newsc = new Scanner(System.in);
         
        //user's id
         //asking to the user to type she/he id
         System.out.print("\n--- Please enter with your id ---\" ");
         //reading from the keyboard
         int iduser = newsc.nextInt();
         //calling the method validateInt to check the user's id 
         boolean result = validateInt(iduser);
         //while the result is false will show the message invalid to the user and it will ask to the user type again
         while (result == false){
            //asking to the user to type she/he id
            System.out.print("\n--- Id is not valid. Try again ---\" ");
            //reading from the keyboard
            iduser = newsc.nextInt();
            //checking the iduser with the method validateInt
            result = validateInt(iduser);
         }
         //instance of the class user
         User users = new User();
         //setting the new id
         users.setId(iduser);

         
         //uses's name
         //instance of the new scanner
         Scanner sc2 = new Scanner(System.in);
         //asking to the user to type she/he name
         System.out.print("\n--- Please enter with your name ---\" ");
         //reading from the keyboard
         String name = sc2.nextLine();
         //calling the method validateName to check the user's name
         result = validateName(name);
         //while the result is false will show the message invalid to the user and it will ask to the user type again
         while (result == false){
            //asking to the user to type she/he name
            System.out.print("\n--- Name is not valid. Start it with Upercase each word ---\" ");
            //reading from the keyboard
            name = sc2.nextLine();
            //calling the method validateName to check the user's name
            result = validateName(name);
         }
         //setting the new name
          users.setName(name);
          
          
         //user's age
         //asking to the user to type she/he age
         System.out.print("\n--- Please enter with your age ---\" ");
         //reading from the keyboard
         int age = newsc.nextInt();
         //calling the method validateInt to check the user's age
         result = validateInt(age);
         while (result == false){
            //asking to the user to type she/he age
            System.out.print("\n--- Age is not valid. Try again ---\" ");
            //reading from the keyboard
            age = newsc.nextInt();
            //calling the method validateInt to check the user's age
            result = validateInt(age);
         }
         //setting the new age
          users.setAge(age);
         
         //user's card number
         //asking to the user to type she/he card number
         System.out.print("\n--- Please enter with your card ---\" ");
         //reading from the keyboard
         String card = sc2.nextLine();
         //calling the method validateCard to check the user's card
         result = validateCard(card);
         while (result == false){
            System.out.print("\n--- Card is not valid. Try again ---\" ");
            //reading from the keyboard
            card = sc2.nextLine();
            //calling the method validateCard to check the user's card
            result = validateCard(card);
         }
         //setting the new card number
         users.setCardnumber(card);
         
         
         //user email
         //asking to the user to type she/he email
         System.out.print("\n--- Please enter with your email ---\" ");
         //reading from the keyboard
         String email = newsc.next();
         //calling the method validateEmail to check the user's email
         result = validateEmail(email);
         while (result == false){
            System.out.print("\n--- Email is not valid. Try again ---\" ");
            //reading from the keyboard
            email = newsc.next();
            //calling the method validateEmail to check the user's email
            result = validatePassword(email);
         }
         //setting the new email
         users.setEmail(email);
         
         
         //user password
         //asking to the user to type she/he password
         System.out.print("\n--- Please enter with your password ---\" ");
         //reading from the keyboard
         String passw = newsc.next();
         //calling the method validatePassword to check the user's password
         result = validatePassword(passw);
         while (result == false){
            System.out.print("\n--- Password is not valid. Try again ---\" ");
            //reading from the keyboard
            passw = newsc.next();
            //calling the method validatePassword to check the user's password
            result = validatePassword(passw);
         }
         //setting the new password
         users.setPassword(passw);
         
         //add new user to the ArrayList user
         user.add(users);
         //printing to the screen the new user created
         System.out.println(users.printUser());

     //returning the ArrayList user    
     return user;
   }
   
    //method created to check  the movies 
    public int CheckMovies(ArrayList<Movies> movie){
        //for loop to show all movies in the ArrayList
        for(int i=0;i<movie.size();i++){
            //show de index and the movies information
            System.out.println("["+i+"] "+movie.get(i).printMovie()+"\n");
           
        }
        
         //instance of new scanner method
         Scanner newsc = new Scanner(System.in);
         
         //asking to the user to type the movie id
         System.out.print("\n--- Please type the id of the Movie ---\" ");
         //reading from the keyboard
         int idmovie = newsc.nextInt();
       
         //calling the method validateInt to check the movies's id
         boolean result = validateInt(idmovie);
         while (result == false){
             //asking to the user to type the movie id
            System.out.print("\n--- Id is not valid. Try again ---\" ");
            //reading from the keyboard
            idmovie = newsc.nextInt();
            //calling the method validateInt to check the movies's id
            result = validateInt(idmovie);
         }
         
     //returning the movie's id 
     return idmovie;
   }
   
    //method created to print the order in a txt file 
    public void printFile(ArrayList<Order> order){  
      //creating a variable type PrintWriter
      PrintWriter writer;
      
      //try-catch to avoid problems
      try{
          //instance of new file order.txt        
          writer = new PrintWriter("order.txt");
          
          //for loop to get all orders from the ArrayList order
          for(int i=0;i<order.size();i++){
            //writer.append is used to update the value in the file
            //each information will be separated by ';'
            writer.append(order.get(i).getDate()+";");
            writer.append(order.get(i).getMovie()+";");
            writer.append(order.get(i).getQuantity()+";");
            writer.append(order.get(i).getUser()+";");
            writer.append(order.get(i).getTotalPrice()+";");
            writer.append(order.get(i).getPaymentType()+"\n");
          }
          //close the PrintWriter
          writer.close();

      //in case of error it will show a exception    
      }catch (Exception ex){
          System.out.println(ex);
      }
}
    
    //method created to check if the ArrayList is empty
    public boolean checkOrderEmpty(ArrayList<Order> order){
        //if it is empty it will return true
        if (order.isEmpty()){
            return true;
        }else{
            //if it is not empty it will return false
            return false; 
        }
    }
    
    //method created to editMovies
    public void editMovies(ArrayList<Movies> movies){
        
          //calling the method to check the movies
          int idm=CheckMovies(movies);
          
          //instance of the scanner method
          Scanner newsc = new Scanner(System.in);

         //Movie Title 
         //asking to the user to type the new movie's title
         System.out.print("\n--- Please enter with new Title of the movie ---\" ");
         //reading from the keyboard
         String nameMovie = newsc.nextLine();
         //while the nameMovie is less then 3 letters
         //it will ask to the user to type again
         while (nameMovie.length()<3){
            System.out.print("\n--- Title is not valid. Try again ---\" ");
            nameMovie = newsc.nextLine();
           
         }
         
         //Movie price
         //asking to the user to type the new movie's price
         System.out.print("\n--- Please enter with new price of the movie ---\" ");
         //reading from the keyboard
         double movieprice = newsc.nextDouble();
          //while the price is less 0r equal zero
         //it will ask to the user to type again
         while (movieprice<=0.0){
            System.out.print("\n--- Price is not valid. Please type value bigger than zero ---\" ");
            movieprice = newsc.nextDouble();
           
         }
         
         //call the method updateFile
         updateFile(idm, nameMovie,movieprice,movies);
         
         
    }
    
    
    //method created to update the Movie's file 
    public void updateFile(int idm,String nameMovie, double moviePrice,ArrayList<Movies> movies){  
    
      //creating a variable type PrintWriter
      PrintWriter writer;
      
      //try-catch to avoid problems
      try{
          
          //instance of new file movies.txt 
          writer = new PrintWriter("movies.txt");
   
          //for loop to get all movies from the ArrayList movies
          for(int i=0;i<movies.size();i++){
              //if the movie is the same id that the user wants to update
              if (i == idm){
               //the movie's title will be changed   
               writer.print(nameMovie+";");
               //writer.append is used to rewrite the value in the file
               //each information will be separated by ';'
               writer.append(movies.get(i).getGenre()+";");
               writer.append(movies.get(i).getAgerated()+";");
               writer.append(movies.get(i).getReleasedate()+";");
               writer.append(movies.get(i).getShowingin()+";");
               writer.append(movies.get(i).getRunningtime()+";");
               writer.append(movies.get(i).getBasedon()+";");
               writer.append(movies.get(i).getCast()+";");
               writer.append(movies.get(i).getDescription()+";");
               writer.append(movies.get(i).getDirector()+";");
               //the movie's price will be changed 
               writer.print(moviePrice+"\n");
              }
              else{
                //writer.append is used to rewrite the value in the file
               //each information will be separated by ';'
               writer.append(movies.get(i).getTitle()+";");
               writer.append(movies.get(i).getGenre()+";");
               writer.append(movies.get(i).getAgerated()+";");
               writer.append(movies.get(i).getReleasedate()+";");
               writer.append(movies.get(i).getShowingin()+";");
               writer.append(movies.get(i).getRunningtime()+";");
               writer.append(movies.get(i).getBasedon()+";");
               writer.append(movies.get(i).getCast()+";");
               writer.append(movies.get(i).getDescription()+";");
               writer.append(movies.get(i).getDirector()+";");
               writer.append(movies.get(i).getPrice()+"\n");
              }

          }
          //close the PrintWriter
          writer.close();
          //instance of setup
          SetUp setup = new SetUp();
          //calling the method buildMovies to update the movie's information into the ArrayList movies.
          setup.buildMovies(movies);

      //in case of error it will show a exception    
      }catch (Exception ex){
          System.out.println(ex);
      }
 }
      
      
      
    
}
