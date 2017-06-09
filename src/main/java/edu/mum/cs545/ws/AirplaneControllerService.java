package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;

@Named
@Path("airplane")
public class AirplaneControllerService {
	@Inject
	private AirplaneService airplaneService;
	
	@Path("getAirplanes")
	@GET
	public List<Airplane> getAllAirplanes() {
		List<Airplane> airplanes = airplaneService.findAll();
		return airplanes;
	}
}
