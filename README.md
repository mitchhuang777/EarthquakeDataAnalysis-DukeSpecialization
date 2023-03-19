# Welcome to the Course
Welcome to “Java Programming: Principles of Software Design”! We are excited that you are starting our course to learn how to write programs in Java, one of the most popular programming languages in the world. In this introductory module, you will hear an overview of this course and be introduced to the supporting resources available.
***

## Programming Exercise: Searching Earthquake Data

For the following assignments, you will start with the files provided, using most of the classes, and modifying only a few of them, and create a new class. The classes provided are:

+ The class Location, from the Android platform and revised for this course, a data class representing a geographic location. One of the constructors has parameters latitude and longitude, and one of the public methods is distanceTo. 
+ The class QuakeEntry, from the lesson, which has a constructor that requires latitude, longitude, magnitude, title, and depth. It has several get methods and a toString method.
+ The class EarthQuakeParser, from the lesson, which has a read method with one String parameter that represents an XML earthquake data file and returns an ArrayList of QuakeEntry objects.
+ The class EarthQuakeClient, which has been started for you and creates an EarthQuakeParser to read in an earthquake data file, creating an ArrayList of QuakeEntrys. You can test the program with the method createCSV to store an ArrayList of the earthquake data and print a CSV file. You will complete the methods that filter magnitude and distance in this class and add additional methods to it. 
+ The class ClosestQuakes, which has been started for you to find the ten closest quakes to a particular location. You will complete this method.

You can run your programs on the URL and see live data, but in order to make sure your program is correct we recommend running your program on a small file we have created that has only 25 lines of earthquake data. That file is nov20quakedatasmall.atom, and its contents printed as QuakeEntrys are:

```
# quakes read: 25
(33.54, -116.66), mag = 0.30, depth = -10410.00, title = 2km SE of Anza, California
(5.86, 126.18), mag = 4.50, depth = -68910.00, title = 55km S of Pondaguitan, Philippines
(38.70, 20.51), mag = 4.80, depth = -10000.00, title = 17km W of Nidri, Greece
(26.38, 142.71), mag = 5.50, depth = -12890.00, title = 91km SSE of Chichi-shima, Japan
(63.44, -147.62), mag = 1.60, depth = -7400.00, title = 66km E of Cantwell, Alaska
(40.37, 73.20), mag = 4.90, depth = -40790.00, title = 21km WNW of Gul'cha, Kyrgyzstan
(19.29, -155.23), mag = 2.10, depth = -2700.00, title = 16km S of Volcano, Hawaii
(0.91, 127.31), mag = 4.70, depth = -10000.00, title = 15km NNW of Kota Ternate, Indonesia
(49.41, 155.28), mag = 4.60, depth = -69810.00, title = 153km SSW of Severo-Kuril'sk, Russia
(36.27, -121.66), mag = 2.00, depth = -7630.00, title = 28km SSE of Carmel Valley Village, California
(63.25, -150.43), mag = 1.70, depth = -99900.00, title = 75km WSW of Cantwell, Alaska(36.65, -117.13), mag = -0.20, depth = -9300.00, title = 44km SW of Beatty, Nevada
(-11.63, 165.52), mag = 5.10, depth = -20700.00, title = 106km SSW of Lata, Solomon Islands
(35.00, -118.21), mag = 1.30, depth = 1010.00, title = Quarry Blast - 7km SSW of Mojave, California
(49.39, -120.44), mag = 2.40, depth = -20.00, title = Explosion - 8km SSE of Princeton, Canada
(47.89, -122.71), mag = 1.90, depth = -18.00, title = Explosion - 4km SSW of Port Ludlow, Washington
(39.69, -119.41), mag = 0.00, depth = -7600.00, title = 16km WNW of Fernley, Nevada
(8.53, -71.34), mag = 5.00, depth = -25160.00, title = 5km ENE of Lagunillas, Venezuela
(37.00, -116.94), mag = -0.10, depth = -6700.00, title = 18km WNW of Beatty, Nevada
(-24.20, -66.84), mag = 4.60, depth = -185930.00, title = 53km W of San Antonio de los Cobres, Argentina
(45.12, -108.59), mag = 2.20, depth = 2000.00, title = Quarry Blast - 35km NNW of Lovell, Wyoming
(-36.16, -71.12), mag = 4.00, depth = -121990.00, title = 55km SE of Linares, Chile
(38.27, 142.53), mag = 4.60, depth = -30500.00, title = 109km E of Ishinomaki, Japan
(-24.67, -175.93), mag = 5.10, depth = -10000.00, title = South of Tonga
(34.05, -117.36), mag = 1.20, depth = 1040.00, title = Quarry Blast - 4km WNW of Grand Terrace, California
```

This output has been modified to reflect the updated EarthQuakeParser class, 1/12/16. Note especially the possibility of negative magnitudes.

## Assignment 1: Filtering by Magnitude and Distance
In this assignment you will complete the program to filter earthquake data by magnitude and distance, which was described in this lesson in the videos “Coding a Magnitude Filter” and “Coding a Distance Filter.”

Specifically, for this assignment, you will only modify one class, the EarthQuakeClient class:

