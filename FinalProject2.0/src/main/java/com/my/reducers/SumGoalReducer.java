/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.reducers;

import com.mycompany.finalproject2.CompositeKeyWritable;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author mineryang
 */
public class SumGoalReducer extends Reducer<CompositeKeyWritable, IntWritable, Text, IntWritable>{
    IntWritable result = new IntWritable();
    Text text = new Text();
    
    public void reduce(CompositeKeyWritable key, Iterable<IntWritable> values,
            Context context) throws IOException, InterruptedException {
        int sum = 0;
        for(IntWritable val : values){
            sum += val.get();
        }
        
        String k = "team_id:"+ key.getTeam_id()+ " "+ "year:"+ key.getYear();
        text.set(k);
        result.set(sum);
        context.write(text, result);
    }
    
}
