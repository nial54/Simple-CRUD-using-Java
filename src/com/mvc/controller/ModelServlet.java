package com.mvc.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.Dao;
import com.mvc.model.Model;

@WebServlet("/")
public class ModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao dao;
	public void init()
	{
		dao = new Dao();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try
		{
			switch(action)
			{
			case "/new":viewmodel(request, response);
				break;
			case "/insert":insertmodel(request, response);
				break;
			case "/delete":deletemodel(request, response);
				break;
			case "/edit":editmodel(request, response);
				break;
			case "/update":updatemodel(request, response);
				break;
			case "/select":selectdata(request, response);
				break;
			case "/view":viewdata(request, response);
				break;
			case "/list":listmodel(request, response);
				break;
			default:
					home(request, response);
					break;
			}
		}
		catch(SQLException se)
		{
			throw new ServletException(se);
		}
	}
	
	private void listmodel(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		List<Model> listmodel = dao.peekmodel();
		request.setAttribute("listmodel", listmodel);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void editmodel(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		Model existingModel = dao.viewmodel(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
		request.setAttribute("model", existingModel);
		dispatcher.forward(request, response);
	}
	
	private void viewmodel(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertmodel(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String education = request.getParameter("education");
		String photo = request.getParameter("photo");
		Model newModel = new Model(name, email, address, phone, city, country, education, photo);
		dao.insertmodel(newModel);
		response.sendRedirect("list");
	}
	
	private void updatemodel(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String education = request.getParameter("education");
		String photo = request.getParameter("photo");
		Model book = new Model(id, name, email, address, phone, city, country, education, photo);
		dao.updatemodel(book);
		response.sendRedirect("list");
	}
	
	private void deletemodel(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deletemodel(id);
		response.sendRedirect("list");
	}
	
	private void selectdata(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException {
		response.setContentType("image/gif");
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		dispatcher.forward(request, response);
	}
	private void viewdata(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		Model existingmodel = dao.selectdata(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view.jsp");
		request.setAttribute("model", existingmodel);
		dispatcher.forward(request, response);
	}
	private void home(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException,ServletException{
		response.sendRedirect("index.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}