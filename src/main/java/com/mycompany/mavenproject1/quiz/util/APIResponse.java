/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.quiz.util;

/**
 *
 * @author tharindu
 */
public class APIResponse {
    
    private String status;
    private Integer min;
    private Integer max;
    private Integer random;
    
    public APIResponse(){
        
    }
    
    public APIResponse(String status, Integer min, Integer max, Integer random){
        this.status = status;
        this.min = min;
        this.max = max;
        this.random = random;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getRandom() {
        return random;
    }

    public void setRandom(Integer random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "APIResponse{" + "status=" + status + ", min=" + min + ", max=" + max + ", random=" + random + '}';
    }
    
}
