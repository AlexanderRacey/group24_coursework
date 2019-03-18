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
     * @param continent - continent to analyze
     * @param connection - Connection to the opened database
     */

    public void inEachContinent(String continent, Connection connection)
    {
        System.out.println("Continent    |    Population Inside Cities    |    Population Outside Cities");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for first SQL statement ( -- population inside cities in each continent -- )
            String stringSelect1 =
                    " SELECT country.Continent, SUM(city.Population) AS Population, city.Name "
                            + " FROM country JOIN city ON country.Code "
                            + " GROUP BY Continent, Name ";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);
            String Continent = "";

            while (result_set1.next())
            {
                Continent = result_set1.getString("Continent");
            }

            // Create string for second SQL statement ( -- population inside cities in each continent -- )
            String stringSelect2 =
                    " SELECT DISTINCT(country.Continent) AS Continent, SUM(country.Population) AS Population "
                            + " FROM country"
                            + " GROUP BY Continent";

            // Execute SQL statement
            ResultSet result_set2 = statement.executeQuery(stringSelect2);

            // Return new continent and population(of cities) table if valid.
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

            // Create string for first SQL statement ( -- population inside cities in each continent -- )
            String stringSelect1 =
                    " SELECT country.Region, SUM(city.Population) AS Population, city.Name "
                            + "FROM country JOIN city ON country.Code = city.CountryCode "
                            + " GROUP BY Region, Name ";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);
            String Region = "";

            while (result_set1.next())
            {
                Region = result_set1.getString("Region");
            }

            // Create string for second SQL statement ( -- population inside cities in each continent -- )
            String stringSelect2 =
                    " SELECT  DISTINCT(country.Region) AS Region, SUM(country.Population) AS Population "
                            + " FROM country "
                            + " GROUP BY Region ";

            // Execute SQL statement
            ResultSet result_set2 = statement.executeQuery(stringSelect2);

            // Return new region with cities and population(of cities) table if valid.
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

            // Create string for first SQL statement ( -- population inside cities in each continent -- )
            String stringSelect1 =
                    " SELECT country.Name, SUM(city.Population) AS Population, city.Name AS cName" +
                            " FROM country JOIN city ON country.Code = city.CountryCode " +
                            " GROUP BY Name, cName ";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);
            String Country = "";

            while (result_set1.next())
            {
                Country = result_set1.getString("Country");
            }

            // Create string for second SQL statement ( -- population inside cities in each continent -- )
            String stringSelect2 =
                    " SELECT  DISTINCT(country.Name) AS Name, SUM(country.Population) AS Population "
                            + " FROM country"
                            + " GROUP BY Name";

            // Execute SQL statement
            ResultSet result_set2 = statement.executeQuery(stringSelect2);

            // Return new country and population(of cities) table if valid.
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
}