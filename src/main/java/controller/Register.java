package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;
@WebServlet("/register")
public class Register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String email=req.getParameter("email");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String gender=req.getParameter("gender");
		Date dob=Date.valueOf(req.getParameter("dob"));
		String createpassword=req.getParameter("createpassword");
		String confirmpassword=req.getParameter("confirmpassword");
		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		
		UserDao userdao=new UserDao();
		if(createpassword.equals(confirmpassword)){
		User user=new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setConfirmpassword(confirmpassword);
		user.setCreatepassword(createpassword);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setGender(gender);
		user.setAge(age);
		user.setDob(dob);
		
		userdao.saveUser(user);
		
		resp.getWriter().print("<h1>User Data Saved Successfully<h1>");
		req.getRequestDispatcher("Register.html").include(req, resp);
	}
	else{
		resp.getWriter().print("<h1>Reenter password<h1>");
		req.getRequestDispatcher("Register.html").include(req, resp);
	}
	}
}

