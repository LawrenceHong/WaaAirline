package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

public class FlightControllerService {
	@Inject
	private FlightService flightService;
	
	@Path("getFlights")
	@GET
	public List<Flight> getAllFlights() {
		List<Flight> flights = flightService.findAll();
		return flights;
	}
}
