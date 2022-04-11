/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.quiz.dao;

import com.mycompany.mavenproject1.quiz.model.Match;
import com.mycompany.mavenproject1.quiz.model.Player;
import com.mycompany.mavenproject1.quiz.util.PasswordEncoder;
import com.mycompany.mavenproject1.quiz.util.PlayerSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tharindu
 */
public class MatchDAO {
    
    private final Connection connection; 
    
    public MatchDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean saveMatchStatus(Match match){
        String sql = "INSERT INTO matches (end_date_time, score, player_id) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(match.getEndDateTime()));
            preparedStatement.setInt(2, match.getScore());
            preparedStatement.setInt(3, match.getPlayerId());
            
            return preparedStatement.executeUpdate() == 1;
                    
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    
}
