/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.quiz.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

/**
 *
 * @author tharindu
 */
public class APIUtil {
    
    private static String URL_DOMAIN = "https://csrng.net/csrng/csrng.php";
    
    public static Integer getRandomValue(int min, int max){
        try {
            URL url = new URL(URL_DOMAIN+ "?min="+ min + "&max=" + max);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("accept","application/json");
            InputStream responseStream = connection.getInputStream();
            
            ObjectMapper mapper = new ObjectMapper();
            APIResponse[] responses = mapper.readValue(responseStream, APIResponse[].class);
            
            return responses[0].getRandom();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Random().nextInt(max);
        }
        
        
        
    }
    
    public static void main(String[] args) {
        getRandomValue(10, 200);
    }
    
}
