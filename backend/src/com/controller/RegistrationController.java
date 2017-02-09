package com.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.exceptions.InvalidInputData;
import com.model.User;
import com.services.UserService;
import com.util.Util;

@Path("/registration")
@Controller
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Util util;
	
	@POST
	public Response registrateUser(User user) {
		try {
				this.userService.saveUser(user);
				return Response.ok().build();
			} catch (InvalidInputData e ) {
				
				return util.buildErrorResponse(400, e);	
			}
	}
}
