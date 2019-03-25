package com.napier.sem;

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
        //app.connect("db");
        app.connect("localhost:33060");
    }

    @Test
    void testGetCountry()
    {
        Country country = app.getCountry(app.connection, "ABW");
        assertEquals(country.name, "Aruba");
        assertEquals(country.continent, "North America");
        assertEquals(country.region, "Caribbean");
    }



}