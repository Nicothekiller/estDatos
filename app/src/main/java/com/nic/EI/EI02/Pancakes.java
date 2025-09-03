package com.nic.EI.EI02;

import com.nic.TDA.LinkedStack;

/**
 * La clase Pancakes simula un stack de la clase pancake.
 */
public class Pancakes {
  private final LinkedStack<Pancake> stack;

  public Pancakes() {
    this.stack = new LinkedStack<>();
  }

  /**
   * Simula comer un pancake.
   */
  public void comer() {
    System.out.println(this.stack.pop());
  }

  /**
   * Añade un pancake al stack.
   *
   * @param pancake - El pancake a añadir al stack.
   */
  public void push(final Pancake pancake) {
    this.stack.push(pancake);
  }

  /**
   * @return El tamaño del stack de pancakes.
   */
  public int size() {
    return this.stack.size();
  }
}
