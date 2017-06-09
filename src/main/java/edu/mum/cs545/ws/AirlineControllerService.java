package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Named
@Path("airline")
public class AirlineControllerService {
	@Inject
	private AirlineService airlineService;
		
	@Path("getAirlines")
	@GET
	public List<Airline> getAllAirlines() {
		List<Airline> airlines = airlineService.findAll();
		return airlines;
	}
}
