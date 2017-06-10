package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Application;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
/*
 * All interfaces have been tested by using postman*/
@Named
@Path("airline")
public class AirlineControllerService {
	@Inject
	private AirlineService airlineService;
		
	@Path("getAirlines")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airline> getAllAirlines() {
		List<Airline> airlines = null;
		try {
			airlines = airlineService.findAll();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return airlines;
	}
//	public String getAllAirlines() {
//		List<Airline> airlines = airlineService.findAll();
//		StringBuilder sBuilder = new StringBuilder();
//		for(Airline airline : airlines)
//			sBuilder.append(airline.getName()).append("*").append(airline.getId()).append("*");
//		return sBuilder.toString();
//	}
	
	@Path("getAirlineByName")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Airline getAirpline(@FormParam("name") String name) {
		return airlineService.findByName(name);
	}
	
	@Path("getAirlinesByFlight")
	@POST
	public List<Airline> findByFlight(@FormParam("flightnr") String flightnr,
									  @FormParam("departureDate") String departureDate,
									  @FormParam("departureTime") String departureTime,
									  @FormParam("arrivalDate") String arrivalDate,
									  @FormParam("arrivalTime") String arrivalTime) {
		Flight flight = new Flight(flightnr, departureDate, departureTime, arrivalDate, arrivalTime);
		return airlineService.findByFlight(flight);
	}
	
	@Path("create")
	@POST
	public void create(@FormParam("name") String name) {
		Airline airline = new Airline();
		airline.setName(name);
		airlineService.create(airline);
	}
	
	@Path("delete/{id}")
	@GET
	public void delete(@PathParam("id") long id) {
		Airline airline = new Airline();
		airline.setId(id);
		airline = airlineService.find(airline);
		airlineService.delete(airline);
	}
	
	@Path("update")
	@PUT
	public Airline update(Airline airport) {
		return airlineService.update(airport);
	}
	
	@Path("find")
	@POST
	public Airline find(@FormParam("name") String name) {
		Airline airline = new Airline(name);
		return airlineService.find(airline);
	}
}
