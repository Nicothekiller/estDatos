package com.nic.E.E02;

import com.nic.TDA.TreeMap;

public class IndexEstudiantes {
  private TreeMap<Integer, Estudiante> map;

  public IndexEstudiantes() { this.map = new TreeMap<>(); }

  // literal b
  public Estudiante getEstudiante(int codigo) { return map.get(codigo); }

  // literal c
  public void insertEstudiante(Estudiante estudiante) {
    map.put(estudiante.getCodigo(), estudiante);
  }

  // literal d
  public Estudiante deleteEstudiante(Integer codigo) {
    return map.remove(codigo);
  }

  // literal e
  //
  // El arbol usa un treeMap para representar los estudiantes, se usa codigo y
  // devuelve el estudiante.
  //
  // Ejemplo de arbol:
  // 2: Computacion
  //     1: Arte
  //
  //     4: Musica
  //         3: Computacion
  //         5: Arquitectura
  //
  //
  // 2
  // |\
  // | \
  // 1  4
  //    |\
  //    | \
  //    3  5
}
