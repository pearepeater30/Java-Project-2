package org.com1027.formative2.ng00367.extra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

import org.com1027.formative2.ng00367.extra.Month;

public class Rainfall {
	/** An array that stores RainfallYear objects. The array is initialized with as null. */
	private RainfallYear rainfallYears[] = null;
	
	/**
     * Parameterized Constructor to create a new Rainfall object.
     * @param rainfallYears array.
 
     */
	public Rainfall(String filename) {
		super();
		
		BufferedReader reader = null;
		   
	    /** stack created so that we can use it to ensure that all the readers are closed properly at the end of this method */
	    Stack<BufferedReader> stack = new Stack<BufferedReader>();

	    try {
	      /** Reader initialised used to find  the number of read the number of rows */
	      reader = new BufferedReader(new FileReader(filename));
	      
	      /** read the number of years there are, so the rainfallYears array can be initialized with a defined value */
	      int numberOfLines = 0;
	      while (reader.readLine() != null) {
	    	  numberOfLines++;
	      }
	      reader.close();
	      
	      /** initialising the rainfallYears array */
	      this.rainfallYears = new RainfallYear[numberOfLines];
	      
	      /** Attempt to open the files */
	      reader = new BufferedReader(new FileReader(filename));

	      /** readers opened so add to stack */
	      stack.push(reader);

	      /** Read and parse each line from the file so create a local variable to hold the line and initialise it*/
	      String line1 = null;
	      

	      /** looping through each row */
	      for (int lineNum = 0; lineNum<numberOfLines; lineNum++) {
	    	/** storing the rows in line1 */
	    	line1 = reader.readLine();
	        /** create the local variables to use;*/
	        int year = 0;
	        double[] rainfall = new double[12];
	        
	        /** Split the line in a file */
	        String[] values1 = line1.split(",");
	        
	        /** Make sure we have enough values to parse: */
	        if (values1.length == 13){
	 
	           /** first array value is a year, therefore assign it as year */
	           year = Integer.parseInt(values1[0]);    
	          
	         
	          /** Remaining values of marks are in the order they are in the file */
	          for (int i = 1; i < values1.length; i++) { // Start from 1.
	            rainfall[i - 1] = Double.parseDouble(values1[i]);
	            
	            
	          }
	          
	        /** now assign the newly created object to the field of the class for each year */
	        this.rainfallYears[lineNum] = new RainfallYear(year, rainfall);
	        System.out.println(line1);

	        
	        }
	    } 
	  } 
	    /** buffered reader failure */
	    catch (IOException error) {
	      error.printStackTrace();
	    }
	    finally {
	      /**  closing the readers */
	      this.close(stack);
	    }

	  }
	
	/**
     * finds the highest mean precipitation in the array rainfallYears.
     *
     * @return Returns the value of the highest mean rainfall across rainfallYears
     */
	
	public double calculateHighestMeanAnnualRainfall() {
		 /** Value used to compare the current mean rainfall vs this variable. */
		double highestRainfall = -1;
		try {
			for (int i = 0; i < rainfallYears.length; i++) {
				double tempRainfall = this.rainfallYears[i].calculateMeanRainfall();
				/**tempRainfall replaces the highestRainfall if tempRainfall is bigger than highestRainfall */
				if (tempRainfall > highestRainfall) {
					highestRainfall = tempRainfall;
				}
			}
		}
		catch (NullPointerException e) {
			System.out.println("the rainfallYears array is empty!");
		}
			
		return highestRainfall;

	}
	
	/**
     * finds the lowest mean precipitation in the array rainfallYears.
     *
     * @return Returns the value of the lowest mean rainfall across rainfallYears
     */

