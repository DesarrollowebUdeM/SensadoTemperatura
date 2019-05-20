/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temperatura.ws.rest.registro;

import com.temperatura.controller.Controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Henry Daniel
 */
/**
 *
 * Esta clase se encarga de exponer un servicio para que el dispositivo movil
 * pueda registrarse
 */
@Path("register")
public class RegistroResource {
      boolean registrado;
//    @Path("newregister")
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String putJson(Telefono movil) {
//        System.out.println(movil);
//        return "True";
//    }

    @Path("newregister")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String Correo) {
        System.out.println(Correo);
        Controller.pushNotify();
        registrado=Controller.register(Correo);
        return ""+registrado;
    }
}
