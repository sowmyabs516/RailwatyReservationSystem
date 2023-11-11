package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/login")
public class Login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String password=req.getParameter("password");
	
	UserDao userDao=new UserDao();
	User user=userDao.find(id);
	if(user==null){
		resp.getWriter().print("<h1>Invalid Id<h1>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
	else{
		if(user.getConfirmpassword().equals(password)){
			req.getSession().setAttribute("user", user);
			resp.getWriter().print("<h1>Login Success<h1>");
			req.getRequestDispatcher("UserHome.html").include(req, resp);
		}
		else{
			resp.getWriter().print("<h1>Enter Correct Password<h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
	}
}
}
