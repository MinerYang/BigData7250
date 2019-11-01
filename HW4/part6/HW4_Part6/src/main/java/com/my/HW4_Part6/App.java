package com.my.HW4_Part6;



import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileAsTextInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;



//import org.apache.hadoop.mapreduce.lib.chain.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
    	
    	/*first mapReduce job*/
    	Configuration cnf1 = new Configuration();
    	Job j1 = Job.getInstance(cnf1, "ChainJob1");
    	j1.setJarByClass(App.class);
    	
        j1.setMapperClass(FirstMapper.class);
        j1.setReducerClass(FirstReducer.class);

        j1.setMapOutputKeyClass(Text.class);
        j1.setMapOutputValueClass(IntWritable.class);
        
        //SequenceFileOutputFormat
        j1.setOutputFormatClass(SequenceFileOutputFormat.class);
 
        
        
        j1.setOutputKeyClass(Text.class);
        j1.setOutputValueClass(IntWritable.class);
        
        Path outputPath=new Path("FirstMapper");
        FileInputFormat.addInputPath(j1,new Path(args[0]));
        FileOutputFormat.setOutputPath(j1,outputPath);
        
        FileSystem fs = FileSystem.get(cnf1);
		fs.delete(outputPath, true);
        
        j1.waitForCompletion(true);
        
        /*second mapReduce job*/
    	Configuration cnf2 = new Configuration();
    	Job j2 = Job.getInstance(cnf2, "ChainJob2");
    	j2.setJarByClass(App.class);
    	
        j2.setMapperClass(SecondMapper.class);
        j2.setSortComparatorClass(IntComparator.class);
        j2.setReducerClass(SecondReducer.class);

        j2.setMapOutputKeyClass(IntWritable.class);
        j2.setMapOutputValueClass(Text.class);
        
        
        j2.setOutputKeyClass(IntWritable.class);
        j2.setOutputValueClass(Text.class);
        
        //
        j2.setInputFormatClass(SequenceFileAsTextInputFormat.class);
        
        Path outputPath2=new Path(args[1]);
        FileInputFormat.addInputPath(j2,outputPath);
        FileOutputFormat.setOutputPath(j2,outputPath2);
        
        FileSystem fs2 = FileSystem.get(cnf2);
		fs2.delete(new Path(args[1]), true);
        
        j2.waitForCompletion(true);
    	
    	
			
    }
}
