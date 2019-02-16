
package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;

public class ListAllCapitalCities {

    public void inTheWorld(Connection connection)
    {
        System.out.println("Name    |    Population");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT  city.`Name`, city.`Population`"
                            + "FROM country JOIN city on country.Code = city.CountryCode "
                            //+ "WHERE Code = 'AFG'"
                            + "WHERE country.`Capital` = city.`ID`"
                            + "ORDER BY city.`Population` DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                /*
                Country country = new Country();
                country.name = result_set.getString("Name");
                //country.population = result_set.getInt("Population");
                country.capital = result_set.getString("country.`Capital'");
                */
                City city = new City();
                city.name = result_set.getString("Name");
                city.population = result_set.getInt("Population");

                System.out.println(city.name + "   |   " + city.population);

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }



/**
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
                    "SELECT `city.Name`, `city.Population`"
                            + "FROM city JOIN country ON city.CountryCode = country.Code "
                            + "WHERE country.Code = '" + continent + "'";
                            //+ "WHERE CountryCode = '" + continent + "'";
                            //+ "WHERE name = 'kabul'";
                            //+ "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.name = result_set.getString("city.Name");
                //city.country_code = result_set.getString("CountryCode");
                city.population = result_set.getInt("city.Population");
                System.out.println(city.name + "   |   " + city.population);

                //Country country = new Country();
                //country.name = result_set.getString("Name");

                //System.out.println(country.name + "   |   " + city.population);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }
 **/
}