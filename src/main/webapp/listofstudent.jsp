<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.royal.bean.UserBean"%>
<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>

<title>Student Management System</title>

<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
	rel="stylesheet">

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
	background: #eef2f7;
}

/* Header */
.header {
	background: linear-gradient(135deg, #1d2671, #c33764);
	color: white;
	padding: 22px;
	text-align: center;
	font-size: 28px;
	font-weight: 600;
	letter-spacing: 1px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

/* Container */
.container {
	width: 95%;
	margin: auto;
	margin-top: 35px;
}

/* Card */
.card {
	background: white;
	border-radius: 10px;
	box-shadow: 0 6px 15px rgba(0, 0, 0, 0.08);
	padding: 20px;
}

/* Top Bar */
.top-bar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 20px;
	flex-wrap: wrap;
	gap: 10px;
}

.top-bar h3 {
	font-weight: 500;
	color: #333;
}

/* Search */
.search-box {
	display: flex;
	align-items: center;
	gap: 5px;
}

.search-box input {
	padding: 8px 10px;
	border-radius: 6px;
	border: 1px solid #ccc;
	outline: none;
}

.search-box button {
	background: #007bff;
	color: white;
	border: none;
	padding: 8px 12px;
	border-radius: 6px;
	cursor: pointer;
}

.search-box button:hover {
	background: #0056b3;
}

/* Add Button */
.add-btn {
	background: #28a745;
	color: white;
	padding: 10px 16px;
	text-decoration: none;
	border-radius: 6px;
	font-size: 14px;
	font-weight: 500;
	transition: 0.3s;
}

.add-btn i {
	margin-right: 5px;
}

.add-btn:hover {
	background: #218838;
	transform: scale(1.05);
}

/* Table */
table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background: #343a40;
	color: white;
	padding: 12px;
	font-weight: 500;
	font-size: 14px;
}

td {
	padding: 12px;
	text-align: center;
	font-size: 14px;
	color: #444;
	border-bottom: 1px solid #eee;
}

tr:hover {
	background: #f9fafc;
}

/* Icon Buttons */
.icon-btn {
	padding: 7px 10px;
	border-radius: 6px;
	color: white;
	text-decoration: none;
	margin: 2px;
	display: inline-block;
	font-size: 14px;
}

.edit-btn {
	background: #3498db;
}

.edit-btn:hover {
	background: #2980b9;
}

.delete-btn {
	background: #e74c3c;
}

.delete-btn:hover {
	background: #c0392b;
}

/* Footer */
.footer {
	text-align: center;
	margin-top: 35px;
	padding: 15px;
	background: #1d2671;
	color: white;
	font-size: 14px;
}
</style>

</head>

<body>
	<%
		UserBean userBean = (UserBean)session.getAttribute("userBean");
	
		if(userBean == null)
		{
			request.setAttribute("invalidAccess", "<font color='red'>Invalid Access,Login First...!</font>");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	%>

	<div class="header">Student Management System</div>

	<div class="container">

		<div class="card">

			<div class="top-bar">

				<h3>Student List</h3>
				<h5>${deleteStudentResult}</h5>
				
				<div class="search-box">
					<input type="text" placeholder="Search student...">
					<button>
						<i class="fa fa-search"></i>
					</button>
				</div>

				<a href="addStudent.jsp" class="add-btn"> <i class="fa fa-plus"></i>
					Add Student
				</a>

			</div>

			<%
			ArrayList<StudentBean> list = (ArrayList<StudentBean>) request.getAttribute("list");
			%>

			<table>

				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Age</th>
					<th>Course</th>
					<th>Gender</th>
					<th>Hobbies</th>
					<th>DOB</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Address</th>
					<th>Action</th>
				</tr>

				<%
				for (int i = 0; i < list.size(); i++) {
					StudentBean s = list.get(i);
				%>

				<tr>

					<td><%=s.getId()%></td>
					<td><%=s.getFullname()%></td>
					<td><%=s.getAge()%></td>
					<td><%=s.getCourse()%></td>
					<td><%=s.getGender()%></td>
					<td><%=s.getHobbiesStr()%></td>
					<td><%=s.getDob()%></td>
					<td><%=s.getEmail()%></td>
					<td><%=s.getMobile()%></td>
					<td><%=s.getAddress()%></td>

					<td><a href="EditStudentServlet?id=<%=s.getId()%>"
						class="icon-btn edit-btn"> <i
							class="fa-solid fa-pen-to-square"></i>
					</a> <a href="DeleteStudentServlet?id=<%=s.getId()%>"
						class="icon-btn delete-btn"
						onclick="return confirm('Are you sure you want to delete this student?');">

							<i class="fa-solid fa-trash"></i>

					</a></td>

				</tr>

				<%
				}
				%>

			</table>

		</div>

	</div>

	<div class="footer">© 2026 Student Management System | JSP CRUD
		Project</div>

</body>
</html>