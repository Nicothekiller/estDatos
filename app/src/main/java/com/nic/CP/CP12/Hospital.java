package com.nic.CP.CP12;

import static com.nic.TDA.GraphTraversals.*;

import com.nic.TDA.AdjacencyMapGraph;
import com.nic.TDA.ChainHashMap;
import com.nic.TDA.Edge;
import com.nic.TDA.Graph;
import com.nic.TDA.Map;
import com.nic.TDA.PositionalList;
import com.nic.TDA.Vertex;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Hospital {
  private Graph<String, Integer> graph;

  public Hospital() { this.graph = new AdjacencyMapGraph<>(false); }

  public Edge<Integer> getEdge(Vertex<String> u, Vertex<String> v)
      throws IllegalArgumentException {
    return graph.getEdge(u, v);
  }

  public Vertex<String> insertSala(String element) {
    return graph.insertVertex(element);
  }

  public Edge<Integer> insertPasillo(Vertex<String> u, Vertex<String> v,
                                     Integer element)
      throws IllegalArgumentException {
    return graph.insertEdge(u, v, element);
  }

  public void removeVertex(Vertex<String> vertex)
      throws IllegalArgumentException {
    graph.removeVertex(vertex);
  }

  public void removeEdge(Edge<Integer> e) throws IllegalArgumentException {
    graph.removeEdge(e);
  }

  public PositionalList<Edge<Integer>> findShortestPath(Vertex<String> start,
                                                        Vertex<String> end) {
    var lengths = shortestPathLengths(graph, start);
    var paths = spTree(graph, start, lengths);

    var path = constructPath(graph, start, end, paths);
    return path;
  }
}
