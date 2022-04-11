/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.quiz.model;

/**
 *
 * @author tharindu
 */
public class Question {
    
    private int num1;
    private int num2;
    private float answer;
    private char operator;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }
    
    public void setOperator(char operator) {
        this.operator = operator;
    }
    
    public void setQuestion(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        setAnswer();
    }

    private void setAnswer() {
        switch (operator) {
            case '+' : answer = num1 + num2; break;
            case '-' : answer = num1 - num2; break;
            case '*' : answer = num1 * num2; break;
            case '/' : answer = (float) (Math.round((num1 / (float)num2) * 100.0)/100.0); break;
            default  : answer = 0.00f;
        }
    }
    
    public boolean checkAnswer(String result) {
        System.out.println(answer + " " + Math.round(Float.parseFloat(result) * 100.0) / 100.0);
        return answer == (float) (Math.round(Float.parseFloat(result) * 100.0) / 100.0);
    }
   
}
