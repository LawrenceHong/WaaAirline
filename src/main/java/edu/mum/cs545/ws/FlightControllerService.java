package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

public class FlightControllerService {
	@Inject
	private FlightService flightService;
		
	@Path("getFlights")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> getAllFlights() {
		List<Flight> flights = null;
		try {
			flights = flightService.findAll();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return flights;
	}
	
//	/*tested*/
//	@Path("create")
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void create(Flight flight) {
//		flightService.create(flight);
//	}
//	
//	/*tested*/
//	@Path("delete/{id}")
//	@GET
//	public void delete(@PathParam("id") long id) {
//		Flight flight = new Flight();
//		flight.setId(id);
//		flight = flightService.find(flight);
//		flightService.delete(flight);
//	}
	
	/*tested*/
	@Path("update/{id}/{flightnr}／{departureDate}/{departureTime}/{arrivalDate}/{arrivalTime}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void update(@PathParam("id") long id,
					   @PathParam("flightnr") String flightnr,
					   @PathParam("departureDate") String departureDate,
					   @PathParam("departureTime") String departureTime,
					   @PathParam("arrivalDate") String arrivalDate,
					   @PathParam("arrivalTime") String arrivalTime) {
		Flight flight = new Flight(flightnr,
								   departureDate,
								   departureTime,
								   arrivalDate,
								   arrivalTime);
		flight.setId(id);
		flightService.update(flight);
	}
	
	/*tested*/
	@Path("find/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Flight find(@PathParam("id") long id) {
		Flight flight = new Flight();
		flight.setId(id);
		return flightService.find(flight);
	}
}
