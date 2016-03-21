package com.projects.api.messanger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/inject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class InjectResources {

	@GET
	@Path("annotations")
	public String getParamUsingAnnotations(@MatrixParam("param") String matParam,
			                               @HeaderParam("customerheadervalue") String headerVal,
			                               @CookieParam("name") String cookie)
	{
		return "value of matrix paamr"+matParam+"header"+headerVal+"cookie"+cookie;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriinfo, @Context HttpHeaders header)
	{
		String path = uriinfo.getAbsolutePath().toString();
		String cookies = header.getCookies().toString();
		return "the path is"+path+ "cookies is "+cookies;
	}
}
