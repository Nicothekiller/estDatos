package com.nic.EI.EI05;

import com.nic.TDA.HashMultimap;
import java.util.Map.Entry;

/**
 * Clase que simula un survey basado en el key designado de las personas que
 * responden (ej: edad).
 *
 * Utiliza el metodo de Double Hashing para evitar colisiones.
 */
public class Survey<K> {
  private final HashMultimap<K, String> surveyMap;

  public Survey() { surveyMap = new HashMultimap<>(); }

  /**
   * Añade una respuesta al survey
   */
  public void addRespuesta(K key, String respuesta) {
    surveyMap.put(key, respuesta);
  }

  /**
   * Devuelve todas las respuestas del survey para un key.
   */
  public Iterable<String> getRespuesta(K key) { return surveyMap.get(key); }

  /**
   * Devuelve todas las respuestas del survey.
   */
  public Iterable<Entry<K, String>> getRespuestas() {
    return surveyMap.entries();
  }
}
