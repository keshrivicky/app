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
import java.util.*;

/**
 * Servlet implementation class ViewStudent
 */
@WebServlet("/viewStudent")
public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con= DatabaseUtils.getConnection();
		Statement st=null;
		List<Student> studentList = new ArrayList<Student>();
		try {
			 st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM student;";
		try {
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){  
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setGender(rs.getString("gender"));
				student.setCourse(rs.getString("course"));
				studentList.add(student);
			}
			
			if(studentList.size()>0) {
				StringBuilder sb = new StringBuilder();
				sb.append("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Add Student</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<table  border=\"1\" width=\"100%\">\r\n"
						+ "<tr>\r\n"
						+ "<th>Student ID</th>\r\n"
						+ "<th>Student Name</th>\r\n"
						+ "<th>Gender</th>\r\n"
						+ "<th>Course</th>\r\n"
						+ "<th>Update</th>\r\n"
						+ "<th>Delete</th>\r\n"
						+ "</tr>");
				for(int i=0;i<studentList.size();i++) {
sb.append("<tr>\r\n"
		+ "<td>"+studentList.get(i).getId()+"</td>\r\n"
		+ "<td>"+studentList.get(i).getName()+"</td>\r\n"
		+ "<td>"+studentList.get(i).getGender()+"</td>\r\n"
		+ "<td>"+studentList.get(i).getCourse()+"</td>\r\n"
		+ "<td><a href='editStudent?id="+studentList.get(i).getId()+"'>Edit</a></td>\r\n"
		+ "<td><a href='deleteStudent?id="+studentList.get(i).getId()+"'>Delete</a></td>\r\n"
		+ "</tr>");
				}
				sb.append("</table>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>");
				response.getWriter().append(sb);
			}else {
				response.getWriter().append("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Add Student</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<h1> Student Data not Found </h1> \r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>");
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
