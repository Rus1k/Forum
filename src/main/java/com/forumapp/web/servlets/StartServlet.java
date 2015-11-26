package com.forumapp.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StartServlet extends com.forumapp.web.servlets.DispetcherServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("logout") != null){
            super.forward("/welcomePage.jsp", req, resp);
        }else if(req.getParameter("enter") != null){
            super.forward("/homePage.jsp", req, resp);
        }else if(req.getParameter("register") != null){
            super.forward("/registration.jsp", req, resp);
        }
    }
}
