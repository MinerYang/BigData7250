/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.finalproject2;



/**
 *
 * @author mineryang
 */
public class MyWritable  {
    String team_id;
    int year;
    float goals;

    public MyWritable() {
        
    }
//    // for construct composite key
//    public MyWritable(String team_id, int year) {
//        this.team_id = team_id;
//        this.year = year;
//    }
    
    

    public MyWritable(String team_id, int year, float goals) {
        this.team_id = team_id;
        this.year = year;
        this.goals = goals;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getGoals() {
        return goals;
    }

    public void setGoals(float goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return "MyWritable{" + "team_id=" + team_id + ", year=" + year + ", goals=" + goals + '}';
    }

    
    
}
