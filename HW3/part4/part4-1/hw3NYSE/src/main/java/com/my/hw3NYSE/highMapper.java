package com.my.hw3NYSE;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
//import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class highMapper extends Mapper<LongWritable,Text,Text,FloatWritable>{
	Text stock_symbol = new Text();
	FloatWritable price_high = new FloatWritable();
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		 String line = value.toString();
  		 String[] tokens = line.split(",");
		 try {
	            if (tokens[0].equals("exchange")) /*Some condition satisfying it is header*/
	                return;
	            else {
	                // For rest of data it goes here
		       		 stock_symbol.set(tokens[1]);
		       	     price_high.set(Float.valueOf(tokens[4]) );
		       		 context.write(stock_symbol, price_high);	
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
	 }

}
