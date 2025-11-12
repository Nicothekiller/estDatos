package com.nic.EI.EI06;

/*
 * Gráfico del ejercicio:
 * (JFK) --300--> (LAX)
 * (JFK) --120--> (ORD)
 * (JFK) --180--> (MIA)
 * (ORD) --150--> (DEN)
 * (ORD) --90---> (ATL)
 * (ATL) --100--> (MIA)
 * (DEN) --140--> (LAX)
 * (LAX) --60---> (SFO)
 * (ATL) --110--> (JFK)
 *
 * (EL gráfico es no dirigido, edges van en las dos direcciones)
 */

/*
 * ¿Que es un componente biconectado?
 * Es un subgrafo en donde al quitar cualquier vértice, el resultado todavía
 * tendrá un camino hacia cualquiera de los vértices del subgrafo.
 *
 * Como por ejemplo, si vas en un viaje Vancouver --> Los Ángeles --> Ecuador,
 * pero en ves de llegar a los Ángeles te despiertas en Las Vegas
 * (si me sucedió una ves), si estos aeropuertos forman un componente
 * biconectado incluso tras quitar el aeropuerto de Los Ángeles todavía es
 * posible llegar a Ecuador.
 */

import com.nic.TDA.Edge;
import com.nic.TDA.PositionalList;
import com.nic.TDA.Vertex;

public class Main {

  public static void main(final String[] args) {
    final FlightNetwork flightNetwork = new FlightNetwork();

    // Se añade algunos aeropuertos.
    flightNetwork.addAirport("JFK"); // New York
    flightNetwork.addAirport("LAX"); // Los Angeles
    flightNetwork.addAirport("ORD"); // Chicago
    flightNetwork.addAirport("ATL"); // Atlanta
    flightNetwork.addAirport("MIA"); // Miami
    flightNetwork.addAirport("SFO"); // San Francisco
    flightNetwork.addAirport("DEN"); // Denver

    // Se añaden los vuelos entre aeropuertos.
    flightNetwork.addFlight("JFK", "LAX", 300);
    flightNetwork.addFlight("JFK", "ORD", 120);
    flightNetwork.addFlight("JFK", "MIA", 180);
    flightNetwork.addFlight("ORD", "DEN", 150);
    flightNetwork.addFlight("ORD", "ATL", 90);
    flightNetwork.addFlight("ATL", "MIA", 100);
    flightNetwork.addFlight("DEN", "LAX", 140);
    flightNetwork.addFlight("LAX", "SFO", 60);
    flightNetwork.addFlight("ATL", "JFK", 110);

    System.out.println("Ejemplo:\n");

    final String origin = "JFK";
    final String destination = "SFO";

    System.out.println("Con DFS:");
    final PositionalList<Edge<Integer>> dfsPath =
        flightNetwork.findDFSPath(origin, destination);
    printPath(flightNetwork, origin, dfsPath);

    System.out.println("Con BFS:");
    final PositionalList<Edge<Integer>> bfsPath =
        flightNetwork.findBFSPath(origin, destination);
    printPath(flightNetwork, origin, bfsPath);
  }

  /**
   * Utilidad para imprimir el camino encontrado.
   */
  private static void printPath(final FlightNetwork flightNetwork,
                                final String origin,
                                final PositionalList<Edge<Integer>> path) {
    if (path.isEmpty()) {
      System.out.println("No hay camino.");
      return;
    }

    Vertex<String> current = flightNetwork.getAirport(origin);
    System.out.print("Camino: " + origin);
    int totalDuration = 0;

    for (final Edge<Integer> edge : path) {
      totalDuration += edge.getElement();
      final Vertex<String> opposite =
          flightNetwork.getNetwork().opposite(current, edge);
      System.out.print(" -> " + opposite.getElement() + " (" +
                       edge.getElement() + " min)");
      current = opposite;
    }
    System.out.println("\nDuracion total: " + totalDuration + " minutos.");
  }
}
