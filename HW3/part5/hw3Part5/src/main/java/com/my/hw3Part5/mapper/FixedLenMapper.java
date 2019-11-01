package com.my.hw3Part5.mapper;

import java.io.IOException;

//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.MapContext;
import org.apache.hadoop.mapreduce.Mapper;

public class FixedLenMapper extends Mapper<LongWritable,Text,Text,Text>{
//	Text ip = new Text();
	//IntWritable one = new IntWritable(1);
	
	public void map(Long key, Text value, MapContext<LongWritable, Text, Text, Text> context) throws IOException, InterruptedException{
//		 String line = value.toString();
//		 String[] tokens = line.split(" ");
//		 ip.set(tokens[0]);
		 context.write(new Text(String.valueOf(key)), value);	
	 }

}
