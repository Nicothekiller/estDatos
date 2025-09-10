package com.nic.CP.hospital;

public class Paciente {
  private String nombre;
  private int historiaClinica;
  private int edad;
  private Genero genero;
  private PacientType type;

  public Paciente(String nombre, int historiaClinica, int edad, Genero genero) {
    this.nombre = nombre;
    this.historiaClinica = historiaClinica;
    this.edad = edad;
    this.genero = genero;

    if (edad < 10) {
      this.type = PacientType.POLIO;
    } else if (edad > 60) {
      this.type = PacientType.HIPERTENSO;
    } else {
      this.type = PacientType.OTRO;
    }
  }

  public String getNombre() {
    return nombre;
  }

  public int getHistoriaClinica() {
    return historiaClinica;
  }

  public int getEdad() {
    return edad;
  }

  public Genero getGenero() {
    return genero;
  }

  public PacientType getType() {
    return type;
  }
}
