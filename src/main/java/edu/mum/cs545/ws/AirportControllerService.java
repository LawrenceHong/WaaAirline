package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

@Named
@Path("airport")
public class AirportControllerService {
	@Inject
	private AirportService airportService;
	
	@Path("getAirports")
	@GET
	public List<Airport> getAllAirports() {
		List<Airport> airports = airportService.findAll();
		return airports;
	}
}
