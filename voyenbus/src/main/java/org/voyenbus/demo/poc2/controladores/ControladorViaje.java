/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voyenbus.demo.poc2.controladores;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.voyenbus.demo.poc2.pojos.Info;
import org.voyenbus.demo.poc2.pojos.Viaje;
import org.voyenbus.demo.poc2.servicios.ServicioViaje;
import org.voyenbus.demo.poc2.utilidades.*;

/**
 *
 * @author PC
 */
public class ControladorViaje {
    private ServicioViaje api;    
    private ConvertidorJSON convertidorJSON;
    private String json;
    List <Viaje> listaViajes;
    
    public ControladorViaje(){
    }
    
    /*public void iniciar(){
        boolean resultado = false;
        api = new ServicioViaje();
        convertidorJSON = new ConvertidorJSON();
        
        this.json = api.obtenerViajes();
        System.out.println(this.json);
        
        if(this.json != null)
            resultado = api.determinarResultado(this.json);
        else
            System.out.println(Constantes.ERROR_API_CONEXION);
        
        if(resultado && this.json != null)
            listaViajes = convertidorJSON.JSONaViajes(json);
        else
            System.out.println(Constantes.ERROR_API_VIAJES);
    }*/
    
    public Info getInfo(){      
        return new ServicioViaje().getInfo();
    }
    
    /*public Viaje obtenerMejorViaje(){       
        
        return new ServicioViaje().obtenerMejorViaje();                
    }*/
}
