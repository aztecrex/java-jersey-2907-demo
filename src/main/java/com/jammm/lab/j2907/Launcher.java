package com.jammm.lab.j2907;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Launcher {

	static {

		try (InputStream logConfigIs = Launcher.class.getResourceAsStream("logger.properties")) {
			java.util.logging.LogManager.getLogManager().readConfiguration(logConfigIs);
		} catch (final IOException e) {
			e.printStackTrace();
			throw new RuntimeException("cannot configure logging", e);
		}

	}

	public static void main(String[] args) throws Exception {

		final ResourceConfig app = new ResourceConfig().register(DemoResources.class)
				.register(RequirePrincipalFilter.class);

		GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8081/"), app, true);

	}

}
