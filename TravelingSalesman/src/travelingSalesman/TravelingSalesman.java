package travelingSalesman;

public class TravelingSalesman {
	private Route dynamicShortestRoute;
	private Integer routeCount = 0;
	/**
	 * return ordered list of cities constituting shortest travel route 
	 * given a start city and list of distances between cities
	 * 
	 * precondition: cityMap is a complete map
	 * precondition: startCity is a member of cityMap
	 * precondition: all members of route are members of cityMap
	 * 
	 * postcondition: route will contain the shortest route that visits all cities
	 * 
	 * @param startCity
	 * @param cityList
	 * @return
	 */
	public Route findBestRoute(City startCity, Route route, CityMap cityMap){
		routeCount++;
		Route optimalRoute = null;
		if (route.getVisitedCities().size() < cityMap.getCities().size())
		{
			for(City city:cityMap.getCities())
			{
				if (!route.cityBeenVisited(city) && city !=startCity)
				{
					Route newRoute = new Route(route);
					newRoute.travelToCity(city, cityMap.getDistance(startCity, city));					
					newRoute = findBestRoute(city, newRoute,cityMap);
					if(optimalRoute!=null)
					{
						if(newRoute.getDistanceTraveled() < optimalRoute.getDistanceTraveled())
						{
							optimalRoute = newRoute;
						}
					}else{
						optimalRoute = newRoute;
					}	
				}
			}
		}
		if (route.getVisitedCities().size() == cityMap.getCities().size())
		{
			optimalRoute = route;
		}
		
		return optimalRoute;
	}
	
	/**
	 * return ordered list of cities constituting shortest travel route 
	 * given a start city and list of distances between cities.  This method uses a dynamic algorithm
	 * to find the shortest travel route to attempt to shorten calc time.
	 * 
	 * precondition: cityMap is a complete map
	 * precondition: startCity is a member of cityMap
	 * precondition: all members of route are members of cityMap
	 * precondition: dynamicShortestRoute global variable contains the shortest route found so far
	 * 
	 * postcondition: route will contain the shortest route that visits all cities
	 * postcondition: if calculated route is longer then dynamicShortestRoute dont continue this recursive call
	 * 
	 * @param startCity
	 * @param cityList
	 * @return
	 */
	public Route findBestRouteDynamically(City startCity, Route route, CityMap cityMap){
		routeCount++;
		Route optimalRoute = null;
		if (route.getVisitedCities().size() < cityMap.getCities().size())
		{
			for(City city:cityMap.getCities())
			{
				if (!route.cityBeenVisited(city) && city !=startCity)
				{
					Route newRoute = new Route(route);
					newRoute.travelToCity(city, cityMap.getDistance(startCity, city));
					if(this.dynamicShortestRoute != null)
					{
						if(newRoute.getDistanceTraveled() < this.dynamicShortestRoute.getDistanceTraveled())
						{
							if(newRoute.getVisitedCities().size() == cityMap.getCities().size())
							{
								this.dynamicShortestRoute = newRoute;
							}
							newRoute = findBestRouteDynamically(city, newRoute,cityMap);
						}
					}else
					{
						if(newRoute.getVisitedCities().size() == cityMap.getCities().size())
						{
							System.out.println("new route");
							this.dynamicShortestRoute = newRoute;
						}
						newRoute = findBestRouteDynamically(city, newRoute,cityMap);
					}
					
					if(optimalRoute!=null)
					{
						if(newRoute != null)
						{
							if(newRoute.getDistanceTraveled() < optimalRoute.getDistanceTraveled())
							{
								optimalRoute = newRoute;
							}
						}
					}else{
						if(newRoute != null)
						{
							optimalRoute = newRoute;
						}	
					}
				}
			}
		}
		if (route.getVisitedCities().size() == cityMap.getCities().size())
		{
			optimalRoute = route;
		}
		
		return optimalRoute;
	}
	
	public Integer getRouteCount()
	{
		return this.routeCount;
	}
}
