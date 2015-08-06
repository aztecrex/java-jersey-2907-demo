package com.jammm.lab.j2907;

import java.net.URI;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Launcher {

	public static void main(String[] args) throws Exception {

		final ResourceConfig app = new ResourceConfig().register(DemoResources.class);

		GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8081/"), app, true);

		//		Thread.currentThread().join();
		
	}

}
