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

    public void inEachContinent(Connection connection)
    {
        System.out.println("City    |    Population");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `Population`"
                            + "FROM country "
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
     * Request 24 - The population of people, people living in cities, and people not living in cities in each region.
     * @param continent - continent to analyze
     * @param connection - Connection to the opened database
     */
    public void inEachRegion(String continent, Connection connection)
    {
        System.out.println(" -- " + continent.toUpperCase() + " -- ");
        System.out.println("Country    |    Population");
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
     * @param region - Region to analyze
     * @param connection - Connection to the opened database
     */
    public void inEachCountry(String region, Connection connection)
    {
        System.out.println(" -- " + region.toUpperCase() + " -- ");
        System.out.println("Country    |    Population");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `Population`"
                            + "FROM country "
                            + "WHERE Region = '" + region + "'"
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
}