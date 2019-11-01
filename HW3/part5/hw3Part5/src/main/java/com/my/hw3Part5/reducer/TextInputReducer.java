package com.my.hw3Part5.reducer;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TextInputReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
	int sum=0;
	@Override
	protected void reduce(Text key, Iterable<IntWritable> value,
			Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		for(IntWritable val: value) {
			sum+=val.get();
		}
		IntWritable count = new IntWritable(sum);
		context.write(key, count);
	}


}
