/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.quiz.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tharindu
 */
public class ScoreTableModel extends AbstractTableModel {
    
    private String[] headers = {"Name", "Score"};
    private List<Player> playerList;
    
    public ScoreTableModel(List<Player> playerList) {
        this.playerList = playerList;
    }
    
    @Override
    public int getRowCount() {
        return playerList.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        Player playerScore = playerList.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return playerScore.getName();
                
            case 1:
                return playerScore.getCurrentScore().toString();

            default:
                return null;
        }
    }
    
    public String getColumnName(int col) {
        return headers[col];
    }
    
}
