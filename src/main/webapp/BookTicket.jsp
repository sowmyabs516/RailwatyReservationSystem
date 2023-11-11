<%@page import="dto.Train"%>
<%@page import="dao.TrainDao"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Book Ticket</h1>
<%User user=(User)session.getAttribute("user");%>
<%if(user==null){
	response.getWriter().print("<h1>Session Expired</h1>");
	request.getRequestDispatcher("Login.html").include(request, response);
}
else{
	int tnumber=Integer.parseInt(request.getParameter("tnumber"));
	TrainDao trainDao=new TrainDao();
	Train train=trainDao.fetchTrain(tnumber);
	if(train==null){
		response.getWriter().print("<h1>Invalid Train Number</h1>");
		request.getRequestDispatcher("Login.html").include(request, response);
	}
	else{%>
		<form action="bookticket">
		Train Number:<input type="number" name="tnumber" value="<%=train.getTnumber() %>">
		User Id:<input type="number" name="userid" value="<%=user.getId() %>">
		From:<select name="from">
		<%for(int i=0;i<=train.getStations().length-1;i++){%>
		<option><%=train.getStations()[i] %></option>
		<%} %>
		</select>
		
		To:<select name="to">
		<%for(int i=1;i<=train.getStations().length-1;i++){%>
		<option><%=train.getStations()[i] %></option>
		<%} %>
		</select>
		
		Number of Seats:<input type="number" name="seats">
		Date Of Journey:<input type="date" name="doj">
		<input type="reset"><button>Book</button>
		</form>
	<% }
}
%>
</body>
</html>