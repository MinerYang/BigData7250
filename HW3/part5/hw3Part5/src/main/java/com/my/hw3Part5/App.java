package com.my.hw3Part5;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.SequenceFile.CompressionType;
import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
//import org.apache.hadoop.mapreduce.lib.input.CombineFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FixedLengthInputFormat;

import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
//import org.apache.hadoop.mapreduce.lib.input.NLineInputFormat;
////import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;


import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import com.my.hw3Part5.mapper.*;
import com.my.hw3Part5.reducer.*;



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		//conf.set("mapreduce.input.fileinputformat.split.maxsize", ONE_MB * 32);
    	try {
			Job job = Job.getInstance(conf, "Word Count Example");
			job.setJarByClass(App.class);
			
			//Set Mapper classes
			job.setMapperClass(KeyValueMapper.class);
//			job.setMapperClass(SqMapper.class);
			job.setMapperClass(FixedLenMapper.class);

			
			//Set reduce class
//			job.setReducerClass(0);
			
			/*Set InputFormat */
			
			/*use KeyValueTextInputFormat */
			job.setInputFormatClass(KeyValueTextInputFormat.class);
			
			/*use NLineInputFormat */
			//job.setInputFormatClass(NLineInputFormat.class);
//			job.getConfiguration().setInt(
//					"mapreduce.input.lineinputformat.linespermap", 3);
			
			/*use SequenceFileInputFormat */
//			job.setInputFormatClass(SequenceFileInputFormat.class);
			
			/*use TextInputFormat */
//			job.setInputFormatClass(TextInputFormat.class);
			
			/*use CombineSequenceFileInputFormat */
//			job.setInputFormatClass(CombineTextInputFormat.class);
			
			/*use FixedLengthInputFormat */
//			job.setInputFormatClass(FixedLengthInputFormat.class);
			
			
			
			
			
			
			//set OutputFormat class 
			job.setOutputFormatClass(TextOutputFormat.class);
//			job.setOutputFormatClass(SequenceFileOutputFormat.class);
//			//从下面的模式中选择一种，并将其余的注释掉
//			// 组合方式1：不压缩模式
//			SequenceFileOutputFormat.setOutputCompressionType(job,CompressionType.NONE);
			
			//Set the output key and value types
//			job.setOutputKeyClass(LongWritable.class);
//			job.setOutputValueClass(Text.class);
			
			
			//Set the input and output paths
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
			//Set the number of reducers
			job.setNumReduceTasks(0);
			
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
