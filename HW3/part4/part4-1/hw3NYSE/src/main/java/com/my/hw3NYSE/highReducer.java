package com.my.hw3NYSE;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class highReducer extends Reducer<Text,FloatWritable,Text,FloatWritable>{
	@Override
	protected void reduce(Text key, Iterable<FloatWritable> value,
			Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		float max=0;
		for(FloatWritable val: value) {
			//sum+=val.get();
			if(val.get()>max)
				max=val.get();
		}
		FloatWritable highest = new FloatWritable(max);
		context.write(key,highest);
	}

}
