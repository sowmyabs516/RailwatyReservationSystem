package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dao.UserDao;
import dto.Train;
import dto.User;

@WebServlet("/availabletrain")

public class AvailableTrain extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserDao userDao=new UserDao();
	List<Train> list=userDao.fetchAllTrain();
	User user=(User) req.getSession().getAttribute("user");
	System.out.println(user);
	if(user==null){
		resp.getWriter().print("<h1>Session Expired</h1>");
		req.getRequestDispatcher("ManagementHome.html").include(req, resp);
	}
	else{
		if(list.isEmpty()){
			resp.getWriter().print("<h1>No Data Available</h1>");
			req.getRequestDispatcher("ManagementHome.html").include(req, resp);
		}
		else{
			req.setAttribute("list", list);
			req.getRequestDispatcher("AvailableTrain.jsp").include(req, resp);
		}
	}
}
}
