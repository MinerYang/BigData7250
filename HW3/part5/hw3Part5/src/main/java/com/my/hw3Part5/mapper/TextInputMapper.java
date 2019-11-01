package com.my.hw3Part5.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TextInputMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	Text ip = new Text();
	//IntWritable one = new IntWritable(1);
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		 String line = value.toString();
		 String[] tokens = line.split(" ");
		 ip.set(tokens[0]);
		 context.write(ip,  new IntWritable(Integer.valueOf(value.toString())));	
	 }

}
