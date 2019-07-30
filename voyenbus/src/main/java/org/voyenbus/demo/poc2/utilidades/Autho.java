package org.voyenbus.demo.poc2.utilidades;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.HttpHeaders;
import java.util.Base64;
import java.util.Date;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

class Autho {
    public static String obtenerToken() {
        String authorize = generarToken();
        
        JSONObject jsonObject = null;
        try {        

            HttpResponse<JsonNode> jsonResponse
                    = Unirest.get("http://api.voyenbus.com/TOLWeb/api/rest/v1.0/authorize")
                    .header(HttpHeaders.AUTHORIZATION , authorize)
                    .header("clientId", "demoVeb1")
                    .header(HttpHeaders.HOST, Constantes.HOST)                    
                    .asJson();

            //System.out.println("Body: " + jsonResponse.getBody().toString());            

            if (jsonResponse.getStatus() == 200) {                
                jsonObject = jsonResponse.getBody().getObject();
                return jsonObject.getString("access_token");

            } else {
            	//System.out.println(jsonResponse);                
            }                        

        } catch (UnirestException e) {
        	e.printStackTrace();
        }
        
        return null;
		
    }

    private static String generarToken() {
        String token = "";       

        long time = new Date().getTime();
        long iat = time / 1000;
        long exp = iat + (60 * 60);
        String iss = "demoVeb1";
        String aud = "test.api";
        String sub = "/TOLWeb/api/rest/v1.0/authorize";

        JSONObject jHeader = new JSONObject();
        jHeader.put("alg", "HS256");
      
        JSONObject jPayload = new JSONObject();
        jPayload.put("aud", aud);
        jPayload.put("exp", exp);
        jPayload.put("iat", iat);
        jPayload.put("iss", iss);
        jPayload.put("sub", sub);

        try {
            
            String encodedHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(jHeader.toString().getBytes(StandardCharsets.UTF_8));
            String encodedPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(jPayload.toString().getBytes(StandardCharsets.UTF_8));
            String unsignedToken = encodedHeader + "." + encodedPayload;

            String secretKey = "i7qMxBBifWQ2eZSFF5Uk2f2UpLBOsb/C+JHeFr/oH+1cWGzqZ3weqUqha4j2uhangudVWdBdMj7CKMxXQMpuBQ==";

            byte[] decodedBytes = Base64.getDecoder().decode(secretKey);
            String intermediateDecoded = new String(decodedBytes);

            String signature = firmaSHA256(unsignedToken, intermediateDecoded);            

            token = unsignedToken + "." + signature;                                      

        } catch (Exception e) {          
        	e.printStackTrace();
        }

        return token;
    }

    private static String firmaSHA256(String msj, String clave) {

        String hash = "";

        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec llave = new SecretKeySpec(clave.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256_HMAC.init(llave);

            hash = Base64.getEncoder().withoutPadding().encodeToString(sha256_HMAC.doFinal(msj.getBytes(StandardCharsets.UTF_8)));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hash;
    }

}
