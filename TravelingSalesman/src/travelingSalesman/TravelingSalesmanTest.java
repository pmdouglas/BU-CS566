package travelingSalesman;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TravelingSalesmanTest {
	private CityMap smallCityMap;
	private CityMap bigCityMap;
	private CityMap incompleteCityMap;
	private	City city1 = new City();
	private	City city2 = new City();
	private	City city3 = new City();
	private	City city4 = new City();
	private	City city5 = new City();
	private City city6 = new City();
	private City city7 = new City();
	
	@Before
	public void setUp() throws Exception {
		city1.index = 1;
		city2.index = 2;
		city3.index = 3;
		city4.index = 4;
		city5.index = 5;
		city6.index = 6;
		city7.index = 7;
		
		smallCityMap = new CityMap();

		smallCityMap.addCityPair(city1, city2, 5);
		smallCityMap.addCityPair(city1, city3, 7);
		smallCityMap.addCityPair(city2, city3, 9);

		bigCityMap = new CityMap();
		
		bigCityMap.addCityPair(city1, city2, 1000);
		bigCityMap.addCityPair(city1, city3, 3);
		bigCityMap.addCityPair(city1, city4, 6);
		bigCityMap.addCityPair(city1, city5, 30);
		bigCityMap.addCityPair(city1, city6, 2);
		bigCityMap.addCityPair(city1, city7, 5);
		
		bigCityMap.addCityPair(city2, city3, 1);
		bigCityMap.addCityPair(city2, city4, 3);
		bigCityMap.addCityPair(city2, city5, 1);
		bigCityMap.addCityPair(city2, city6, 4);
		bigCityMap.addCityPair(city2, city7, 7);
		
		bigCityMap.addCityPair(city3, city4, 2);
		bigCityMap.addCityPair(city3, city5, 5);
		bigCityMap.addCityPair(city3, city6, 10);
		bigCityMap.addCityPair(city3, city7, 4);
		
		bigCityMap.addCityPair(city4, city5, 4);
		bigCityMap.addCityPair(city4, city6, 3);
		bigCityMap.addCityPair(city4, city7, 7);
		
		bigCityMap.addCityPair(city5, city6, 2);
		bigCityMap.addCityPair(city5, city7, 9);
		
		bigCityMap.addCityPair(city6, city7, 4);
		
		incompleteCityMap = new CityMap();
		incompleteCityMap.addCityPair(city1,city2,1);
		incompleteCityMap.addCityPair(city3, city4, 1);
	}

	@Test
	public void testIsCompleteMap() {
		assertTrue(bigCityMap.isCompleteMap());
		assertTrue(smallCityMap.isCompleteMap());
		assertFalse(incompleteCityMap.isCompleteMap());
		
	}
	@Test
	public void testFindBestRoute(){
		TravelingSalesman ts = new TravelingSalesman();
		Route route = ts.findBestRoute(city1, new Route(city1),bigCityMap);
		System.out.println("Distance " + route.getDistanceTraveled());
		System.out.println("Number of recursive calls to find result " + ts.getRouteCount());
		route.printRoute();
	}
	@Test
	public void testFindBestRouteDynamically(){
		TravelingSalesman ts = new TravelingSalesman();
		Route route = ts.findBestRouteDynamically(city1, new Route(city1),bigCityMap);
		System.out.println("Distance " + route.getDistanceTraveled());
		System.out.println("Number of recursive calls to find result " + ts.getRouteCount());
		route.printRoute();
	}
	@Test 
	public void testAddCityPair()
	{
		CityMap cm = new CityMap();
		cm.addCityPair(city1, city2, 4);
		assertEquals((long)cm.getDistance(city1, city2),4);
	}

}
