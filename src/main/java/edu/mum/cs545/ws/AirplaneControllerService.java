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

import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;

@Named
@Path("airplane")
public class AirplaneControllerService {
	@Inject
	private AirplaneService airplaneService;
	
	/*tested, but have some issues*/	
	@Path("getAirplanes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airplane> getAllAirplanes() {
		List<Airplane> airplanes = null;
		try {
			airplanes = airplaneService.findAll();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return airplanes;
	}
	
	/*tested*/
	@Path("create")
	@POST
	@Consumes
	public void create(Airplane airplane) {
		airplaneService.create(airplane);
	}
	
	/*tested*/
	@Path("delete/{id}")
	@GET
	public void delete(@PathParam("id") long id) {
		Airplane airplane = new Airplane();
		airplane.setId(id);
		airplane = airplaneService.find(airplane);
		airplaneService.delete(airplane);
	}
	
	/*tested*/
	@Path("update/{id}/{serialnr}/{model}/{capacity}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void update(@PathParam("id") long id,
					   @PathParam("serialnr") String serialnr,
					   @PathParam("model") String model,
					   @PathParam("capacity") int capacity) {
		Airplane airplane = new Airplane(serialnr, model, capacity);
		airplane.setId(id);
		airplaneService.update(airplane);
	}
	
	/*tested*/
	@Path("find/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Airplane find(@PathParam("id") long id) {
		Airplane airplane = new Airplane();
		airplane.setId(id);
		return airplaneService.find(airplane);
	}
}
