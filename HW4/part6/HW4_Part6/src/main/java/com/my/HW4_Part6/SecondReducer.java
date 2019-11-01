package com.my.HW4_Part6;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SecondReducer extends Reducer<IntWritable,Text,IntWritable,Text> {
	
	static int count;
	
	@Override
	protected void setup(Reducer<IntWritable, Text, IntWritable,Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		count = 0;
	}
    
	public void reduce(IntWritable key, Iterable<Text> values,
            Context context) throws IOException, InterruptedException {
		if(count<10) {
			for(Text val:values) {
				context.write(key, val);
			}	
			count++;
		}
		else
			return;
	}

}
