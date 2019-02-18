package com.napier.sem;

/**
 * Represents a city
 */
public class City {

    // City name
    public String name;

    // Country
    public String country_code;

    // District
    public String disctrict;

    // Population
    public int population;

    /**
     * Prints the details of the city to the console
     */
    public void print(){
        System.out.println(this.name + " with a population of "
                            + this.population + " is located in the "
                            + this.disctrict + " district, of "
                            + this.country_code);
    }
}