+ Write the method filterByMagnitude that has already been started for you. This method has two parameters, an ArrayList of type QuakeEntry named quakeData, and a double named magMin. This method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData that have a magnitude larger than magMin. Notice that we have already created an ArrayList named answer for you to store those earthquakes that satisfy this requirement.
+ Modify the method bigQuakes that has no parameters to use filterByMagnitude and print earthquakes above a certain magnitude, and also print the number of such earthquakes. Currently this method reads data on earthquakes from a file, stores a QuakeEntry for each earthquake read in the ArrayList named list, and prints out the number of earthquakes read in. After making modifications, when you run your program on the file nov20quakedatasmall.atom for quakes larger than 5.0, you should get the output:

```
read data for 25 quakes
(26.38, 142.71), mag = 5.50, depth = -12890.00, title = 91km SSE of Chichi-shima, Japan
(-11.63, 165.52), mag = 5.10, depth = -20700.00, title = 106km SSW of Lata, Solomon Islands
(-24.67, -175.93), mag = 5.10, depth = -10000.00, title = South of Tonga
Found 3 quakes that match that criteria
```

+ Write the method filterByDistanceFrom that has already been started for you. This method has three parameters, an ArrayList of type QuakeEntry named quakeData, a double named distMax, and a Location named from. This method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData that are less than distMax from the location from. Notice that we have already created an ArrayList named answer for you to store those earthquakes that satisfy this requirement. 
+ Modify the method closeToMe that has no parameters to call filterByDistance to print out the earthquakes within 1000 Kilometers to a specified city (such as Durham, NC). For each earthquake found, print the distance from the earthquake to the specified city, followed by the information about the city (use getInfo()). Currently this method reads data on earthquakes from a URL, stores a QuakeEntry for each earthquake read in the ArrayList named list, and prints out the number of earthquakes read in. It also gives the location for two cities, Durham, NC (35.988, -78.907) and Bridgeport, CA (38.17, -118.82). After making modifications, when you run your program on the file nov20quakedatasmall.atom for the city location Durham, NC, no earthquakes are found. But if you then run the program for the city location Bridgeport, CA, seven earthquakes are found, and you should get the output:

```
read data for 25 quakes
549.2146875 2km SE of Anza, California
329.17615625 28km SSE of Carmel Valley Village, California
225.440046875 44km SW of Beatty, Nevada
356.428375 Quarry Blast - 7km SSW of Mojave, California
176.09775 16km WNW of Fernley, Nevada
210.82540625 18km WNW of Beatty, Nevada
475.94878125 Quarry Blast - 4km WNW of Grand Terrace, California
Found 7 quakes that match that criteria
```
> `EarthQuakeClient.java`

## Assignment 2: Filtering by Depth
In this assignment you will filter earthquakes by their depth, finding those earthquakes whose depth is between a minimum and maximum value. For more information on what the "depth" of an earthquake means, see the information here: http://earthquake.usgs.gov/learn/topics/seismology/determining_depth.php 

Specifically, for this assignment, you will add new methods to one class, the EarthQuakeClient class:

+ Write the method filterByDepth that has three parameters, an ArrayList of type QuakeEntry named quakeData,  a double named minDepth and a double named maxDepth. This method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData whose depth is between minDepth and maxDepth, exclusive. (Do not include quakes with depth exactly minDepth or maxDepth.)
+ Write the void method quakesOfDepth that has no parameters to use filterByDepth and print all the earthquakes from a data source whose depth is between a given minimum and maximum value. You should also print out the number of earthquakes found. After writing this method, when you run your program on the file nov20quakedatasmall.atom for quakes with depth between -10000.0 and -5000.0 you should find five such quakes and get the output:

```
read data for 25 quakes
Find quakes with depth between -10000.0 and -5000.0
(63.44, -147.62), mag = 1.60, depth = -7400.00, title = 66km E of Cantwell, Alaska
(36.27, -121.66), mag = 2.00, depth = -7630.00, title = 28km SSE of Carmel Valley Village, California
(36.65, -117.13), mag = -0.20, depth = -9300.00, title = 44km SW of Beatty, Nevada
(39.69, -119.41), mag = 0.00, depth = -7600.00, title = 16km WNW of Fernley, Nevada
(37.00, -116.94), mag = -0.10, depth = -6700.00, title = 18km WNW of Beatty, Nevada
Found 5 quakes that match that criteria
```

> `EarthQuakeClient.java`

## Assignment 3: Filtering by Phrase in Title
In this assignment you will filter earthquakes by a phrase in the title given for the earthquake in three ways, finding those earthquakes whose title starts with a phrase, ends with a phrase, or just has a phrase somewhere in the title.

Specifically, for this assignment, you will add new methods to one class, the EarthQuakeClient class:

+ Write the method filterByPhrase that has three parameters, an ArrayList of type QuakeEntry named quakeData, a String named where that indicates where to search in the title and has one of three values: (“start”, ”end”, or “any”), and a String named phrase, indicating the phrase to search for in the title of the earthquake. The title of the earthquake can be obtained through the getInfo() method. The filterByPhrase method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData whose titles have the given phrase found at location where (“start” means the phrase must start the title, “end” means the phrase must end the title and “any” means the phrase is a substring anywhere in the title.)
+ Write the void method quakesByPhrase to use filterByPhrase and print all the earthquakes from a data source that have phrase in their title in a given position in the title. You should also print out the number of earthquakes found. After writing this method, when you run your program on the file nov20quakedatasmall.atom for quakes with phrase “California” and where set to “end”  you should find four such quakes and get the output:

