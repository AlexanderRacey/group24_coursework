package com.napier.sem.features;

import com.napier.sem.*;

import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;

/**
 * Solves requests 1 - 3
 * Listing countries by population ( Descending )
 */
public class Extras
{

    /**
     * Request - World pop
     */

    public static ArrayList<Country> worldPop(Connection connection)
    {
        ArrayList<Country> worldPopulation = new ArrayList<Country>();
        try
        {
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
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return worldPopulation;
    }

    /**
     * Request - Population of a continent.
     */

    public static ArrayList<Country> contPop(String continent, Connection connection)
    {
        ArrayList<Country> contPopulation = new ArrayList<Country>();
        try
        {
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
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return contPopulation;
    }

    /**
     *Request - Population of a region
     */
    public static ArrayList<Country> regionPop(String region, Connection connection)
    {
        ArrayList<Country> regionPopulation = new ArrayList<Country>();
        try
        {
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
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return regionPopulation;
    }

    /**
     * Request - Population of a country
     */
    public static ArrayList<Country> countryPop(String searchCountry, Connection connection)
    {
        ArrayList<Country> countryPopulation = new ArrayList<Country>();
        try
        {
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
                country.WorldPopulation = result_set.getLong("Population");
                System.out.println(country.WorldPopulation);

                countryPopulation.add(country);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return countryPopulation;
    }

    /**
     * Request - Population of a district
     */
    public static ArrayList<City> districtPop(String district, Connection connection)
    {
        ArrayList<City> districtPopulation = new ArrayList<City>();
        try
        {
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
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return districtPopulation;
    }

    /**
     * Request - Population of a city
     */
    public static ArrayList<City> cityPop(String selectCity, Connection connection)
    {
        ArrayList<City> cityPopulation = new ArrayList<City>();
        try
        {
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
                city.districtPopulation = result_set.getLong("Population");
                System.out.println(city.districtPopulation);

                cityPopulation.add(city);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cityPopulation;
    }

    /**
     * Request - Language speakers **!!NOT FINISHED!!**
     */

    public void languageSpeakers(Connection connection)
    {
        try
        {
            String eng = "English";
            String chin = "Chinese";
            String hin = "Hindi";
            String spa = "Spanish";
            String arab = "Arabic";
            String countryCode;

            Statement statement = connection.createStatement();

            String stringSelect =
                    "SELECT `Percentage`, `CountryCode`"
                            + "FROM countryLanguage "
                            + "WHERE `Language` = '"+ eng +"' OR '"+ chin +"' OR '"+ hin + "' OR '"+ spa +"' OR '"+ arab +"'";
            ResultSet result_set = statement.executeQuery(stringSelect);

            while (result_set.next())
            {

            }

            //System.out.println("Population of " + continent + ": " + total);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }


    public void reportCountry(String country, Connection connection)
    {
        System.out.println(country + " Report:");
        try
        {
            Statement statement = connection.createStatement();
            String stringSelect =
                    "SELECT `Code`,`Name`,`Continent`,`Region`,`Population`,`Capital`"
                            + "FROM `country` "
                            + "WHERE `Name` = '" + country +"'";

            ResultSet result_set = statement.executeQuery(stringSelect);

            while (result_set.next())
            {
                Country c = new Country();
                c.code = result_set.getString("Code");
                c.name = result_set.getString("Name");
                c.continent =  result_set.getString("Continent");
                c.region = result_set.getString("Region");
                c.population = result_set.getInt("Population");
                c.capital = result_set.getString("Capital");

                System.out.println("Code: "+ c.code +"\nName: "+ c.name +"\nContinent: "+ c.continent +"\nRegion: "+ c.region +"\nPopulation: "+ c.population +"\nCapital: "+ c.capital);
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

}