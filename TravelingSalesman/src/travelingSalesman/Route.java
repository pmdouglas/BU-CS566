package travelingSalesman;

import java.util.ArrayList;
/**
 * Route object contains an ordered list of cities that have been visited as well as the total distance traveled
 * @author Patrick
 *
 */
public class Route {
	private Integer distanceTraveled;
	private ArrayList<City> visitedCities;
	/**
	 * copy constructor.  creates deep copy to be used for recursive calls
	 * @param route
	 */
	public Route(Route route)
	{
		this.distanceTraveled = route.distanceTraveled;
		this.visitedCities = new ArrayList<City>();
		for(int i = 0;i < route.visitedCities.size();i++)
		{
			this.visitedCities.add(route.visitedCities.get(i));
		}
	}
	/**
	 * Constructor takes a starting city 
	 * @param startCity
	 */
	public Route(City startCity)
	{
		distanceTraveled = 0;
		visitedCities = new ArrayList<City>();
		visitedCities.add(startCity);
	}
	/**
	 * returns the total distance traveled so far
	 * @return
	 */
	public Integer getDistanceTraveled()
	{
		return distanceTraveled;
	}
	/**
	 * adds a given city to list of visited city and increases the total travel distance apropriatly
	 * @param city
	 * @param distanceToNewCity
	 */
	public void travelToCity(City city, Integer distanceToNewCity)
	{
		visitedCities.add(city);
		distanceTraveled = distanceTraveled + distanceToNewCity;
	}
	/**
	 * returns true if a given city is already part of this route
	 * @param city
	 * @return
	 */
	public boolean cityBeenVisited(City city)
	{
		return visitedCities.contains(city);
	}
	/**
	 * returns full list of visited cities
	 * @return
	 *  
	 */
	public ArrayList<City> getVisitedCities()
	{
		return visitedCities;
	}
	/**
	 * print the list of visited cities to std out
	 */
	public void printRoute()
	{
		for(int i = 0; i< visitedCities.size();i++)
		{
			System.out.println("Visit City " + visitedCities.get(i).index);
		}
		System.out.println();
	}
}
