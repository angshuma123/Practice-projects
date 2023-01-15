package com.sl.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/dashboard")
public class Dashboard extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=resp.getWriter();
	resp.setContentType("text/html");
	String Tok=req.getParameter("userid");
	HttpSession session=req.getSession(false);
	if(session!=null) {
		String USERNAME=(String)session.getAttribute("key");
		if(USERNAME!=null) {
			out.print("Welcome user"+USERNAME);
			out.print("<a href='logout'>Logout</a>");
		}
		else {
			out.print("Please login again");
		}
	}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
