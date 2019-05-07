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

    @Test
    void listAllCapitalCitiesInWorldNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.inTheWorld(null);
        cities.contains("null");
    }

    @Test
    void listAllCapitalCitiesNInWorldNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.nInTheWorld(null, null);
        cities.contains("null");
    }

    @Test
    void listAllCapitalCitiesOnContinentNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.onContinent(null, null);
        cities.contains("null");
    }

    @Test
    void listAllCapitalCitiesNOnContinentNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.nOnContinent(null, null, null);
        cities.contains("null");
    }

    @Test
    void listAllCapitalCitiesInRegionNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.inRegion(null, null);
        cities.contains("null");
    }

    @Test
    void listAllCapitalCitiesNInRegionNull()
    {
        ArrayList<City> cities = ListAllCapitalCities.nInRegion(null, null, null);
        cities.contains("null");
    }

    @Test
    void listAllCitiesInWorldNull()
    {
        ListAllCities listAllCitiesWorld = new ListAllCities();
        listAllCitiesWorld.citiesInWorld(null);
    }

    @Test
    void listAllCitiesInContinentNull()
    {
        ListAllCities listAllCitiesContinent = new ListAllCities();
        listAllCitiesContinent.citiesContinent(null, null);
    }

    @Test
    void listAllCitiesInCountryNull()
    {
        ListAllCities listAllCitiesCountry = new ListAllCities();
        listAllCitiesCountry.citiesInCountry(null, null);
    }

    @Test
    void listAllCitiesInRegionNull()
    {
        ListAllCities listAllCitiesRegion = new ListAllCities();
        listAllCitiesRegion.citiesInRegion(null, null);
    }

    @Test
    void listAllCitiesInDistrictNull()
    {
        ListAllCities listAllCitiesDistrict = new ListAllCities();
        listAllCitiesDistrict.citiesInDistrict(null,null);
    }

    @Test
    void listAllNCitiesInWorldNull()
    {
        ListAllCities listNCitiesWorld = new ListAllCities();
        listNCitiesWorld.nCitiesInWorld(null,null);
    }

    @Test
    void listNCitiesInContinentNull()
    {
        ListAllCities listNCitiesContinent = new ListAllCities();
        listNCitiesContinent.nCitiesContinent(null,null,null);
    }

    @Test
    void listNCitiesInRegionNull()
    {
        ListAllCities listNCitiesRegion = new ListAllCities();
        listNCitiesRegion.nCitiesInRegion(null,null,null);
    }

    @Test
    void listNCitiesInCountryNull()
    {
        ListAllCities listNCitiesCountry = new ListAllCities();
        listNCitiesCountry.nCitiesInCountry(null,null,null);
    }

    @Test
    void listNCitiesInDistrictNull()
    {
        ListAllCities listNCitiesDistrict = new ListAllCities();
        listNCitiesDistrict.nCitiesInDistrict(null,null,null);
    }
}
