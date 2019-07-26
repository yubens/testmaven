/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voyenbus.demo.poc2.pojos;

/**
 *
 * @author PC
 */
public class Viaje {

    private String nombreCompania;
    private String duracion;
    private String moneda;
    private double precio;
    private int idDesde;
    private String nombreDesde;
    private int idHacia;
    private String nombreHacia;
    private String diaSalida;
    private String diaLlegada;
    private String horaSalida;
    private String horaLlegada;
    private String idViaje;
    private String llaveViaje;
    private String categoria;

    public Viaje(String nombreCompania, String duracion, String moneda, double precio,
            int idDesde, String nombreDesde, int idHacia, String nombreHacia, String diaSalida,
            String diaLlegada, String horaSalida, String horaLlegada, String idViaje, String llaveViaje, String categoria) {
        this.nombreCompania = nombreCompania;
        this.duracion = duracion;
        this.moneda = moneda;
        this.precio = precio;
        this.idDesde = idDesde;
        this.nombreDesde = nombreDesde;
        this.idHacia = idHacia;
        this.nombreHacia = nombreHacia;
        this.diaSalida = diaSalida;
        this.diaLlegada = diaLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.idViaje = idViaje;
        this.llaveViaje = llaveViaje;
        this.categoria = categoria;
    }

    public Viaje() {
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdDesde() {
        return idDesde;
    }

    public void setIdDesde(int idDesde) {
        this.idDesde = idDesde;
    }

    public String getNombreDesde() {
        return nombreDesde;
    }

    public void setNombreDesde(String nombreDesde) {
        this.nombreDesde = nombreDesde;
    }

    public int getIdHacia() {
        return idHacia;
    }

    public void setIdHacia(int idHacia) {
        this.idHacia = idHacia;
    }

    public String getNombreHacia() {
        return nombreHacia;
    }

    public void setNombreHacia(String nombreHacia) {
        this.nombreHacia = nombreHacia;
    }

    public String getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(String diaSalida) {
        this.diaSalida = diaSalida;
    }

    public String getDiaLlegada() {
        return diaLlegada;
    }

    public void setDiaLlegada(String diaLlegada) {
        this.diaLlegada = diaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    

    public String getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(String idViaje) {
        this.idViaje = idViaje;
    }

    public String getLlaveViaje() {
        return llaveViaje;
    }

    public void setLlaveViaje(String llaveViaje) {
        this.llaveViaje = llaveViaje;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
