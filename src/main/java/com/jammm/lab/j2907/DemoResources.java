package com.jammm.lab.j2907;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Produces("text/plain")
@Consumes("text/plain")
@Path("/")
public class DemoResources {

	@POST
	@Path("echo")
	public String echo(String what) {
		return what;
	}

}
