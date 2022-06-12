package com.google.sps.servlets;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
    ArrayList<String> quotes = new ArrayList<>(Arrays.asList("I like blue", "I like white", "I like pink"));

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    String color = getRandomColor();
    response.getWriter().println("<h1>Hello Claire!</h1>");
    //response.getWriter().println(color);
    String json = new Gson().toJson(color);
    response.getWriter().write(json);
    
    String quotesArr = new Gson().toJson(quotes);
    response.getWriter().write(quotesArr);

    }

    public String getRandomColor(){
        String[] colors = {"blue", "white", "pink", "red", "black", "yellow"};  
        String color = colors[(int) Math.floor(Math.random() * colors.length)];
        return color;
    }
}



