
package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;

public class ListAllCapitalCities {

    //lists all the capital cities in a continent from largest population to smallest
    public void onContinent(String continent, Connection connection)
    {
        System.out.println(" -- " + continent.toUpperCase() + " -- ");
        System.out.println("Country    |    Capital");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `CountryCode`"
                            + "FROM city "
                            //+ "WHERE Continent = '" + continent + "'"
                            + "WHERE name = 'kabul'";
                            //+ "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.country_code = result_set.getString("CountryCode");
                System.out.println(city.name + "   |   " + city.country_code);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }
}