```
read data for 25 quakes
(33.54, -116.66), mag = 0.30, depth = -10410.00, title = 2km SE of Anza, California
(36.27, -121.66), mag = 2.00, depth = -7630.00, title = 28km SSE of Carmel Valley Village, California
(35.00, -118.21), mag = 1.30, depth = 1010.00, title = Quarry Blast - 7km SSW of Mojave, California
(34.05, -117.36), mag = 1.20, depth = 1040.00, title = Quarry Blast - 4km WNW of Grand Terrace, California
Found 4 quakes that match California at end
```

For another example, when you run your program on the file nov20quakedatasmall.atom for quakes with phrase “Can” and where set to “any”  you should find three such quakes and get the output:

```
read data for 25 quakes
(63.44, -147.62), mag = 1.60, depth = -7400.00, title = 66km E of Cantwell, Alaska
(63.25, -150.43), mag = 1.70, depth = -99900.00, title = 75km WSW of Cantwell, Alaska
(49.39, -120.44), mag = 2.40, depth = -20.00, title = Explosion - 8km SSE of Princeton, Canada
Found 3 quakes that match Can at any
```

For another example, when you run your program on the file nov20quakedatasmall.atom for quakes with phrase “Explosion” and where set to “start” you should find two such quakes and get the output:

```
read data for 25 quakes
(49.39, -120.44), mag = 2.40, depth = -20.00, title = Explosion - 8km SSE of Princeton, Canada
(47.89, -122.71), mag = 1.90, depth = -18.00, title = Explosion - 4km SSW of Port Ludlow, Washington
Found 2 quakes that match Explosion at start
```

> `EarthQuakeClient.java`

## Assignment 4: Finding the Closest Earthquakes to a Location
In this assignment you will complete the program to determine the N closests earthquakes to a specified location that was described in this lesson in the video. 

Specifically, for this assignment, you will only modify one class, the ClosestQuakes class:

+ The first method you need has already been written for you. The method findClosestQuakes reads in data on earthquakes storing them in the ArrayList list and prints how many quakes there are. It sets a location variable named jakarta to the location of the city Jakarta. It then calls the method getClosest to determine the ten closest earthquakes in list and prints information about those quakes and how close they are to Jakarta. This method has already been written for you, but doesn’t work yet since the method getClosest is not complete. 
+ Complete the method getClosest that has already been started for you. This method has three parameters, an ArrayList of type QuakeEntry named quakeData, a Location named current, and an int named howMany. This method should find the closest number of howMany earthquakes to the current Location and return them in an ArrayList of type QuakeEntry. The earthquakes should be in the ArrayList in order with the closest earthquake in index position 0.  If there are fewer then howMany earthquakes in quakeData, then the ArrayList returned would be the same size as quakeData. 
+ Now run the method findClosestQuakes by calling getClosest with the location current set to Jakarta (-6.211,106.845) and howMany set to 3. When you run your program on the file nov20quakedatasmall.atom you should find the three closest quakes and get the output:

```
read data for 25
2406.51 (0.91, 127.31), mag = 4.70, depth = -10000.00, title = 15km NNW of Kota Ternate, Indonesia
2529.61 (5.86, 126.18), mag = 4.50, depth = -68910.00, title = 55km S of Pondaguitan, Philippines
5289.10 (26.38, 142.71), mag = 5.50, depth = -12890.00, title = 91km SSE of Chichi-shima, Japan
number found: 3
```

> `ClosestQuakes.java`

## Assignment 5: Finding the Largest Magnitude Earthquakes
In this assignment you will write a new class and methods to determine the N biggest earthquakes, those with largest magnitude.

Specifically, for this assignment, you will: 

+ Write a new class named  LargestQuakes. Be sure to import java.util.*;
+ Write a void method named findLargestQuakes that reads in earthquake data from a source and storing them into an ArrayList of type QuakeEntry. Then it prints all the earthquakes and how many earthquakes that were from the source. You should read in earthquakes from the small file nov20quakedatasmall.atom, print all the earthquakes and also print how many there are. After this works you should comment out the printing of all the earthquakes, but continue to print out the total number of earthquakes read in. 
+ Write a method named indexOfLargest that has one parameter, an ArrayList of type QuakeEntry named data. This method returns an integer representing the index location in data of the earthquake with the largest magnitude. You should test out this method by adding code to the method  findLargestQuakes to print the index location of the largest magnitude earthquake in the file nov20quakedatasmall.atom and the earthquake at that location. You will see that the largest such earthquake is at location 3 and has magnitude 5.50. Once this works you may want to comment this out. 
+ Write a method named getLargest that has two parameters, an ArrayList of type QuakeEntry named quakeData and an integer named howMany. This method returns an ArrayList of type QuakeEntry of the top howMany largest magnitude earthquakes from quakeData. The quakes returned should be in the ArrayList in order by their magnitude, with the largest magnitude earthquake in index position 0. If quakeData has fewer than howMany earthquakes, then the number of earthquakes returned in the ArrayList is equal to the number of earthquakes in quakeData. This method should call the method indexOfLargest.
+ Modify the method findLargestQuakes to call getLargest to print the five earthquakes of largest magnitude from the file nov20quakedatasmall.atom. Those five earthquakes are:

