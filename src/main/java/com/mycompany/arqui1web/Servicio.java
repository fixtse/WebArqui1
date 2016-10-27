/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arqui1web;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.Call;
/**
 *
 * @author fixt
 */
public interface Servicio {
    
        @POST("suma")
        Call<Float> obtenerSuma(@Body NumReq req);

        @POST("resta")
        Call<Float> obtenerResta(@Body NumReq req);

        @POST("multi")
        Call<Float> obtenerMulti(@Body NumReq req);

        @POST("divi")
        Call<Float> obtenerDivi(@Body NumReq req);
    
}
