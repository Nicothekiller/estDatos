package com.nic.EI.EI05;

import com.nic.TDA.DoubleHashMap;
import com.nic.TDA.DoublyLinkedList;
import com.nic.TDA.Entry;

/**
 * Clase que simula un survey basado en el key designado de las personas que
 * responden (ej: edad).
 *
 * Utiliza el metodo de Double Hashing para evitar colisiones.
 */
public class Survey<K> {
  private final DoubleHashMap<K, DoublyLinkedList<String>> surveyMap;

  public Survey() { surveyMap = new DoubleHashMap<>(); }

  /**
   * Añade una respuesta al survey
   */
  public void addRespuesta(final K key, final String respuesta) {
    final var arr = surveyMap.get(key);
    if (arr == null) {
      surveyMap.put(key, new DoublyLinkedList<String>());
    }
    surveyMap.get(key).addLast(respuesta);
  }

  /**
   * Devuelve todas las respuestas del survey para un key.
   */
  public DoublyLinkedList<String> getRespuesta(final K key) {
    return surveyMap.get(key);
  }

  /**
   * Devuelve todas las respuestas del survey.
   */
  public Iterable<Entry<K, DoublyLinkedList<String>>> getRespuestas() {
    return surveyMap.entrySet();
  }
}