```
(26.38, 142.71), mag = 5.50, depth = -12890.00, title = 91km SSE of Chichi-shima, Japan
(-11.63, 165.52), mag = 5.10, depth = -20700.00, title = 106km SSW of Lata, Solomon Islands
(-24.67, -175.93), mag = 5.10, depth = -10000.00, title = South of Tonga
(8.53, -71.34), mag = 5.00, depth = -25160.00, title = 5km ENE of Lagunillas, Venezuela
(40.37, 73.20), mag = 4.90, depth = -40790.00, title = 21km WNW of Gul'cha, Kyrgyzstan
```

> `LargestQuakes.java`

***

## Programming Exercise: Filtering Data

For the following assignments, you will start with the files provided, using most of the classes, and modifying only a few of them, and create new classes. First there are several classes provided from the previous lesson that are unchanged:

+ The class Location, from the Android platform and revised for this course, a data class representing a geographic location. One of the constructors has parameters latitude and longitude, and one of the public methods is distanceTo.
+ The class QuakeEntry, from the lesson, which has a constructor that requires latitude, longitude, magnitude, title, and depth. It has several get methods and a toString method.
+ The class EarthQuakeParser, from the lesson, which has a read method with one String parameter that represents an XML earthquake data file and returns an ArrayList of QuakeEntry objects.

There are several new classes and an interface that are provided for you. 

+ The interface Filter, which has one method signature named satisfies. Note that satisfies is not defined. Any class you write that implements Filter must provide the satisfies method.
+ The class MinMagFilter that implements Filter. This class has a private double variable named magMin, representing the minimum magnitude of earthquakes to consider for filtering. This class has a constructor with one parameter named min to initialize magMin, and a satisfies method that returns true if its QuakeEntry parameter qe has a magnitude greater than or equal to magMin.
+ The class EarthQuakeClient2, which has been started for you. It contains several methods including the following.

- The method filter that has two parameters, an ArrayList of type QuakeEntry named quakeData, and a Filter named f. This method returns an ArrayList of QuakeEntry’s from quakeData that meet the requirements of Filter f’s satisfies method. 
- The void method quakesWithFilter that has no parameters. This method creates an EarthQuakeParser to read in an earthquake data file, creating an ArrayList of QuakeEntrys. It then creates a MinMagFilter with minimum magnitude 4.0, and then calls the filter method with the MinMagFilter to create an ArrayList of QuakeEntry’s that have magnitude 4.0 or greater.  

## Assignment 1: Implementing Filters

In this assignment you will create several new filters and add code to test them.

Specifically, for this assignment, you will:

+ Write the class MagnitudeFilter that implements Filter. This class should include private instance variables for a minimum and maximum magnitude, a constructor to initialize those variables, and a satisfies method that returns true if a QuakeEntry’s magnitude is between the minimum and maximum magnitudes, or equal to one of them. Otherwise it should return false.
+ Write the class DepthFilter that implements Filter. This class should include private instance variables for a minimum and maximum depth, a constructor to initialize those variables, and a satisfies method that returns true if a QuakeEntry’s depth is between the minimum and maximum depths, or equal to one of them. Otherwise it should return false. 
+ Write the class DistanceFilter that implements Filter. This class should include private instance variables for a location and a maximum distance, a constructor to initialize those variables, and a satisfies method that returns true if a QuakeEntry’s distance from the given location is less than the specified maximum distance. Otherwise it should return false.
+ Write the class PhraseFilter that implements Filter. This class should include two private instance variables for 1) a String representing the type of request that indicates where to search in the title and has one of three values: (“start”, ”end”, or “any”), and 2) a String indicating the phrase to search for in the title of the earthquake (Note the title of the earthquake can be obtained through the getInfo method). This class also has a constructor to initialize those variables, and a satisfies method that returns true if the phrase is found at the requested location in the title. If the phrase is not found, this method should return false.
+ Modify the code in the quakesWithFilter method in the EarthQuakeClient2 class to filter earthquakes using two criteria, those with magnitude between 4.0 and 5.0 and depth between -35000.0 and -12000.0. You’ll need to use both the MagnitudeFilter and the DepthFilter. Use one and then use the other on the result from the first. After writing this method, when you run your program on the file nov20quakedatasmall.atom, you will see the following two earthquakes meet that criteria:

(8.53, -71.34), mag = 5.00, depth = -25160.00, title = 5km ENE of Lagunillas, Venezuela

(38.27, 142.53), mag = 4.60, depth = -30500.00, title = 109km E of Ishinomaki, Japan

+ Comment out the previous code in quakesWithFilter in the EarthQuakeClient2 class and add additional code to the quakesWithFilter method in the EarthQuakeClient2 class to filter earthquakes using two criteria, those that are 10,000,000 meters (10,000 km) from Tokyo, Japan whose location is (35.42, 139.43), and that are in Japan (this means "Japan" should be the last word in the title). After writing this method, when you run your program on the file nov20quakedatasmall.atom, you will see the following two earthquakes meet that criteria:

(26.38, 142.71), mag = 5.50, depth = -12890.00, title = 91km SSE of Chichi-shima, Japan

(38.27, 142.53), mag = 4.60, depth = -30500.00, title = 109km E of Ishinomaki, Japan

> `MagnitudeFilter.java`

> `DepthFilter.java`

> `DistanceFilter.java`

> `PhraseFilter.java`

> `EarthQuakeClient2.java`

## Assignment 2: MatchAllFilter and Modification to the Interface

