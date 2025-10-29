package com.nic.EI.EI05;

public class Cliente {
  private final Persona persona;

  /** Balance de la persona, determina cuanto tiene de duedas.*/
  private int balance;

  public Cliente(final int balance, final Persona persona) {
    this.balance = balance;
    this.persona = persona;
  }

  public Cliente(final int balance, final String nombre, final int edad,
                 final String cedula) {
    this.balance = balance;
    this.persona = new Persona(nombre, edad, cedula);
  }

  public int getBalance() { return balance; }

  public String getNombre() { return persona.getNombre(); }

  public int getEdad() { return persona.getEdad(); }

  public String getCedula() { return persona.getCedula(); }

  /**
   * Cambia el balance del cliente. Se puede usar un numero negativo para quitar
   * del balance.
   */
  public void changeBalance(final int balance) { this.balance += balance; }
}
