package com.nic.CP.CP08;

import com.nic.TDA.ChainHashMap;
import com.nic.TDA.DoubleHashMap;
import com.nic.TDA.ProbeHashMap;
import java.util.ArrayList;

public class Hashing {
  public static void main(String[] args) {
    int[] nums = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16, 5};
    var chaining = new ChainHashMap<Integer, Integer>();
    var probing = new ProbeHashMap<Integer, Integer>();
    var doublemap = new DoubleHashMap<Integer, Integer>();

    // array de tamaño fijo, solo se usa arraylist para el metodo toString
    var chainingarr = new ArrayList<Integer>(nums.length);
    var probingarr = new ArrayList<Integer>(nums.length);
    var doublearr = new ArrayList<Integer>(nums.length);
    for (int i : nums) {
      chaining.put(i, i);
      chainingarr.add(chaining.hashValue(i));

      probing.put(i, i);
      probingarr.add(probing.hashValue(i));

      doublemap.put(i, i);
      doublearr.add(doublemap.hashValue(i));
    }

    System.out.println("Hashes: " + chainingarr);
    System.out.println("Chaining: " + chaining.entrySet());
    System.out.println("\nHashes: " + probingarr);
    System.out.println("Probing: " + probing.entrySet());
    System.out.println("\nHashes: " + doublearr);
    System.out.println("Double: " + doublemap.entrySet());
  }
}
