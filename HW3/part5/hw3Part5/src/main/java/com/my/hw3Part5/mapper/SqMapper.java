package com.my.hw3Part5.mapper;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
//import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class SqMapper extends Mapper<LongWritable, Text, LongWritable, Text>{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		 context.write(key, value);	
	 }
}