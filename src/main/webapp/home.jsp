<?xml version="1.0" encoding="UTF-8" ?>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home Page</title>
</head>
<body>
	<h1>First Jsp Page</h1>
	
		<%
			int no1,no2,ans;
			no1=100;
			no2=200;

			ans = no1+no2;

			out.print("Addition : " + ans) ;
		%>
		<br>
		Subtraction : <%=1000-200%>	
	
</body>
</html>
