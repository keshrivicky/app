package com.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddStudent() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd =request.getRequestDispatcher("TestingServlet");
		rd.forward(request, response);
		response.getWriter().append("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Add Student</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>Add Student</h1>\r\n"
				+ "<form action=\"saveStudent\" method=\"POST\">\r\n"
				+ "FullName: - <input type=\"text\" name=\"name\" ><br>\r\n"
				+ "password: - <input type=\"password\" name=\"password\" ><br>\r\n"
				+ "Gender : - &nbsp;&nbsp;&nbsp;MALE <input type=\"radio\" name=\"gender\" value=\"Male\">&nbsp;&nbsp;&nbsp; FEMALE<input type=\"radio\" name=\"gender\" value=\"Female\"><br>\r\n"
				+ "Course: - <input type=\"text\" name=\"course\" ><br>\r\n"
				+ "\r\n"
				+ "<input type=\"submit\" value=\"Save\"><br>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
