package com.mvc.controller;

import java.io.IOException;
import java.io.OutputStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.util.DBConnection;

@WebServlet("/getimage")
public class getimage extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
        System.out.println("Id in imageretirve="+id);
	    try 
	    {
	    	Connection connection = DBConnection.createConnection();
	        PreparedStatement ps = connection.prepareStatement("select * from pro1 where id=?");
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) 
	        {
	            Blob blob = rs.getBlob("photo");
	            byte byteArray[] = blob.getBytes(1, (int) blob.length());
	            response.setContentType("image/gif");
	            OutputStream os = response.getOutputStream();
	            os.write(byteArray);
	            os.flush();
	            os.close();
	        } 
	        else 
	        {
	            System.out.println("No image found with this id.");
	        }
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    }
		
	}

}