/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voyenbus.demo.poc2.servicios;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import org.voyenbus.demo.poc2.pojos.Info;
import org.voyenbus.demo.poc2.pojos.Viaje;
import org.voyenbus.demo.poc2.utilidades.ClienteAPI;
import org.voyenbus.demo.poc2.utilidades.Constantes;
import org.voyenbus.demo.poc2.utilidades.ConvertidorJSON;

/**
 *
 * @author PC
 */
public class ServicioViaje {
    private String json;    
    private Info info;
    
    public ServicioViaje() {
    }
    public Info getInfo(){
        info = new Info();
        
        info.setViajes(obtenerViajes());
        info.setMejorViaje(obtenerMejorViaje());
        
        return info;        
    }
    
    public List<Viaje> obtenerViajes() {
        ConvertidorJSON convertidorJSON;
        
        List<Viaje> listaViajes = null;
      
        boolean resultado = false;
                
        ClienteAPI clienteAPI = new ClienteAPI();
        //json = clienteAPI.obtenerViajesHARD();
        //json = clienteAPI.obtenerViajes();        
        json = clienteAPI.getViajes();
        
        if(json != null) {
        	resultado = determinarResultado();        	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
        }
            
        else
            System.out.println(Constantes.ERROR_API_CONEXION);
        
        if(resultado && json != null){
            convertidorJSON = new ConvertidorJSON();
            listaViajes = convertidorJSON.JSONaViajes(json);
        } else
            System.out.println(Constantes.ERROR_API_VIAJES);
                                   
        return listaViajes;
    }
    
    public boolean determinarResultado(){
        boolean resultado = false;
        JSONObject obj = new JSONObject(json);
        String estado = obj.getJSONObject("Trips").getString("status");
        String mensaje = obj.getJSONObject("Trips").getString("message");
                             
        System.out.println("estado " + estado);
        System.out.println("mensaje " + mensaje);        
        
        if(estado.equals(Constantes.OK) && mensaje.equals(Constantes.OK)){            
            resultado = true;         
        }
                    
        return resultado;
    }
    
    public Viaje obtenerMejorViaje() {       
        Viaje viaje = null;
        double menor = 0.0;
        
        Iterator iterator = info.getViajes().iterator();
        viaje = (Viaje)iterator.next();
        menor = viaje.getPrecio();
        
        while(iterator.hasNext()){
            Viaje aux = (Viaje)iterator.next();
            
            if(aux.getPrecio() < menor){
                menor = aux.getPrecio();
                viaje = aux;
            }            
        }
        
        return viaje;
    }   
       
    
}