In this assignment you will write a class named MatchAllFilter that can store and apply many filters, and you will also modify the Filter interface to store the name of the filter. 

+ Write the class MatchAllFilter that implements Filter. This class has a private ArrayList of Filters that is created in the constructor that has no parameters. This class has two methods, 1) a void method named addFilter with one Filter parameter that adds the Filter to its private ArrayList, and 2) a method named satisfies that has one QuakeEntry parameter and returns true if the QuakeEntry satisfies all the filter conditions, otherwise it returns false. 
+ Write a new void method named testMatchAllFilter in the EarthQuakeClient2 class. This method reads in earthquake data from a source and stores them into an ArrayList of type QuakeEntry. Then it prints all the earthquakes and how many earthquakes that were from the source. You should read in earthquakes from the small file nov20quakedatasmall.atom, print all the earthquakes and also print how many there are. After this works you should comment out the printing of all the earthquakes, but continue to print out the total number of earthquakes read in. Then create a MatchAllFilter named maf and use the addFilter method to add three Filters to test the magnitude between 0.0 and 2.0, to test the depth between -100000.0 and -10000.0, and if the letter “a” is in the title. Then use filter(list, maf) to use all three filters and print out the resulting list of earthquakes. You will see the following two earthquakes meet that criteria:

(33.54, -116.66), mag = 0.30, depth = -10410.00, title = 2km SE of Anza, California

(63.25, -150.43), mag = 1.70, depth = -99900.00, title = 75km WSW of Cantwell, Alaska

+ Write a new void method named testMatchAllFilter2 in the EarthQuakeClient2 class. This method should be identical to the method testMatchAllFilter, but will create different Filters. You should read in earthquakes from the small file nov20quakedatasmall.atom.Then create a MatchAllFilter named maf, and use the addFilter method to add three Filters to test the magnitude between 0.0 and 3.0, to test for the distance from Tulsa, Oklahoma at location (36.1314, -95.9372) is less than 10000000 meters (10000 km), and if the substring “Ca” is in the title. Then use filter(list, maf) to use all three filters and print out the resulting list of earthquakes. You will see the following seven earthquakes meet that criteria:

(33.54, -116.66), mag = 0.30, depth = -10410.00, title = 2km SE of Anza, California

(63.44, -147.62), mag = 1.60, depth = -7400.00, title = 66km E of Cantwell, Alaska

(36.27, -121.66), mag = 2.00, depth = -7630.00, title = 28km SSE of Carmel Valley Village, California

(63.25, -150.43), mag = 1.70, depth = -99900.00, title = 75km WSW of Cantwell, Alaska

(35.00, -118.21), mag = 1.30, depth = 1010.00, title = Quarry Blast - 7km SSW of Mojave, California

(49.39, -120.44), mag = 2.40, depth = -20.00, title = Explosion - 8km SSE of Princeton, Canada

(34.05, -117.36), mag = 1.20, depth = 1040.00, title = Quarry Blast - 4km WNW of Grand Terrace, California

+ Modify the Filter interface to include a new method named getName that returns the name of the filter. The line added to the Filter interface should be: public String getName(); What changes need to be made to all the Filter classes? The user should be able to specify what they want the name of the filter to be when they create a specific filter. For the MatchAllFilter class, a getName method should return a String of all the Filter names in its ArrayList.
+ Add to the end of the method testMatchAllFilter a call to the MatchAllFilter getName method to print out all the Filter names used. For the example above, printing “Filters used are: “ followed by the call to getName could result in the output:

Filters used are: Magnitude Depth Phrase

> `MatchAllFilter.java`

> `EarthQuakeClient2.java`

> `Filter.java`

***

## Earthquakes: Sorting Algorithms

In this module, you will continue using real earthquake data to explore several sorting algorithms. You will learn how to implement a selection sort and a bubble sort, then be introduced to a Java method Collections.sort, which sorts with much greater efficiency. By the end of this module, you will be able to (1) implement several sorting algorithms from scratch, (2) use efficient pre-existing sorting classes, (3) modify a class’s compareTo method to choose the criteria by which objects of that type are ordered, and (4) write classes that implement the Comparator interface to create interchangeable sorting criteria.

## Programming Exercise: Implementing Selection Sort

For the following assignments, you will start with the files provided, using most of the classes, and modifying only one of them.  

First there are several classes provided from the previous lesson that are unchanged:

+ The class Location, from the Android platform and revised for this course, a data class representing a geographic location. One of the constructors has parameters latitude and longitude, and one of the public methods is distanceTo.
+ The class QuakeEntry, from the lesson, which has a constructor that requires latitude, longitude, magnitude, title, and depth. It has several get methods and a toString method.
+ The class EarthQuakeParser, from the lesson, which has a read method with one String parameter that represents an XML earthquake data file and returns an ArrayList of QuakeEntry objects.

There are several new classes: 

+ The QuakeSortWithTwoArrayLists class includes code shown in the video “Translating to Code” on how to sort using two ArrayLists of QuakeEntry’s. You should run the testSort method and understand how this sorting algorithm works. 
+ The QuakeSortInPlace class is the class you will modify. Currently it implements the selection sort algorithm that sorts earthquakes by magnitude in place, in one ArrayList of QuakeEntry’s. The code for the method sortByMagnitude was shown in the video “In Place.” You should run the testSort method and understand how this sorting algorithm works. 

