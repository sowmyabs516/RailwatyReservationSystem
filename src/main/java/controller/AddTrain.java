package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/addtrain")
public class AddTrain extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int trainnumber=Integer.parseInt(req.getParameter("tnumber"));
	String  trainname=req.getParameter("name");
	int seats=Integer.parseInt(req.getParameter("seat"));
	String stations=req.getParameter("stations");
	String[] trainstations=stations.split(",");
	
	String  time=req.getParameter("time");
	String[] traintime=time.split(",");

	String  days=req.getParameter("days");
	String[] traindays=days.split(",");
	
	String  price=req.getParameter("price");
	String[] trainprice=price.split(",");


	TrainDao trainDao=new TrainDao();
	Train train=new Train();
	train.setDays(traindays);
	train.setTnumber(trainnumber);
	train.setName(trainname);
	train.setPrice(trainprice);
	train.setSeat(seats);
	train.setStations(trainstations);
	train.setTime(traintime);
	train.setPrice(trainprice);
	
	trainDao.saveTrain(train);
	resp.getWriter().print("<h1>Train Added Successfully</h1>");
	req.getRequestDispatcher("ManagementHome.html").include(req, resp);
}
}
