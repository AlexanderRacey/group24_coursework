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
    void testListAllCapitalCitiesInWorld()
    {
        ListAllCapitalCities listAllCapitalCities = new ListAllCapitalCities();
        listAllCapitalCities.inTheWorld(null);
    }
    @Test
    void listAllCapitalCitiesOnContinentNull()
    {
        ListAllCapitalCities listAllCapitalCities = new ListAllCapitalCities();
        listAllCapitalCities.onContinent(null, null);
    }

    @Test
    void listAllCapitalCitiesInRegionNull()
    {
        ListAllCapitalCities listAllCapitalCities = new ListAllCapitalCities();
        listAllCapitalCities.inRegion( null, null);
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