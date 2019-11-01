package com.my.HW4_Part5;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class AverageWritable implements Writable {
	
	float stpac;
	int count;
	
	public AverageWritable() {
		super();
	}

	public AverageWritable(float stpac, int count) {
		super();
		this.stpac = stpac;
		this.count = count;
	}

	public float getStpac() {
		return stpac;
	}

	public void setStpac(float stpac) {
		this.stpac = stpac;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		stpac = in.readFloat();
		count = in.readInt();
		
	}

	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeFloat(stpac);
		out.writeInt(count);
		
	}

	@Override
	public String toString() {
		return "AverageWritable [stpac=" + stpac + ", count=" + count + "]";
	}
	
	

}
