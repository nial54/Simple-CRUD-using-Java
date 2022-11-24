package com.mvc.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import com.mvc.model.Model;
import com.mvc.util.DBConnection;

public class Dao {
	
	private static final String INSERT_DATA_SQL = "insert into pro1(name,email,address,phone,city,country,education,photo) "+
																	" values(?,?,?,?,?,?,?,?);";
	private static final String SELECT_DATA_BY_ID = "select name,email,address,phone,city,country,education from pro1 where id =?";
	private static final String SELECT_DATA_LIST = "select id,name,city from pro1 ";
	private static final String DELETE_DATA_SQL = "delete from pro1 where id = ?;";
	private static final String UPDATE_DATA_SQL = "update pro1 set name=?,email=?,address=?,phone=?,city=?,country=?,education=?,photo=? where id=?";
	private static final String VIEW_DATA = "select name,email,address,phone,city,country,education,photo from pro1 where id=?;";
	
	public Dao()
	{	}
	
	protected Connection getConnection() throws SQLException
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConnection.createConnection();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	//insert data
	public void insertmodel(Model model) throws FileNotFoundException
	{
		System.out.println(INSERT_DATA_SQL);
		try
		{
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT_DATA_SQL);
			ps.setString(1, model.getName());
			ps.setString(2, model.getEmail());
			ps.setString(3, model.getAddress());
			ps.setString(4, model.getPhone());
			ps.setString(5, model.getCity());
			ps.setString(6, model.getCountry());
			ps.setString(7, model.getEducation());
			String img = model.getPhoto();
			File f = new File(img);
			FileInputStream fis = new FileInputStream(f);
			int len = (int)f.length();
			ps.setBinaryStream(8, (InputStream)fis,len);
			System.out.println(ps);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
	}
	
	//view by ID
	public Model viewmodel (int id)
	{
		Model model = null;
		try
		{
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_DATA_BY_ID);
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				String country = rs.getString("country");
				String education = rs.getString("education");
				model = new Model(id, name, email, address, phone, city, country, education);
			}
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return model;
	}
	
	//view list record
	public List<Model> peekmodel()
	{
		List<Model> model = new ArrayList<Model>();
		try
		{
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_DATA_LIST);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String city = rs.getString("city");
				model.add(new Model(id, name, city));
			}
		}
		catch(SQLException e)
		{
			printSQLException(e);
		}
		return model;
	}
	
	//delete data
	public boolean deletemodel(int id) throws SQLException
	{
		boolean rowDeleted;
		try
		{
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE_DATA_SQL);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate()>0;
		}
		finally
		{		}
		return rowDeleted;
	}
	
	//update data
	public boolean updatemodel(Model model) throws SQLException, FileNotFoundException
	{
		boolean rowUpdate;
		try
		{
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE_DATA_SQL);
			System.out.println("Update model "+ps);
			ps.setString(1, model.getName());
			ps.setString(2, model.getEmail());
			ps.setString(3, model.getAddress());
			ps.setString(4, model.getPhone());
			ps.setString(5, model.getCity());
			ps.setString(6, model.getCountry());
			ps.setString(7, model.getEducation());
			String img = model.getPhoto();
			File f = new File(img);
			FileInputStream fis = new FileInputStream(f);
			int len = (int)f.length();
			ps.setBinaryStream(8, (InputStream)fis, len);
			ps.setInt(9, model.getId());
			rowUpdate = ps.executeUpdate()>0;
		}
		finally
		{		}
		return rowUpdate;
	}
	
	//view data
	public Model selectdata (int id)
	{
		Model model = null;
		try
		{
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(VIEW_DATA);
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String city = rs.getString("city");
				String country = rs.getString("country");
				String education = rs.getString("education");
				Blob img = rs.getBlob("photo");
				byte image [] = img.getBytes(1, (int)img.length());
				model = new Model(id, name, email, address, phone, city, country, education, image);
			}
			}
			catch (SQLException e) 
			{
				printSQLException(e);
			}
			finally
			{	}
			return model;
		}
	
	//error
	private void printSQLException(SQLException se)
	{
		for(Throwable e : se)
		{
			if(e instanceof SQLException)
			{
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException)e).getSQLState());
				System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
				System.err.println("Message: " +e.getMessage());
				Throwable t = se.getCause();
				while(t!=null)
				{
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
