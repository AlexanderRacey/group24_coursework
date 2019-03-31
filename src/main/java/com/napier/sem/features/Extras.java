package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;

/**
 * Solves requests 1 - 3
 * Listing countries by population ( Descending )
 */
public class Extras
{

    /**
     * Request - World pop
     */

    public void worldPop(Connection connection)
    {
        System.out.println("World Population:");
        try
        {
            long totalPop =0;
            long pop;

            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Population`"
                            + "FROM country ";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.population = result_set.getInt("Population");
                pop = country.population;
                totalPop = totalPop + pop;
            }

            System.out.println(totalPop);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

    /**
     * Request - Population of a continent.
     */

    public void contPop(String continent, Connection connection)
    {
        System.out.println(continent + " Population:");
        try
        {
            long pop;
            long total = 0;
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Population`"
                            + "FROM country "
                            + "WHERE Continent = '" + continent +"'";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.population = result_set.getInt("Population");
                pop = country.population;
                total = total + pop;
            }

            System.out.println("Population of " + continent + ": " + total);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

    public void regionPop(String region, Connection connection)
    {
        System.out.println(region + " Population:");
        try
        {
            long pop;
            long total = 0;
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Population`"
                            + "FROM country "
                            + "WHERE Region = '" + region +"'";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.population = result_set.getInt("Population");
                pop = country.population;
                total = total + pop;
            }

            System.out.println("Population of " + region + ": " + total);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

    public void countryPop(String country, Connection connection)
    {
        System.out.println(country + " Population:");
        try
        {
            long pop;
            long total = 0;
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Population`"
                            + "FROM country "
                            + "WHERE `Name` = '" + country +"'";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                Country c = new Country();
                c.population = result_set.getInt("Population");
                pop = c.population;
                total = total + pop;
            }

            System.out.println("Population of " + country + ": " + total);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

    public void districtPop(String district, Connection connection)
    {
        System.out.println(district + " Population:");
        try
        {
            long pop;
            long total = 0;
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Population`"
                            + "FROM city "
                            + "WHERE district = '" + district +"'";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.population = result_set.getInt("Population");
                pop = city.population;
                total = total + pop;
            }

            System.out.println("Population of " + district + ": " + total);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

}