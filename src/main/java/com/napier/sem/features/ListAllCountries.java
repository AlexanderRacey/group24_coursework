package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;

/**
 * Solves requests 1 - 3
 * Listing countries by population ( Descending )
 */
public class ListAllCountries {

    /**
     * Request 1 - All the countries in the world organised by largest population to smallest
     * @param connection - Connection to the opened database
     */
    public void inTheWorld(Connection connection)
    {
        System.out.println("Country    |    Population");
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
     * Request 2 - All the countries on a continent organised by largest population to smallest
     * @param continent - continent to analyze
     * @param connection - Connection to the opened database
     */
    public void onContinent(String continent, Connection connection)
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
     * Request 3 - All the countries in a region organised by largest population to smallest
     * @param region - Region to analyze
     * @param connection - Connection to the opened database
     */
    public void inRegion(String region, Connection connection)
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
