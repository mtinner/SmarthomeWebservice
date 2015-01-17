package ch.smarthome.pl.controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ch.smarthome.bll.entity.Lamp;
import ch.smarthome.bll.manager.LampManager;
import ch.smarthome.helper.StatusHelper;


@Path("lamp")
public class LampController {
	private LampManager lampManager= new LampManager();
	
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLamp(@PathParam("id") int id) {
		try {
			return StatusHelper.getStatusOk(lampManager.get(id));
		} catch (Exception e) {
			return StatusHelper.getStatusBadRequest();
		}
	}
	
	@POST
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getGeoFilename(Lamp lamp) {
		try {
			return StatusHelper.getStatusOk(lampManager.set(lamp));
		} catch (Exception e) {
			return StatusHelper.getStatusBadRequest();
		}
	}
}
