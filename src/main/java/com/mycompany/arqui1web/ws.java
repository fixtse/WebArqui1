/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arqui1web;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author fixt
 */
@WebServlet(name = "ws", urlPatterns = {"/ws"})
public class ws extends HttpServlet {
    
    private Float val=0f;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException {
        
        Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://ws-software1.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        Servicio service = retrofit.create(Servicio.class);
        
        HttpSession ses = request.getSession(true);
        Float val1 = Float.valueOf(request.getParameter("val1"));
        Float val2 = Float.valueOf(request.getParameter("val2"));
        String ans = request.getParameter("ans");
        NumReq req = new NumReq(val1,val2);
//        System.out.println(val1);
//        System.out.println(val2);
        
        
        
        switch (ans){
            case "+":
                service.obtenerSuma(req).enqueue(new Callback<Float>() {
                                @Override
                                public void onResponse(Call<Float> call, Response<Float> respon) {
                                    
                                    val = respon.body();                                  
                                    
                                    
                                    
                                }

                                @Override
                                public void onFailure(Call<Float> call, Throwable t) {

                                }
                            });
                break;
            case "-":
                service.obtenerResta(req).enqueue(new Callback<Float>() {
                                @Override
                                public void onResponse(Call<Float> call, Response<Float> respon) {
                                    val = respon.body();
                                }

                                @Override
                                public void onFailure(Call<Float> call, Throwable t) {

                                }
                            });
                break;
            case "*":
                service.obtenerMulti(req).enqueue(new Callback<Float>() {
                                @Override
                                public void onResponse(Call<Float> call, Response<Float> respon) {
                                    val = respon.body();
                                }

                                @Override
                                public void onFailure(Call<Float> call, Throwable t) {

                                }
                            });
                break;
            case "/":
                service.obtenerDivi(req).enqueue(new Callback<Float>() {
                                @Override
                                public void onResponse(Call<Float> call, Response<Float> respon) {
                                    val = respon.body();
                                }

                                @Override
                                public void onFailure(Call<Float> call, Throwable t) {

                                }
                            });
                break;
                
                
                
            
        }
        
        
        Thread.sleep(1000);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        request.setAttribute("resp", val);
        rd.forward(request, response);

        
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            
            
          
        } catch (InterruptedException ex) {
            Logger.getLogger(ws.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
