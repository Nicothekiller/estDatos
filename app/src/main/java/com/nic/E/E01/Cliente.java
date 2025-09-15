package com.nic.E.E01;

public class Cliente {
  private String nombre;
  private String motivoLlamada;
  private int numeroTelefonico;

  public Cliente(String nombre, String motivoLlamada, int numeroTelefonico) {
    this.nombre = nombre;
    this.motivoLlamada = motivoLlamada;
    this.numeroTelefonico = numeroTelefonico;
  }

  public String getNombre() {
    return nombre;
  }

  public String getMotivoLlamada() {
    return motivoLlamada;
  }

  public int getNumeroTelefonico() {
    return numeroTelefonico;
  }
}
