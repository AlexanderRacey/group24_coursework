package com.napier.sem;

import com.napier.sem.features.ListAllCapitalCities;
import com.napier.sem.features.*;


import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        // Create App instance
        App app = new App();

        // Connect to database
        if (args.length < 1)
        {
            app.connect("localhost:33060");
        }
        else
        {
            app.connect(args[0]);
        }

        /**
         * Lists all capital cities in the world by population
         **/

        ListAllCapitalCities listAllCapitalCities = new ListAllCapitalCities();
        listAllCapitalCities.inTheWorld(app.connection);


        /**
         * Lists all Capital Cities in ASIA by population
         **/

        /*
        ListAllCapitalCities listAllCapitalCities = new ListAllCapitalCities();
        listAllCapitalCities.onContinent( "Asia", app.connection);
        */

        /**
         * Lists all Capital Cities in Caribbean by population
         **/
        /*
        ListAllCapitalCities listAllCapitalCities = new ListAllCapitalCities();
        listAllCapitalCities.inRegion( "Caribbean", app.connection);
        */

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

        // list n cities world, user enters n, by pop
        /*
        ListAllCities listNCitiesWorld = new ListAllCities();
        listNCitiesWorld.nCitiesInWorld("5",app.connection);
        */

        // list n cities continent, user enters n & continent, by pop
        /*
        ListAllCities listNCitiesContinent = new ListAllCities();
        listNCitiesContinent.nCitiesContinent("Asia","5",app.connection);
        */

        // list n cities region, user enters n & region, by pop
        /*
        ListAllCities listNCitiesRegion = new ListAllCities();
        listNCitiesRegion.nCitiesInRegion("North America","5",app.connection);
        */

        // list n cities country, user enters n & country, by pop
        /*
        ListAllCities listNCitiesCountry = new ListAllCities();
        listNCitiesCountry.nCitiesInCountry("France","5",app.connection);
        */

        // list n cities district, user enters n & district, by pop
        /*
        ListAllCities listNCitiesDistrict = new ListAllCities();
        listNCitiesDistrict.nCitiesInDistrict("England","5",app.connection);
        */

        // Disconnect from the database
        app.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    public Connection connection = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 20;
        for (int i = 1; i <= retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(5000);
                // Connect to database
                connection = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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

    public Country getCountry(Connection connection, String code)
    {
        // Initialize country container
        Country country = new Country();

        try {
            // Create an SQL statement
            Statement statement = connection.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT  *"
                            + "FROM country"
                            + "WHERE country.`Code` = '" + code + "'";
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new country and population table if valid.
            // Take countries one by one from the top
            while (result_set.next()) {
                country = new Country(          result_set.getString("Code"),
                        result_set.getString("Name"),
                        result_set.getString("Continent"),
                        result_set.getString("Region"),
                        result_set.getString("SurfaceArea"),
                        result_set.getString("IndepYear"),
                        result_set.getString("LifeExpectancy"),
                        result_set.getString("GNP"),
                        result_set.getString("GNPOLD"),
                        result_set.getString("LocalName"),
                        result_set.getString("GovernmentForm"),
                        result_set.getString("HeadOfState"),
                        result_set.getString("Capital"),
                        result_set.getString("Code2")               );
            }
            return country;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong");
        }
        return country;
    }
}