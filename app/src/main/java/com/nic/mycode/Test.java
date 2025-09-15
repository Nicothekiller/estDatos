package com.nic.mycode;

import com.nic.TDA.DoublyLinkedList;

/** Class for testing */
public class Test {
  public static void main(String[] args) {
    var list = new DoublyLinkedList<Integer>();
    for (int i = 0; i < 10; i++) {
      list.addLast(i);
    }
    System.out.println(list.search(5).getElement());
    var num = list.remove(list.search(5));
    list.addBetween(num, list.search(7), list.search(8));
    while (!list.isEmpty()) {
      System.out.print(list.removeFirst() + " ");
    }
  }
}
