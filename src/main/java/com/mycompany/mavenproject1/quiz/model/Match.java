/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.quiz.model;

import java.time.LocalDateTime;

/**
 *
 * @author tharindu
 */
public class Match {
    
    private Integer id;
    private LocalDateTime endDateTime;
    private Integer score;
    private Integer playerId;

    public Match() {
    }

    public Match(Integer id, LocalDateTime endDateTime, Integer score, Integer playerId) {
        this.id = id;
        this.endDateTime = endDateTime;
        this.score = score;
        this.playerId = playerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    @Override
    public String toString() {
        return "Match{" + "id=" + id + ", endDateTime=" + endDateTime + ", score=" + score + ", playerId=" + playerId + '}';
    }
    
    
    
}
