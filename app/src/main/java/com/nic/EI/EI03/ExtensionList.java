package com.nic.EI.EI03;

import com.nic.TDA.DoublyLinkedList;

/**
 * La clase ExtensionList simula varias extensiones electricas seguidas
 * conectadas una tras otra entre si. Tener en cuenta que conectar muchas puede
 * ser riesgoso.
 */
public class ExtensionList {
  private final DoublyLinkedList<Extension> extensiones;

  public ExtensionList() {
    this.extensiones = new DoublyLinkedList<>();
  }

  /**
   * Añade una nueva extension.
   *
   * @param element - La extension a conectar.
   * @throws FireHazardException - Cuando hay muchas conexiones.
   * @throws Exception           - Cuando la Extension anterior ya no tiene en
   *                             donde conectar la siguiente extension.
   */
  public void conectar(final Extension element) throws FireHazardException, Exception {
    if (extensiones.size() < 10) {
      if (this.extensiones.last() != null) {
        this.extensiones.last().conectar();
      }
      extensiones.addLast(element);
    } else {
      throw new FireHazardException("Demasiadas conexiones al mismo tiempo. Se quemo la casa.");
    }
  }

  public Extension last() {
    return this.extensiones.last();
  }

  public Extension first() {
    return this.extensiones.first();
  }

  public Extension removeLast() {
    // Solo posible con Doubly Linked List
    final Extension removeLast = this.extensiones.removeLast();
    this.extensiones.last().setConexiones(this.extensiones.last().getConexiones() + 1);
    return removeLast;
  }
}
