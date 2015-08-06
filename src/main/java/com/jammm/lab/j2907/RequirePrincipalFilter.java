package com.jammm.lab.j2907;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Priority(Priorities.AUTHORIZATION)
public class RequirePrincipalFilter implements ContainerRequestFilter {

	private static final Logger LOG = LoggerFactory.getLogger(RequirePrincipalFilter.class);

	@Override
	public void filter(final ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getSecurityContext() == null
				|| requestContext.getSecurityContext().getUserPrincipal() == null) {
			LOG.debug("No Principal");
			requestContext.abortWith(Response.status(Status.UNAUTHORIZED).type(MediaType.TEXT_PLAIN)
					.entity("Authorization Required").header("WWW-Authenticate", "Bearer").build());
			LOG.debug("Request Aborted");
		}
	}

}
