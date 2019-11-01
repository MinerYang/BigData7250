package com.my.HW4_Part5;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class AverageReducer extends Reducer<Text, AverageWritable, Text, AverageWritable> {
	//public Text dt = new Text();
	public AverageWritable aw = new AverageWritable();
	
	public void reduce(Text key, Iterable<AverageWritable> values,
            Context context) throws IOException, InterruptedException {
		float sum = 0;
		int count = 0;
		
		//iterate
		for(AverageWritable val :values) {
			sum += val.getCount() * val.getStpac();
			count += val.getCount();
		}
		
		aw.setCount(count);
		aw.setStpac(sum/count);
		context.write(key, aw);
		
	}

}
