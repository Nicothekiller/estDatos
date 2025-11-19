package com.nic.CP.CP11;

import static com.nic.TDA.GraphTraversals.*;

import com.nic.TDA.AdjacencyMapGraph;
import com.nic.TDA.Edge;
import com.nic.TDA.Graph;
import com.nic.TDA.Map;
import com.nic.TDA.UnsortedTableMap;
import com.nic.TDA.Vertex;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Graph<String, String> graph = new AdjacencyMapGraph<>(true);

    var a = graph.insertVertex("A");
    var b = graph.insertVertex("B");
    var m = graph.insertVertex("M");
    var j = graph.insertVertex("J");
    var f = graph.insertVertex("F");

    graph.insertEdge(b, m, "BM");
    graph.insertEdge(b, a, "BA");
    graph.insertEdge(b, j, "BJ");
    graph.insertEdge(m, a, "MA");
    graph.insertEdge(a, f, "AF");
    graph.insertEdge(a, j, "AJ");

    System.out.println("--- topologicalSort ---");
    var sort = topologicalSort(graph);
    for (var val : sort) {
      System.out.println(val.getElement());
    }

    transitiveClosure(graph);

    System.out.println("\n--- transitiveClosure ---");
    for (var val : graph.edges()) {
      System.out.println(val.getElement());
    }
  }
}
