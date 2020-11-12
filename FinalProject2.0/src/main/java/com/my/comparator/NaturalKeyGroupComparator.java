/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.comparator;

import com.mycompany.finalproject2.CompositeKeyWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 *
 * @author mineryang
 */
public class NaturalKeyGroupComparator extends WritableComparator  {
    public NaturalKeyGroupComparator() {
		super(CompositeKeyWritable.class, true);
		// TODO Auto-generated constructor stub
	}
    
    public int compare(WritableComparable a, WritableComparable b) {
		//-1 0 1
		CompositeKeyWritable ck1 = (CompositeKeyWritable)a;
		CompositeKeyWritable ck2 = (CompositeKeyWritable)b;
		//descending order
		int res = ck1.getTeam_id().compareTo(ck2.getTeam_id());
		return res;
	}
    
}
