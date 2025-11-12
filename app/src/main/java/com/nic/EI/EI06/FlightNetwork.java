package com.nic.EI.EI06;

import com.nic.TDA.AdjacencyMapGraph;
import com.nic.TDA.Edge;
import com.nic.TDA.Graph;
import com.nic.TDA.GraphTraversals;
import com.nic.TDA.Map;
import com.nic.TDA.PositionalList;
import com.nic.TDA.UnsortedTableMap;
import com.nic.TDA.Vertex;
// Necesario para el path traversal con BFS y DFS.
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa un sistema de viajes de aviones con un
 * AdjacencyMapGraph. Se guardan los aeropuertos y la duracion de cada viaje
 * para poder calcular la via mas eficiente entre aeropuertos.
 */
public class FlightNetwork {

  private final Graph<String, Integer> network;
  private final Map<String, Vertex<String>> airports;

  public FlightNetwork() {
    this.network = new AdjacencyMapGraph<>(false);
    this.airports = new UnsortedTableMap<>();
  }

  /**
   * Añade un nuevo aeropuerto a la lista de aeropuertos.
   */
  public void addAirport(final String airportCode) {
    if (airports.get(airportCode) == null) {
      final Vertex<String> airportVertex = network.insertVertex(airportCode);
      airports.put(airportCode, airportVertex);
    }
  }

  /**
   * Añade un vuelo disponible entre aeropuertos.
   *
   * @param origin - Aeropuerto de origen.
   * @param destination - Destino final.
   * @param duration - Duracion del vuelo.
   */
  public void addFlight(final String origin, final String destination,
                        final int duration) {
    final Vertex<String> originVertex = airports.get(origin);
    final Vertex<String> destVertex = airports.get(destination);

    if (originVertex == null || destVertex == null) {
      throw new IllegalArgumentException("Aeropuerto no esta en el network.");
    }

    network.insertEdge(originVertex, destVertex, duration);
  }

  public Vertex<String> getAirport(final String airportCode) {
    return airports.get(airportCode);
  }

  /**
   * Camino entre aeropuertos con DFS.
   *
   * @param origin - Lugar inicial.
   * @param destination - Destino final.
   * @return - Lista de los aeropuertos visitados para llegar al destino.
   */
  public PositionalList<Edge<Integer>> findDFSPath(final String origin,
                                                   final String destination) {
    final Vertex<String> originVertex = airports.get(origin);
    final Vertex<String> destVertex = airports.get(destination);

    if (originVertex == null || destVertex == null) {
      return new com.nic.TDA.LinkedPositionalList<>();
    }

    final Set<Vertex<String>> known = new HashSet<>();
    final Map<Vertex<String>, Edge<Integer>> forest = new UnsortedTableMap<>();
    GraphTraversals.DFS(network, originVertex, known, forest);

    return GraphTraversals.constructPath(network, originVertex, destVertex,
                                         forest);
  }

  /**
   * Camino entre aeropuertos con BFS.
   *
   * @param origin - Lugar inicial.
   * @param destination - Destino final.
   * @return - Lista de los aeropuertos visitados para llegar al destino.
   */
  public PositionalList<Edge<Integer>> findBFSPath(final String origin,
                                                   final String destination) {
    final Vertex<String> originVertex = airports.get(origin);
    final Vertex<String> destVertex = airports.get(destination);

    if (originVertex == null || destVertex == null) {
      return new com.nic.TDA.LinkedPositionalList<>();
    }

    final Set<Vertex<String>> known = new HashSet<>();
    final Map<Vertex<String>, Edge<Integer>> forest = new UnsortedTableMap<>();
    GraphTraversals.BFS(network, originVertex, known, forest);

    return GraphTraversals.constructPath(network, originVertex, destVertex,
                                         forest);
  }

  public Graph<String, Integer> getNetwork() { return network; }
}
