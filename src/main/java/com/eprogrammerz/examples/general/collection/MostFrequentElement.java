/**
 * 
 */
package com.eprogrammerz.examples.general.collection;

import java.util.TreeMap;

/**
 * @author Yogen
 *
 */
public class MostFrequentElement {

	public static void main(String[] args) {
		String[] elems = {"a", "b", "c", "b", "d", "a", "b"};
		
		TreeMap<String, Integer> elemFreq = new TreeMap<>();
		
		for(String e: elems) {
			if(elemFreq.containsKey(e)) {
				elemFreq.put(e, elemFreq.get(e) + 1);
			} else {
				elemFreq.put(e, 1);
			}
		}
		
		System.out.println(elemFreq);
	}
}
