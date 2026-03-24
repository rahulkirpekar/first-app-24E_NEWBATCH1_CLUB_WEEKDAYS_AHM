<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Application</title>

<style>
    * {
        box-sizing: border-box;
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
    }

    body {
        margin: 0;
        min-height: 100vh;
        background: linear-gradient(135deg, #667eea, #764ba2);
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .login-container {
        background: #ffffff;
        width: 100%;
        max-width: 380px;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 15px 35px rgba(0,0,0,0.2);
    }

    .login-container h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #333;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        margin-bottom: 6px;
        font-weight: 600;
        color: #555;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px 12px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 15px;
        transition: border-color 0.3s;
    }

    input:focus {
        outline: none;
        border-color: #667eea;
    }

    .login-btn {
        width: 100%;
        padding: 10px;
        background: #667eea;
        border: none;
        color: #fff;
        font-size: 16px;
        font-weight: bold;
        border-radius: 5px;
        cursor: pointer;
        transition: background 0.3s;
    }

    .login-btn:hover {
        background: #5563c1;
    }

    .footer-text {
        text-align: center;
        margin-top: 15px;
        font-size: 14px;
        color: #777;
    }

    @media (max-width: 480px) {
        .login-container {
            padding: 20px;
        }
    }
</style>

</head>

<body>

<div class="login-container">
    <h2>User Login</h2>

    <form action="loginServlet" method="post">
		
		${loginErr}
		${logoutAccess}
		${invalidAccess}
		
        <div class="form-group">
            <label>User Name</label>
            <input type="text" name="userName" placeholder="Enter username" required>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password" name="password" placeholder="Enter password" required>
        </div>

        <button type="submit" class="login-btn">Login</button>

    </form>

    <div class="footer-text">
        © 2026 Login Application
    </div>
</div>

</body>
</html>