> `QuakeSortWithTwoArrayLists.java`

## Assignment 1: Sort by Depth

In this assignment, you will add methods in the QuakeSortInPlace class to sort the quakes by depth, from largest depth to smallest depth. This will mean any positive depth values will be first, followed by depths with increasingly negative values, e.g., 200.00, 0.00, -20000.00, -100000.00.

Specifically, for this assignment, you will modify the QuakeSortInPlace class:

+ Write the method getLargestDepth that has two parameters, an ArrayList of type QuakeEntry named quakeData and an int named from representing an index position in the ArrayList. This method returns an integer representing the index position of the QuakeEntry with the largest depth considering only those QuakeEntry’s from position from to the end of the ArrayList. 
+ Write the void method sortByLargestDepth that has one parameter, an ArrayList of type QuakeEntry named in. This method sorts the QuakeEntry’s in the ArrayList by depth using the selection sort algorithm, but in reverse order from largest depth to smallest depth (the QuakeEntry with the largest depth should be in the 0th position in the ArrayList). This method should call the method getLargestDepth repeatedly until the ArrayList is sorted. 
+ Modify the testSort method to comment out the line sortByMagnitude and add below this line a call to sortByLargestDepth. Run your program on any data file and you should see the earthquakes in sorted order from largest depth to smallest depth> ``

> `QuakeSortInPlace.java`

## Assignment 2: Bubble Sort

For this assignment, you will implement the bubble sort algorithm, which also sorts the data in an ArrayList in place. Bubble sort sorts using several passes. One pass over the ArrayList compares adjacent elements and swaps them if they are out of order. For example, if we want to sort the numbers:

4  7  3  8  1

One pass would compare the first two elements in the ArrayList, 4 and 7.  They are in order, so there is no swap. Then the second and third elements are compared, 7 and 3, they are out of order, so they would be swapped, resulting in:  

4  3  7  8  1

The next two adjacent elements are compared, the third and fourth elements, 7 and 8. They are in order, so there is no swap. The next two adjacent elements are 8 and 1. They are out of order, so they are swapped, resulting in: 

4  3  7  1  8

The pass is complete. Notice that as a result of the pass, the largest element in the ArrayList, which is larger than any other element, is “bubbled” down and is the last item in the ArrayList, where it belongs in the final sorted order. 

After a second pass, the elements in the ArrayList should be in the order:

3  4  1  7  8 

Notice now that the last two elements, the largest two, should be where they belong in the final sorted order. 

The bubble sort algorithm works as follows. If there are N elements in the ArrayList. Apply N-1 passes, and the ArrayList should be sorted. Notice that with each pass, there is one more element where it belongs in the final sorted order. Thus each pass can look at one fewer element than the previous pass.

Specifically, for this assignment, you will modify the QuakeSortInPlace class:

+ Write the void method onePassBubbleSort that has two parameters, an ArrayList of type QuakeEntry named quakeData and an int named numSorted that represents the number of times this method has already been called on this ArrayList and thus also represents the number of the elements that are guaranteed to already be where they belong when the ArrayList is sorted by magnitude. This method makes one pass of bubble sort on the ArrayList. It should take advantage of the fact that the last numSorted elements are already in sorted order. 
+ Write the void method sortByMagnitudeWithBubbleSort that has one parameter, an ArrayList of type QuakeEntry named in. If the ArrayList in has N elements in it, this method should call onePassBubbleSort N – 1 times to sort the elements in in.  
+ Modify the testSort method to comment out the line sortByLargestDepth, and add below this line a call to sortByMagnitudeWithBubbleSort. Run your program on any data file and you should see the earthquakes in sorted order from smallest to largest magnitude. 
+ Are you convinced your program is working correctly? Let’s add more output and test it on a small file. Add code to sortByMagnitudeWithBubbleSort to print all the quakes before a pass, and then to print all the quakes after each pass, identifying the pass. Since there will be a lot of data, you’ll only want to run your program on a small file. Once you are sure it works, you probably want to then comment out the print statements. Run your program on the file earthquakeDataSampleSix2.atom, which has data on only five earthquakes. You should get the following output. Focusing on the magnitude, after pass 0 (the first pass) the quake with magnitude 4.80 is last, after pass 1 the quake with magnitude 2.60 is where it belongs. Note that pass 3 wasn’t needed as the quakes were already in sorted order. That might happen sometimes.

Output:

