package com.nic.EI.EI05;

import com.nic.TDA.ProbeHashMap;

/**
 * Clase que simula sistema de registro de una tienda. Utiliza un ProbeHashMap
 * (metodo de linear probing para colisiones) para guardar los clientes basado
 * en sus cedulas.
 */
public class Tienda {
  private final ProbeHashMap<String, Cliente> mapaClientes;

  public Tienda() { mapaClientes = new ProbeHashMap<>(); }

  /**
   * Añade un cliente a el registra de la tienda.
   */
  public void addCliente(final Cliente cliente) {
    mapaClientes.put(cliente.getCedula(), cliente);
  }

  /*
   * Metodo para cambiar el balance de un cliente basado en su cedula.
   */
  public void changeBalance(final String cedula, final int balance) {
    mapaClientes.get(cedula).changeBalance(balance);
  }

  /**
   * Regresa el balance de un cliente basado en su cedula.
   */
  public int getBalance(String cedula) {
    return mapaClientes.get(cedula).getBalance();
  }
}
