package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Solves requests 23 - 25
 * Listing population of people in and out of cities
 */

public class PopulationCitiesInOut {

    /**
     * Request 23 - The population of people, people living in cities, and people not living in cities in each
     * continent.
     *
     * @param connection - Connection to the opened database
     */

    public static ArrayList<Country> inEachContinent(Connection connection)
    {
        //ArrayList<City> cities = new ArrayList<>();
        //ArrayList<Country> countries = new ArrayList<>();

        try
        {
            // Prints out list headers
            System.out.println("**************************************************************************************");
            System.out.println(" Continent | Continent Pop | City Pop | City Pop % | Not a City Pop | Not a City Pop %");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement ( -- population inside cities in each continent -- )
            String stringSelect1 =
                    " SELECT DISTINCT country.Continent AS dContinent," +
                            " SUM(DISTINCT country.Population) AS coPopulation," +
                            " SUM(city.Population) AS cPopulation "
                         + " FROM country JOIN city ON country.Code = city.CountryCode "
                         + " WHERE country.Code = city.CountryCode "
                         + " GROUP BY dContinent ";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            ArrayList<Country> country = new ArrayList<Country>();

            while (result_set1.next())
            {
                Country cnt = new Country();
                City cCity = new City();

                cnt.popCiLong = result_set1.getLong("coPopulation");
                cnt.continent = result_set1.getString("dContinent");
                cCity.popCoLong = result_set1.getLong("cPopulation");

                System.out.println(cnt.continent + "    |    "
                        + cnt.popCiLong + "    |    "
                        + cCity.popCoLong + "    |    "
                        + (((cCity.popCoLong * 100) / (cnt.popCiLong))) + "%" + "    |    "
                        + (cnt.popCiLong - cCity.popCoLong) + "    |    "
                        + (100 - ((cCity.popCoLong * 100) / (cnt.popCiLong))) + "%");

                country.add(cnt);
            }
            System.out.println("\n");
            return country;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
            return null;
        }
    }

    /**
     * Request 24 - The population of people, people living in cities, and people not living in cities in each region.
     * @param connection - Connection to the opened database
     */
    public static ArrayList<City> inEachRegion (Connection connection)
    {
        ArrayList<City> cities = new ArrayList<City>();

        try
        {
            // Prints out list headers
            System.out.println("*************************************************************************");
            System.out.println("Region    |    Population Inside Cities    |    Population Outside Cities");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for first SQL statement ( -- population inside cities in each region -- )
            String stringSelect1 =
                    " SELECT DISTINCT country.Region AS Region, SUM(DISTINCT city.Population) AS Population," +
                            " SUM(DISTINCT country.Population) AS PopulationC, city.Name "
                         + " FROM country JOIN city ON country.Code = city.CountryCode "
                         + " WHERE country.Code = city.CountryCode "
                         + " GROUP BY Region, Name";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            while (result_set1.next())
            {
                Country country = new Country();
                City city = new City();

                country.name = result_set1.getString("Region");
                city.population = result_set1.getInt("Population");
                country.population = result_set1.getInt("PopulationC");
                System.out.println(country.name + "   |   " + city.population + "    |    " + country.population);

                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return (cities);
    }

    /**
     * Request 25 - The population of people, people living in cities, and people not living in cities in each country.
     * @param connection - Connection to the opened database
     */
    public static ArrayList<City> inEachCountry(Connection connection)
    {
        ArrayList<City> cities = new ArrayList<City>();


        try
        {
            // Prints out list headers
            System.out.println("**************************************************************************");
            System.out.println("Country    |    Population Inside Cities    |    Population Outside Cities");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for first SQL statement ( -- population inside cities in each country -- )
            String stringSelect1 =
                    " SELECT DISTINCT country.Name AS Country, SUM(DISTINCT city.Population) AS Population, " +
                            "SUM(DISTINCT country.Population) AS PopulationC, city.Name "
                         + " FROM country JOIN city ON country.Code = city.CountryCode "
                         + " WHERE country.Code = city.CountryCode "
                         + " GROUP BY Country, Name";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            while (result_set1.next())
            {
                Country country = new Country();
                City city = new City();

                country.name = result_set1.getString("Country");
                city.population = result_set1.getInt("Population");
                country.population = result_set1.getInt("PopulationC");
                System.out.println(country.name + "   |   " + city.population + "    |    " + country.population);

                cities.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }
}