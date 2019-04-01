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
        System.out.println("Continent    |    Population Inside Cities    |    Population Outside Cities");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for first SQL statement ( -- population inside cities in each continent -- )
            String stringSelect1 =
                    " SELECT DISTINCT country.Continent AS Continent, SUM(city.Population) AS Population, SUM(country.Population) AS PopulationC, city.Name "
                            + " FROM country JOIN city ON country.Code = city.CountryCode "
                            + " GROUP BY Continent, Name";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            while (result_set1.next())
            {
                Country country = new Country();
                City city = new City();

                country.name = result_set1.getString("Continent");
                city.population = result_set1.getInt("Population");
                country.population = result_set1.getInt("PopulationC");
                System.out.println(country.name + "   |   " + city.population + "    |    " + country.population);
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
     * @param connection - Connection to the opened database
     */
    public void inEachRegion(Connection connection)
    {
        System.out.println("Region    |    Population Inside Cities    |    Population Outside Cities");
        try
        {
            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for first SQL statement ( -- population inside cities in each continent -- )
            String stringSelect1 =
                    " SELECT DISTINCT country.Region AS Region, SUM(city.Population) AS PopIn, (SUM(country.Population) - PopIn) AS PopOut, city.Name "
                            + " FROM country JOIN city ON country.Code = city.CountryCode "
                            + " GROUP BY Region, Name ";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            while (result_set1.next())
            {
                Country country = new Country();
                City city = new City();

                country.name = result_set1.getString("Region");
                city.population = result_set1.getInt("PopIn");
                country.population = result_set1.getInt("PopOut");
                System.out.println(country.name + "   |   " + city.population + "    |    " + country.population);
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
                    " SELECT DISTINCT country.Name AS Name, SUM(city.Population) AS Population, SUM(country.Population) AS PopulationC, city.Name AS cName" +
                            " FROM country JOIN city ON country.Code = city.CountryCode " +
                            " GROUP BY Name, cName ";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            // Return new country and population(of cities) table if valid.
            while (result_set1.next())
            {
                // Population inside city
                Country country = new Country();
                City city = new City();

                country.name = result_set1.getString("Country");
                city.population = result_set1.getInt("Population");
                country.population = result_set1.getInt("PopulationC");
                System.out.println(country.name + "   |   " + city.population + "    |    " + country.population);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }
}