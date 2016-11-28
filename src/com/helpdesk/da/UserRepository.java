package com.helpdesk.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.helpdesk.model.DivisionModel;
import com.helpdesk.model.UserModel;
import com.helpdesk.helper.*;


public class UserRepository {
	
	private static Connection connection;
	
	public UserRepository(){
		Database database= new Database();
		try {
			connection = database.Get_Connection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<UserModel> Users() throws Exception
	{
		ArrayList<UserModel> users = new ArrayList<UserModel>();
		try
		{
			String sql = "SELECT * FROM user a INNER JOIN division b ON a.id_division=b.id_division";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				UserModel user = new UserModel();
				user.setId_user(rs.getInt("id_user"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setId_division(rs.getString("id_division"));
				user.setPc_sn(rs.getString("pc_sn"));
				user.setPc_barcode(rs.getString("pc_barcode"));
				user.setSender_id(rs.getString("sender_id"));
				user.division = new DivisionModel();
				user.division.setDivision_name(rs.getString("division_name"));
				users.add(user);
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public UserModel User(String id) throws Exception
	{
		UserModel user = new UserModel();
		try
		{
			String sql = "SELECT * "
					+ "FROM user a "
					+ "INNER JOIN division b "
					+ "ON a.id_division=b.id_division "
					+ "WHERE a.id_user = ? ";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
				user.setId_user(rs.getInt("id_user"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setId_division(rs.getString("id_division"));
				user.setPc_sn(rs.getString("pc_sn"));
				user.setPc_barcode(rs.getString("pc_barcode"));
				user.setSender_id(rs.getString("sender_id"));
				user.division = new DivisionModel();
				user.division.setDivision_name(rs.getString("division_name"));
				
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public UserModel Login(String username,String password) throws Exception
	{
		
		UserModel user = new UserModel();
		try
		{
			String sql = "SELECT * "
					+ "FROM user a "
					+ "INNER JOIN division b "
					+ "ON a.id_division=b.id_division "
					+ "WHERE a.username = ? "
					+ "AND a.password = ? ";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2,MD5.crypt(password));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				
				user.setId_user(rs.getInt("id_user"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setId_division(rs.getString("id_division"));
				user.setPc_sn(rs.getString("pc_sn"));
				user.setPc_barcode(rs.getString("pc_barcode"));
				user.setSender_id(rs.getString("sender_id"));
				user.division = new DivisionModel();
				user.division.setDivision_name(rs.getString("division_name"));
				
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public long Insert(String email,String username,String password,String division,String serial,String barcode){
		long result = 0;
		
		try
		{
			String sql = "INSERT INTO user(email,username,password,id_division,pc_sn,pc_barcode) "
					+ "VALUES(?,?,?,?,?,?) ";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, username);
			ps.setString(3, MD5.crypt(password));
			ps.setInt(4, Integer.parseInt(division));
			ps.setString(5, serial);
			ps.setString(6, barcode);
			result = ps.executeUpdate();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Got an exception!");
		    System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	public long Update(String id,String email,String username,String division,String serial,String barcode)
	{
		long result = 0;
		try
		{
			
			 String sql = "UPDATE user "
					+ "SET email = ?, "
					+ "username = ?, "
					+ "id_division = ?, "
					+ "pc_sn = ?, "
					+ "pc_barcode = ? "
					+ "WHERE id_user = ? ";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, username);
			ps.setInt(3, Integer.parseInt(division));
			ps.setString(4, serial);
			ps.setString(5, barcode);
			ps.setInt(6, Integer.parseInt(id));
			ps.execute();
			result = ps.executeUpdate();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Got an exception!");
		    System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
}
