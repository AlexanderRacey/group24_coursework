# Full Use Cases

## Use Case 1 - Provide the number of people who speak the following languages, in descending order, including the percentage of the world's population who speaks it.

### Characteristic Information

#### Goal in Context
As a member of GlobalStat I need to see how many people (and their percentage worldwide) speak Chinese, English, Hindi, Spanish, Arabic so I can create a ranking.

#### Scope
Company

####Level
Primary task

####Preconditions
Having a database with language data

####Success End Condition
A ranking is created of all the chosen languages showing what percentage of the world speak them

####Failed End Condition
No ranking is produced

####Primary Actor
GlobalStat

####Trigger
A request for the information is sent to GlobalStat

####Main Success Scenario
1. Someone requests the ranking
2. The ranking is calculated
3. The ranking is displayed on screen
    
####Extensions
1. The ranking is output to a .txt file

####Sub-Variations
N/A

####Schedule
Due: Release 1.0.

## Use Case 2 - The population of the world, a continent, a region, a country, a district, a city should be accessible

### Characteristic Information

#### Goal in Context
As a member of GlobalStat I need to access the population of the world, continent, region, country, district or city to be able to analyse it

#### Scope
Company

####Level
Primary Task

####Preconditions
Database contains related information.    
We know what the user wants to get population data for.

####Success End Condition
The population data of a given place is available to look at

####Failed End Condition
The population data isn't displayed

####Primary Actor
GlobalStat

####Trigger
A request for the information is sent to GlobalStat

####Main Success Scenario
1. Someone requests population data for a certain place
2. The place is entered into the program
3. Population data is retrieved
    
####Extensions
1. Data is sent to a .txt file to be analysed

####Sub-Variations
N/A

####Schedule
Due: Release 1.0.

## Use Case 3 - Display the population of people living in cities and the population of people not living in cities for a given continent, region and country

### Characteristic Information

#### Goal in Context
As an Analyst I want to see total, urban and rural population of a continent, region or country so I can to produce a report. 

#### Scope
Company

####Level
Primary Task

####Preconditions
Knowing which, continent, region or country
Having a database with relevant data

####Success End Condition
The number of people who live in cities, the number of people who dont live in cities are displayed

####Failed End Condition
The data isn't displayed

####Primary Actor
Analyst

####Trigger
Request is given for the population of a place in cities and not in cities

####Main Success Scenario
1. Request is given for the information
2. The place that data is needed for is input into the program
3. The information is displayed
    
####Extensions
1. The data is stored in a .txt file for analysis

####Sub-Variations
N/A

####Schedule
Due: Release 1.0.

## Use Case 4 - Display all the capital cities in the world, a continent or a region based on population from largest to smallest

### Characteristic Information

#### Goal in Context
As an Analyst I want to view the population for capital cities worldwide, continental or regional, so I can produce a ranking 

#### Scope
Company

####Level
Primary Task

####Preconditions
We know the continent or region         
The database has relevant information

####Success End Condition
A list of capital cities is displayed

####Failed End Condition
The required list isn't displayed

####Primary Actor
Analyst

####Trigger
A request is sent to an analyst

####Main Success Scenario
1. A request is sent to the analyst
2. Analyst inputs the place into the program
3. The relevant information is displayed
    
####Extensions
1. The information is stored ina .txt file to be analysed

####Sub-Variations
N/A

####Schedule
Due: Release 1.0.

## Use Case 5 - Display the top n populated capital cities in the world, a continent or a region

### Characteristic Information

#### Goal in Context
As an Analyst I want to view the top n capital cities populations worldwide, continental or regional, in descending order so that I can easily inspect trends

#### Scope
Company

####Level
Primary Task

####Preconditions
We know the place to take capital cities from
We know how many capital cities are to be displayed
the database has relevant data

####Success End Condition
The top n populated capital cities in a place are displayed

####Failed End Condition
the correct number of capital cities and their populations aren't displayed

####Primary Actor
Analyst

