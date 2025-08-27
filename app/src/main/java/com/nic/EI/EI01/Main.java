package com.nic.EI.EI01;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de la clase. Se puede añadir personas.
        String[] nameList = { "Jhon", "Lily", "Garfield", "Sam", "Nicolas", "Pablo" };
        Fila fila = new Fila();

        for (String value : nameList) {
            fila.newPersona(new Persona(value));
        }

        // Añadir personas y quitarlas no daña el orden. Se van quitando basado en cual
        // persona se encuentra mas tiempo en la fila.
        System.out.println(fila.quitarPersona().getNombre());

        fila.newPersona(new Persona("Juan"));
        System.out.println(fila.quitarPersona().getNombre());

        fila.newPersona(new Persona("Pedro"));

        while (!fila.isEmpty()) {
            System.out.println(fila.quitarPersona().getNombre());
        }
    }
}
