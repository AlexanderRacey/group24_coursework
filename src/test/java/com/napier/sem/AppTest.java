package com.napier.sem;

import com.napier.sem.features.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    // List all capital cities in the world - Test (null)
    @Test
    void listAllCapitalCitiesInWorldNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.inTheWorld(null);
        cities.contains("null");
    }

    // List all capital cities in the continent - Test (null)
    @Test
    void listAllCapitalCitiesOnContinentNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.onContinent(null, null);
        cities.contains("null");
    }

    // List all capital cities in the region - Test (null)
    @Test
    void listAllCapitalCitiesInRegionNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.inRegion(null, null);
        cities.contains("null");
    }

    // List all capital cities (N) in the world - Test (null)
    @Test
    void listAllCapitalCitiesNInWorldNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.nInTheWorld(null, null);
        cities.contains("null");
    }

    // List all capital cities (N) in the continent - Test (null)
    @Test
    void listAllCapitalCitiesNOnContinentNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.nOnContinent(null, null, null);
        cities.contains("null");
    }

    // List all capital cities (N) in the region - Test (null)
    @Test
    void listAllCapitalCitiesNInRegionNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.nInRegion(null, null, null);
        cities.contains("null");
    }

    // List all cities in the world - Test (null)
    @Test
    void listAllCitiesInWorldNull()
    {
        ArrayList<City> cities = ListAllCities.citiesInWorld(null);
        cities.contains("null");
    }

    // List all cities in the continent - Test (null)
    @Test
    void listAllCitiesInContinentNull()
    {
        ArrayList<City> cities = ListAllCities.citiesContinent(null, null);
        cities.contains("null");

    }

    // List all cities in the country - Test (null)
    @Test
    void listAllCitiesInCountryNull()
    {
        ArrayList<City> cities = ListAllCities.citiesInCountry(null, null);
        cities.contains("null");
    }

    // List all cities in the region - Test (null)
    @Test
    void listAllCitiesInRegionNull()
    {
        ArrayList<City> cities = ListAllCities.citiesInRegion(null, null);
        cities.contains("null");
    }

    // List all cities in the district - Test (null)
    @Test
    void listAllCitiesInDistrictNull()
    {
        ArrayList<City> cities = ListAllCities.citiesInDistrict(null,null);
        cities.contains("null");
    }

    // List all (N) cities in the world - Test (null)
    @Test
    void listAllNCitiesInWorldNull()
    {
        ArrayList<City> cities = ListAllCities.nCitiesInWorld(null,null);
        cities.contains("null");
    }

    // List all (N) cities in the continent - Test (null)
    @Test
    void listNCitiesInContinentNull()
    {
        ArrayList<City> cities = ListAllCities.nCitiesContinent(null,null,null);
        cities.contains("null");
    }

    // List all (N) cities in the region - Test (null)
    @Test
    void listNCitiesInRegionNull()
    {
        ArrayList<City> cities = ListAllCities.nCitiesInRegion(null,null,null);
        cities.contains("null");
    }

    // List all (N) cities in the country - Test (null)
    @Test
    void listNCitiesInCountryNull()
    {
        ArrayList<City> cities = ListAllCities.nCitiesInCountry(null,null,null);
        cities.contains("null");
    }

    // List all (N) cities in the district - Test (null)
    @Test
    void listNCitiesInDistrictNull()
    {
        ArrayList<City> cities = ListAllCities.nCitiesInDistrict(null,null,null);
        cities.contains("null");
    }

    // List population in the world - Test (null)
    @Test
    void popInWorldNull()
    {
        ArrayList<Country> countries = Extras.worldPop(null);
        countries.contains("null");
    }

    // List population in the continent - Test (null)
    @Test
    void popInContinentNull()
    {
        ArrayList<Country> countries = Extras.contPop(null, null);
        countries.contains("null");
    }

    // List population in the region - Test (null)
    @Test
    void popInRegionNull()
    {
        ArrayList<Country> countries = Extras.regionPop(null, null);
        countries.contains("null");
    }

    // List population in the country - Test (null)
    @Test
    void popInCountryNull()
    {
        ArrayList<Country> countries = Extras.countryPop(null, null);
        countries.contains("null");
    }

    // List population in the district - Test (null)
    @Test
    void popInDistrictNull()
    {
        ArrayList<City> cities = Extras.districtPop(null, null);
        cities.contains("null");
    }

    // List population in the city - Test (null)
    @Test
    void popInCityNull()
    {
        ArrayList<City> cities = Extras.cityPop(null, null);
        cities.contains("null");
    }

    // List country population in the world - Test (null)
    @Test
    void countriesPopWorldNull()
    {
        ArrayList<Country> countries = ListAllCountries.inTheWorld(null);
        countries.contains("null");
    }

    // List country population in the continent - Test (null)
    @Test
    void countriesPopContinentNull()
    {
        ArrayList<Country> countries = ListAllCountries.onContinent(null, null);
        countries.contains("null");
    }

    // List country population in the region - Test (null)
    @Test
    void countriesPopRegionNull()
    {
        ArrayList<Country> countries = ListAllCountries.inRegion(null, null);
        countries.contains("null");
    }

    // List highest country population (N) in the world - Test (null)
    @Test
    void topNCountriesPopWorldNull()
    {
        ArrayList<Country> countries = TopCountries.nInTheWorld(null ,null);
        countries.contains("null");
    }

    // List highest country population (N) in the continent - Test (null)
    @Test
    void topNCountriesPopContinentNull()
    {
        ArrayList<Country> countries = TopCountries.nOnContinent(null, null, null);
        countries.contains("null");
    }

    // List highest country population (N) in the region - Test (null)
    @Test
    void topNCountriesPopRegionNull()
    {
        ArrayList<Country> countries = TopCountries.nInRegion(null, null, null);
        countries.contains("null");
    }

    // List population in and out of cities in each continent - Test (null)
    @Test
    void listPopulationInOutCitiesContinentNull()
    {
        ArrayList<Country> country = PopulationCitiesInOut.inEachContinent(null);
    }

    // List population in and out of cities in each region - Test (null)
    @Test
    void listPopulationInOutCitiesRegionNull()
    {
        ArrayList<Country> country = PopulationCitiesInOut.inEachRegion(null);
    }

    // List population in and out of cities in each country - Test (null)
    @Test
    void listPopulationInOutCitiesCountryNull()
    {
        ArrayList<Country> countries = PopulationCitiesInOut.inEachCountry(null);
    }
}
