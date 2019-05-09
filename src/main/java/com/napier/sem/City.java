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
    public String district;

    // Population
    public int population;

    //dictrict population
    public long districtPopulation;

    // Population inside cities
    public long popCoLong;

    // Population outside cities
    public int popOut;

    /**
     * Prints the details of the city to the console
     */
    public void print(){
        System.out.println(this.name + " with a population of "
                            + this.population + " is located in the "
                            + this.district + " district, of "
                            + this.country_code);
    }
}
