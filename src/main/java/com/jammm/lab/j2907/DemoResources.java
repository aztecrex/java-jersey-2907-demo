package com.jammm.lab.j2907;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Produces("text/plain")
@Consumes("text/plain")
public class DemoResources {

	@GET
	@Path("/echo")
	public String echo(String what) {
		return what;
	}

}
