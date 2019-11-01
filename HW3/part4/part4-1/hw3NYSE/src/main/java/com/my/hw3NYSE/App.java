package com.my.hw3NYSE;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
    	try {
			Job job = Job.getInstance(conf, "Highest Stock Price");
			job.setJarByClass(App.class);
			
			//Set Mappers and Reducer classes
			job.setMapperClass(highMapper.class);
			job.setReducerClass(highReducer.class);
			
			//Set InputFormat and OutputFormat class
			job.setInputFormatClass(TextInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);
			
			//Set the output key and value types
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(FloatWritable.class);
			
			//Set the input and output paths
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
			//Set the number of reducers
			job.setNumReduceTasks(2);
			
			try {
				System.exit(job.waitForCompletion(true) ? 0 : 1);
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
    	
        System.out.println( "Hello World!" );

	}

}
