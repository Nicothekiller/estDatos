package com.nic.E.E02;

public class Producto {
  private int identificacion;
  private String categoria;
  private String descripcion;

  public Producto(int identificacion, String categoria, String descripcion) {
    this.identificacion = identificacion;
    this.categoria = categoria;
    this.descripcion = descripcion;
  }

  public void setIdentificacion(int identificacion) {
    this.identificacion = identificacion;
  }
  public void setCategoria(String categoria) { this.categoria = categoria; }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getIdentificacion() { return identificacion; }
  public String getCategoria() { return categoria; }
  public String getDescripcion() { return descripcion; }
}
