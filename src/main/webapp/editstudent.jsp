<!DOCTYPE html>
<%@page import="com.royal.bean.UserBean"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Student Registration</title>

<style>

body {
    margin: 0;
    background: #f3f7ff;
    font-family: Arial, sans-serif;
}

/* ===== HEADER ===== */

.header {
    background: #007bff;
    color: white;
    padding: 12px 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.logout-btn {
    background: #dc3545;
    color: white;
    border: none;
    padding: 6px 14px;
    border-radius: 4px;
    cursor: pointer;
    font-size: 13px;
}

/* ===== FORM CONTAINER ===== */

.container {
    width: 480px;
    background: white;
    margin: 30px auto;
    padding: 25px;
    border-radius: 8px;
    box-shadow: 0 0 12px rgba(0,0,0,0.15);
}

h2 {
    margin-top: 0;
}

/* ===== FORM ELEMENTS ===== */

label {
    font-weight: bold;
    font-size: 14px;
    display: block;
    margin-top: 12px;
}

input,
select,
textarea {
    width: 100%;
    padding: 8px;
    margin-top: 5px;
    border: 1px solid #888;
    border-radius: 4px;
    box-sizing: border-box;
}

.inline-options {
    margin-top: 6px;
}

.inline-options input {
    width: auto;
}

.btn-container {
    text-align: center;
    margin-top: 20px;
}

input[type="submit"],
input[type="reset"] {
    width: 120px;
    padding: 10px;
    border: none;
    color: white;
    font-weight: bold;
    border-radius: 4px;
    cursor: pointer;
}

input[type="submit"] {
    background: #007bff;
}

input[type="reset"] {
    background: #6c757d;
}

</style>

<script>
function confirmLogout() {
    return confirm("Are you sure you want to logout?");
}
</script>

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

<!-- ===== HEADER ===== -->

<div class="header">
    <span>Welcome, User</span>

    <form action="LogoutServlet" method="post" onsubmit="return confirmLogout();">
        <input type="submit" value="Logout" class="logout-btn">
    </form>
</div>

<!-- ===== FORM SECTION ===== -->

<div class="container">

	<h2>Student Registration</h2>
	
	<form action="UpdateStudentServlet" method="post">
	
		${dbErr}
	
	    <label for="id">Employee Id</label>
	    <input type="text" id="id" name="id" value="${sbean.id}" readonly="readonly">
	
	    <label for="fullname">Full Name ${fullnameErr}</label>
	    <input type="text" id="fullname" name="fullname" value="${sbean.fullname}">
	
	    <label for="age">Age ${ageErr}</label>
	    <input type="number" id="age" name="age" value="${sbean.age}">
	
	    <label for="course">Select Course ${courseErr}</label>
	   <select id="course" name="course">
	        <option value="">-- Select Course --</option>
	        <option value="C Programming"  ${sbean.course  == 'C Programming'  ? 'selected' : ''} >C Programming</option>
	        <option value="C++"            ${sbean.course  == 'C++'            ? 'selected' : ''}           >C++</option>
	        <option value="Core Java"       ${sbean.course == 'Core Java'      ? 'selected' : ''}      >Core Java</option>
	        <option value="Advanced Java"   ${sbean.course == 'Advanced Java'  ? 'selected' : ''}  >Advanced Java</option>
	        <option value="BSc IT"          ${sbean.course == 'BSc IT'         ? 'selected' : ''}>BSc IT</option>
	        <option value="MSc IT"   ${sbean.course == 'MSc IT'  ? 'selected' : ''}  >MSc IT</option>
	        <option value="MCA"          ${sbean.course == 'MCA'         ? 'selected' : ''}>MCA</option>
	        <option value="BCA"          ${sbean.course == 'BCA'         ? 'selected' : ''}>BCA</option>
	    </select>
	
	    <label>Gender ${genderErr}</label>
	    <div class="inline-options">
	        <input type="radio" name="gender" value="Male"	 ${sbean.gender=='Male'   ? 'checked' : ''}> Male
	        <input type="radio" name="gender" value="Female"  ${sbean.gender=='Female' ? 'checked' : ''}> Female
	        <input type="radio" name="gender" value="Other"	 ${sbean.gender=='Other'  ? 'checked' : ''}> Other
	    </div>
	
	    <label>Hobbies ${hobbyErr}</label>
	    <div class="inline-options">
	        <input type="checkbox" name="hobby" value="Reading"	${sbean.isHobbySelected('Reading') ? 'checked' : ''}	> Reading
	        <input type="checkbox" name="hobby" value="Music"		${sbean.isHobbySelected('Music')   ? 'checked' : ''}	> Music
	        <input type="checkbox" name="hobby" value="Sports"	${sbean.isHobbySelected('Sports')  ? 'checked' : ''} > Sports
	        <input type="checkbox" name="hobby" value="Coding"	${sbean.isHobbySelected('Coding')  ? 'checked' : ''}	> Coding
	    </div>
	
	    <label for="dob">Date of Birth ${dobErr}</label>
	    <input type="date" id="dob" name="dob" value="${sbean.dob}">
	
	    <label for="email">Email ${emailErr}</label>
	    <input type="email" id="email" name="email" value="${sbean.email}">
	
	    <label for="mobile">Mobile ${mobileErr}</label>
	    <input type="tel" id="mobile" name="mobile" value="${sbean.mobile}">
	
	    <label for="address">Address ${addressErr}</label>
	    <textarea id="address" name="address" rows="3">${sbean.address}</textarea>
	
	    <div class="btn-container">
	        <input type="submit" value="Update">
	        <input type="reset" value="Clear">
	    </div>
	</form>
</div>
</body>
</html>