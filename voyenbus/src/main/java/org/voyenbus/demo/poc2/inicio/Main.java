package org.voyenbus.demo.poc2.inicio;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.voyenbus.demo.poc2.controladores.ControladorViaje;
import org.voyenbus.demo.poc2.pojos.Info;
import org.voyenbus.demo.poc2.pojos.Viaje;
import org.voyenbus.demo.poc2.utilidades.Constantes;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PC
 */
public class Main {
    private static ControladorViaje controlador;
    //private static List <Viaje> listaViajes;
    //private static Viaje mejorViaje = null;
    
    public static void main(String args[]){
        System.out.println(Constantes.BIENVENIDA);        
        controlador = new ControladorViaje();        
        //controlador.iniciar();
        
        Info info = controlador.getInfo();
        Viaje mejorViaje = info.getMejorViaje();  
        List<Viaje> listaViajes = info.getViajes();
        
        if(listaViajes != null)
            imprimirViajes(listaViajes);
        
        if(mejorViaje != null)
            imprimirMejorViaje(mejorViaje);
    }
     
    public static void imprimirViajes(List<Viaje> viajes){
        Iterator viajesIterator = viajes.iterator();
        System.out.println();
        System.out.println(Constantes.INFO_VIAJES);
        System.out.println();
        DecimalFormat format = new DecimalFormat("#0.00");
        
        while(viajesIterator.hasNext()){
            Viaje viaje = (Viaje)viajesIterator.next();
            
            System.out.println(Constantes.EMPRESA + viaje.getNombreCompania());
            System.out.println(Constantes.DIA_SALIDA + viaje.getDiaSalida()); 
            System.out.println(Constantes.HORA_SALIDA + viaje.getHoraSalida());
            System.out.println(Constantes.DESDE + viaje.getNombreDesde());
            System.out.println(Constantes.DIA_LLEGADA + viaje.getDiaLlegada());
            System.out.println(Constantes.HORA_LLEGADA + viaje.getHoraLlegada());
            System.out.println(Constantes.HACIA + viaje.getNombreHacia());
            System.out.println(Constantes.TIPO_ASIENTO + viaje.getCategoria());
            System.out.println(Constantes.PRECIO + format.format(viaje.getPrecio()));  
            System.out.println(Constantes.SEPARADOR);
        }
    }
    
    public static void imprimirMejorViaje(Viaje viaje){
        DecimalFormat format = new DecimalFormat("#0.00");
        System.out.println();
        System.out.println(Constantes.MEJOR_PRECIO );  
        System.out.println();
        System.out.println(Constantes.EMPRESA + viaje.getNombreCompania());
        System.out.println(Constantes.DIA_SALIDA + viaje.getDiaSalida()); 
        System.out.println(Constantes.HORA_SALIDA + viaje.getHoraSalida());
        System.out.println(Constantes.DESDE + viaje.getNombreDesde());
        System.out.println(Constantes.DIA_LLEGADA + viaje.getDiaLlegada());
        System.out.println(Constantes.HORA_LLEGADA + viaje.getHoraLlegada());
        System.out.println(Constantes.HACIA + viaje.getNombreHacia());
        System.out.println(Constantes.TIPO_ASIENTO + viaje.getCategoria());
        System.out.println(Constantes.PRECIO + format.format(viaje.getPrecio()));  
        
    }
}
