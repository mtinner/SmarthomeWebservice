package ch.smarthome.pl.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ch.smarthome.bll.entity.ESPOutput;
import ch.smarthome.bll.entity.Lamp;
import ch.smarthome.bll.manager.LampManager;
import ch.smarthome.helper.StatusHelper;

@Path("lamp")
public class LampController {
	private static LampManager lampManager = new LampManager();

	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getLamp(@PathParam("id") int id) {
		System.out.println("ni");
		try {
			return StatusHelper.getStatusOk(null);
		} catch (Exception e) {
			return StatusHelper.getStatusBadRequest();
		}
	}

	@POST
	@Path("output/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setLamp(@PathParam("id") int id, ESPOutput output) {
		lampManager.set(id, output);
		return StatusHelper.getStatusOk(null);
//		try {
//			lampManager.set(id, output);
//			return StatusHelper.getStatusOk(new Integer(4));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return StatusHelper.getStatusBadRequest();
//		}
	}
}
