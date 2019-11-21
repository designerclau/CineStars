/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinestars;

import java.text.DecimalFormat;

/**
 *
 * @author Claudinea de Almeida
 */
public class Order {
    
    //Declaration of the attributes in the class Order 
    private String date;
    private String movie;
    private int quantity;
    private int userid;
    private double totalPrice;
    private String paymentType;
   

    //default constructor
    public Order(){}

    //constructor with parameters
    public Order(String date, String movie, int quantity, int userid, double totalPrice, String paymentType) {
        
        this.date = date;
        this.movie = movie;
        this.quantity = quantity;
        this.userid = userid;
        this.totalPrice = totalPrice;
        this.paymentType=paymentType;
      
    }

    //getting date of the order
    public String getDate() {
        return date;
    }

    //setting date of the order
    public void setDate(String date) {
        this.date = date;
    }
    
    //getting Movie of the order
    public String getMovie() {
        return movie;
    }

    //setting Movie of the order
    public void setMovie(String movie) {
        this.movie = movie;
    }

    //getting quantity of the tickets of the order
    public int getQuantity() {
        return quantity;
    }

     //Setting quantity of the tickets of the order
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //getting user of the order
    public int getUser() {
        return userid;
    }

    //setting user of the order
    public void setUser(int userid) {
        this.userid = userid;
    }

    //getting Total price of the order
    public double getTotalPrice() {
        return totalPrice;
    }

    //Setting Total price of the order
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //getting payment type of the order
    public String getPaymentType() {
        return paymentType;
    }

    //setting payment type of the order
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    //getting user id of the order
    public int getUserid() {
        return userid;
    }

    //setting user id of the order
    public void setUserid(int userid) {
        this.userid = userid;
    }

    //method to print the Order       
    public String printOrder() 
    {
             
        String movies = "\n"+"Order Information:" + "\n"+"Date: " + date +"\n"+"Movie: " + movie + "\n"+"Quantity " +quantity+ "\n"+ "User id: " + userid + "\n"+"Total Price: $"+ totalPrice +"\n"+"Payment Type: "+paymentType;
              
        return movies;
    }
    
    //method toString the order
    @Override
    public String toString() {
        return "Order{" + "date=" + date + ", movie=" + movie + ", quantity=" + quantity + ", userid=" + userid + ", totalPrice=" + totalPrice + ", paymentType="+paymentType+ '}';
    }

  

   

  
    
    
}
