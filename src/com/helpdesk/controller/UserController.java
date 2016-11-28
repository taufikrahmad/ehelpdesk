package com.helpdesk.controller;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import com.helpdesk.da.UserRepository;
import com.helpdesk.model.ErrorModel;
import com.helpdesk.model.UserModel;

@Path("/User")
public class UserController {
	
	@GET
	@Path("/")
	@Produces("application/json")
	public String Users()
	{
		String result  = null;Gson gson = new Gson();
		try
		{
			UserRepository usrRep = new UserRepository();
			ArrayList<UserModel> users = new ArrayList<UserModel>();
			users = usrRep.Users();
			if(users.size()>0){
				
				result = gson.toJson(users);
			}else{
				ErrorModel err = new ErrorModel();
				
				err.setErrStatus("1");
				err.setErrMessage("Data Not Found");
				result = gson.toJson(err);
			}
		}catch (Exception e)
		{
			ErrorModel err = new ErrorModel();
			
			err.setErrStatus("1");
			err.setErrMessage(e.getMessage());
			result = gson.toJson(err);
		}
		
		return result;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public String User(@PathParam("id") String id)
	{
		String result  = null;Gson gson = new Gson();
		
		try
		{
			UserRepository usrRep = new UserRepository();
			UserModel user = new UserModel();
			user = usrRep.User(id);
			if(user.getId_user()!=0){
				result = gson.toJson(user);
			}else
			{
				ErrorModel err = new ErrorModel();
				err.setErrStatus("1");
				err.setErrMessage("Data Not Found");
				result = gson.toJson(err);
			}
			
		}catch (Exception e)
		{
			ErrorModel err = new ErrorModel();
			
			err.setErrStatus("1");
			err.setErrMessage(e.getMessage());
			result = gson.toJson(err);
		}
		return result;
	}
	
	@POST
	@Path("/")
	@Produces("application/json")
	public String Add(@FormParam("email") String email,@FormParam("username") String username,
			@FormParam("password") String password,@FormParam("division") String division,
			@FormParam("serial") String serial,
			@FormParam("barcode") String barcode)
	{
		String result  = null;Gson gson = new Gson();
		
		ErrorModel err = new ErrorModel();
		
		try
		{
			UserRepository usrRep = new UserRepository();
			long status = usrRep.Insert(email, username, password, division, serial, barcode);
			if(status>0){
				err.setErrStatus("0");
				err.setErrMessage("Success Create New User");
			}else{
				err.setErrStatus("1");
				err.setErrMessage("Failed Create New User");
			}
		}catch (Exception e)
		{
			err.setErrStatus("1");
			err.setErrMessage(e.getMessage());
			
		}
		
		result = gson.toJson(err);
		return result;
	}
	
	@POST
	@Path("/Login")
	public String Login(@FormParam("username") String username,
			@FormParam("password") String password){
		
		String result  = null;Gson gson = new Gson();
		
		try
		{
			UserRepository usrRep = new UserRepository();
			UserModel user = new UserModel();
			user = usrRep.Login(username, password);
			if(user.getId_user()!=0){
				result = gson.toJson(user);
			}else
			{
				ErrorModel err = new ErrorModel();
				err.setErrStatus("1");
				err.setErrMessage("Data Not Found");
				result = gson.toJson(err);
			}
		}catch (Exception e)
		{
			ErrorModel err = new ErrorModel();
			
			err.setErrStatus("1");
			err.setErrMessage(e.getMessage());
			result = gson.toJson(err);
		}
		
		return result;
		
	}


	@PUT
	@Path("/{id}")
	@Produces("application/json")
	public String Update(
			@PathParam("id") String id,
			@FormParam("email") String email,@FormParam("username") String username,
			@FormParam("division") String division,
			@FormParam("serial") String serial,
			@FormParam("barcode") String barcode
			)
	{
		String result  = null;Gson gson = new Gson();
		ErrorModel err = new ErrorModel();
		
		try
		{
			UserRepository usrRep = new UserRepository();
			long status = usrRep.Update(id, email, username, division, serial, barcode);
			if(status>0){
				err.setErrStatus("0");
				err.setErrMessage("Success Update User Data");
			}else{
				err.setErrStatus("1");
				err.setErrMessage("Failed Update User Data");
			}
		}catch (Exception e)
		{
			err.setErrStatus("1");
			err.setErrMessage(e.getMessage());
			
		}
		
		result = gson.toJson(err);
		
		return result;
		
	}
	
}
