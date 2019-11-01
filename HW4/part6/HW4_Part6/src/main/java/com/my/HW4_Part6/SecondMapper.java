package com.my.HW4_Part6;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class SecondMapper extends Mapper<Text,Text,IntWritable,Text>  {
	IntWritable count = new IntWritable();


	public void map(Text key, Text value, Context context) throws IOException, InterruptedException {
		//swap key and value
		int tmp = Integer.parseInt(value.toString());
		count.set(tmp);

		context.write(count, key);
	}

}

/* LongWritable,Text,Text,IntWritable ---->TextInputFormat ---> extends FileInputFormat<LongWritable,Text>
 * 
 * Text,Text,Text,IntWritable   ---->KeyValueTextInputFormat ---> extends FileInputFormat<Text,Text>
 * 
 * Text,IntWritable,Text,IntWritable ---->
 *
 * Text,Text,IntWritable,Text    ---> SequenceFileAsTextInputFormat ----> extends SequenceFileInputFormat<Text,Text>
 * 
 * 
 * */
