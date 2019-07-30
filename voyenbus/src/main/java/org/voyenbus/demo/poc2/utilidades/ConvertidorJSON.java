/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voyenbus.demo.poc2.utilidades;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.voyenbus.demo.poc2.pojos.Viaje;

/**
 *
 * @author PC
 */
public class ConvertidorJSON {
    List<Viaje> viajes;
    
    public ConvertidorJSON() {
    }      
    
    public List<Viaje> JSONaViajes(String json){
        List<Viaje> lista = new ArrayList<Viaje>();
        try {        	
           
            JSONObject obj = new JSONObject(json);
            JSONArray jsonArray = obj.getJSONObject("Trips").getJSONArray("oneWay");             
            
            for(int i = 0; i < jsonArray.length(); i++){
                Viaje viaje = new Viaje();
                String fecha, hora;                
                
                viaje.setNombreCompania(jsonArray.getJSONObject(i).getString("companyName"));
                
                String categoria = null;
                try {
                	categoria = jsonArray.getJSONObject(i).getJSONObject("fares").getString("category");
                }
                catch(JSONException e) {
                	categoria = Constantes.ERROR_CAT;
                }
                  
                viaje.setCategoria(categoria);
                viaje.setPrecio(Double.valueOf(jsonArray.getJSONObject(i).getJSONObject("fares").getString("price")));
                viaje.setMoneda(jsonArray.getJSONObject(i).getJSONObject("fares").getString("currency"));
                viaje.setIdDesde(jsonArray.getJSONObject(i).getInt("fromId"));
                viaje.setIdHacia(jsonArray.getJSONObject(i).getInt("toId"));
                viaje.setNombreDesde(jsonArray.getJSONObject(i).getString("fromName"));
                viaje.setNombreHacia(jsonArray.getJSONObject(i).getString("toName"));
                viaje.setIdViaje(jsonArray.getJSONObject(i).getString("tripId"));
                viaje.setLlaveViaje(jsonArray.getJSONObject(i).getString("tripKey"));
                
                fecha = convertidorFecha(jsonArray.getJSONObject(i).getString("departure"));
                viaje.setDiaSalida(fecha);
                fecha = convertidorFecha(jsonArray.getJSONObject(i).getString("arrive"));
                viaje.setDiaLlegada(fecha);
                hora = convertidorHora(jsonArray.getJSONObject(i).getString("departure"));
                viaje.setHoraSalida(hora);
                hora = convertidorHora(jsonArray.getJSONObject(i).getString("arrive"));
                viaje.setHoraLlegada(hora);
                
                lista.add(viaje);
            }           
                        
        } catch (Exception e) {
            System.out.println(Constantes.ERROR_JSON);
            e.printStackTrace();
        }
        
        return lista;
    }
    
    private String convertidorFecha(String fechaHora){       
        String resultado[] = null;
        
        resultado = fechaHora.split("T");
                
        String anio = resultado[0].substring(0, 4);
        String mes = resultado[0].substring(5, 7);
        String dia = resultado[0].substring(8, 10);
      
        return dia + "/" + mes + "/" + anio;
    }
    
    private String convertidorHora(String fechaHora){       
        String resultado[] = null;        
        resultado = fechaHora.split("T");       

        return resultado[1].substring(0, 5);
    }     
        
}
