<%@ page import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    String ageStr = request.getParameter("age");

    int age = 0;

    // Server-side validation
    if(name == null || name.isEmpty() || 
       domain == null || domain.isEmpty() || 
       ageStr == null || ageStr.isEmpty()) {
%>
        <h3 style="color:red;">All fields are required!</h3>
        <a href="index.jsp">Go Back</a>
<%
    } else {
        try {
            age = Integer.parseInt(ageStr);

            Cookie cookie = new Cookie(name, domain);
            cookie.setMaxAge(age);

            response.addCookie(cookie);
%>
            <h2>Cookie Added Successfully!</h2>
            <p><b>Name:</b> <%= name %></p>
            <p><b>Domain:</b> <%= domain %></p>
            <p><b>Max Age:</b> <%= age %> seconds</p>

            <br>
            <a href="viewCookies.jsp">Go to Active Cookie List</a>

<%
        } catch(Exception e) {
%>
            <h3 style="color:red;">Invalid Age!</h3>
            <a href="index.jsp">Go Back</a>
<%
        }
    }
%>

</body>
</html>