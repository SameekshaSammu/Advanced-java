package com.cookie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    // STEP 1: Show form first
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Enter Your Name</h2>");
        out.println("<form method='post' action='CookieServlet'>");
        out.println("Name: <input type='text' name='username' required><br><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
    }

    // STEP 2: Process form after submit
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        int visitCount = 1;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                }
            }
        }

        Cookie nameCookie = new Cookie("username", name);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Expiry (10 sec)
        nameCookie.setMaxAge(10);
        countCookie.setMaxAge(10);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // Output
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times</h3>");

        out.println("<h3>List of Cookies:</h3>");
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("Cookie Name: " + c.getName() + "<br>");
            }
        }

        out.println("<br><p>Cookies expire in 10 seconds.</p>");

        // Back link
        out.println("<br><a href='CookieServlet'>Go Back</a>");
    }
}