/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.quiz.dao;

import com.mycompany.mavenproject1.quiz.model.Player;
import com.mycompany.mavenproject1.quiz.util.PasswordEncoder;
import com.mycompany.mavenproject1.quiz.util.PlayerSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tharindu
 */
public class PlayerDAO {
    
    private final Connection connection; 
    
    public PlayerDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean existsUserByNameOrEmail(String name, String email) {
        String sql = "SELECT COUNT(id) FROM players WHERE name =? or email =?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return resultSet.getInt("count") == 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean createPlayer(Player player){
        String sql = "INSERT INTO players (name, email, password) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, player.getName());
            preparedStatement.setString(2, player.getEmail());
            preparedStatement.setString(3, PasswordEncoder.encodePassword(player.getPassword()));
            
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
    
    public Optional<Player> getPlayerByNameAndPassword(String name, String password){
        String sql = "SELECT id, name FROM players WHERE name =? AND password =? LIMIT 1";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Optional<Player> optionalPlayer = Optional.empty();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, PasswordEncoder.encodePassword(password));

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Player player = new Player(resultSet.getInt("id"), resultSet.getString("name"), "", "", 0);
                PlayerSession.setSession(player.getName(), player.getId());
                
                optionalPlayer = Optional.of(player);   
            } 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
             try {
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
             
        }
        return optionalPlayer;
    }
    
    public List<Player> getTopMatchPlayerResults(){
        String sql = "SELECT p.id, p.name, sum(m.score) AS total FROM players p INNER JOIN matches m ON p.id = m.player_id " +
                        "GROUP BY p.id ORDER BY sum(m.score) DESC LIMIT 3;";
        Statement statement = null;
        ResultSet resultSet = null;
        List<Player> topPlayers = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            
            boolean isCurrentUserInTopPlayers = false;
            
            while(resultSet.next()){
                Player player = new Player(resultSet.getInt("id"), resultSet.getString("name"), "", "", resultSet.getInt("total"));
                topPlayers.add(player);
                
                if(PlayerSession.getPlayerId() == player.getId()) isCurrentUserInTopPlayers = true;
            }
            
            if(!isCurrentUserInTopPlayers) {
                Player currentPlayer = new Player(PlayerSession.getPlayerId(), PlayerSession.getPlayerName()
                        , "", "", getPlayerScoreById(PlayerSession.getPlayerId()).get());
                topPlayers.add(currentPlayer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
             try {
                if(statement != null) statement.close();
                if(resultSet != null) resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
             
        }
        return topPlayers;
    }
    
    public Optional<Integer> getPlayerScoreById(int id){
        String sql = "SELECT SUM(score) AS total FROM matches WHERE player_id =?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Optional<Integer> optionalsScore = Optional.empty();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                optionalsScore =  Optional.of(resultSet.getInt("total"));  
            } 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
             try {
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
             
        }
        return optionalsScore;
    }
    
    
}
