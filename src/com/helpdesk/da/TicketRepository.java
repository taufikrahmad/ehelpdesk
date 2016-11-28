package com.helpdesk.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.helpdesk.model.TicketModel;
import com.helpdesk.model.TicketsNumberModel;
import com.helpdesk.model.TypeTicketModel;
import com.helpdesk.model.UserModel;

public class TicketRepository {
	
private static Connection connection;

	private ArrayList<TicketModel> tickets;

	private String sql;
	
	public TicketRepository(){
		Database database= new Database();
		
		try {
			connection = database.Get_Connection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* 
	 * parameter : 
	 * 1. type_ticket
	 */
	public ArrayList<TicketModel> Tickets(String type_ticket) throws Exception
	{
		tickets = new ArrayList<TicketModel>();
		try
		{
			sql = "select a.*,b.Type,c.ticket_number, "
					+ "d.username requester,"
					+ "e.username solve,"
					+ "f.division_name requester_division,"
					+ "g.status status_ticket,"
					+ "DATE_FORMAT(a.createdAt,'%d-%m-%Y %r') ticket_date "
					+ "from tickets a  "
					+ "inner join type_ticket b "
					+ "on a.type_ticket = b.id "
					+ "inner join tickets_number c "
					+ "on a.id_tickets = c.id_tickets "
					+ "left outer join user d "
					+ "on a.request_by = d.id_user "
					+ "inner join division f "
					+ "on d.id_division = f.id_division "
					+ "left outer join user e "
					+ "on a.solve_by = e.id_user "
					+ "inner join status_ticket g "
					+ "on a.status_ticket = g.id_status "
					+ "Where a.type_ticket = ? "
					+ "order by a.id_tickets DESC ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, type_ticket);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				TicketModel ticket = new TicketModel();
				ticket.setIdTickets(rs.getInt("id_tickets"));
				ticket.setNoTicket(rs.getString("no_ticket"));
				ticket.setTypeTicket(rs.getString("type_ticket"));
				ticket.setRequestBy(rs.getInt("request_by"));
				ticket.setRequestEmail(rs.getString("request_email"));
				ticket.setPcSn(rs.getString("pc_sn"));
				ticket.setPcBarcode(rs.getString("pc_barcode"));
				ticket.setTitle(rs.getString("title"));
				ticket.setDescription(rs.getString("description"));
				ticket.setSolveBy(rs.getInt("solve_by"));
				ticket.setEtf(rs.getInt("etf"));
				ticket.setStatusTicket(rs.getInt("status_ticket"));
				ticket.setUserVerificatonCode(rs.getString("user_verificaton_code"));
				ticket.setItVerificationCode(rs.getString("it_verification_code"));
				ticket.setSenderId(rs.getString("sender_id"));
				ticket.setAutoCreatedAt(rs.getString("autoCreatedAt"));
				ticket.setAutoUpdatedAt(rs.getDate("autoUpdatedAt"));
				
				ticket.ticketType = new TypeTicketModel();
				ticket.ticketType.setType(rs.getString("Type"));
				
				ticket.ticketNumber = new TicketsNumberModel();
				ticket.ticketNumber.setTicketNumber(rs.getString("ticket_number"));
				
				ticket.requester = new UserModel();
				ticket.requester.setUsername(rs.getString("requester"));
				
				ticket.solve = new UserModel();
				ticket.solve.setUsername(rs.getString("solve"));
				
				ticket.setCreatedAt(rs.getDate("ticket_date"));
				
				tickets.add(ticket);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tickets;
	}
	
}
