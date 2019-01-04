package org.com1027.formative2.ng00367.extra;
/**
 * RainfallYear class used to store the mean rainfall for each month of a year in an array. Three methods and a constructor are provided.
 * 
 * @author Nathan Gu
 */

public class RainfallYear {
	/** The array used to store the mean rainfall for each month. A double data type is used. */
	private double[] rainfallMonths = null;
	/** A variable used to store the value of a year. The data type of integer is used. */
	private int year = 0;
	
	/**
     * Parameterized Constructor to create a new RainfallYear object.
     * @param year
     *          The year
     * @param rainfallMonths
     *          The array for the value of mean rainfall per month
 	 */
	
	public RainfallYear(int year, double[] rainfallMonths) {
		super();
		this.year = year;
		this.rainfallMonths = rainfallMonths;
	}
	
	/**
	    * @return the year 
	    */
		
	public int getYear() {
		return this.year;
	}
	
	 /**
	 * Uses a for loop to calculate the mean value of the array rainfallMonths. Therefore calculates the mean rainfall in this year
     * @return the mean rainfall of the year
     */
	public double calculateMeanRainfall(){
		double total_rainfall = 0;
		double mean_rainfall = 0;
		try {
			for (int i = 0; i < rainfallMonths.length; i++) {
				total_rainfall = total_rainfall + rainfallMonths[i];	
				mean_rainfall = total_rainfall / rainfallMonths.length;
			}
		}	
		catch(NullPointerException e) {
			System.out.println("Array is empty");
			
		}
		
		return mean_rainfall;
	}
	
	/**
	* Gets rainfall amount for a specific month. The ordinal() function is retrieve an index in the enum which can be used in the rainfallMonths array
    * @return the rain at the index of i (aka the month neeeded)
    */
	
	public double getRainfallMonth(Month month) {
		int i = month.ordinal();
		if (rainfallMonths.length == 0) {
			throw new NullPointerException("Array is empty!");
		}
		else {
			return rainfallMonths[i];
		}
	}
	

	

}