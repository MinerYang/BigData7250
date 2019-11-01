package com.my.HW4_Part6;

import java.nio.ByteBuffer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparator;

public class IntComparator extends WritableComparator  {

	public IntComparator( ) {
		super(IntWritable.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
		// TODO Auto-generated method stub
		Integer v1 = ByteBuffer.wrap(b1, s1, l1).getInt();
	    Integer v2 = ByteBuffer.wrap(b2, s2, l2).getInt();
	    //descending order
		return v2.compareTo(v1);
	}

}
