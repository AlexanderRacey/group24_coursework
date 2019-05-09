package com.napier.sem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Represents a country
 */
public class Country {

    // Name
    public String name;

    // Continent
    public String continent;

    // Region
    public String region;

    // Area
    public double surface_area;

    // Population
    public int population;

    //World Pop
    public long WorldPopulation;

    // Population inside cities
    public long popCiLong;

    // Independence year
    public int indepentence_year;

    // Life expectancy
    public double life_expectancy;

    // Gross National Product - CURRENT
    public double gnp;

    // Gross National Product - PREVIOUS
    public double gnpold;

    // Local name
    public String local_name;

    // Type of government
    public String government_form;

    // Head of state name
    public String head_of_state;

    // Capital
    public String capital;

    // 3 Letter code
    public String code;

    // 2 Letter code
    public String code_short;
    
    // Spoken languages
    public ArrayList<Language> languages;
}
