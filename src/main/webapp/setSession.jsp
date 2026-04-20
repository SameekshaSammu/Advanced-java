<%
    String name = request.getParameter("username");
    int time = Integer.parseInt(request.getParameter("time"));

    // Create session
    session.setAttribute("user", name);

    // Set session timeout (seconds)
    session.setMaxInactiveInterval(time * 60);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Session Created</title>
</head>
<body>

    <h2>Hello <%= name %>!</h2>

    <p>Your session is set for <%= time %> minutes.</p>

    <a href="checkSession.jsp">Click here to check session</a>

    <br><br>
    <p>
        👉 Click the link within session time OR wait for expiry to see session expire.
    </p>

</body>
</html>