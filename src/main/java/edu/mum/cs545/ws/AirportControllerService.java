package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

@Named
@Path("airport")
public class AirportControllerService {
	@Inject
	private AirportService airportService;
	
	/*tested, but have some issues*/	
	@Path("getAirports")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airport> getAllAirports() {
		List<Airport> airports = null;
		try {
			airports = airportService.findAll();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return airports;
	}
	
	/*tested*/
	@Path("create")
	@POST
	@Consumes
	public void create(Airport airport) {
		airportService.create(airport);
	}
	
	/*tested*/
	@Path("delete/{id}")
	@GET
	public void delete(@PathParam("id") long id) {
		Airport airport = new Airport();
		airport.setId(id);
		airport = airportService.find(airport);
		airportService.delete(airport);
	}
	
	/*tested*/
	@Path("update/{id}/{airportcode}/{name}/{city}/{country}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void update(@PathParam("id") long id,
					   @PathParam("airportcode") String airportcode,
					   @PathParam("name") String name,
					   @PathParam("city") String city,
					   @PathParam("country") String country) {
		
		Airport airport = new Airport(airportcode, name, city, country);
		airport.setId(id);
		airportService.update(airport);
	}
	
	/*tested*/
	@Path("find/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airport find(@PathParam("id") long id) {
		Airport airport = new Airport();
		airport.setId(id);
		return airportService.find(airport);
	}
}
