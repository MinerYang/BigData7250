package com.my.HW4_Part4;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class MyWritable implements Writable {
	long max_stv;
	long min_stv;
	float max_stpac;
	
	public MyWritable() {
		
	}
	
	public MyWritable(long max_stv, long min_stv, float max_stpac) {
		super();
		this.max_stv = max_stv;
		this.min_stv = min_stv;
		this.max_stpac = max_stpac;
	}
	
	public long getMax_stv() {
		return max_stv;
	}
	public void setMax_stv(long max_stv) {
		this.max_stv = max_stv;
	}
	public long getMin_stv() {
		return min_stv;
	}
	public void setMin_stv(long min_stv) {
		this.min_stv = min_stv;
	}
	public float getMax_stpac() {
		return max_stpac;
	}
	public void setMax_stpac(float max_stpac) {
		this.max_stpac = max_stpac;
	}
	
	
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		max_stv = in.readLong();
		min_stv = in.readLong();
		max_stpac = in.readFloat();
		
	}
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeLong(max_stv);
		out.writeLong(min_stv);
		out.writeFloat(max_stpac);
		
	}
	
	@Override
	public String toString() {
		return "MyWritable [max_stv=" + max_stv + ", min_stv=" + min_stv + ", max_stpac=" + max_stpac + "]";
	}
	
	
	
	

}
