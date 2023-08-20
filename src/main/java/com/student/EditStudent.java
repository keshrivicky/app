package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/editStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int StudentId =  Integer.parseInt(request.getParameter("id"));

		Connection con = DatabaseUtils.getConnection();
		Statement st = null;
		try {
			st= con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM student where id="+StudentId;
		Student student = new Student();
		ResultSet  rs = null;
		try {
			  rs =  st.executeQuery(sql);
		
		
		while(rs.next()) {
				
				student.setCourse(rs.getString("course"));
				student.setGender(rs.getString("gender"));
				student.setName(rs.getString("name"));
				student.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String htmlforMale="";
		String htmlforFemale="";
		if(student.getGender().equalsIgnoreCase("MALE")) {
			htmlforMale = 	"<input type=\"radio\" name=\"gender\" value=\"Male\" checked>";
		}else {
			htmlforMale = 	"<input type=\"radio\" name=\"gender\" value=\"Male\">";
		}
		
		if(student.getGender().equalsIgnoreCase("FEMALE")) {
			htmlforFemale = 	"<input type=\"radio\" name=\"gender\" value=\"Female\" checked>";
		}else {
			htmlforFemale = 	"<input type=\"radio\" name=\"gender\" value=\"Female\" >";
		}
		
		
		response.getWriter().append("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Edit Student</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>Edit Student</h1>\r\n"
				+ "<form action=\"EditStudentData\" method=\"POST\">\r\n"
				+ "<input type=\"hidden\" name=\"id\" value=\""+StudentId+"\"><br>\r\n"
				+ "FullName: - <input type=\"text\" name=\"name\" value=\""+student.getName()+"\"><br>\r\n"
				+ "password: - <input type=\"text\" name=\"password\" value="+student.getPassword()+"><br>\r\n"
				+ "Gender : - &nbsp;&nbsp;&nbsp;MALE "+htmlforMale+" &nbsp;&nbsp;&nbsp; FEMALE "+htmlforFemale+"<br>\r\n"
				+ "Course: - <input type=\"text\" name=\"course\" value="+student.getCourse()+"><br>\r\n"
				+ "\r\n"
				+ "<input type=\"submit\" value=\"Edit\"><br>\r\n"
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
