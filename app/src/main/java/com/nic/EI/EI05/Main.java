package com.nic.EI.EI05;

import com.nic.TDA.DoublyLinkedList;
import com.nic.TDA.Entry;

public class Main {
  public static void main(String[] args) throws Exception {
    // ejemplo para SistemaCedulas (Separate Chaining)
    System.out.println("--- SistemaCedulas (ChainHashMap) ---");
    SistemaCedulas sistemaCedulas = new SistemaCedulas();
    Persona persona1 = new Persona("Alice", 25, "123");
    Persona persona2 = new Persona("Bob", 30, "456");

    sistemaCedulas.addPersona(persona1);
    sistemaCedulas.replacePersona(persona2);

    sistemaCedulas.addPersona(new Persona("Noel", 25, "789"));

    System.out.println("Persona con cedula 123: " +
                       sistemaCedulas.getPersona("123").getNombre());

    System.out.println("Personas: ");
    for (Persona persona : sistemaCedulas.values()) {
      System.out.println(persona);
    }

    // ejemplo para la tienda (Linear Probing)
    System.out.println("\n--- Tienda (ProbeHashMap) ---");
    Tienda tienda = new Tienda();
    Cliente cliente1 = new Cliente(100, "Charlie", 35, "789");
    Cliente cliente2 = new Cliente(200, "David", 40, "101");

    tienda.addCliente(cliente1);
    tienda.addCliente(cliente2);

    System.out.println("Balance para cedula 789: " + tienda.getBalance("789"));
    tienda.changeBalance("789", -50);
    System.out.println("Nuevo balance para cedula 789: " +
                       tienda.getBalance("789"));

    // Ejemplo de survey (Double Hashing)
    System.out.println("\n--- Survey (DoubleHashMap) ---");
    Survey<String> survey = new Survey<>();
    survey.addRespuesta("Color", "Blue");
    survey.addRespuesta("Color", "Red");
    survey.addRespuesta("Animal", "Dog");
    survey.addRespuesta("Animal", "Cat");

    DoublyLinkedList<String> respuesta = survey.getRespuesta("Color");
    System.out.println("Respuestas para Color: ");
    while (respuesta.size() != 0) {
      System.out.print(respuesta.removeLast() + " ");
    }

    survey.addRespuesta("Color", "Blue");
    survey.addRespuesta("Color", "Red");
    survey.addRespuesta("Color", "Green");

    Iterable<Entry<String, DoublyLinkedList<String>>> respuestas =
        survey.getRespuestas();
    System.out.println("\n\nTodas las respuestas: ");
    for (var values : respuestas) {
      System.out.print(values.getKey() + ": ");
      while (values.getValue().size() != 0) {
        System.out.print(values.getValue().removeLast() + " ");
      }
      System.out.println();
    }
  }
}
