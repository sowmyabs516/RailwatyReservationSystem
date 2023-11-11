<%@page import="java.util.List"%>
<%@page import="dto.Train"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Train> list=(List<Train>) request.getAttribute("list");%>
<table border="1">
<tr>
<th>Train Number</th>
<th>Name</th>
<th>Seats</th>
<th>Stations</th>
<th>Price</th>
<th>Time</th>
<th>Days</th>
</tr>

<%for (Train train:list){ %>
<tr>
<th><%=train.getTnumber() %></th>
<th><%=train.getName() %></th>
<th><%=train.getSeat() %></th>
<th><%=train.getStations() %></th>
<th><%=train.getPrice() %></th>
<th><%=train.getTime() %></th>
<th><%=train.getDays() %></th>
</tr>
<%} %>
</table>
</body>
</html>