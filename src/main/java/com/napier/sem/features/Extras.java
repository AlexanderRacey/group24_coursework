package com.napier.sem.features;

import com.napier.sem.*;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;

public class Extras
{

    /**
     *  gets population of world
     * @param connection
     * @return ArrayList of country with world population
     */
    public static ArrayList<Country> worldPop(Connection connection)
    {
        ArrayList<Country> worldPopulation = new ArrayList<Country>();
        try
        {
            System.out.println("*****************");
            System.out.println("World Population:");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT SUM(Population) AS Population "
                            + "FROM country";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.WorldPopulation = result_set.getLong("Population");
                System.out.println(country.WorldPopulation);

                worldPopulation.add(country);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return worldPopulation;
    }


    /**
     * gets continent
     * @param continent selects the continent
     * @param connection
     * @return ArrayList of country with continent population
     */
    public static ArrayList<Country> contPop(String continent, Connection connection)
    {
        ArrayList<Country> contPopulation = new ArrayList<Country>();
        try
        {
            System.out.println("************************");
            System.out.println(continent + " Population:");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT SUM(Population) AS Population "
                            + "FROM country "
                            + "WHERE Continent = '" + continent +"'";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.WorldPopulation = result_set.getLong("Population");
                System.out.println(country.WorldPopulation);

                contPopulation.add(country);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return contPopulation;
    }

    /**
     * gets the population of a region
     * @param region selects the region
     * @param connection
     * @return ArrayList of country with region population in WorldPopulation
     */
    public static ArrayList<Country> regionPop(String region, Connection connection)
    {
        ArrayList<Country> regionPopulation = new ArrayList<Country>();
        try
        {
            System.out.println("*********************");
            System.out.println(region + " Population:");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT SUM(Population) AS Population "
                            + "FROM country "
                            + "WHERE Region = '" + region +"'";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.WorldPopulation = result_set.getLong("Population");
                System.out.println(country.WorldPopulation);

                regionPopulation.add(country);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return regionPopulation;
    }

    /**
     * Gets population of country
     * @param searchCountry selects the country
     * @param connection
     * @return ArrayList of country with population
     */
    public static ArrayList<Country> countryPop(String searchCountry, Connection connection)
    {
        ArrayList<Country> countryPopulation = new ArrayList<Country>();
        try
        {
            System.out.println("****************************");
            System.out.println(searchCountry + " Population:");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT SUM(Population) AS Population "
                            + "FROM country "
                            + "WHERE `Name` = '" + searchCountry +"'";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.population = result_set.getInt("Population");
                System.out.println(country.population);

                countryPopulation.add(country);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return countryPopulation;
    }

    /**
     * Gets Population of District
     * @param district selects district
     * @param connection
     * @return ArrayList with District population
     */
    public static ArrayList<City> districtPop(String district, Connection connection)
    {
        ArrayList<City> districtPopulation = new ArrayList<City>();
        try
        {
            System.out.println("***********************");
            System.out.println(district + " Population:");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT SUM(Population) AS Population "
                            + "FROM city "
                            + "WHERE district = '" + district +"'";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.districtPopulation = result_set.getLong("Population");
                System.out.println(city.districtPopulation);

                districtPopulation.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return districtPopulation;
    }

    /**
     * Gets City population
     * @param selectCity selects city
     * @param connection
     * @return ArrayList of city with a population
     */
    public static ArrayList<City> cityPop(String selectCity, Connection connection)
    {
        ArrayList<City> cityPopulation = new ArrayList<City>();
        try
        {
            System.out.println("*************************");
            System.out.println(selectCity + " Population:");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT SUM(Population) AS Population "
                            + "FROM city "
                            + "WHERE `Name` = '" + selectCity +"'";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.population = result_set.getInt("Population");
                System.out.println(city.population);

                cityPopulation.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cityPopulation;
    }
}