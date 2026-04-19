/*
 6c. Build a servlet program to check the given number is prime number or not using HTML with step by step procedure.
 */
package com.primeservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("num");

        out.println("<html><body>");

        try {
            int num = Integer.parseInt(input);
            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                out.println("<h2 style='color:green;'>" + num + " is Prime</h2>");
            } else {
                out.println("<h2 style='color:red;'>" + num + " is NOT Prime</h2>");
            }

        } catch (Exception e) {
            out.println("<h2 style='color:red;'>Invalid Input</h2>");
        }

        out.println("<br><a href='prime.html'>Try Again</a>");
        out.println("</body></html>");
    }
}