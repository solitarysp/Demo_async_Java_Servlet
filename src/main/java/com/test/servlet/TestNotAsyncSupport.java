package com.test.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@WebServlet(value = "/testNotAsync")
public class TestNotAsyncSupport extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ExecutorService executorService = Executors.newFixedThreadPool(50);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String uid= UUID.randomUUID().toString();
        System.out.println("Run uid : "+uid);
            System.out.println("Async start uid: "+uid);
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Async End uid: "+uid);

    }


}
