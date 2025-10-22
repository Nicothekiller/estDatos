package com.nic.mycode;

import com.nic.TDA.DoublyLinkedList;
import com.nic.TDA.TreeMap;

/** Class for testing */
public class Test {
  public static void main(String[] args) {
    var tree = new TreeMap<Integer, String>();
    tree.put(1, "A");
    tree.put(2, "B");
    tree.put(3, "C");
    tree.put(4, "D");
    tree.put(5, "E");

    System.out.println("--- Before ---");
    tree.dump();
  }
}
