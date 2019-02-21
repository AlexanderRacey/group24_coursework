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
        app.connect();

        /**
         * Lists all countries in the world by population
         */
         ListAllCountries listAllCountries = new ListAllCountries();
         listAllCountries.inTheWorld(app.connection);


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
        */

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