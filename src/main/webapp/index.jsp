<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Data Form</title>

    <script>
        function validateForm() {
            let username = document.forms["form"]["username"].value;
            let email = document.forms["form"]["email"].value;
            let designation = document.forms["form"]["designation"].value;

            // Empty check
            if (username === "" || email === "" || designation === "") {
                alert("All fields are required!");
                return false;
            }

            // Email validation
            let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
            if (!email.match(emailPattern)) {
                alert("Enter a valid email!");
                return false;
            }

            return true;
        }
    </script>
</head>

<body>
    <h2>User Details Form</h2>

    <form name="form" action="UserDataServlet" method="post" onsubmit="return validateForm()">
        Username: <input type="text" name="username"><br><br>
        Email: <input type="text" name="email"><br><br>

        Designation:
        <select name="designation">
            <option value="">--Select--</option>
            <option value="Student">Student</option>
            <option value="Developer">Developer</option>
            <option value="Manager">Manager</option>
        </select>
        <br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>