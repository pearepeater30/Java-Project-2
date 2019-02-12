# Java-Project-2

**extra contains all source code written by me.**

**extratest contains all code for testing the source code. This code was not written by me, but rather by my lecturers.**


This project is meant to view rainfall statistics for months and years in the UK. The application requires me to use the average rainfall to calculate the mean rainfall for a given year. The mean rainfall of a given month can also bee calculated throughout the years. The lowest and highest mean rainfall for any years can also be calculated.

A .CSV file containing a year number following with 12 numbers representing the mean rainfall per month can be read to present.

For example, the following extract from the file shows the data from 1873 through to 1875:

![alt text](https://github.com/pearepeater30/Java-Project-2/blob/master/Annotation%202019-02-12%20112806.jpg)

There are two classes used: Rainfall and RainfallYears. An enumeration type is used called Month.

The RainfallYears class stores the mean monthly rainfall data for one year in an array and the variable used to store the current year. A constructo is also included for the class. A getter for the year is included and also two methods are included. One is to calculate the mean rainfall for a year and another is to get the mean rainfall for a month.

The Rainfall class is used to store rainfall data for each year in an array as RainfallYears objects. As well as a method which will return an array of the availble years, this method also provide methods to:

- return the mean precipitation for a given year
- the lowest mean precipitation for all years
- the highest mean precipitation for all years
- a method that will calculate mean precipitation for a certain month across all years.

When a Rainfall object is constructed, it will receive the available precipitation data as an object via asa parameter and the test class has created a sample set of data for you to use.

I have also included a method in Rainfall which allows files to be read and calculating the mean rainfall between two years.
