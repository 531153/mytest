package com.lxy.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Collection {
	public static void main(String[] args) {
		List list  = new ArrayList();
		List list1 = new Vector();
		List list2 = new LinkedList();
		Map<String,String>  map   = new HashMap();
		Set  set   = new HashSet();
		map.put("aa","xx");
		Integer[] integers = new Integer[] {1,2,3,5};
		for (Map.Entry<String,String> entry:map.entrySet()){
			System.out.println(entry.getValue());
		}
	}
}
