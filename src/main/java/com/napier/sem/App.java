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

        //1 - All the countries in the world organised by largest population to smallest
        ListAllCountries.inTheWorld(app.connection);

        //2 - All the countries in a continent organised by largest population to smallest
        ListAllCountries.onContinent("Asia", app.connection);

        //3 - All the countries in a region organised by largest population to smallest
        ListAllCountries.inRegion("North America", app.connection);

        //4 - The top N populated countries in the world where N is provided by the user
        TopCountries.nInTheWorld("5", app.connection);

        //5 - The top N populated countries in a continent where N is provided by the user
        TopCountries.nOnContinent("Asia", "5", app.connection);

        //6 - The top N populated countries in a region where N is provided by the user
        TopCountries.nInRegion("Middle East", "5", app.connection);

        //7 - All the cities in the world organised by largest population to smallest
        ListAllCities.citiesInWorld(app.connection);

        //8 - All the cities in a continent organised by largest population to smallest
        ListAllCities.citiesContinent("Asia", app.connection);

        //9 - All the cities in a region organised by largest population to smallest
        ListAllCities.citiesInCountry("France", app.connection);

        //10 - All the cities in a country organised by largest population to smallest
        ListAllCities.citiesInRegion("Middle East", app.connection);

        //11 - All the cities in a district organised by largest population to smallest
        ListAllCities.citiesInDistrict("Scotland",app.connection);

        //12 - The top N populated cities in the world where N is provided by the user
        ListAllCities.nCitiesInWorld("5",app.connection);

        //13 - The top N populated cities in a continent where N is provided by the user
        ListAllCities.nCitiesContinent("Asia","5",app.connection);

        //14 - The top N populated cities in a region where N is provided by the user
        ListAllCities.nCitiesInRegion("Middle East","5",app.connection);

        //15 - The top N populated cities in a country where N is provided by the user
        ListAllCities.nCitiesInCountry("France","5",app.connection);

        //16 - The top N populated cities in a district where N is provided by the user
        ListAllCities.nCitiesInDistrict("England","5",app.connection);

        //17 - All the capital cities in the world organised by largest population to smallest
        ListAllCapitalCities.inTheWorld(app.connection);

        //18 - All the capital cities in a continent organised by largest population to smallest
        ListAllCapitalCities.onContinent( "Asia", app.connection);

        //19 - All the capital cities in a region organised by largest to smallest
        ListAllCapitalCities.inRegion( "Middle East", app.connection);

        //20 - The top N populated capital cities in the world where N is provided by the user
        ListAllCapitalCities.nInTheWorld("5",app.connection);

        //21 - The top N populated capital cities in a continent where N is provided by the user
        ListAllCapitalCities.nOnContinent( "Asia", "5",app.connection);

        //22 - The top N populated capital cities in a region where N is provided by the user.
        ListAllCapitalCities.nInRegion( "Middle East","5", app.connection);

        //23 - The population of people, people living in cities, and people not living in cities in each continent
        PopulationCitiesInOut.inEachContinent(app.connection);

        //24 - The population of people, people living in cities, and people not living in cities in each region
        PopulationCitiesInOut.inEachRegion(app.connection);

        //25 - The population of people, people living in cities, and people not living in cities in each country.
        PopulationCitiesInOut.inEachCountry(app.connection);

        //26 - The population of the world
        Extras.worldPop(app.connection);

        //27 - The population of a continent.
        Extras.contPop("Asia", app.connection);

        //28 - The population of a region
        Extras.regionPop("Middle East", app.connection);

        //29 - The population of a country
        Extras.countryPop("France", app.connection);

        //30 - The population of a district
        Extras.districtPop("England", app.connection);

        //31 - The population of a city
        Extras.cityPop("London", app.connection);

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