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
            int totalPop =0;
            int pop;

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
            int pop;
            int totalPop = 0;
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



}