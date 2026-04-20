package com.userdata;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        // Server-side validation
        if (username == null || username.isEmpty() ||
            email == null || email.isEmpty() ||
            designation == null || designation.isEmpty()) {

            response.sendRedirect("index.jsp");
            return;
        }

        // Email format check
        if (!email.matches("^[^ ]+@[^ ]+\\.[a-z]{2,3}$")) {
            response.sendRedirect("index.jsp");
            return;
        }

        // Set attributes
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("designation", designation);

        // Forward to JSP
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}