package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/test")
public class TestServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    String color = getRandomColor();

    response.getWriter().println("<h1>Hello Claire!</h1>");
    response.getWriter().println(color);
    }

    public String getRandomColor(){
        String[] colors = {"blue", "green", "red", "purple", "yellow", "white", "pink"};  
        String color = colors[(int) Math.floor(Math.random() * colors.length)];
        return color;
    }
}



