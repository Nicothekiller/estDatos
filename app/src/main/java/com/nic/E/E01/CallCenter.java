package com.nic.E.E01;

import com.nic.TDA.DoublyLinkedList;
import com.nic.TDA.LinkedQueue;
import com.nic.TDA.SortedPriorityQueue;

public class CallCenter {
  private LinkedQueue<Cliente> llamadas;
  private DoublyLinkedList<Operador> operadores;
  private DoublyLinkedList<String> llamadasCompletas;

  public CallCenter() {
    this.llamadas = new LinkedQueue<>();
    this.operadores = new DoublyLinkedList<>();
  }

  public void addLlamada(Cliente cliente) {
    this.llamadas.enqueue(cliente);
  }

  public void addOperador(Operador operador) {
    this.operadores.addLast(operador);
  }

  // El big O de esta funcion (literal d) es n, donde n es el numero de llamadas
  // totales atendidas en el dia
  public void atenderClientes() {
    while (!this.llamadas.isEmpty()) {
      // Solo los operadores en la lista estan disponibles. Cualquier otro no lo esta.
      Operador operador = this.operadores.removeFirst();
      int num = operador.atenderLlamada(this.llamadas);
      for (int i = 0; i < num; i++) {
        this.llamadasCompletas.addLast(operador.getNombre());
      }
      this.operadores.addLast(operador);
    }
  }

  public int getLLamadasAtendidas(String nombre) {
    int counter = 0;
    DoublyLinkedList<String> tempList = new DoublyLinkedList<>();
    while (true) {
      var temp = this.llamadasCompletas.remove(this.llamadasCompletas.search(nombre));
      if (temp == null) {
        break;
      }
      counter += 1;
      tempList.addLast(temp);
    }
    while (!tempList.isEmpty()) {
      this.llamadasCompletas.addLast(tempList.removeFirst());
    }
    return counter;
  }
}
