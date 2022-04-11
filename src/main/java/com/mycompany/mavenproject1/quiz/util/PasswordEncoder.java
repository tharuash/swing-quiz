/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.quiz.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author tharindu
 */
public class PasswordEncoder {
    
    public static String encodePassword(String password) {
        
        String encryptedpassword = null;  
        try {  
            MessageDigest m = MessageDigest.getInstance("MD5");  
            m.update(password.getBytes());  
            byte[] bytes = m.digest();  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
            encryptedpassword = s.toString();  
        }   
        catch (NoSuchAlgorithmException ex)   
        {  
            ex.printStackTrace();  
        }
        
        return encryptedpassword;
        
    } 
    
}
