package com.nic.EI.EI03;

/**
 * La clase Extension simula una Extension electrica, para conectar cosas que
 * necesiten electricidad desde una mayor distancia.
 */
public class Extension {
  private int longitud;
  private int conexiones;

  public Extension(final int conexiones, final int longitud) {
    this.conexiones = conexiones;
    this.longitud = longitud;
  }

  public int getLongitud() {
    return longitud;
  }

  public void setLongitud(final int longitud) {
    this.longitud = longitud;
  }

  public int getConexiones() {
    return conexiones;
  }

  public void setConexiones(final int conexiones) {
    this.conexiones = conexiones;
  }

  /**
   * Funcion para conectar algun dispositivo. Menora la cantidad de conexiones
   * displonibles.
   *
   * @throws Exception - Cuando no hay mas conexiones disponibles.
   */
  public void conectar() throws Exception {
    if (this.conexiones > 0) {
      this.conexiones -= 1;
    } else {
      throw new Exception("No hay mas conexiones disponibles.");
    }
  }

  @Override
  public String toString() {
    return "Extension [longitud=" + longitud + ", conexiones=" + conexiones + "]";
  }
}
