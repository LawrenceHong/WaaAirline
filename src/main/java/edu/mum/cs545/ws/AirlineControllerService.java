package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;
/*
 * All interfaces have been tested by using postman*/
@Named
@Path("airline")
public class AirlineControllerService {
	@Inject
	private AirlineService airlineService;
	
	/*tested, but have some issues*/	
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

	/*tested*/
	@Path("getAirlineByName")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Airline getAirpline(@FormParam("name") String name) {
		return airlineService.findByName(name);
	}
	
	/*tested*/
	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Airline airline) {
		airlineService.create(airline);
	}
	
	/*tested*/
	@Path("delete/{id}")
	@GET
	public void delete(@PathParam("id") long id) {
		Airline airline = new Airline();
		airline.setId(id);
		airline = airlineService.find(airline);
		airlineService.delete(airline);
	}
	
	/*tested*/
	@Path("update/{id}/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void update(@PathParam("id") long id, @PathParam("name") String name) {
		Airline airline = new Airline(name);
		airline.setId(id);
		airlineService.update(airline);
	}
	
	/*tested*/
	@Path("find/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airline find(@PathParam("id") long id) {
		Airline airline = new Airline();
		airline.setId(id);
		return airlineService.find(airline);
	}
}
