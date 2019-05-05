package com.napier.sem;

import java.util.List;
import java.util.Scanner;
import com.napier.sem.features.*;

import java.sql.*;

public class UserInterface {

    static boolean exit = false;

    private static void displayHeadder(String selection){
        System.out.println();
        System.out.println("*****************************");
        System.out.println("*         " + selection + "         *");
        System.out.println("*****************************");
        System.out.println();
    }

    public static void runMenu(Connection connection){
        do{
            displayMenu();
            int selection = userInput(37);
            execute(selection, connection);
        }while(!exit);
    }

    private static void displayMenu(){
        displayHeadder("Main Menu");

        System.out.println("  11) List countries in the world by population");
        System.out.println("  12) List countries of a continent by population");
        System.out.println("  13) List countries in a region by population");
        System.out.println();
        System.out.println("  21) List capital in the world cities by population");
        System.out.println("  22) List capital of a continent cities by population");
        System.out.println("  23) List capital in a region cities by population");
        System.out.println();
        System.out.println("  31) World Countries population ranking  **UNDER DEVELOPMENT**");
        System.out.println("  32) Continent Countries population ranking  **UNDER DEVELOPMENT**");
        System.out.println("  33) Region Countries population ranking  **UNDER DEVELOPMENT**");
        System.out.println();
        System.out.println("  41) Capitals of the world population ranking  **UNDER DEVELOPMENT**");
        System.out.println("  42) Capitals of a continent population ranking  **UNDER DEVELOPMENT**");
        System.out.println("  43) Capitals of a region population ranking  **UNDER DEVELOPMENT**");
        System.out.println();
        System.out.println("  51) List cities in the world by population");
        System.out.println("  52) List cities of a continent by population");
        System.out.println("  53) List cities in a region by population");
        System.out.println("  54) List cities in a country by population");
        System.out.println("  55) List cities in a district by population");
        System.out.println();
        System.out.println("  61) Cities in the world population ranking");
        System.out.println("  62) Cities of a continent population ranking");
        System.out.println("  63) Cities in a region population ranking");
        System.out.println("  64) Cities of a country population ranking");
        System.out.println("  65) Cities in a district population ranking");
        System.out.println();
        System.out.println("  71) List of overall, urban and rural population of each continent");
        System.out.println("  72) List of overall, urban and rural population of each region");
        System.out.println("  73) List of overall, urban and rural population of each country");
        System.out.println();
        System.out.println("  81) Total population of the world  **UNDER DEVELOPMENT**");
        System.out.println("  82) Total population of a continent  **UNDER DEVELOPMENT**");
        System.out.println("  83) Total population of a region  **UNDER DEVELOPMENT**");
        System.out.println("  84) Total population of a country  **UNDER DEVELOPMENT**");
        System.out.println("  85) Total population of a district  **UNDER DEVELOPMENT**");
        System.out.println("  86) Total population of a city  **UNDER DEVELOPMENT**");
        System.out.println();
        System.out.println("  91) Total speakers of Chinese  **UNDER DEVELOPMENT**");
        System.out.println("  92) Total speakers of English  **UNDER DEVELOPMENT**");
        System.out.println("  93) Total speakers of Hindi  **UNDER DEVELOPMENT**");
        System.out.println("  94) Total speakers of Spanish  **UNDER DEVELOPMENT**");
        System.out.println("  95) Total speakers of Arabic  **UNDER DEVELOPMENT**");
        System.out.println();
        System.out.println("  0) Exit");

    }

    private static String userInput(String type){
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        System.out.println("Input desired " + type + ": ");
        input = keyboard.nextLine();
        return input;
    }

    private static int userInput(int options){
        Scanner keyboard = new Scanner(System.in);
        int selection = -1;
        do{
            try {
                System.out.println("Select option: ");
                selection = Integer.parseInt(keyboard.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Invalid, please try again");
            }

        }while(selection < 0 || selection > options);
        return selection;
    }

    private static void execute(int selection, Connection connection){
        switch(selection){
            case 0:
                exit = true;
                break;
            case 11:
                ListAllCountries.inTheWorld(connection);
                break;
            case 12:
                ListAllCountries.onContinent(userInput("continent"), connection);
                break;
            case 13:
                ListAllCountries.inRegion(userInput("region"), connection);
                break;
            case 21:
                ListAllCapitalCities.inTheWorld(connection);
                break;
            case 22:
                ListAllCapitalCities.onContinent(userInput("continent"), connection);
                break;
            case 23:
                ListAllCapitalCities.inRegion(userInput("region"), connection);
                break;
            case 31:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 32:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 33:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 41:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 42:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 43:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 51:
                ListAllCities.citiesInWorld(connection);
                break;
            case 52:
                ListAllCities.citiesContinent(userInput("continent"), connection);
                break;
            case 53:
                ListAllCities.citiesInRegion(userInput("region"), connection);
                break;
            case 54:
                ListAllCities.citiesInCountry(userInput("country"), connection);
                break;
            case 55:
                ListAllCities.citiesInDistrict(userInput("district"), connection);
                break;
            case 61:
                ListAllCities.nCitiesInWorld(userInput("range"), connection);
                break;
            case 62:
                ListAllCities.nCitiesContinent(userInput("continent"), userInput("range"), connection);
                break;
            case 63:
                ListAllCities.nCitiesInRegion(userInput("region"), userInput("range"), connection);
                break;
            case 64:
                ListAllCities.nCitiesInCountry(userInput("country"), userInput("range"), connection);
                break;
            case 65:
                ListAllCities.nCitiesInDistrict(userInput("district"), userInput("range"), connection);
                break;
            case 71:
                PopulationCitiesInOut.inEachContinent(connection);
                break;
            case 72:
                PopulationCitiesInOut.inEachRegion(connection);
                break;
            case 73:
                PopulationCitiesInOut.inEachCountry(connection);
                break;
            case 81:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 82:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 83:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 84:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 85:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 86:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 91:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 92:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 93:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 94:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            case 95:
                System.out.println("FUNCTIONALITY IN DEVELOPMENT");
                break;
            default:
                System.out.println("An unknown error has occured");
                break;
        }
    }

}
