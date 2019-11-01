package com.my.HW4_Part4;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class MyReducer extends Reducer<Text, MyWritable, Text, Text> {
	
	public Text dt = new Text();
	public Text tt = new Text();
	
	public void reduce(Text key, Iterable<MyWritable> values,
            Context context) throws IOException, InterruptedException {
		
		long max_volume = Integer.MIN_VALUE;
		long min_volume = Integer.MAX_VALUE;
		float max_stpac = 0;
		
		//iterate values
		for(MyWritable val:values) {
			
			if(val.getMax_stv()>max_volume) {
				max_volume = val.getMax_stv();
			}
			
			if(val.getMin_stv()<min_volume) {
				min_volume = val.getMin_stv();
			}
			
			if(val.getMax_stpac()>max_stpac) {
				max_stpac = val.getMax_stpac();
			}
			
			tt.set(String.valueOf(max_volume)+ ","+String.valueOf(min_volume)+","+ String.valueOf(max_stpac));
			
		}
		
		dt.set(key);
		context.write(dt, tt);	
		
	}

}
