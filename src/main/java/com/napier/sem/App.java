package com.napier.sem;


import com.napier.sem.features.*;

import java.util.Scanner;

//import com.napier.sem.features.*;

import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        // Create App instance
        App app = new App();

        // Connect to the database
        app.connect();


        //7 - list all cities in world by pop
        /*
        ListAllCities listAllCitiesWorld = new ListAllCities();
        listAllCitiesWorld.citiesInWorld(app.connection);
        */

        //8 - list all cities in entered continent by pop
        /*
        ListAllCities listAllCitiesContinent = new ListAllCities();
        listAllCitiesContinent.citiesContinent("Asia", app.connection);
        */

        //9 - list all cities in country by pop
        /*
        ListAllCities listAllCitiesCountry = new ListAllCities();
        listAllCitiesCountry.citiesInCountry("France", app.connection);
        */

        //10 - list all cities in region by pop
        /*
        ListAllCities listAllCitiesRegion = new ListAllCities();
        listAllCitiesRegion.citiesInRegion("North America", app.connection);
        */

        //11 - list all cities in district by pop
        /*
        ListAllCities listAllCitiesDistrict = new ListAllCities();
        listAllCitiesDistrict.citiesInDistrict("Scotland",app.connection);
        */

        //12 - list n cities world, user enters n, by pop
        /*
        ListAllCities listNCitiesWorld = new ListAllCities();
        listNCitiesWorld.nCitiesInWorld("5",app.connection);
        */

        //13 - list n cities continent, user enters n & continent, by pop
        /*
        ListAllCities listNCitiesContinent = new ListAllCities();
        listNCitiesContinent.nCitiesContinent("Asia","5",app.connection);
        */

        //14 - list n cities region, user enters n & region, by pop
        /*
        ListAllCities listNCitiesRegion = new ListAllCities();
        listNCitiesRegion.nCitiesInRegion("North America","5",app.connection);
        */

        //15 - list n cities country, user enters n & country, by pop
        /*
        ListAllCities listNCitiesCountry = new ListAllCities();
        listNCitiesCountry.nCitiesInCountry("France","5",app.connection);
        */

        //16 - list n cities district, user enters n & district, by pop
        /*
        ListAllCities listNCitiesDistrict = new ListAllCities();
        listNCitiesDistrict.nCitiesInDistrict("England","5",app.connection);
        */

        //E1 - List world population
        /*
        Extras worldPopulation = new Extras();
        worldPopulation.worldPop(app.connection);
        */

        //E2 - List continent population
        /*
        Extras continentPopulation = new Extras();
        continentPopulation.contPop("Asia",app.connection);
        */

        //E3 - List region Population
        /*
        Extras regionPopulation = new Extras();
        regionPopulation.regionPop("South America", app.connection);
        */

        //E4 - List population of a country
        /*
        Extras countryPopulation = new Extras();
        countryPopulation.countryPop("France", app.connection);
        */

        //E5 - Lists district population
        /*
        Extras districtPopulation = new Extras();
        districtPopulation.districtPop("Scotland", app.connection);
        */

        //E6 - Pop of a city
        /*
        Extras cityPopulation = new Extras();
        cityPopulation.cityPop("Edinburgh", app.connection);
        */

        Extras countryReport = new Extras();
        countryReport.reportCountry("France", app.connection);



        // Disconnect from the database
        app.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection connection = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(5000);
                // Connect to database
                connection = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (connection != null)
        {
            try
            {
                // Close connection
                connection.close();
                System.out.println("Successfully disconnected");
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
}