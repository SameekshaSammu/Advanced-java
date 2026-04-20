<%
    String name = (String) session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Check Session</title>
</head>
<body>

<%
    if (name != null) {
%>
        <h2>Hello <%= name %>! Your session is still active.</h2>
<%
    } else {
%>
        <h2>Session Expired!</h2>
        <p>Please go back and create a new session.</p>
        <a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>