package com.napier.sem.features;

import com.napier.sem.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TopCountries {
    /**
     * lists the top n countries in the world and orders by population
     * @param number selects how many are returned
     * @param connection
     * @return arrayList of countries
     */
    public static ArrayList<Country> nInTheWorld(String number, Connection connection)
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
            int num = Integer.parseInt(number);
            int count = 0;
            while (result_set.next() && count<num )
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
     * lists n countries on a continent and orders them by population from largest to smallest
     * @param continent selects continent
     * @param number selects how many countries are returned
     * @param connection
     * @return ArrayList of countries
     */
    public static ArrayList<Country> nOnContinent(String continent, String number, Connection connection)
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
            int num = Integer.parseInt(number);
            int count = 0;
            while (result_set.next() && count < num)
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
     * lists n countries on a region and orders them by population from largest to smallest
     * @param region selects region
     * @param number selects how many countries are returned
     * @param connection
     * @return ArrayList of countries
     */
    public static ArrayList<Country> nInRegion(String region, String number, Connection connection)
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
            int num = Integer.parseInt(number);
            int count = 0;
            while (result_set.next() && count < num)
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