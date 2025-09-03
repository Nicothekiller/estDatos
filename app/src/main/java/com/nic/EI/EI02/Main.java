package com.nic.EI.EI02;

public class Main {
  public static void main(final String[] args) {
    // Parte 1
    System.out.println("-- Parte 1 --");
    final Pancake[] stack = {
        new Pancake(1000, "chocolate"),
        new Pancake(100, "chocolate"),
        new Pancake(2000, "Jarabe alto en fructosa"),
        new Pancake(1000, "Miel de maple") };

    final Pancakes pancakeStack = new Pancakes();
    for (final var i : stack) {
      pancakeStack.push(i);
    }

    // El orden en que se añade los elementos si importa a la hora quitarlos
    pancakeStack.comer();
    pancakeStack.push(new Pancake(300, "Azucar"));

    while (pancakeStack.size() > 0) {
      pancakeStack.comer();
    }

    // parte 2
    System.out.println("\n-- Parte 2 --");
    final String[] alcoholes = { "Vodka", "Whisky", "Vodka", "cerveza" };
    final Shots shotQueue = new Shots();

    for (final String i : alcoholes) {
      shotQueue.enqueue(i);
    }

    // De manera opuesta a la primera parte, el orden en que se añade los elementos
    // no importa a la hora quitarlos
    shotQueue.tomar();
    shotQueue.enqueue("Gin");
    shotQueue.enqueue("Mas vodka");

    while (shotQueue.size() > 0) {
      shotQueue.tomar();
    }
  }
}
