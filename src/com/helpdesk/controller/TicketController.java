package com.helpdesk.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.helpdesk.da.TicketRepository;
import com.helpdesk.model.ErrorModel;
import com.helpdesk.model.TicketModel;

@Path("/Ticket")
public class TicketController {
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public String Tickets(@PathParam("id") String type_ticket)
	{
		String result  = null;Gson gson = new Gson();
		try
		{
			TicketRepository ticRep = new TicketRepository();
			ArrayList<TicketModel> tickets = new ArrayList<TicketModel>();
			tickets = ticRep.Tickets(type_ticket);
			if(tickets.size()>0){
				result = gson.toJson(tickets);
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
	
}
