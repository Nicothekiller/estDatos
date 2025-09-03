package com.nic.EI.EI02;

import com.nic.TDA.LinkedQueue;

/**
 * La clase shots simula al estudiante promedio el fin de semana. La clase
 * almacena un Queue de shots de alcohol. Nuevos shots se añaden al Queue hasta
 * llegar al ultimo. Solo se puede tomar el shot mas antiguo en el Queue.
 */
public class Shots {
  /**
   * El Queue de shots pendientes. Cada "shot" es un string con el nombre del
   * alcohol (ej: vodka, whisky, etc.).
   */
  private final LinkedQueue<String> shots;

  public Shots() {
    this.shots = new LinkedQueue<>();
  }

  /**
   * La función simula tomar un shot. Por favor usar la función con mesura
   * para evitar tomar cantidades excesivas.
   */
  public void tomar() {
    System.out.println("Tomaste: " + this.shots.dequeue());
  }

  /**
   * La función añade un shot al Queue.
   *
   * @param element - Elemento a añadir al Queue.
   */
  public void enqueue(final String element) {
    this.shots.enqueue(element);
  }

  /**
   * @return El tamaño del Queue de shots.
   */
  public int size() {
    return this.shots.size();
  }
}
