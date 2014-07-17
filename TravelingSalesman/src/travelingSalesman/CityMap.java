package travelingSalesman;

import java.util.ArrayList;
/**
 * City map object contains a list of cities and the distances between each city
 * @author Patrick
 *
 */
public class CityMap {
	private ArrayList<City> cities = new ArrayList<City>();
	private ArrayList<CityPair> pairs = new ArrayList<CityPair>();
	
	public CityMap()
	{
		
	}
	/**
	 * add a connection between two cities.  if either city is not in the master list it is added
	 * @param city1
	 * @param city2
	 * @param Distance
	 */
	public void addCityPair(City city1, City city2, Integer Distance)
	{
		if(!cities.contains(city1))
		{
			cities.add(city1);
		}
		if(!cities.contains(city2))
		{
			cities.add(city2);
		}
		CityPair pair = new CityPair(city1, city2, Distance);
		pairs.add(pair);
	}
	/**
	 * get distance between two cities.  If map is not complete this may return 0 if no data exists to link the two cities
	 * @param city1
	 * @param city2
	 * @return
	 */
	public Integer getDistance(City city1, City city2)
	{
		Integer distance = 0;
		for(CityPair pair:pairs)
		{
			if(pair.getStartCity() == city1 && pair.getEndCity() == city2 || pair.getStartCity() == city2 && pair.getEndCity() == city1)
			{
				distance = pair.getDistance();
			}
		}
		return distance;
	}
	/**
	 * returns true if all cities contain connections to all other cities
	 * @return
	 */
	public boolean isCompleteMap()
	{
		boolean complete = true;
		boolean matchFound = false;
		for(City city1:cities)
		{
			for(City city2:cities)
			{
				if (city1 != city2)
				{
					matchFound = false;
					for(CityPair pair:pairs)
					{
						if((pair.getStartCity() == city1 && pair.getEndCity() == city2)||(pair.getStartCity() == city2 && pair.getEndCity() == city1))
						{
							matchFound = true;
						}
					}
					if(!matchFound)
					{
						complete = false;
					}
				}
			}
		}
		return complete;
	}
	/**
	 * returns the list of cities map
	 * @return
	 */
	public ArrayList<City> getCities(){
		return cities;
	}
}
