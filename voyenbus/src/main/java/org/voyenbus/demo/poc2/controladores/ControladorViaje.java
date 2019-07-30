/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voyenbus.demo.poc2.controladores;


import org.voyenbus.demo.poc2.pojos.Info;
import org.voyenbus.demo.poc2.servicios.ServicioViaje;

/**
 *
 * @author PC
 */
public class ControladorViaje {     
    
    public ControladorViaje(){
    }
      
    public Info getInfo(){      
        return new ServicioViaje().getInfo();
    }    
}
