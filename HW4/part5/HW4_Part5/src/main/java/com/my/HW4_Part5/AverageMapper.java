package com.my.HW4_Part5;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AverageMapper extends Mapper<LongWritable,Text, Text, AverageWritable> {
	String year;
	float stpac;
	//int count;
	Text yy = new Text();
	AverageWritable aw = new AverageWritable();
	
	public void map(LongWritable key, Text value, Context context) {
		String line = value.toString();
		String[] tokens = line.split(",");
		//skip first line which is the header line
		if(tokens[0].equals("exchange"))
			return;
		else {
			String date = tokens[2];
			String[] sp=date.split("-");
			year = sp[0];
			stpac = Float.parseFloat(tokens[8]);
		
			
			yy.set(year);
			aw.setStpac(stpac);
			aw.setCount(1);
			
			try {
				context.write(yy, aw);
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
