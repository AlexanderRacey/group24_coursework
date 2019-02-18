package com.napier.sem;

import com.napier.sem.features.*;
import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        // Test your feature here
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

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
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
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
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
                System.out.println("Successfully disconnected");
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     *
     */
    public City getCity(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement statement = con.createStatement();
            // Create string for SQL statement
            String stringSelect =
                    "SELECT Name, CountryCode, District, Population "
                            + "FROM city "
                            + "WHERE ID = " + ID;
            // Execute SQL statement
            ResultSet result_set = statement.executeQuery(stringSelect);
            // Return new employee if valid.
            // Check one is returned
            if (result_set.next())
            {
                City city = new City();
                city.name = result_set.getString("Name");
                city.country_code = result_set.getString("CountryCode");
                city.disctrict = result_set.getString("District");
                city.population = result_set.getInt("Population");
                return city;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Random City ID Generator
     */
    public static int randomCityID(){
        int id = (int)(Math.random()*((4079-1)+1))+1;
        return id;
    }
}