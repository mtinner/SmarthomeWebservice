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
	private static LampManager lampManager= new LampManager();
	
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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setLamp(Lamp lamp) {
		try {
			lampManager.set(lamp);
			return StatusHelper.getStatusOk(null);
		} catch (Exception e) {
			return StatusHelper.getStatusBadRequest();
		}
	}
}
