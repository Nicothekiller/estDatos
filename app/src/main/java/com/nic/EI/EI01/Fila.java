package com.nic.EI.EI01;

import com.nic.TDA.SinglyLinkedList;

/**
 * La clase fila (o queue en ingles) representa una fila de espera de personas.
 * Un ejemplo de esto es un grupo de gente esperando de manera ordenada para un
 * servicio.
 *
 * Añadir una persona la mete al final, y solo se quita las personas del
 * principio.
 */
public class Fila {
    private final SinglyLinkedList<Persona> personas;

    public Fila(final Persona persona) {
        this.personas = new SinglyLinkedList<>();
        personas.addLast(persona);
    }

    public Fila() {
        this.personas = new SinglyLinkedList<>();
    }

    /**
     * Añade una persona al final de la fila de espera.
     *
     * @param persona es la persona a ser añadida.
     */
    public void newPersona(final Persona persona) {
        personas.addLast(persona);
    }

    /**
     * Quita la primera persona en la fila de espera.
     *
     * @return la primera persona de la fila.
     */
    public Persona quitarPersona() {
        Persona ret = personas.removeFirst();
        return ret;
    }

    /**
     * Afirma si la fila esta vacia.
     */
    public boolean isEmpty() {
        return personas.isEmpty();
    }
}
