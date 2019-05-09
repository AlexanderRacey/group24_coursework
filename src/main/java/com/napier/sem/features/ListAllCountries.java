package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;
import java.util.ArrayList;

public class ListAllCountries {

    /**
     * Lists all countries in the world from largest population to smallest
     * @param connection
     * @return ArrayList of countries
     */
    public static ArrayList<Country> inTheWorld(Connection connection)
    {
        ArrayList<Country> countries = new ArrayList<>();
        try
        {
            System.out.println("******************************************************************************");
            System.out.println("Code   |   Country   |   Continent   |   Region   |   Population   |   Capital");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Code`, `Name`, `Continent`, `Region`, `Population`, `Capital`"
                            + "FROM country "
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.code = result_set.getString("Code");
                country.name = result_set.getString("Name");
                country.continent = result_set.getString("Continent");
                country.region = result_set.getString("Region");
                country.population = result_set.getInt("Population");
                country.capital = result_set.getString("Capital");
                System.out.println(country.code + "   |   " + country.name + "   |   " + country.continent + "   |   "
                        + country.region + "   |   " + country.population + "   |   " + country.capital);

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
     * lists all countries on a continent from largest to smallest population
     * @param continent selects continent
     * @param connection
     * @return ArrayList of countries
     */
    public static ArrayList<Country> onContinent(String continent, Connection connection)
    {
        ArrayList<Country> countries = new ArrayList<>();
        try
        {
            System.out.println("******************************************************************************");
            System.out.println(" -- " + continent.toUpperCase() + " -- ");
            System.out.println("Code   |   Country   |   Continent   |   Region   |   Population   |   Capital");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Code`, `Name`, `Continent`, `Region`, `Population`, `Capital`"
                            + "FROM country "
                            + "WHERE Continent = '" + continent + "'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.code = result_set.getString("Code");
                country.name = result_set.getString("Name");
                country.continent = result_set.getString("Continent");
                country.region = result_set.getString("Region");
                country.population = result_set.getInt("Population");
                country.capital = result_set.getString("Capital");
                System.out.println(country.code + "   |   " + country.name + "   |   " + country.continent + "   |   "
                        + country.region + "   |   " + country.population + "   |   " + country.capital);

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
     * lists all countries on a region from largest to smallest population
     * @param region selects region
     * @param connection
     * @return ArrayList of countries
     */
    public static ArrayList<Country> inRegion(String region, Connection connection)
    {
        ArrayList<Country> countries = new ArrayList<>();
        try
        {
            System.out.println("******************************************************************************");
            System.out.println(" -- " + region.toUpperCase() + " -- ");
            System.out.println("Code   |   Country   |   Continent   |   Region   |   Population   |   Capital");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Code`, `Name`, `Continent`, `Region`, `Population`, `Capital`"
                            + "FROM country "
                            + "WHERE Region = '" + region + "'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                Country country = new Country();
                country.code = result_set.getString("Code");
                country.name = result_set.getString("Name");
                country.continent = result_set.getString("Continent");
                country.region = result_set.getString("Region");
                country.population = result_set.getInt("Population");
                country.capital = result_set.getString("Capital");
                System.out.println(country.code + "   |   " + country.name + "   |   " + country.continent + "   |   "
                        + country.region + "   |   " + country.population + "   |   " + country.capital);

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
