<%@ page import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie cookies[] = request.getCookies();

    if(cookies != null) {
        for(Cookie c : cookies) {
%>
            <p>
                <b>Name:</b> <%= c.getName() %> <br>
                <b>Value (Domain):</b> <%= c.getValue() %> <br>
                <b>Max Age:</b> <%= c.getMaxAge() %> <br><br>
            </p>
<%
        }
    } else {
%>
        <p>No cookies found.</p>
<%
    }
%>

<br>
<a href="index.jsp">Add Another Cookie</a>

</body>
</html>