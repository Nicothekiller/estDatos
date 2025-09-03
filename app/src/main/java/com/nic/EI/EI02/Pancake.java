package com.nic.EI.EI02;

/**
 * La clase pancake simula un pancake.
 */
public class Pancake {
  private int calorias;
  private String aderezo;

  /**
   * @param calorias - Numero de calorías del Pancake
   * @param aderezo  - El aderezo a utilizar en el pancake (ej: chocolate, miel
   *                 de maple, etc.)
   */
  public Pancake(final int calorias, final String aderezo) {
    this.calorias = calorias;
    this.aderezo = aderezo;
  }

  @Override
  public String toString() {
    return "Pancake: calorias=" + calorias + ", aderezo=" + aderezo;
  }
}
