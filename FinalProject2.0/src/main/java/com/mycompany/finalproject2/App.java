/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.finalproject2;

import com.my.mappers.*;
import com.my.reducers.*;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 *
 * @author mineryang
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Configuration cnf = new Configuration();
    	Job job;
    	try {
			job = Job.getInstance(cnf, "FINAL PROJECT");
			job.setJarByClass(App.class);
			
			job.setMapOutputKeyClass(CompositeKeyWritable.class);
			job.setMapOutputValueClass(IntWritable.class);
			
			//
			job.setInputFormatClass(TextInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
			job.setMapperClass(SumGoalMapper.class);
			//job.setReducerClass(StockMaxReducer.class);
			job.setReducerClass(SumGoalReducer.class);
			
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job,  new Path(args[1]));
			
			FileSystem fs = FileSystem.get(cnf);
			fs.delete(new Path(args[1]), true);
			
			try {
				job.waitForCompletion(true);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