```
read data for 5 quakes
(-23.27, -67.66), mag = 4.80, depth = -175320.00, title = 69km SE of San Pedro de Atacama, Chile
(35.68, -118.10), mag = 1.50, depth = -8280.00, title = 27km W of Inyokern, California
(36.22, -117.89), mag = 2.60, depth = -1450.00, title = 12km ESE of Olancha, California
(36.95, -121.57), mag = 1.00, depth = -8660.00, title = 6km S of Gilroy, California
(38.82, -122.77), mag = 1.40, depth = -1300.00, title = 3km W of Cobb, California
Printing Quakes after pass 0
(35.68, -118.10), mag = 1.50, depth = -8280.00, title = 27km W of Inyokern, California
(36.22, -117.89), mag = 2.60, depth = -1450.00, title = 12km ESE of Olancha, California
(36.95, -121.57), mag = 1.00, depth = -8660.00, title = 6km S of Gilroy, California
(38.82, -122.77), mag = 1.40, depth = -1300.00, title = 3km W of Cobb, California
(-23.27, -67.66), mag = 4.80, depth = -175320.00, title = 69km SE of San Pedro de Atacama, Chile
Printing Quakes after pass 1
(35.68, -118.10), mag = 1.50, depth = -8280.00, title = 27km W of Inyokern, California
(36.95, -121.57), mag = 1.00, depth = -8660.00, title = 6km S of Gilroy, California
(38.82, -122.77), mag = 1.40, depth = -1300.00, title = 3km W of Cobb, California
(36.22, -117.89), mag = 2.60, depth = -1450.00, title = 12km ESE of Olancha, California
(-23.27, -67.66), mag = 4.80, depth = -175320.00, title = 69km SE of San Pedro de Atacama, Chile
Printing Quakes after pass 2
(36.95, -121.57), mag = 1.00, depth = -8660.00, title = 6km S of Gilroy, California
(38.82, -122.77), mag = 1.40, depth = -1300.00, title = 3km W of Cobb, California
(35.68, -118.10), mag = 1.50, depth = -8280.00, title = 27km W of Inyokern, California
(36.22, -117.89), mag = 2.60, depth = -1450.00, title = 12km ESE of Olancha, California
(-23.27, -67.66), mag = 4.80, depth = -175320.00, title = 69km SE of San Pedro de Atacama, Chile
Printing Quakes after pass 3
(36.95, -121.57), mag = 1.00, depth = -8660.00, title = 6km S of Gilroy, California
(38.82, -122.77), mag = 1.40, depth = -1300.00, title = 3km W of Cobb, California
(35.68, -118.10), mag = 1.50, depth = -8280.00, title = 27km W of Inyokern, California
(36.22, -117.89), mag = 2.60, depth = -1450.00, title = 12km ESE of Olancha, California
(-23.27, -67.66), mag = 4.80, depth = -175320.00, title = 69km SE of San Pedro de Atacama, Chile
EarthQuakes in sorted order:
(36.95, -121.57), mag = 1.00, depth = -8660.00, title = 6km S of Gilroy, California
(38.82, -122.77), mag = 1.40, depth = -1300.00, title = 3km W of Cobb, California
(35.68, -118.10), mag = 1.50, depth = -8280.00, title = 27km W of Inyokern, California
(36.22, -117.89), mag = 2.60, depth = -1450.00, title = 12km ESE of Olancha, California
(-23.27, -67.66), mag = 4.80, depth = -175320.00, title = 69km SE of San Pedro de Atacama, Chile
```

> `QuakeSortInPlace.java`

## Assignment 3: Check for Completion

For this assignment, we will explore the idea that the data might be sorted before all the passes are complete. We want to write a method to determine whether a list is already sorted and then use that method to end our sorting algorithms early if earthquakes are sorted early.

Specifically, for this assignment, you will modify the QuakeSortInPlace class:

+ Write the method checkInSortedOrder that has one parameter, an ArrayList of type QuakeEntry named quakes. This method returns true if the earthquakes are in sorted order by magnitude from smallest to largest. Otherwise this methods returns false. You’ll need to loop through the ArrayList and check adjacent earthquakes to see if any are out of order. 
+ Write the void method sortByMagnitudeWithBubbleSortWithCheck that has one parameter, an ArrayList of type QuakeEntry named in. If the ArrayList in has N elements in it, this method should call onePassBubbleSort at most N – 1 times.  This method should call checkInSortedOrder and stop early if the ArrayList is already sorted. This method should print how many passes were needed to sort the elements. 
+ Modify the testSort method to call to sortByMagnitudeWithBubbleSortWithCheck. Run your program on any data files earthquakeDataSampleSix1.atom (should sort after 2 passes) and earthquakeDataSampleSix2.atom (should sort after 3 passes). Both of these files have five earthquakes.  
+ Write the void method sortByMagnitudeWithCheck that has one parameter, an ArrayList of type QuakeEntry named in. This method sorts earthquakes by their magnitude from smallest to largest using selection sort similar to the sortByMagnitude method. However, this method should call checkInSortedOrder and stop early if the ArrayList is already sorted. This method should print how many passes were needed to sort the elements. For selection sort, one pass has exactly one swap. 
+ Modify the testSort method to call to sortByMagnitudeWithCheck. Run your program on any data files earthquakeDataSampleSix1.atom (should sort after 3 passes) and earthquakeDataSampleSix2.atom (should sort after 4 passes). Both of these files have five earthquakes.  

> `QuakeSortInPlace.java`

***

## Programming Exercise: Sorting at Scale

For the following assignments, you will start with the files provided, using most of the classes, and modifying only a few of them.  

First there are several classes provided from the previous lesson that are unchanged:

+ The class Location, from the Android platform and revised for this course, a data class representing a geographic location. One of the constructors has parameters latitude and longitude, and one of the public methods is distanceTo.
+ The class QuakeEntry, from the lesson, which has a constructor that requires latitude, longitude, magnitude, title, and depth. It has several get methods and a toString method. It also has a compareTo method to sort earthquakes by magnitude (and commented out code that previously sorted earthquakes by distance to a location). You will be modifying the compareTo method in the first assignment. 
+ The class EarthQuakeParser, from the lesson, which has a read method with one String parameter that represents an XML earthquake data file and returns an ArrayList of QuakeEntry objects.

There are several new classes

