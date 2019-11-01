package com.my.HW4_Part4;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class MyCombiner extends Reducer<Text, MyWritable, Text, MyWritable> {
	
	//public Text dt = new Text();
	public MyWritable mw ;
	
	public void reduce(Text key, Iterable<MyWritable> values,
            Context context) throws IOException, InterruptedException {
		
		
		//iterate values
		for(MyWritable val:values) {
			 mw = val;
		}
		
		//dt.set(key);
		context.write(key, mw);	
	}

}
