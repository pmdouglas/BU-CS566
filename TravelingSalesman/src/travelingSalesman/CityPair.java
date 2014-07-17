package travelingSalesman;
/**
 * Pair object contains two city objects and the distance between them
 * @author Patrick
 *
 */
public class CityPair {
	private City city1;
	private City city2;
	private Integer distance;
	
	/**
	 * citypair constructor
	 * @param city1
	 * @param city2
	 * @param distance
	 */
	public CityPair(City city1,City city2, Integer distance)
	{
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
	}
	/**
	 * returns the first city of the pair
	 * @return
	 */
	public City getStartCity()
	{
		return city1;
	}
	/**
	 * returns the second city of the pair
	 * @return
	 */
	public City getEndCity()
	{
		return city2;
	}
	/**
	 * return the distance between the two cities
	 * @return
	 */
	public Integer getDistance()
	{
		return distance;
	}

}