+ The DifferentSorters class includes several methods that are similar to code shown in the videos to test several of the classes/methods in this assignment. You’ll be adding additional tester methods to this class.  
+ The MagnitudeComparator class implements Comparator to allow one to sort QuakeEntry’s by magnitude from smallest to largest magnitude. This method was mentioned in a video.
+ The DistanceComparator class implements Comparator to allow one to sort QuakeEntry’s by their distance to a specified location that is passed in as a parameter. This method was also mentioned in a video. 

> `MagnitudeComparator.java`

> `DistanceComparator.java`

## Assignment 1: compareTo Method

In this assignment, you will modify the **compareTo** method to sort quakes in a different way.

Specifically, for this assignment, you will: 

+ Modify the **compareTo** method in the QuakeEntry class. (You may want to comment out the current code first). The **compareTo** method should now sort quake by magnitude first, from smallest magnitude to largest magnitude, and then break ties (use == operator to determine whether magnitudes are equal) by depth, from smallest (most negative) depth to largest depth.
+ Test the **compareTo** method by running the **sortWithCompareTo** method in the DifferentSorters class with any data file. The sort used is **Collections.sort**. You should be able to see that the earthquakes are sorted by magnitude, and those with the same magnitude are sorted by depth. Modify this method to print out the QuakeEntry in the ArrayList in position 10 (which is actually the 11th element in the ArrayList) by adding the following code at the end of this method, after sorting and printing out all the elements.

```
int quakeNumber = 10;
System.out.println("Print quake entry in position " + quakeNumber);
System.out.println(list.get(quakeNumber));
```

When you run your method on the file nov20quakedata.atom, the element in position 10 that is printed should be:

```
(36.75, -116.15), mag = -0.20, depth = -4200.00, title = 57km ESE of Beatty, Nevada
```

This output has been modified to reflect the updated EarthQuakeParser class, 1/12/16. 

> `QuakeEntry.java`

> `DifferentSorters.java`

## Assignment 2: Title Comparator

In this assignment, you will write a Comparator to sort earthquakes by title first and break ties by depth. 

Specifically, for this assignment, you will: 

+ Write the TitleAndDepthComparator class that implements a Comparator of type QuakeEntry. In this class you should write the compare method that has two parameters, a QuakeEntry named q1 and a QuakeEntry named q2. This method should compare the title of q1 and q2. If q1’s title comes before q2’s title in alphabetical order, then this method should return a negative integer. If q1’s title comes after q2’s title, then this method should return a positive integer. If q1’s title is the same as q2’s title, then this method should compare the depth of the two earthquakes. If q1’s depth is less than q2’s depth, then this method should return a negative number. If q1’s depth is greater than q2’s depth, then this method should return a positive integer. Otherwise, this method should return 0. 
+ Write the void method sortByTitleAndDepth in the DifferentSorters class. This method should create an EarthQuakeParser, read data from a file on earthquakes and create an ArrayList of QuakeEntry’s. Then this method should call Collections.sort on this ArrayList and use the TitleAndDepthComparator to sort the earthquakes. You should be able to see that the earthquakes are sorted by title first, and those with the same title are sorted by depth. Modify this method to print out the QuakeEntry in the ArrayList in position 10 (which is actually the 11th element in the ArrayList) after sorting and printing out all the elements.

When you run your method on the file nov20quakedata.atom, the element in position 10 that is printed should be:

```
(49.76, 155.83), mag = 4.70, depth = -58380.00, title = 104km SSW of Severo-Kuril'sk, Russia
```

> `TitleAndDepthComparator.java`

> `DifferentSorters.java`

## Assignment 3: Last Word in Title Comparator

In this assignment, you will write a Comparator to sort earthquakes by the last word in their title first and break ties by magnitude. 

Specifically, for this assignment, you will: 

+ Write the TitleLastAndMagnitudeComparator class that implements a Comparator of type QuakeEntry. In this class you should write the compare method that has two parameters, a QuakeEntry named q1 and a QuakeEntry named q2. This method should compare the last word in the title of q1 and q2. If q1’s last word comes before q2’s last word in alphabetical order, then this method should return a negative integer. If q1’s last word comes after q2’s last word, then this method should return a positive integer. If q1’s last word is the same as q2’s last word, then this method should compare the magnitude of the two earthquakes. If q1’s magnitude is less than q2’s magnitude, then this method should return a negative number. If q1’s magnitude is greater than q2’s magnitude, then this method should return a positive integer. Otherwise, this method should return 0. 
+ Write the void method sortByLastWordInTitleThenByMagnitude in the DifferentSorters class. This method should create an EarthQuakeParser, read data from a file on earthquakes and create an ArrayList of QuakeEntry’s. Then this method should call Collections.sort on this ArrayList and use the TitleLastAndMagnitudeComparator to sort the earthquakes. You should be able to see that the earthquakes are sorted by the last word in their title, and those with the same last word are sorted by magnitude. Modify this method to print out the QuakeEntry in the ArrayList in position 10 (which is actually the 11th element in the ArrayList) after sorting and printing out all the elements.

When you run your method on the file nov20quakedata.atom, the element in position 10 that is printed should be:

```
(64.47, -149.48), mag = 0.40, depth = -16300.00, title = 21km WSW of North Nenana, Alaska
```

> `TitleLastAndMagnitudeComparator.java`

> `DifferentSorters.java`

