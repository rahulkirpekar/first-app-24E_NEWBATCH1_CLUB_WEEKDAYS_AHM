<?xml version="1.0" encoding="UTF-8" ?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Table Page</title>
</head>
<body>
	<%
		String value = request.getParameter("value");
		int no = Integer.parseInt(value);
	%>

	<table border="1">
		<tr>
			<td>No</td>
			<td>i</td>
			<td>(No*i)</td>
		</tr>
	<%
		for(int i = 1; i <= 10; i++)
		{
	%>
		<tr>
			<td><%=no%></td>
			<td><%=i%></td>
			<td><%=no*i%></td>
		</tr>
	<% 	
		}
	%>
</table>
</body>
</html>
