/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voyenbus.demo.poc2.pojos;

import java.util.List;

/**
 *
 * @author PC
 */
public class Info {
    private List <Viaje> viajes;
    private Viaje mejorViaje;
        
    public Info(){
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public Viaje getMejorViaje() {
        return mejorViaje;
    }

    public void setMejorViaje(Viaje mejorViaje) {
        this.mejorViaje = mejorViaje;
    }   
}
