package com.my.HW4_Part6;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class FirstMapper extends Mapper<LongWritable,Text, Text, IntWritable> {
	
	Text ip = new Text();
	IntWritable one = new IntWritable(1);
	
	public void map(LongWritable key, Text value, Context context) {
		String line = value.toString();
		String[] tokens = line.split(" ");
		ip.set(tokens[0]);
		try {
			context.write(ip, one);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
