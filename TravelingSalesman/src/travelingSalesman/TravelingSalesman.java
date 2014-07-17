package travelingSalesman;

public class TravelingSalesman {
	/**
	 * return ordered list of cities constituting shortest travel route 
	 * given a start city and list of distances between cities
	 * 
	 * @param startCity
	 * @param cityList
	 * @return
	 */
	public Route findBestRoute(City startCity, Route route, CityMap cityMap){
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
}
