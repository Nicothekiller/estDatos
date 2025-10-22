package com.nic.E.E02;

import com.nic.TDA.TreeMap;
import com.nic.TDA.UnsortedTableMap;

public class AlmacenamientoProductos {
  private TreeMap<Integer, Producto> map;

  // inserción O(1), pero esta comentado para no duplicar estructuras de datos
  // private UnsortedTableMap<Integer,Producto> unsortedMap;

  public AlmacenamientoProductos() {
    map = new TreeMap<>();
    // inserción O(1), pero esta comentado para no duplicar estructuras de datos
    // unsortedMap = new UnsortedTableMap<>()
  }

  // literal b
  public void insertProducto(Producto producto) {
    map.put(producto.getIdentificacion(), producto);

    // inserción O(1), pero esta comentado para no duplicar estructuras de datos
    // unsortedMap.put(producto.getIdentificacion(), producto);
  }

  // literal c
  public Producto getProducto(Integer key) {
    // es recursivo ya que el metodo de busqueda de llave es recursivo
    return map.get(key);
  }

  // literal d
  public int countCatergoria(String categoria) {
    int counter = 0;
    // es recursivo ya que iterar atraves de un arbol es recursivo
    for (Producto i : map.values()) {
      if (i.getCategoria().equals(categoria)) {
        counter += 1;
      }
    }

    return counter;
  }
}
