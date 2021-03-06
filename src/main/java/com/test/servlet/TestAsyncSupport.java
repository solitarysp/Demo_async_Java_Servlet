package com.test.servlet;

import sun.net.www.http.HttpClient;

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


@WebServlet(value = "/test",asyncSupported = true)
public class TestAsyncSupport extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ExecutorService executorService = Executors.newFixedThreadPool(50);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String name=  request.getParameter("name");
        final AsyncContext ctx =   request.startAsync();
        final String uid= UUID.randomUUID().toString();
        System.out.println("Run uid : "+uid+" Thread :"+Thread.currentThread().getName());
        // cho vaof queue chay bat dong bo
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Async start "+name+": "+uid);
                    try {
                   Thread.sleep(10000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Async End "+name+": "+uid);
                    ctx.getResponse().getWriter().write("Hello user "+name+": "+uid);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //The callback is completed after the final execution.
                ctx.complete();
            }
        });
    }


}
