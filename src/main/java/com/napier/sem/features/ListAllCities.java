package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;
import java.util.ArrayList;

public class ListAllCities
{
    /**
     * Request 1 - All the countries in the world organised by largest population to smallest
     * @param connection - Connection to the opened database
     */

    public static ArrayList<City> citiesInWorld(Connection connection)
    {
        ArrayList<City> cities = new ArrayList<City>();
        try
        {
            System.out.println("********************************************************");
            System.out.println("City    |    Country    |    District    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `CountryCode`, `District`, `Population`"
                            + "FROM city "
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.country_code = result_set.getString("CountryCode");
                city.district = result_set.getString("District");
                city.population = result_set.getInt("Population");
                System.out.println(city.name + "    |    " + city.country_code + "    |    " + city.district
                                    + "    |    " + city.population);

                cities.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }


    /**
     * Request 8 - List all cities in a continent by order of size
     */

    public static ArrayList<City> citiesContinent(String continent, Connection connection)
    {
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("********************************************************");
            System.out.println("-- " + continent.toUpperCase() + " --");
            System.out.println("City    |    Country    |    District    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT city.`Name`, city.`CountryCode`, city.`District`, city.`Population`"
                            + "FROM country JOIN city on country.Code = city.CountryCode "
                            + "WHERE  country.`Continent` = '" + continent + "'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.country_code = result_set.getString("CountryCode");
                city.district = result_set.getString("District");
                city.population = result_set.getInt("Population");
                System.out.println(city.name + "    |    " + city.country_code + "    |    " + city.district
                        + "    |    " + city.population);

                cities.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }

    /**
     * Requirement 9 - list all cities in a region
     */

    public static ArrayList<City> citiesInRegion(String region, Connection connection)
    {
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("********************************************************");
            System.out.println("-- " + region.toUpperCase() + " --");
            System.out.println("City    |    Country    |    District    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT city.`Name`, city.`CountryCode`, city.`District`, city.`Population`"
                            + "FROM country JOIN city on country.Code = city.CountryCode "
                            + "WHERE  country.`Region` = '" + region + "'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.country_code = result_set.getString("CountryCode");
                city.district = result_set.getString("District");
                city.population = result_set.getInt("Population");
                System.out.println(city.name + "    |    " + city.country_code + "    |    " + city.district
                        + "    |    " + city.population);

                cities.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }


    /**
     * Requirement 10 - List All Cities in Country
     */
    public static ArrayList<City> citiesInCountry(String countryName, Connection connection)
    {
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("********************************************************");
            System.out.println("-- " + countryName.toUpperCase() + " --");
            System.out.println("City    |    Country    |    District    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect1 =
                    "SELECT `Code`"
                            + "FROM country "
                            + "WHERE Name = '" + countryName + "'";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            String countryCode ="";

            while (result_set1.next())
            {
                countryCode = result_set1.getString("Code");
            }

            String stringSelect2 = "SELECT `Name`, `CountryCode`, `District`, `Population`"
                    + "FROM city "
                    + "WHERE CountryCode = '" + countryCode +"'"
                    + "ORDER BY Population DESC";

            ResultSet result_set2 = statement.executeQuery(stringSelect2);

            while (result_set2.next())
            {
                City city = new City();
                city.name = result_set2.getString("Name");
                city.country_code = result_set2.getString("CountryCode");
                city.district = result_set2.getString("District");
                city.population = result_set2.getInt("Population");
                System.out.println(city.name + "    |    " + city.country_code + "    |    " + city.district
                        + "    |    " + city.population);

                cities.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }

    /**
     * Request 11 - List All cities in district
     */

    public static ArrayList<City> citiesInDistrict(String district, Connection connection)
    {
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("********************************************************");
            System.out.println("-- " + district.toUpperCase() + " --");
            System.out.println("City    |    Country    |    District    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `CountryCode`, `District`, `Population`"
                            + "FROM city "
                            + "WHERE district = '" + district +"'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new city and population table if valid.
            // Take cities one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.country_code = result_set.getString("CountryCode");
                city.district = result_set.getString("District");
                city.population = result_set.getInt("Population");
                System.out.println(city.name + "    |    " + city.country_code + "    |    " + city.district
                        + "    |    " + city.population);

                cities.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }

    /**
     * Request 12 - top n world
     */
    public static ArrayList<City> nCitiesInWorld(String number, Connection connection)
    {
        ArrayList<City> cities = new ArrayList<>();
        try
        {
            System.out.println("********************************************************");
            System.out.println("City    |    Country    |    District    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `CountryCode`, `District`, `Population`"
                            + "FROM city "
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new city and population table if valid.
            // Take cities one by one from the top

            int num = Integer.parseInt(number);

            int count =0;

            while (result_set.next() && count<num)
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.country_code = result_set.getString("CountryCode");
                city.district = result_set.getString("District");
                city.population = result_set.getInt("Population");
                System.out.println(city.name + "    |    " + city.country_code + "    |    " + city.district
                        + "    |    " + city.population);

                count++;
                cities.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }

    /**
     * Request 13 - top n cities in Continent
     */

    public static ArrayList<City> nCitiesContinent(String continent, String number, Connection connection)
    {
        ArrayList<City> cities = new ArrayList<City>();
        try
        {
            System.out.println("********************************************************");
            System.out.println("-- " + continent.toUpperCase() + " --");
            System.out.println("City    |    Country    |    District    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT city.`Name`, city.`CountryCode`, city.`District`, city.`Population`"
                            + "FROM country JOIN city on country.Code = city.CountryCode "
                            + "WHERE  country.`Continent` = '" + continent + "'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new country and population table if valid.
            // Take countries one by one from the top
            int num = Integer.parseInt(number);
            int count = 0;

            while (result_set.next() && count<num)
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.country_code = result_set.getString("CountryCode");
                city.district = result_set.getString("District");
                city.population = result_set.getInt("Population");
                System.out.println(city.name + "    |    " + city.country_code + "    |    " + city.district
                        + "    |    " + city.population);

                count++;
                cities.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }

    /**
     * Request 14 - Top n Region
     */

    public static ArrayList<City> nCitiesInRegion(String region, String number, Connection connection)
    {
        ArrayList<City> cities = new ArrayList<City>();
        try
        {
            System.out.println("********************************************************");
            System.out.println("-- " + region.toUpperCase() + " --");
            System.out.println("City    |    Country    |    District    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT city.`Name`, city.`CountryCode`, city.`District`, city.`Population`"
                            + "FROM country JOIN city on country.Code = city.CountryCode "
                            + "WHERE  country.`Region` = '" + region + "'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new country and population table if valid.
            // Take countries one by one from the top
            int num = Integer.parseInt(number);
            int count = 0;

            while (result_set.next() && count < num)
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.country_code = result_set.getString("CountryCode");
                city.district = result_set.getString("District");
                city.population = result_set.getInt("Population");
                System.out.println(city.name + "    |    " + city.country_code + "    |    " + city.district
                        + "    |    " + city.population);

                count++;
                cities.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }

    /**
     * Request - 15 top n country
     */
    public static ArrayList<City> nCitiesInCountry(String countryName, String number, Connection connection)
    {
        ArrayList<City> cities = new ArrayList<City>();
        try
        {
            System.out.println("********************************************************");
            System.out.println("-- " + countryName.toUpperCase() + " --");
            System.out.println("City    |    Country    |    District    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect1 =
                    "SELECT `Code`"
                            + "FROM country "
                            + "WHERE Name = '" + countryName + "'";

            // Execute SQL statement
            ResultSet result_set1 = statement.executeQuery(stringSelect1);

            String countryCode ="";

            while (result_set1.next())
            {
                countryCode = result_set1.getString("Code");
            }

            String stringSelect2 = "SELECT `Name`, `CountryCode`, `District`, `Population`"
                    + "FROM city "
                    + "WHERE CountryCode = '" + countryCode +"'"
                    + "ORDER BY Population DESC";

            ResultSet result_set2 = statement.executeQuery(stringSelect2);

            int num = Integer.parseInt(number);
            int count =0;

            while (result_set2.next() && count<num)
            {
                City city = new City();
                city.name = result_set2.getString("Name");
                city.country_code = result_set2.getString("CountryCode");
                city.district = result_set2.getString("District");
                city.population = result_set2.getInt("Population");
                System.out.println(city.name + "    |    " + city.country_code + "    |    " + city.district
                        + "    |    " + city.population);

                count++;
                cities.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }

    /**
     * Request 16 - n Cities in district
     */
    public static ArrayList<City> nCitiesInDistrict(String district,String number, Connection connection)
    {
        ArrayList<City> cities = new ArrayList<City>();
        try
        {
            System.out.println("********************************************************");
            System.out.println("-- " + district.toUpperCase() + " --");
            System.out.println("City    |    Country    |    District    |    Population");

            // Create an SQL statement
            Statement statement = connection.createStatement();

            // Create string for SQL statement
            String stringSelect =
                    "SELECT `Name`, `CountryCode`, `District`, `Population`"
                            + "FROM city "
                            + "WHERE district = '" + district +"'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);

            // Return new city and population table if valid.
            // Take cities one by one from the top
            int num = Integer.parseInt(number);
            int count = 0;

            while (result_set.next() && count<num)
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.country_code = result_set.getString("CountryCode");
                city.district = result_set.getString("District");
                city.population = result_set.getInt("Population");
                System.out.println(city.name + "    |    " + city.country_code + "    |    " + city.district
                        + "    |    " + city.population);

                count++;
                cities.add(city);
            }
            System.out.println("\n");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return cities;
    }
}