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

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");

    }

    @Test
    void listAllCapitalCitiesInWorld()
    {
        ArrayList<City> cities = ListAllCapitalCities.inTheWorld(app.connection);
        assertEquals(cities.get(0). name, "Seoul");
    }

    @Test
    void listAllCapitalCitiesOnContinent()
    {
        ArrayList<City> cities = ListAllCapitalCities.onContinent("Asia", app.connection);
        assertEquals(cities.get(0). name, "Seoul");
    }

    @Test
    void listAllCapitalCitiesInRegion()
    {
        ArrayList<City> cities = ListAllCapitalCities.inRegion("Middle East" , app.connection);
        assertEquals(cities.get(0). name, "Baghdad");
    }

    @Test
    void listAllCapitalCitiesNInWorld()
    {
        ArrayList<City> cities = ListAllCapitalCities.nInTheWorld("5", app.connection);
        assertEquals(cities.get(4). name, "Tokyo");
    }

    @Test
    void listAllCapitalCitiesNOnContinent()
    {
        ArrayList<City> cities = ListAllCapitalCities.nOnContinent("Asia", "5", app.connection);
        assertEquals(cities.get(4). name, "Teheran");
    }

    @Test
    void listAllCapitalCitiesNInRegion()
    {
        ArrayList<City> cities = ListAllCapitalCities.nInRegion( "Middle East", "5", app.connection);
        assertEquals(cities.get(4). name, "Damascus");
    }

    @Test
    void listAllCitiesInWorld()
    {
        ArrayList<City> cities = ListAllCities.citiesInWorld( app.connection);
        assertEquals(cities.get(0). name, "Mumbai (Bombay)");
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
        ArrayList<City> cities = ListAllCities.citiesInRegion("Middle East", app.connection);
        assertEquals(cities.get(0). name, "Istanbul");
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
        ArrayList<City> cities = ListAllCities.nCitiesInRegion("Middle East","5", app.connection);
        assertEquals(cities.get(4). name, "Izmir");
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
    void popInWorld()
    {
        ArrayList<Country> countries = Extras.worldPop(app.connection);
        countries.contains("6078749450");
    }

    @Test
    void popInContinent()
    {
        ArrayList<Country> countries = Extras.contPop("Asia", app.connection);
        countries.contains("3705025700");
    }

    @Test
    void popInRegion()
    {
        ArrayList<Country> countries = Extras.regionPop("Middle East", app.connection);
        countries.contains("309632000");
    }

    @Test
    void popInCountry()
    {
        ArrayList<Country> countries = Extras.countryPop("France", app.connection);
        countries.contains("59225700");
    }

    @Test
    void popInDistrict()
    {
        ArrayList<City> cities = Extras.districtPop("England", app.connection);
        cities.contains("19978543");
    }

    @Test
    void popInCity()
    {
        ArrayList<City> cities = Extras.cityPop("London", app.connection);
        cities.contains("7624917");
    }

    @Test
    void countriesPopWorld()
    {
        ArrayList<Country> countries = ListAllCountries.inTheWorld( app.connection);
        assertEquals(countries.get(0). name, "China");
    }

    @Test
    void countriesPopContinent()
    {
        ArrayList<Country> countries = ListAllCountries.onContinent("Asia", app.connection);
        assertEquals(countries.get(0). name, "China");
    }

    @Test
    void countriesPopRegion()
    {
        ArrayList<Country> countries = ListAllCountries.inRegion("Middle East", app.connection);
        assertEquals(countries.get(0). name, "Turkey");
    }

    @Test
    void topNCountriesPopWorld()
    {
        ArrayList<Country> countries = TopCountries.nInTheWorld("5", app.connection);
        assertEquals(countries.get(4). name, "Brazil");
    }

    @Test
    void topNCountriesPopContinent()
    {
        ArrayList<Country> countries = TopCountries.nOnContinent("Asia", "5", app.connection);
        assertEquals(countries.get(4). name, "Bangladesh");
    }

    @Test
    void topNCountriesPopRegion()
    {
        ArrayList<Country> countries = TopCountries.nInRegion("Middle East", "5", app.connection);
        assertEquals(countries.get(4). name, "Syria");
    }

    @Test
    void listPopulationInOutCitiesContinent()
    {
        ArrayList<Country> country = PopulationCitiesInOut.inEachContinent(app.connection);
        assertEquals(country.get(0). continent, "Asia");
    }

    @Test
    void listPopulationInOutCitiesRegion()
    {
        ArrayList<Country> country = PopulationCitiesInOut.inEachRegion(app.connection);
        assertEquals(country.get(0). region, "Australia and New Zealand");
    }

    @Test
    void listPopulationInOutCitiesCountry() {
        ArrayList<Country> country = PopulationCitiesInOut.inEachCountry(app.connection);
        assertEquals(country.get(0).name, "Afghanistan");
    }

}