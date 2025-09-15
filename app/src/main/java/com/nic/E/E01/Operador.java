package com.nic.E.E01;

import com.nic.TDA.LinkedQueue;

public class Operador {
  private String nombre;
  private int codigo;

  public Operador(String nombre, int codigo) {
    this.nombre = nombre;
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public int getCodigo() {
    return codigo;
  }

  public int atenderLlamada(LinkedQueue<Cliente> llamadas) {
    int counter = 0;
    while (!llamadas.isEmpty()) {
      // atender llamada
      llamadas.dequeue();
      counter += 1;
    }
    return counter;
  }
}
