package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;

/**
 * Solves requests 23 - 25
 * Listing population of people in and out of cities
 */

public class PopulationCitiesInOut {

    /**
     * Request 23 - The population of people, people living in cities, and people not living in cities in each continent.
     * @param connection - Connection to the opened database
     */

    public void inEachContinent(String continent, Connection connection)
    {
        System.out.println("Continent    |    Population Inside Cities    |    Population Outside Cities");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create strings for SQL statements
            String stringSelect =
                    "SELECT (`Continent`, `Population` FROM country) AS PopOutCities"
                            + "FROM country "
                            + "WHERE Continent = '" + continent + "'"
                            + "GROUP BY Continent";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.continent = result_set.getString("Continent");
                country.population = result_set.getInt("Population Inside Cities");
                System.out.println(country.continent + "   |   " + country.population);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

    /**
     * Request 24 - The population of people, people living in cities, and people not living in cities in each region.
     * @param continent - continent to analyze
     * @param connection - Connection to the opened database
     */
    public void inEachRegion(String continent, Connection connection)
    {
        System.out.println(" -- " + continent.toUpperCase() + " -- ");
        System.out.println("Region    |    Population Inside Cities    |    Population Outside Cities");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `Population`"
                            + "FROM country "
                            + "WHERE Continent = '" + continent + "'"
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.name = result_set.getString("Name");
                country.population = result_set.getInt("Population");
                System.out.println(country.name + "   |   " + country.population);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

    /**
     * Request 25 - The population of people, people living in cities, and people not living in cities in each country.
     * @param connection - Connection to the opened database
     */
    public void inEachCountry(Connection connection)
    {
        System.out.println("Country    |    Population Inside Cities    |    Population Outside Cities");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Population`"
                            + "FROM city "
                            + "GROUP BY CountryCode";
                            //+ "INNER JOIN country ON city.CountryCode = country.Code"
                            //+ "ORDER BY CountryCode ";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {

                Country country = new Country();
                country.name = result_set.getString("Name");
                country.population = result_set.getInt("Population Inside Cities");
                System.out.println(country.name + "   |   " + country.population);

                /*
                City city = new City();
                city.name = result_set.getString("Name");
                city.population = result_set.getInt("Population");
                System.out.println(city.name + "   |   " + city.population);
                */
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }
}