package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;

/**
 * Solves requests 1 - 3
 * Listing countries by population ( Descending )
 */
public class ListAllCities
{

    /**
     * Request 1 - All the countries in the world organised by largest population to smallest
     * @param connection - Connection to the opened database
     */

    public void citiesInWorld(Connection connection)
    {
        System.out.println("City    |    Population");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `Population`"
                            + "FROM city "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
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
     * Request 8 - List all cities in a continent by order of size
     */

    public void citiesContinent(String continent, Connection connection)
    {
        System.out.println("-- " + continent.toUpperCase() + " --");
        System.out.println("City    |     Population");

        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT city.`Name`, city.`Population`"
                            + "FROM country JOIN city on country.Code = city.CountryCode "
                            + "WHERE  country.`Continent` = '" + continent + "'"
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
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
     * Requirement 9 - list all cities in a region
     */

    public void citiesInRegion(String region, Connection connection)
    {
        System.out.println("-- " + region.toUpperCase() + " --");
        System.out.println("City    |     Population");

        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT city.`Name`, city.`Population`"
                            + "FROM country JOIN city on country.Code = city.CountryCode "
                            + "WHERE  country.`Region` = '" + region + "'"
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
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
     * Requirement 10 - List All Cities in Country
     */


    public void citiesInCountry(String countryName, Connection connection)
    {
        System.out.println("-- " + countryName.toUpperCase() + " --");
        System.out.println("City    |     Population");

        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect1 =
                    "SELECT `Code`"
                            + "FROM country "
                            + "WHERE Name = '" + countryName + "'";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            String countryCode ="";

            while (result_set1.next())
            {
                countryCode = result_set1.getString("Code");
            }

            String stringSelect2 = "SELECT `Name`, `Population`"
                    + "FROM city "
                    + "WHERE CountryCode = '" + countryCode +"'"
                    + "ORDER BY Population DESC";

            ResultSet result_set2 = statement.executeQuery(stringSelect2);

            while (result_set2.next())
            {
                City city = new City();
                city.name = result_set2.getString("Name");
                city.population = result_set2.getInt("Population");
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
     * Request 11 - List All cities in district
     */

    public void citiesInDistrict(String district, Connection connection)
    {
        System.out.println("-- " + district.toUpperCase() + " --");
        System.out.println("City    |    Population");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `Population`"
                            + "FROM city "
                            + "WHERE district = '" + district +"'"
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
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



}