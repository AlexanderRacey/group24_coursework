package com.napier.sem;

import com.napier.sem.features.*;
import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        // Create App instance
        App app = new App();

        // Connect to the database
        if(args.length < 1)
        {
            //app.connect();
            app.connect("localhost:33060");
        }
        else
        {
            app.connect(args[0]);
        }

         //Lists all capital cities in the world by population
         ListAllCapitalCities.inTheWorld(app.connection);

         //Lists all Capital Cities in ASIA by population
         ListAllCapitalCities.onContinent( "Asia", app.connection);

         //Lists all Capital Cities in Caribbean by population
         ListAllCapitalCities.inRegion( "Caribbean", app.connection);

         //Lists all N capital cities in the world by population
         ListAllCapitalCities.nInTheWorld("5",app.connection);

         //Lists all N Capital Cities in ASIA by population
         ListAllCapitalCities.nOnContinent( "Asia", "5",app.connection);

         //Lists all N Capital Cities in Caribbean by population
         ListAllCapitalCities.nInRegion( "Caribbean","5", app.connection);

         //7 - list all cities in world by pop
         ListAllCities.citiesInWorld(app.connection);

         //8 - list all cities in entered continent by pop
         ListAllCities.citiesContinent("Asia", app.connection);

         //9 - list all cities in country by pop
         ListAllCities.citiesInCountry("France", app.connection);

         //10 - list all cities in region by pop
         ListAllCities.citiesInRegion("North America", app.connection);

         //11 - list all cities in district by pop
         ListAllCities.citiesInDistrict("Scotland",app.connection);

         //list n cities world, user enters n, by pop
         ListAllCities.nCitiesInWorld("5",app.connection);

         //list n cities continent, user enters n & continent, by pop
         ListAllCities.nCitiesContinent("Asia","5",app.connection);

         //list n cities region, user enters n & region, by pop
         ListAllCities.nCitiesInRegion("North America","5",app.connection);

         //list n cities country, user enters n & country, by pop
         ListAllCities.nCitiesInCountry("France","5",app.connection);

         //list n cities district, user enters n & district, by pop
         ListAllCities.nCitiesInDistrict("England","5",app.connection);


         //Population of the world
         Extras.worldPop(app.connection);


        // Disconnect from the database
        app.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    //private Connection connection = null;
    public Connection connection = null;

    /**
     * New Connect to the MySql database
     */
    public void connect(String location) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                connection = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
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