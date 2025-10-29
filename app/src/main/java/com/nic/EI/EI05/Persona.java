package com.nic.EI.EI05;

public class Persona {
  private String nombre;
  private int edad;
  private String cedula;

  public Persona(final String nombre, final int edad, final String cedula) {
    this.nombre = nombre;
    this.edad = edad;
    this.cedula = cedula;
  }

  public String getNombre() { return nombre; }

  public void setNombre(final String nombre) { this.nombre = nombre; }

  public int getEdad() { return edad; }

  public void setEdad(final int edad) { this.edad = edad; }

  public String getCedula() { return cedula; }

  public void setCedula(final String cedula) { this.cedula = cedula; }
}
