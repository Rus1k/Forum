package com.forumapp.web.servlets;

import com.forumapp.repository.query.DBService;
import com.forumapp.repository.query.DBServiceImpl;
import com.forumapp.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class SaveInfoServlet extends HttpServlet {
    DBService dbService = new DBServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password1");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
        String city = req.getParameter("city");
        if(!dbService.checkLogin(login)) {
            int idAccount = dbService.saveAccount(Account.builder().login(login).password(password).build());
            dbService.saveUserInfo(UserInfo.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .birthday(birthday)
                    .city(city)
                    .idAccount(idAccount)
                    .build());
            System.out.println("!!!!!!!!!!!!!!!!!!!!!! != TRUE!!!!!!!!!!!!!!!!!!!");
        }else {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!! TRUE!!!!!!!!!!!!!!!!!!!");
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();
            pw.println("Login already use");
        }
    }
}
