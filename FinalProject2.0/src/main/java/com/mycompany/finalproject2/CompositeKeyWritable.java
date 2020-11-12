/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.finalproject2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.WritableComparable;

/**
 *
 * @author mineryang
 */
public class CompositeKeyWritable  implements WritableComparable {
    String team_id;
    String year;

    public CompositeKeyWritable() {
    }

    public CompositeKeyWritable(String team_id, String year) {
        this.team_id = team_id;
        this.year = year;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    
    @Override
    public void write(DataOutput out) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
        out.writeUTF(team_id);
        out.writeUTF(year);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
        team_id = in.readUTF();
        year = in.readUTF();
    }

    @Override
    public int compareTo(Object o) {
         //To change body of generated methods, choose Tools | Templates.
         CompositeKeyWritable ck = (CompositeKeyWritable)o;
	 String thisValue = this.getTeam_id();
	 String  otherValue = ck.getTeam_id();
	 int result =  thisValue.compareTo(otherValue);
		return (result <0 ? -1 : (result==0 ? 0 : 1));
    }
    
}
