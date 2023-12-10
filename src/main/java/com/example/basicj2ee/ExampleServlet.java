package com.example.basicj2ee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/ExampleServlet")
public class ExampleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String name = request.getParameter("name");
        String message = "Hello, " + name + "!";

        // Set response content type
        response.setContentType("text/html");

        // Write the response message
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Response from servlet:</h2>");
        out.println("<h3>" + message + "</h3>");
        out.println("</body></html>");
    }
}
