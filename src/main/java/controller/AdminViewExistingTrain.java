package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/viewexistingtrain")
public class AdminViewExistingTrain extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	TrainDao trainDao=new TrainDao();
	List<Train> list=trainDao.fetchAllTrain();
	
	if(list.isEmpty()){
		resp.getWriter().print("<h1>No Existing Train</h1>");
		req.getRequestDispatcher("ManagementHome.html").include(req, resp);
	}
	else{
		req.setAttribute("list", list);
		req.getRequestDispatcher("ViewExistingTrain.jsp").forward(req, resp);
	}
}
}
