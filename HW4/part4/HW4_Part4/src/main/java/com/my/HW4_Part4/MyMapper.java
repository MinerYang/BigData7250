package com.my.HW4_Part4;


import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text, Text, MyWritable> {
	String date;
	long volume;
	float stpac;
	Text Dt = new Text();
	MyWritable mw = new MyWritable();
	
	public void map(LongWritable key, Text value, Context context) {
		String line = value.toString();
		String[] tokens = line.split(",");
		
		//skip first line which is the header line
		if(tokens[0].equals("exchange"))
			return;
		else {
			date = tokens[2];
			volume = Long.parseLong(tokens[7]);
			stpac = Float.parseFloat(tokens[8]);
			
			Dt.set(date);
			mw.setMax_stv(volume);
			mw.setMin_stv(volume);
			mw.setMax_stpac(stpac);
			
			try {
				context.write(Dt, mw);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
		
		
	}

}
