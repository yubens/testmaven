/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.voyenbus.demo.poc2.utilidades;

import javax.ws.rs.core.HttpHeaders;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

/**
 *
 * @author PC
 */
public class ClienteAPI {
    private String token;
    public ClienteAPI(){}       
	    
    public String getViajes() {
    	
    	//variables temporales que deberian obtnerse a traves de la API http://api.voyenbus.com/TOLWeb/api/rest/v1.0/authorize
    	String tokenTmp = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJWb3llbmJ1cyIsImF1ZCI6ImRlbW9WZWIxX3Rlc3QuYXBpIiwiZXhwIjoxNTY0MzczNDI4LCJzdWIiOiJhdXRoX3Rva2VuIiwiaWF0IjoxNTY0MzcyNTI4LCJqdGkiOiJENDg1OUY1MjVGMDBDMERGMTlDNzJCMTU1NDlCMTJDQyJ9.xAiVBofKKsgMcnR3qyqUPlODvcfm4TTEUNRB-wnegxw";    	
        String cookie = "JSESSIONID=D4859F525F00C0DF19C72B15549B12CC";
        setToken(tokenTmp);        
        
        String host = Constantes.HOST;        
        String desde = Constantes.DESDE_BUSQUEDA;
        String hacia = Constantes.HACIA_BUSQUEDA;
        String fecha = Constantes.FECHA_BUSQUEDA;
        
        String viajes = null;       

        try {        
        	
        	String tokenAux = getToken();
        	
        	if(tokenAux == null)
        		return obtenerViajesHARD();
        	
            HttpResponse<JsonNode> jsonResponse
                    = Unirest.get("http://api.voyenbus.com/TOLWeb/api/rest/v1.0/trips/{from}/{to}/{date}")
                    .header(HttpHeaders.AUTHORIZATION, tokenAux)
					.header(HttpHeaders.COOKIE, cookie)
					.header(HttpHeaders.HOST, host)
                    .routeParam("from", desde)
                    .routeParam("to", hacia)
                    .routeParam("date", fecha)
                    .asJson();
                       
            viajes = jsonResponse.getBody().toString();            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Constantes.ERROR_API_CONEXION);
        } 
    	
