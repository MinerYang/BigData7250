/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.mappers;

import com.mycompany.finalproject2.CompositeKeyWritable;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author mineryang
 */
public class SumGoalMapper extends Mapper<LongWritable,Text, CompositeKeyWritable, IntWritable> {
    String year;
    String team_id;
    int goals;
    
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
	String[] tokens = line.split(",");
        
        //skip first line which is the header line
	if(tokens[0].equals("game_id"))
            return;
        else{
            String game_id  = tokens[0];// get game_id
            year = game_id.substring(0,4);
            team_id = tokens[2];
            // goals here represent performance, summarizing goals, hits and shots number
            goals = Integer.valueOf(tokens[5]) + Integer.valueOf(tokens[6]) + Integer.valueOf(tokens[7]);
            
            //set composite key
            CompositeKeyWritable comkey = new CompositeKeyWritable(team_id, year);
            IntWritable gl = new IntWritable (goals);
            
            context.write(comkey, gl);
        }
    }
}
