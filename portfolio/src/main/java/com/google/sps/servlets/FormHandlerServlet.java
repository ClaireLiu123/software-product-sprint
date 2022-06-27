package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;



@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    //String textValue = request.getParameter("text-input");

    String textValue = Jsoup.clean(request.getParameter("title"), Whitelist.none());
    
    //String emailValue = request.getParameter("email");
    String emailValue = Jsoup.clean(request.getParameter("title"), Whitelist.none());

    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + textValue);

    System.out.println("You submitted: " + emailValue);

    // Write the value to the response so the user can see it.
    response.getWriter().println("You submitted: " + textValue);
    response.getWriter().println("You submitted: " + emailValue);

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");
    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("title", textValue)
            .set("email", emailValue)
            .build();
    datastore.put(taskEntity);

    
    response.sendRedirect("https://cliu-sps-summer22.appspot.com/");

  }

}