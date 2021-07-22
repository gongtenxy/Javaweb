package Dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class teacherDate
 */
@WebServlet("/teacherDate")
public class teacherDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vote?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true","root","123456");
			Statement stat = conn.createStatement();
			String sql = "SELECT * FROM people";
			ResultSet rs = stat.executeQuery(sql);
			//PrintWriter out = response.getWriter();
			ArrayList al=new ArrayList();
			while(rs.next()){
				teacher teach=new teacher();
			    teach.setId(rs.getString("id"));
				teach.setName(rs.getString("name"));
				teach.setNumber(rs.getInt("number"));
				al.add(teach);
			}			

		     request.getSession().setAttribute("al", al);
		     response.sendRedirect("/Vote/index.jsp");
			stat.close();
			conn.close();
		}
		catch(Exception err){
			PrintWriter out = response.getWriter();
			out.println("wrong");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