	public double calculateLowestMeanAnnualRainfall() {
		 /** Value used to compare the current mean rainfall vs this variable. */
		double lowestRainfall = this.rainfallYears[0].calculateMeanRainfall();
		try {
			for (int i = 0; i < rainfallYears.length; i++) {
				double tempRainfall = this.rainfallYears[i].calculateMeanRainfall();
				/**tempRainfall replaces the lowestRainfall if tempRainfall is smaller than lowestRainfall */
				if (tempRainfall < lowestRainfall) {
					lowestRainfall = tempRainfall;
				}
			}
		}
		catch (NullPointerException e) {
			System.out.println("the rainfallYears array is empty!");
		}
		return lowestRainfall;
	}
	
	/**
     * Finds the mean rainfall for a specific month across all objects in rainfallYears. 
     *
     * @return Returns the mean value of rainfall for a specified month
     */

	public double calculateMeanRainfallMonth(Month month) {
		double mean = 0;
		try {
			for (int i = 0; i < this.rainfallYears.length; i++) {
				/**mean stores the mean rainfall for the month specified across all the rainfallYears  */
				mean += this.rainfallYears[i].getRainfallMonth(month);
			}
		}
		catch (IllegalArgumentException e){
			System.out.println("Illegal Argument used!");
		}
		return mean / this.rainfallYears.length;
	}
	/**
     * Finds the mean rainfall for a specific year in rainfallYears object
     *
     * @return Returns the mean value of rainfall for a specified year
     */
	public double calculateMeanRainfallYear(int year) {
		double meanYear = 0.0;
		try {
			for (int i = 0; i < this.rainfallYears.length; i++) {
				/**Searches for the year in the rainfallYears array  */
				if (year == this.rainfallYears[i].getYear()) {
					meanYear = this.rainfallYears[i].calculateMeanRainfall();
				}
				else {
					System.out.println("There are no years which are in the rainfallYear object");
				}
			}
		}
		catch (NullPointerException e){
			System.out.println("Illegal Argument used!");
		}
		return meanYear;
	}
	
	/**
     * gets the mean rainfall between two years
     *
     * @return Returns the mean of rainfall from two years.
     */
	
	public double calculateMeanRainfallTwoYears(int year1, int year2) {
		double totalYear1 = 0.0;
		double totalYear2 = 0.0;
		/**two for loops are used to store find the years desired */
		try {
			for (int i = 0; i < this.rainfallYears.length; i++) {
				if (year1 == this.rainfallYears[i].getYear()) {
					totalYear1 = this.rainfallYears[i].calculateMeanRainfall();
				}
				else {
					System.out.println("Year 1 not found");
				}
			}	
			for (int j = 0; j < this.rainfallYears.length; j++) {
				if (year2 == this.rainfallYears[j].getYear()) {
					totalYear2 = this.rainfallYears[j].calculateMeanRainfall();
				}
				else {
					System.out.println("Year 2 not found");
				}
			}
		}
		
		catch (IllegalArgumentException e){
			System.out.println("Illegal Argument used!");
		}
		return (totalYear1 + totalYear2) / 2;		
				
	}
	
	/**
     * Used to close readers that are still open
     *
     * 
     */
	private void close(Stack<BufferedReader> readers) {
		 BufferedReader currentReader = readers.pop();
		    if (currentReader != null) {
		      try {
		        currentReader.close();
		      }
		      catch (IOException e) {
		        /** if failure to close */
		        e.printStackTrace();
		      }
		      finally {
		        /**  if more readers to close then call recursively */
		        if (!readers.isEmpty()) {
		          this.close(readers);
		        }
		      }
		  }
	}
	
	/**
     * gets all the years from the rainfallYears and stores it in an array
     *
     * @return Returns all the years for the rainfall data stored in the rainfallYears array.
     */
	public int[] getYears() {
		int[] allYears = new int[this.rainfallYears.length];
		try {
			for (int i = 0; i < this.rainfallYears.length; i++) {
				allYears[i] = this.rainfallYears[i].getYear();
			}
		}
		catch(NullPointerException e){
			System.out.println("The rainfallYears array is empty!");
		}
					
		return allYears;
		
	}


	

}
