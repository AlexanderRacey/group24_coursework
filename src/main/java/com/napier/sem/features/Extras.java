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

    /**
     *Request - Population of a region
     */
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

    /**
     * Request - Population of a country
     */
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

    /**
     * Request - Population of a district
     */
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

    /**
     * Request - Population of a city
     */
    public void cityPop(String city, Connection connection)
    {
        System.out.println(city + " Population:");
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
                            + "WHERE `Name` = '" + city +"'";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                City c = new City();
                c.population = result_set.getInt("Population");
                pop = c.population;
                total = total + pop;
            }

            System.out.println("Population of " + city + ": " + total);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

    /**
     * Request - Language speakers **!!NOT FINISHED!!**
     */
    /*
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
    */

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