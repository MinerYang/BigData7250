package com.my.HW4_Part5;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cnf = new Configuration();
    	Job job;
    	try {
			job = Job.getInstance(cnf, "HW4_PART5");
            job.setJarByClass(App.class);
			
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(AverageWritable.class);
			
			//
			job.setInputFormatClass(TextInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);
			
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(AverageWritable.class);
			
			//use combiner
			job.setMapperClass(AverageMapper.class);
			//job.setCombinerClass(AverageReducer.class);
			job.setReducerClass(AverageReducer.class);
			
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
