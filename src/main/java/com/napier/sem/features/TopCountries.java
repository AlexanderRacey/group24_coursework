package com.napier.sem.features;

import com.napier.sem.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Solves requests 4 - 6
 * Listing top N populated countries
 */
public class TopCountries {
    /**
     * Request 1 - All the countries in the world organised by largest population to smallest
     */
    public static ArrayList<Country> nInTheWorld(String number, Connection connection)
    {
        ArrayList<Country> countries = new ArrayList<>();
        try
        {
            System.out.println("**************************");
            System.out.println("Country    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `Population`"
                            + "FROM country "
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new country and population table if valid.
            // Take countries one by one from the top
            int num = Integer.parseInt(number);
            int count = 0;
            while (result_set.next() && count<num )
            {
                Country country = new Country();
                country.name = result_set.getString("Name");
                country.population = result_set.getInt("Population");
                System.out.println(country.name + "   |   " + country.population);

                count++;
                countries.add(country);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return countries;
    }

    /**
     * Request 2 - All the countries on a continent organised by largest population to smallest
     */
    public static ArrayList<Country> nOnContinent(String continent, String number, Connection connection)
    {
        ArrayList<Country> countries = new ArrayList<>();
        try
        {
            System.out.println("**************************");
            System.out.println(" -- " + continent.toUpperCase() + " -- ");
            System.out.println("Country    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `Population`"
                            + "FROM country "
                            + "WHERE Continent = '" + continent + "'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new country and population table if valid.
            // Take countries one by one from the top
            int num = Integer.parseInt(number);
            int count = 0;
            while (result_set.next() && count < num)
            {
                Country country = new Country();
                country.name = result_set.getString("Name");
                country.population = result_set.getInt("Population");
                System.out.println(country.name + "   |   " + country.population);

                count++;
                countries.add(country);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return countries;
    }

    /**
     * Request 3 - All the countries in a region organised by largest population to smallest
     */
    public static ArrayList<Country> nInRegion(String region, String number, Connection connection)
    {
        ArrayList<Country> countries = new ArrayList<>();
        try
        {
            System.out.println("**************************");
            System.out.println(" -- " + region.toUpperCase() + " -- ");
            System.out.println("Country    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `Population`"
                            + "FROM country "
                            + "WHERE Region = '" + region + "'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new country and population table if valid.
            // Take countries one by one from the top
            int num = Integer.parseInt(number);
            int count = 0;
            while (result_set.next() && count < num)
            {
                Country country = new Country();
                country.name = result_set.getString("Name");
                country.population = result_set.getInt("Population");
                System.out.println(country.name + "   |   " + country.population);

                count++;
                countries.add(country);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return countries;
    }
}