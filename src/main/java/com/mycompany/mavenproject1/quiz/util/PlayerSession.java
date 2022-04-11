/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.quiz.util;

/**
 *
 * @author tharindu
 */
public class PlayerSession {
    
    private static String playerName = null;
    private static Integer playerId = null;
    
    private PlayerSession(){        
    }
    
    public static void setSession(String name, Integer id) {
        playerName = name;
        playerId = id;
    }
    
    public static void clearSession() {
        playerName = null;
        playerId = null;
    }
    
    public static String getPlayerName() {
        return playerName;
    }
    
    public static Integer getPlayerId(){ 
        return playerId;
    }
    
}
