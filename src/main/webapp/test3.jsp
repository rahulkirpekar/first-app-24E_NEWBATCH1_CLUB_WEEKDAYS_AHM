<?xml version="1.0" encoding="UTF-8" ?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Declaration Tag</title>
</head>
<body>
	
	<%@ include file="header.jsp" %>

	<%!
		int getCube(int no)
		{
			return(no*no*no);	
		}
	%>

	Cube Value :  <%=getCube(10)%>;


	<%@ include file="footer.jsp" %>

</body>
</html>