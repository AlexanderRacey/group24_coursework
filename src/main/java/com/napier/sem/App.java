package com.napier.sem;

<<<<<<< HEAD
import com.napier.sem.features.ListAllCountries;
=======
import com.napier.sem.features.*;

>>>>>>> aef17a156264a9a1f69bcdcfce12d6128b521d28

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

        /**
         * 7 - list all cities in world by pop
         **/
        /*
        ListAllCities listAllCitiesWorld = new ListAllCities();
        listAllCitiesWorld.citiesInWorld(app.connection);
        */

        /**
<<<<<<< HEAD
         * Lists all countries in the world by population
         */
        /*
        ListAllCountries listAllCountries = new ListAllCountries();
        listAllCountries.inTheWorld(app.connection);
         */

        /**
         * Lists all countries in ASIA by population
         */
        /*
        ListAllCountries listAllCountries = new ListAllCountries();
        listAllCountries.onContinent("Asia", app.connection);
         */

        /**
         * Lists all countries in WESTERN EUROPE by population
         */
        /*
        ListAllCountries listAllCountries = new ListAllCountries();
        listAllCountries.inRegion("Western Europe", app.connection);
=======
         * 8 - list all cities in entered continent by pop
         **/
        /*
        ListAllCities listAllCitiesContinent = new ListAllCities();
        listAllCitiesContinent.citiesContinent("Asia", app.connection);
        */

        /**
         * 9 - list all cities in country by pop
         **/
        /*
        ListAllCities listAllCitiesCountry = new ListAllCities();
        listAllCitiesCountry.citiesInCountry("France", app.connection);
        */
        /**
         * 10 - list all cities in region by pop
         **/
        /*
        ListAllCities listAllCitiesRegion = new ListAllCities();
        listAllCitiesRegion.citiesInRegion("North America", app.connection);
        */
        /**
         * 11 - list all cities in district by pop
         **/
        /*
        ListAllCities listAllCitiesDistrict = new ListAllCities();
        listAllCitiesDistrict.citiesInDistrict("Scotland",app.connection);
        */
        /**
         * list n cities world, user enters n, by pop
         **/
        /*
        ListAllCities listNCitiesWorld = new ListAllCities();
        listNCitiesWorld.nCitiesInWorld("5",app.connection);
        */
        /**
         * list n cities continent, user enters n & continent, by pop
         **/
        /*
        ListAllCities listNCitiesContinent = new ListAllCities();
        listNCitiesContinent.nCitiesContinent("Asia","5",app.connection);
        */
        /**
         * list n cities region, user enters n & region, by pop
         **/
        /*
        ListAllCities listNCitiesRegion = new ListAllCities();
        listNCitiesRegion.nCitiesInRegion("North America","5",app.connection);
        */
        /**
         * list n cities country, user enters n & country, by pop
         **/
        /*
        ListAllCities listNCitiesCountry = new ListAllCities();
        listNCitiesCountry.nCitiesInCountry("France","5",app.connection);
        */
        /**
         * list n cities district, user enters n & district, by pop
         **/
        /*
        ListAllCities listNCitiesDistrict = new ListAllCities();
        listNCitiesDistrict.nCitiesInDistrict("England","5",app.connection);
>>>>>>> aef17a156264a9a1f69bcdcfce12d6128b521d28
        */

        // Disconnect from the database
        app.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection connection = null;

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
     * Old Connect to the MySQL database.
     */
    /*
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
    */
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