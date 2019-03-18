package com.napier.sem;

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

    // Independence year
    public int indepentence_year;

    // Life expectancy
    public double life_expectancy;

    // Gross National Product - CURRENT
    public double gnp;

    // Goss National Product - PREVIOUS
    public double gnpold;

    // Local name
    public String local_name;

    // Type of government
    public String government_form;

    // Head of state name
    public String head_of_state;

    // Capital
    public int capital;

    // 3 Letter code
    public String code;

    // 2 Letter code
    public String code_short;
    
    // Spoken languages
    public ArrayList<Language> languages;

    public Country()
    {

    }

    public Country(String code,
            String name,
            String continent,
            String region,
            Float surface_area,
            Integer indepentence_year,
            Float life_expectancy,
            Float gnp,
            Float gnpold,
            String local_name,
            String government_form,
            String head_of_state,
            Integer capital,
            String code_short)

    {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surface_area = surface_area;
        this.indepentence_year = indepentence_year;
        this.life_expectancy = life_expectancy;
        this.gnp = gnp;
        this.gnpold = gnpold;
        this.local_name = local_name;
        this.government_form = government_form;
        this.head_of_state = head_of_state;
        this.capital = capital;
        this.code_short = code_short;
    }

}
