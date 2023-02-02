/*
 * ENSF 380 - Assignment 1
 * 
 * Author: Jaiden Reese Sanchez
 * UCID: 30113637
 */

package edu.ucalgary.oop;

public class Itinerary {
	 private Trip[] trips = new Trip[20];

    // Returns a string in the format of:
    // value (key)
    public static String fmtString(String key, String value) {
    	String out = new String(value);
    	return out.concat("(" + key + ")");
    }

    // Constructor
    public Itinerary(String[][] myTrips) 
    {
    	for(int i = 0; i < myTrips.length; i++)
    	{
    		Trip newTrip = new Trip(myTrips[i]);
    		trips[i] = newTrip;
    	}
    }

    // Getter
    public Trip[] getTrips() {
    	return trips;
    }

    public String formatByArrival() {
    	String outFormat = new String();
    	for(int i = 1; i <= 3; i++) {
    		for(int j = 1; j <= 12; j++) {
    			boolean firstIndex = false;
    			if(trips[i] == null) {
        			break;
        		}
        		for(int k = 0; k < trips.length; k++) {
        			if (trips[k] == null) {
        				break;
        			}
        			else if (trips[k].getYear(trips[k].getArrival()) == (2020 + i) && trips[k].getMonth(trips[k].getArrival()) == j && firstIndex == false) {
        				outFormat = outFormat.concat(trips[k].fmtString("Year", Integer.toString(trips[k].getYear(trips[k].getArrival()))) + "\n--" 
        						+ trips[k].fmtString("Month", Integer.toString(trips[k].getMonth(trips[k].getArrival()))) + "\n----" 
        						+ trips[k].fmtString("city", trips[k].getCity()) + ", "	+ trips[k].fmtString("Country", trips[k].getCountry()) + " (Place)\n");
        				firstIndex = true;
        			}
        			else if (trips[k].getYear(trips[k].getArrival()) == (2020 + i) && trips[k].getMonth(trips[k].getArrival()) == j && firstIndex == true) {
        				outFormat = outFormat.concat("----" + trips[k].fmtString("city", trips[k].getCity()) + ", "	+ trips[k].fmtString("Country", trips[k].getCountry()) + " (Place)\n");
        			}
        		}
    		}
    	}
    	return outFormat;
    }

    // The first array holds years (2021-2023).
    // The second array holds months.
    // The third array holds formatted locations occurring in the year/month
    String[][][] byDate() {
    	
    	String[][][] orderedDates = new String[3][12][20];
    	
    	for(int i = 1; i <= 3; i++) {
    		for(int j = 1; j <= 12; j++) {
    			int index = 0;
    			if(trips[i] == null) {
        			break;
        		}
    			for(int k = 0; k < trips.length; k++) {
        			if (trips[k] == null) {
        				break;
        			}
        			else if (trips[k].getYear(trips[k].getArrival()) == (2020 + i) && trips[k].getMonth(trips[k].getArrival()) == j) {
        				orderedDates[i-1][j-1][index] = trips[k].fmtString("city", trips[k].getCity()) + ", "	+ trips[k].fmtString("Country", trips[k].getCountry());
        				index++;
        			}
        		}
    		}
    	}
    	return orderedDates;
    }
}