####Trigger
A request is sent to an analyst

####Main Success Scenario
1. An analyst receives a request
2. They type in how many capital cities they want to display and the place they want to take the cities from
3. The cities and their population data is displayed
    
####Extensions
1. The data is stored in a .txt for analysis

####Sub-Variations
N/A

####Schedule
Due: Release 1.0.

## Use Case 6 - Display all the cities in the world, a continent, a region, a country or a district by population largest to smallest

### Characteristic Information

#### Goal in Context
As an Analyst I want to view all cities worldwide, continental, regional, country-wide or from a specific country district, in descending order based on their population so that I can easily inspect population trends.

#### Scope
Company

####Level
Primary Task

####Preconditions
Know which place to view the cities from 
Have the relevant data in the database

####Success End Condition
The list of cities in a specified place is displayed

####Failed End Condition
the list of cities for a specified place is not displayed correctly

####Primary Actor
Analyst

####Trigger
An analyst receives a request

####Main Success Scenario
1. An analyst receives a request
2. The place is entered into the program
3. All the cities are displayed
    
####Extensions
1. The cities are saved in  a .txt file so trends can be inspected easily

####Sub-Variations
N/A

####Schedule
Due: Release 1.0.

## Use Case 7 - Display the top n, where n is provided by the user, populated cities in the world, a continent, a region, a country or a district  

### Characteristic Information

#### Goal in Context
As an Analyst I want to view a specific number of cities worldwide, continental, regional, country-wide or from a specific district, in descending order based on their population so that I can easily inspect population trends.

#### Scope
Company

####Level
Primary Task

####Preconditions
Know how many cities need to be displayed
Know where the cities to be displayed are from 
Have a relevant database

####Success End Condition
The top n populated cities are displayed for a specific place

####Failed End Condition
The correct cities are not displayed

####Primary Actor
Analyst

####Trigger
A request is sent to an analyst

####Main Success Scenario
1. A request is sent to an analyst
2. The number of cities and the place where the cities are from is entered into the program
3. The cities are displayed in  the correct order
    
####Extensions
1. The returned cities could be added to a .txt file for analysis

####Sub-Variations
N/A

####Schedule
Due: Release 1.0.

## Use Case 8 - Display the top n, where N is defined by the user, populated countries in the world, a continent or a region.

### Characteristic Information

#### Goal in Context
As an Analyst I want to see the population for a specified amount of countries worldwide, continental or regional, based on their population so that I can create a ranking. 

#### Scope
Company

####Level
Primary Task

####Preconditions
Knowing how many countries to display
Knowing where the countries to be displayed are from
Having the relevant data

####Success End Condition
The correct countries are displayed

####Failed End Condition
The correct number, or the correct countries are not displayed

####Primary Actor
Analyst

####Trigger
Analyst receives a request

####Main Success Scenario
1. Analyst receives a request
2. Analyst enters the number and the places where the countries are to be taken from
3. The correct countries are  to be displayed
    
####Extensions
1. The countries are displayed in a .txt to be analysed

####Sub-Variations
N/A 

####Schedule
Due: Release 1.0.

## Use Case 9 - Display all the counries worldwide, per continent, or per region by population from largest to smallest

### Characteristic Information

#### Goal in Context
 As an Analyst I want to view all countries worldwide, continental or regional, in descending order based on their population so that I can easily inspect population trends. 

#### Scope
Company

####Level
Primary Task

####Preconditions
Know where the countries to be selected are from
Have the relevant data

####Success End Condition
The correct countries are displayed in the correct order

####Failed End Condition
The correct countries are displayed in the wrong order or the incorrect countries are displayed

####Primary Actor
Analyst

####Trigger
Analyst receives a request

####Main Success Scenario
1. Analyst receives a request
2. Analyst enters the place the countries are to be taken from
3. The countries are displayed
    
####Extensions
1. The countries displayed are written to a .txt for analysis

####Sub-Variations
N/A

####Schedule
Due: Release 1.0.
Due: Release 1.0.