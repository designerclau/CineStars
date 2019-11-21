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
public class Movies {
 
    //Declaration of the attributes in the class Movies    
    private String title;      //Ad Astra
    private String genre;      //fiction
    private int    agerated;   //12vyears
    private String releasedate;//18 September 2019
    private String showingin;  //2d, 3d
    private String runningtime; //123 minutes  
    private String basedon;     //book xxx
    private String cast;        //Brad Pitt, Tommy Lee Jones, Ruth Negga, Donald Sutherland
    private String description; //Astronaut Roy McBride (Brad Pitt) travels to the outer edges of the solar system to find his missing father...  
    private String director;    //James Gray
    private double price;       //price of the ticket of the movie
    
    //default constructor
    public Movies(){}

    // constructor with some parameters
    public Movies(String title, String genre, int agerated) {
        this.title = title;
        this.genre = genre;
        this.agerated = agerated;
    
    }
    
    // constructor with parameters
    public Movies(String title, String genre, int agerated, String releasedate, String showingin, String runningtime, String basedon, String cast, String description, String director, double price) {
        this.title = title;
        this.genre = genre;
        this.agerated = agerated;
        this.releasedate = releasedate;
        this.showingin = showingin;
        this.runningtime = runningtime;
        this.basedon = basedon;
        this.cast = cast;
        this.description = description;
        this.director = director;
        this.price=price;
    }

    //getting Title of the movie
    public String getTitle() {
        return title;
    }

    //Setting Title of the movie
    public void setTitle(String title) {
        this.title = title;
    }

    //getting Genre of the movie
    public String getGenre() {
        return genre;
    }

    //Setting Genre of the movie
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //getting Age rated of the movie
    public int getAgerated() {
        return agerated;
    }
    //Setting Age rated of the movie
    public void setAgerated(int agerated) {
        this.agerated = agerated;
    }

    //getting Release date of the movie
    public String getReleasedate() {
        return releasedate;
    }
    
    //Setting Release date of the movie
    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    //getting Showing in (2d or 3d) of the movie
    public String getShowingin() {
        return showingin;
    }

    //Setting Showing in (2d or 3d) of the movie
    public void setShowingin(String showingin) {
        this.showingin = showingin;
    }

    //getting Running time of the movie
    public String getRunningtime() {
        return runningtime;
    }

    //Setting Running time of the movie
    public void setRunningtime(String runningtime) {
        this.runningtime = runningtime;
    }

    //getting Based on of the movie
    public String getBasedon() {
        return basedon;
    }

    //Setting Based on of the movie
    public void setBasedon(String basedon) {
        this.basedon = basedon;
    }

    //getting cast of the movie
    public String getCast() {
        return cast;
    }

    //Setting cast of the movie
    public void setCast(String cast) {
        this.cast = cast;
    }

    //getting Desciption of the movie
    public String getDescription() {
        return description;
    }

    //Setting Desciption of the movie
    public void setDescription(String description) {
        this.description = description;
    }

    //getting director of the movie
    public String getDirector() {
        return director;
    }

    //Setting director of the movie
    public void setDirector(String director) {
        this.director = director;
    }

    //getting price of the movie
    public double getPrice() {
        return price;
    }

    //Setting price of the movie
    public void setPrice(double price) {
        this.price = price;
    }

    //method to print the Movie
    public String printMovie() 
    {
       
        String movie = "\n"+"Movie Information:" + "\n"+"Title: " + title +"\n"+"Genre: " + genre + " Age " +agerated+ "\n"+ "Cast: " + cast + "\n"+ "Cast: " + description +  "\n"+ "Price: $" + price;
            
        return movie;
    }
    
    //method toString of the movies
    @Override
    public String toString() {
        return "Movies{" + "title=" + title + ", genre=" + genre + ", agerated=" + agerated + ", releasedate=" + releasedate + ", showingin=" + showingin + ", runningtime=" + runningtime + ", basedon=" + basedon + ", cast=" + cast + ", description=" + description + ", director=" + director + '}';
    }

    
    
    
    
    
    
    
}
