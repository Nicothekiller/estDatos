package com.nic.E.E02;

public class Estudiante {
  private String carrera;
  private int codigo;

  public Estudiante(int codigo, String carrera) {
    this.codigo = codigo;
    this.carrera = carrera;
  }

  public int getCodigo() { return codigo; }

  public String getCarrera() { return carrera; }

  public void setCarrera(String carrera) { this.carrera = carrera; }
}
