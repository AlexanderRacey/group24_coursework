package com.napier.sem;

import com.napier.sem.features.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    static ListAllCapitalCities ListAllCapitalCities;
    static ListAllCities ListAllCities;

    @BeforeAll
    static void init()
    {
        app = new App();
        ListAllCapitalCities = new ListAllCapitalCities();
        ListAllCities = new ListAllCities();
        app.connect("localhost:33060");

    }

    @Test
    void listAllCapitalCitiesInWorld()
    {
        ArrayList<City> cities = ListAllCapitalCities.inTheWorld(app.connection);
        assertEquals(cities.get(0). name, "Seoul");
    }

    @Test
    void listAllCapitalCitiesNInWorld()
    {
        ArrayList<City> cities = ListAllCapitalCities.nInTheWorld("5", app.connection);
        assertEquals(cities.get(4). name, "Tokyo");
    }

    @Test
    void listAllCapitalCitiesOnContinent()
    {
        ArrayList<City> cities = ListAllCapitalCities.onContinent("Asia", app.connection);
        assertEquals(cities.get(0). name, "Seoul");
    }

    @Test
    void listAllCapitalCitiesNOnContinent()
    {
        ArrayList<City> cities = ListAllCapitalCities.nOnContinent("Asia", "5", app.connection);
        assertEquals(cities.get(4). name, "Teheran");
    }

    @Test
    void listAllCapitalCitiesInRegion()
    {
        ArrayList<City> cities = ListAllCapitalCities.inRegion( "Caribbean", app.connection);
        assertEquals(cities.get(0). name, "La Habana");
    }

    @Test
    void listAllCapitalCitiesNInRegion()
    {
        ArrayList<City> cities = ListAllCapitalCities.nInRegion( "Caribbean", "5", app.connection);
        assertEquals(cities.get(4). name, "Nassau");
    }


    @Test
    void listAllCitiesInContinent()
    {
        ArrayList<City> cities = ListAllCities.citiesContinent("Asia", app.connection);
        assertEquals(cities.get(0). name, "Mumbai (Bombay)");
    }

    @Test
    void listAllCitiesInCountry()
    {
        ArrayList<City> cities = ListAllCities.citiesInCountry("France", app.connection);
        assertEquals(cities.get(0). name, "Paris");
    }

    @Test
    void listAllCitiesInRegion()
    {
        ArrayList<City> cities = ListAllCities.citiesInRegion("North America", app.connection);
        assertEquals(cities.get(0). name, "New York");
    }

    @Test
    void listAllCitiesInDistrict()
    {
        ArrayList<City> cities = ListAllCities.citiesInDistrict("England", app.connection);
        assertEquals(cities.get(0). name, "London");
    }

    @Test
    void listAllNCitiesInWorld()
    {
        ArrayList<City> cities = ListAllCities.nCitiesInWorld("5", app.connection);
        assertEquals(cities.get(4). name, "Jakarta");
    }

    @Test
    void listNCitiesInContinent()
    {
        ArrayList<City> cities = ListAllCities.nCitiesContinent("Asia","5", app.connection);
        assertEquals(cities.get(4). name, "Karachi");
    }

    @Test
    void listNCitiesInRegion()
    {
        ArrayList<City> cities = ListAllCities.nCitiesInRegion("North America","5", app.connection);
        assertEquals(cities.get(4). name, "Philadelphia");
    }

    @Test
    void listNCitiesInCountry()
    {
        ArrayList<City> cities = ListAllCities.nCitiesInCountry("France","5", app.connection);
        assertEquals(cities.get(4). name, "Nice");
    }

    @Test
    void listNCitiesInDistrict()
    {
        ArrayList<City> cities = ListAllCities.nCitiesInDistrict("England","5", app.connection);
        assertEquals(cities.get(4). name, "Manchester");
    }

    @Test
    void popInWorldNull()
    {
        ArrayList<Country> countries = Extras.worldPop(app.connection);
        countries.contains("6078749450");
    }

    @Test
    void popInContinentNull()
    {
        ArrayList<Country> countries = Extras.contPop("Asia", app.connection);
        countries.contains("3705025700");
    }

    @Test
    void popInRegionNull()
    {
        ArrayList<Country> countries = Extras.regionPop("North America", app.connection);
        countries.contains("309632000");
    }

    @Test
    void popInCountryNull()
    {
        ArrayList<Country> countries = Extras.countryPop("France", app.connection);
        countries.contains("59225700");
    }

    @Test
    void popInDistrictNull()
    {
        ArrayList<City> cities = Extras.districtPop("England", app.connection);
        cities.contains("19978543");
    }

    @Test
    void popInCityNull()
    {
        ArrayList<City> cities = Extras.cityPop("London", app.connection);
        cities.contains("7624917");
    }

}