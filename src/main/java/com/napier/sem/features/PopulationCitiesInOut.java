package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;
import java.util.ArrayList;

public class PopulationCitiesInOut {

    /**
     * shows the population of people, people living in cities, and people not living in cities in each continent
     * @param connection
     * @return country with the population
     */
    public static ArrayList<Country> inEachContinent(Connection connection)
    {
        try
        {
            // Prints out list headers
            System.out.println("***********************************************************************************");
            System.out.println("Continent | Cont. Pop | City Pop | City Pop % | Out of City Pop | Out of City Pop %");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement ( -- population inside cities in each continent -- )
            String stringSelect1 =
                    " SELECT DISTINCT country.Continent AS dContinent," +
                            " SUM(DISTINCT country.Population) AS coPopulation," +
                            " SUM(city.Population) AS ciPopulation "
                         + " FROM country JOIN city ON country.Code = city.CountryCode "
                         + " WHERE country.Code = city.CountryCode "
                         + " GROUP BY dContinent ";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            ArrayList<Country> country = new ArrayList<Country>();

            // Print out results of SQl statement
            while (result_set1.next())
            {
                Country cnt = new Country();
                City cCity = new City();

                cnt.popCiLong = result_set1.getLong("coPopulation");
                cnt.continent = result_set1.getString("dContinent");
                cCity.popCoLong = result_set1.getLong("ciPopulation");

                // Calculates percentages of populations
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
            // Error message when continents are not found
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
            return null;
        }
    }

    /**
     * shows the population of people, people living in cities, and people not living in cities in each region
     * @param connection
     * @return country with the population
     */
    public static ArrayList<Country> inEachRegion(Connection connection)
    {
        try
        {
            // Prints out list headers
            System.out.println("*********************************************************************************");
            System.out.println("Region | Region Pop | City Pop | City Pop % | Out of City Pop | Out of City Pop %");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement ( -- population inside cities in each continent -- )
            String stringSelect1 =
                    " SELECT DISTINCT country.Region AS dRegion," +
                            " SUM(DISTINCT country.Population) AS coPopulation," +
                            " SUM(city.Population) AS ciPopulation "
                            + " FROM country JOIN city ON country.Code = city.CountryCode "
                            + " WHERE country.Code = city.CountryCode "
                            + " GROUP BY dRegion ";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            ArrayList<Country> country = new ArrayList<Country>();

            // Print out results of SQl statement
            while (result_set1.next())
            {
                Country cnt = new Country();
                City cCity = new City();

                cnt.region = result_set1.getString("dRegion");
                cnt.popCiLong = result_set1.getLong("coPopulation");
                cCity.popCoLong = result_set1.getLong("ciPopulation");

                // Calculates percentages of populations
                System.out.println(cnt.region + "    |    "
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
            // Error message when regions are not found
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
            return null;
        }
    }

    /**
     * shows the population of people, people living in cities, and people not living in cities in each country
     * @param connection
     * @return country with the population
     */
    public static ArrayList<Country> inEachCountry(Connection connection)
    {
        try
        {
            // Prints out list headers
            System.out.println("************************************************************************************");
            System.out.println("Country | Country Pop | City Pop | City Pop % | Out of City Pop | Out of City Pop %");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement ( -- population inside cities in each continent -- )
            String stringSelect1 =
                    " SELECT DISTINCT country.Name AS dCountry," +
                            " SUM(DISTINCT country.Population) AS coPopulation," +
                            " SUM(city.Population) AS ciPopulation "
                            + " FROM country JOIN city ON country.Code = city.CountryCode "
                            + " WHERE country.Code = city.CountryCode "
                            + " GROUP BY dCountry ";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            ArrayList<Country> country = new ArrayList<Country>();

            // Print out results of SQl statement
            while (result_set1.next())
            {
                Country cnt = new Country();
                City cCity = new City();

                cnt.name = result_set1.getString("dCountry");
                cnt.popCiLong = result_set1.getLong("coPopulation");
                cCity.popCoLong = result_set1.getLong("ciPopulation");

                // Calculates percentages of populations
                System.out.println(cnt.name + "    |    "
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
            // Error message when countries are not found
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
            return null;
        }
    }
}