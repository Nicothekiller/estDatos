package com.nic.EI.EI05;

import com.nic.TDA.ChainHashMap;

/**
 * Clase para manejar e obtener la informacion de los ciudadanos basado en sus
 * cedulas de identificacion.
 *
 * Usa un ChainHashMap (metodo de separate chaining para colisiones).
 */
public class SistemaCedulas {
  private final ChainHashMap<String, Persona> mapaPersonas;

  public SistemaCedulas() { mapaPersonas = new ChainHashMap<>(); }

  /**
   * Añade una persona al sistema. No funciona si ya existe una persona con una
   * cedula especifica. Para añadir/remplazar una persona utilizar el metodo
   * replacePersona.
   */
  public void addPersona(final Persona persona) throws Exception {
    if (mapaPersonas.get(persona.getCedula()).equals(null)) {
      mapaPersonas.put(persona.getCedula(), persona);
    } else {
      throw new Exception("Ya existe esa persona en el sistema.");
    }
  }

  /**
   * Añade o remplaza una persona al sistema.
   */
  public void replacePersona(final Persona persona) {
    mapaPersonas.put(persona.getCedula(), persona);
  }

  /**
   * Metodo que devuelve una persona del sistema.
   */
  public Persona getPersona(final String cedula) {
    return mapaPersonas.get(cedula);
  }
}
