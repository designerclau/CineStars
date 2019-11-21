/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinestars;

/**
 *
 * @author Claudinea de Almeida
 */
public class User {
    
    //Declaration of the attributes in the class User 
    private int id;
    private String name;
    private int age;
    private String cardnumber;
    private String email;
    private String password;
    
    //default constructor
    public User(){}

    // constructor with parameters
    public User(int id, String name, int age, String cardnumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cardnumber = cardnumber;
        this.email = email;
        this.password = password;
    }

   // constructor with parameters id and password
   public User(int id,String password){
       this.id = id;
       this.password = password;
   }

    //getting Id of the User
    public int getId() {
        return id;
    }

    //setting Id of the User
    public void setId(int id) {
        this.id = id;
    }

    //getting Name of the User
    public String getName() {
        return name;
    }
    
    //setting Name of the User
    public void setName(String name) {
        this.name = name;
    }

    //getting Age of the User
    public int getAge() {
        return age;
    }

    //setting Age of the User
    public void setAge(int age) {
        this.age = age;
    }

    //getting Card number of the User
    public String getCardnumber() {
        return cardnumber;
    }

    //setting Card number of the User
    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    //getting email of the User
    public String getEmail() {
        return email;
    }

    //setting email of the User
    public void setEmail(String email) {
        this.email = email;
    }

    //getting password of the User
    public String getPassword() {
        return password;
    }

    //setting password of the User
    public void setPassword(String password) {
        this.password = password;
    }

    //method to print the user
     public String printUser() 
    {
        
        String user = "\n"+"User Information:" + "\n"+"Id: " + id +"\n"+"Name: " + name +"\n"+ "email: " + email +"\n";
             
        return user;
    }
    
     //method to toString the user
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", age=" + age + ", password=" + password + ", email=" + email + '}';
    }

    
    
       
    
    
    
}
