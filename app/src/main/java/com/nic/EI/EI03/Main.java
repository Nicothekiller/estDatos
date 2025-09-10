package com.nic.EI.EI03;

public class Main {
  public static void main(String[] args) throws FireHazardException, Exception {
    var extensiones = new ExtensionList();
    for (int i = 0; i < 10; i++) {
      // Despues de ser añadidas la extension anterior tendra una conexion menos.
      extensiones.conectar(new Extension(3, i));
      System.out.println(extensiones.last());
    }

    // Si funciona ya que se quita 1
    // Solo posible quitar el ultimo elemento con un Doubly Linked List
    System.out.println(extensiones.removeLast());
    // EL ultimo es el de longitud 8
    System.out.println(extensiones.last());

    // funcina
    extensiones.conectar(new Extension(3, 3));
    System.out.println(extensiones.last());
    // Muchas conexiones, entonces no funciona.
    extensiones.conectar(new Extension(3, 3));
  }
}