        return viajes;
    }    
	
    public String obtenerViajesHARD(){
        String viajesHARD = "{\"Trips\":{\"status\":\"OK\",\"message\":\"OK\",\"oneWay\":[{\"companyName\":\"Cata Internacional\",\"companyCode\":\"CAT\",\"logo\":\"CAT\",\"duration\":\"17:30\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T07:00:00.000-03:00\",\"arrive\":\"2019-08-11T00:30:00.000-03:00\",\"tripId\":\"B110\",\"tripKey\":\"1-SC-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Semi Cama\",\"free\":38,\"price\":\"1250.00\",\"categoryCode\":\"SC\",\"categoryLocale\":\"Semi Cama|Semi Bed|Semileito\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Cata Internacional\",\"companyCode\":\"CAT\",\"logo\":\"CAT\",\"duration\":\"17:30\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T07:00:00.000-03:00\",\"arrive\":\"2019-08-11T00:30:00.000-03:00\",\"tripId\":\"B110\",\"tripKey\":\"1-EX-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Cama\",\"free\":7,\"price\":\"2700.00\",\"categoryCode\":\"EX\",\"categoryLocale\":\"Cama|Bed service|Cama\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"El Rapido Int. S.R.L.\",\"companyCode\":\"ERI\",\"logo\":\"ERI\",\"duration\":\"18:40\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T14:00:00.000-03:00\",\"arrive\":\"2019-08-11T08:40:00.000-03:00\",\"tripId\":\"E005\",\"tripKey\":\"2-SC-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Semi Cama\",\"free\":26,\"price\":\"1250.00\",\"categoryCode\":\"SC\",\"categoryLocale\":\"Semi Cama|Semi Bed|Semileito\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"El Rapido Int. S.R.L.\",\"companyCode\":\"ERI\",\"logo\":\"ERI\",\"duration\":\"18:40\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T14:00:00.000-03:00\",\"arrive\":\"2019-08-11T08:40:00.000-03:00\",\"tripId\":\"E005\",\"tripKey\":\"2-SL-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Semicama Low Cost\",\"free\":18,\"price\":\"2300.00\",\"categoryCode\":\"SL\",\"categoryLocale\":\"Semicama Low Cost|Semibed Low Cost|Semileito Low Cost\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"El Rapido Int. S.R.L.\",\"companyCode\":\"ERI\",\"logo\":\"ERI\",\"duration\":\"18:40\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T14:00:00.000-03:00\",\"arrive\":\"2019-08-11T08:40:00.000-03:00\",\"tripId\":\"E005\",\"tripKey\":\"2-EX-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Cama\",\"free\":7,\"price\":\"2700.00\",\"categoryCode\":\"EX\",\"categoryLocale\":\"Cama|Bed service|Cama\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Chevallier\",\"companyCode\":\"CHE2\",\"logo\":\"CHE2\",\"duration\":\"17:00\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T16:00:00.000-03:00\",\"arrive\":\"2019-08-11T09:00:00.000-03:00\",\"tripId\":\"C029\",\"tripKey\":\"3-SC-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Semi Cama\",\"free\":21,\"price\":\"1250.00\",\"categoryCode\":\"SC\",\"categoryLocale\":\"Semi Cama|Semi Bed|Semileito\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Chevallier\",\"companyCode\":\"CHE2\",\"logo\":\"CHE2\",\"duration\":\"17:00\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T16:00:00.000-03:00\",\"arrive\":\"2019-08-11T09:00:00.000-03:00\",\"tripId\":\"C029\",\"tripKey\":\"3-BT-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Semicama sin Servicio\",\"free\":18,\"price\":\"2300.00\",\"categoryCode\":\"BT\",\"categoryLocale\":\"Semicama sin Servicio|Semicama sin Servicio|Semicama sin Servicio\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Chevallier\",\"companyCode\":\"CHE2\",\"logo\":\"CHE2\",\"duration\":\"17:00\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T16:00:00.000-03:00\",\"arrive\":\"2019-08-11T09:00:00.000-03:00\",\"tripId\":\"C029\",\"tripKey\":\"3-EX-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Cama\",\"free\":8,\"price\":\"2700.00\",\"categoryCode\":\"EX\",\"categoryLocale\":\"Cama|Bed service|Cama\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"San Juan Mar del Plata\",\"companyCode\":\"SJM\",\"logo\":\"SJMP\",\"duration\":\"15:40\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T16:30:00.000-03:00\",\"arrive\":\"2019-08-11T08:10:00.000-03:00\",\"tripId\":\"Q003\",\"tripKey\":\"4-EJ-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Cama Ejecutivo \",\"free\":27,\"price\":\"1800.00\",\"categoryCode\":\"EJ\",\"categoryLocale\":\"Cama Ejecutivo |Bed Executive |Executivo\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Cata Internacional\",\"companyCode\":\"CAT\",\"logo\":\"CAT\",\"duration\":\"14:35\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T17:45:00.000-03:00\",\"arrive\":\"2019-08-11T08:20:00.000-03:00\",\"tripId\":\"B032\",\"tripKey\":\"5-EJ-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Cama Ejecutivo \",\"free\":33,\"price\":\"1800.00\",\"categoryCode\":\"EJ\",\"categoryLocale\":\"Cama Ejecutivo |Bed Executive |Executivo\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Aut Andesmar S.A.\",\"companyCode\":\"AND\",\"logo\":\"AND\",\"duration\":\"15:00\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T18:00:00.000-03:00\",\"arrive\":\"2019-08-11T09:00:00.000-03:00\",\"tripId\":\"A026\",\"tripKey\":\"6-SJ-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Semi Cama C\\/Serv\",\"free\":19,\"price\":\"1400.00\",\"categoryCode\":\"SJ\",\"categoryLocale\":\"Semi Cama C\\/Serv|Semi BED W\\/serv|Semi Cama C\\/Serv\"},\"selectable\":true,\"ticketType\":1,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Aut Andesmar S.A.\",\"companyCode\":\"AND\",\"logo\":\"AND\",\"duration\":\"15:00\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T18:00:00.000-03:00\",\"arrive\":\"2019-08-11T09:00:00.000-03:00\",\"tripId\":\"A026\",\"tripKey\":\"6-LS-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Semicama Low Cost\",\"free\":19,\"price\":\"2530.00\",\"categoryCode\":\"LS\",\"categoryLocale\":\"Semicama Low Cost|Semibed Low Cost|Semileito Low Cost\"},\"selectable\":true,\"ticketType\":1,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Aut Andesmar S.A.\",\"companyCode\":\"AND\",\"logo\":\"AND\",\"duration\":\"15:00\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T18:00:00.000-03:00\",\"arrive\":\"2019-08-11T09:00:00.000-03:00\",\"tripId\":\"A026\",\"tripKey\":\"6-EJ-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Cama Ejecutivo \",\"free\":12,\"price\":\"2970.00\",\"categoryCode\":\"EJ\",\"categoryLocale\":\"Cama Ejecutivo |Bed Executive |Executivo\"},\"selectable\":true,\"ticketType\":1,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"FlechaBus\",\"companyCode\":\"FBU\",\"logo\":\"FBU\",\"duration\":\"14:40\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T20:30:00.000-03:00\",\"arrive\":\"2019-08-11T11:10:00.000-03:00\",\"tripId\":\"MRF1\",\"tripKey\":\"7-EJ-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Cama Ejecutivo \",\"free\":29,\"price\":\"1800.00\",\"categoryCode\":\"EJ\",\"categoryLocale\":\"Cama Ejecutivo |Bed Executive |Executivo\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Chevallier\",\"companyCode\":\"CHE2\",\"logo\":\"CHE2\",\"duration\":\"14:50\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T21:30:00.000-03:00\",\"arrive\":\"2019-08-11T12:20:00.000-03:00\",\"tripId\":\"C041\",\"tripKey\":\"8-SC-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Semi Cama\",\"free\":30,\"price\":\"1250.00\",\"categoryCode\":\"SC\",\"categoryLocale\":\"Semi Cama|Semi Bed|Semileito\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Chevallier\",\"companyCode\":\"CHE2\",\"logo\":\"CHE2\",\"duration\":\"14:50\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T21:30:00.000-03:00\",\"arrive\":\"2019-08-11T12:20:00.000-03:00\",\"tripId\":\"C041\",\"tripKey\":\"8-BT-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Semicama sin Servicio\",\"free\":12,\"price\":\"2300.00\",\"categoryCode\":\"BT\",\"categoryLocale\":\"Semicama sin Servicio|Semicama sin Servicio|Semicama sin Servicio\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false},{\"companyName\":\"Chevallier\",\"companyCode\":\"CHE2\",\"logo\":\"CHE2\",\"duration\":\"14:50\",\"currency\":\"ARS\",\"fromId\":710,\"fromName\":\"Terminal, Mendoza\",\"toId\":889,\"toName\":\"Terminal, Retiro\",\"departure\":\"2019-08-10T21:30:00.000-03:00\",\"arrive\":\"2019-08-11T12:20:00.000-03:00\",\"tripId\":\"C041\",\"tripKey\":\"8-EX-2-710-889\",\"fares\":{\"currency\":\"ARS\",\"category\":\"Cama\",\"free\":9,\"price\":\"2700.00\",\"categoryCode\":\"EX\",\"categoryLocale\":\"Cama|Bed service|Cama\"},\"selectable\":true,\"ticketType\":0,\"cuitRequired\":false,\"cuitRequiredFor\":\"ARG,ARG\",\"remarkablePromo\":false}]}}";
                
        return viajesHARD;
    }
    
    public void setToken(String token) {
    	//this.token = token;
    	this.token = Autho.obtenerToken();
   	}
    
    public String getToken() {
    	return this.token;
    }
}
