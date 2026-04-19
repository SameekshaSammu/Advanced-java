/*
 6b. Build a servlet program to create a cookie to get your name through text box and press submit button( through HTML) to display the message by greeting Welcome back your name ! , you have visited this page n times ( n = number of your visit ) and demonstrate the expiry of cookie also.
 */
package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String existingUser = null;
        int count = 0;

        // Read cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        out.println("<html><body>");

        // Always show guest message (like your screenshot)
        out.println("<h2 style='color:red;'>Welcome Guest! you have been logged out or kindly login first time</h2>");

        if (existingUser != null) {
            count++;

            // Update count cookie
            Cookie countCookie = new Cookie("count", String.valueOf(count));
            countCookie.setMaxAge(60);
            response.addCookie(countCookie);

            out.println("<h1 style='color:blue; font-size:40px;'>Welcome back, " + existingUser + "!</h1>");
            out.println("<h1 style='color:magenta; font-size:40px;'>You have visited this page " + count + " times!</h1>");
        } else {
            out.println("<form method='post'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // Handle POST (Login + Logout)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        if (userName != null && !userName.isEmpty()) {
            // LOGIN
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60);

            Cookie countCookie = new Cookie("count", "0");
            countCookie.setMaxAge(60);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        } else {
            // LOGOUT
            Cookie userCookie = new Cookie("user", "");
            userCookie.setMaxAge(0);

            Cookie countCookie = new Cookie("count", "");
            countCookie.setMaxAge(0);

            response.addCookie(userCookie);
            response.addCookie(countCookie);
        }

        response.sendRedirect("CookieServlet");
    }
}