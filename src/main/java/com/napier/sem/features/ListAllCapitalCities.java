
package com.napier.sem.features;

import com.napier.sem.*;
import java.sql.*;
import java.util.ArrayList;

import com.napier.sem.features.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@SpringBootApplication
@RestController
public class ListAllCapitalCities {


    @RequestMapping("ListAllCapitalCities")
    public static ArrayList<City> inTheWorld(Connection connection)
    {
        ArrayList<City> cities = new ArrayList<>();

        try {
            System.out.println("Name    |    Country    |    Population");
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT  city.`Name`, country.`Name` AS `country`, city.`Population`"
                            + "FROM country JOIN city on country.Code = city.CountryCode "
                            + "WHERE country.`Capital` = city.`ID`"
                            + "ORDER BY city.`Population` DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next()) {

                City city = new City();
                city.name = result_set.getString("Name");
                city.population = result_set.getInt("Population");

                Country country = new Country();
                country.name = result_set.getString("country");

                System.out.println(city.name + "   |   " + country.name + "   |   " + city.population);

                cities.add(city);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }

        return cities;
    }


    //lists all the capital cities in a continent from largest population to smallest
    public void onContinent(String continent, Connection connection)
    {
        try
        {
            System.out.println(" -- " + continent.toUpperCase() + " -- ");
            System.out.println("Name    |    Country    |    Population");
            if(continent == null)
            {
                throw new NullPointerException("Continent is null");
            }
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT  city.`Name`, country.`Name` AS `country`, city.`Population`"
                            + "FROM country JOIN city on country.Code = city.CountryCode "
                            + "WHERE country.`Capital` = city.`ID` AND country.`Continent` = '" + continent + "'"
                            + "ORDER BY city.`Population` DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.population = result_set.getInt("Population");

                Country country = new Country();
                country.name = result_set.getString("country");

                System.out.println(city.name + "   |   " + country.name  + "   |   " + city.population);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

    //lists all the capital cities in a region from largest population to smallest
    public void inRegion(String region, Connection connection)
    {
        try
        {
            System.out.println(" -- " + region.toUpperCase() + " -- ");
            System.out.println("Name    |    Country    |    Population");
            if(region == null)
            {
                throw new NullPointerException("Region is null");
            }
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT  city.`Name`, country.`Name` AS `country`, city.`Population`"
                            + "FROM country JOIN city on country.Code = city.CountryCode "
                            + "WHERE country.`Capital` = city.`ID` AND country.`Region` = '" + region + "'"
                            + "ORDER BY city.`Population` DESC";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next())
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.population = result_set.getInt("Population");

                Country country = new Country();
                country.name = result_set.getString("country");

                System.out.println(city.name + "   |   " + country.name  + "   |   " + city.population);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
    }

}