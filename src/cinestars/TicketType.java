/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinestars;

import java.util.ArrayList;

/**
 *
 * @author Claudinea de Almeida
 */
  //defining the discount
  enum TicketType {
  child(0.4), adult(0), senior(0.2);
  private double discount;

  //setting the discount according to age above
  TicketType(double discount) {
    this.discount = discount;
  }

  
  //getting the price subtracting the discount
  public double getPrice(ArrayList<Movies> movies, int i) {
    
      //getting the pricce of the movie and multipling for the discount
      double totdiscount = discount*movies.get(i).getPrice();
      //getting the original price of the movie
      double originprice = movies.get(i).getPrice();
      //subtracting the original price a discount
      double result = originprice - totdiscount;
      //returning the result of the calcule
      return result;
  }
}

