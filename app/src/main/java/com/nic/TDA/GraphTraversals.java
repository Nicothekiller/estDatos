package com.nic.TDA;

import java.util.HashSet;
import java.util.Set;

public class GraphTraversals<V, E> {

  public static <V, E> void DFS(Graph<V, E> graph, Vertex<V> u,
                                Set<Vertex<V>> known,
                                Map<Vertex<V>, Edge<E>> forest) {
    known.add(u);
    for (Edge<E> e : graph.outgoingEdges(u)) {
      Vertex<V> v = graph.opposite(u, e);
      if (!known.contains(v)) {
        forest.put(v, e);
        DFS(graph, v, known, forest);
      }
    }
  }

  public static <V, E> PositionalList<Edge<E>>
  constructPath(Graph<V, E> graph, Vertex<V> u, Vertex<V> v,
                Map<Vertex<V>, Edge<E>> forest) {
    PositionalList<Edge<E>> path = new LinkedPositionalList<>();
    if (forest.get(v) != null) {
      Vertex<V> walk = v;
      while (walk != u) {
        Edge<E> edge = forest.get(walk);
        path.addFirst(edge);
        walk = graph.opposite(walk, edge);
      }
    }

    return path;
  }

  public static <V, E> Map<Vertex<V>, Edge<E>> DFSComplete(Graph<V, E> graph) {
    Set<Vertex<V>> known = new HashSet<>();
    Map<Vertex<V>, Edge<E>> forest = new UnsortedTableMap<>();
    for (Vertex<V> u : graph.vertices()) {
      if (!known.contains(u)) {
        DFS(graph, u, known, forest);
      }
    }

    return forest;
  }

  public static <V, E> void BFS(Graph<V, E> graph, Vertex<V> s,
                                Set<Vertex<V>> known,
                                Map<Vertex<V>, Edge<E>> forest) {
    PositionalList<Vertex<V>> level = new LinkedPositionalList<>();
    known.add(s);
    level.addLast(s);
    while (!level.isEmpty()) {
      PositionalList<Vertex<V>> nextLevel = new LinkedPositionalList<>();
      for (Vertex<V> u : level) {
        for (Edge<E> e : graph.outgoingEdges(u)) {
          Vertex<V> v = graph.opposite(u, e);
          if (!known.contains(v)) {
            known.add(v);
            forest.put(v, e);
            nextLevel.addLast(v);
          }
        }
      }
      level = nextLevel;
    }
  }

  public static <V> Map<Vertex<V>, Integer>
  shortestPathLengths(Graph<V, Integer> g, Vertex<V> src) {
    Map<Vertex<V>, Integer> d = new ProbeHashMap<>();
    Map<Vertex<V>, Integer> cloud = new ProbeHashMap<>();
    AdaptablePriorityQueue<Integer, Vertex<V>> pq;
    pq = new HeapAdaptablePriorityQueue<>();
    Map<Vertex<V>, Entry<Integer, Vertex<V>>> pqTokens;
    pqTokens = new ProbeHashMap<>();
    for (Vertex<V> v : g.vertices()) {
      if (v == src)
        d.put(v, 0);
      else
        d.put(v, Integer.MAX_VALUE);
      pqTokens.put(v, pq.insert(d.get(v), v));
    }
    while (!pq.isEmpty()) {
      Entry<Integer, Vertex<V>> entry = pq.removeMin();
      int key = entry.getKey();
      Vertex<V> u = entry.getValue();
      cloud.put(u, key);
      pqTokens.remove(u);
      for (Edge<Integer> e : g.outgoingEdges(u)) {
        Vertex<V> v = g.opposite(u, e);
        if (cloud.get(v) == null) {
          int wgt = e.getElement();
          if (d.get(u) + wgt < d.get(v)) {
            d.put(v, d.get(u) + wgt);
            pq.replaceKey(pqTokens.get(v), d.get(v));
          }
        }
      }
    }
    return cloud;
  }

  /** Converts graph g into its transitive closure. */
  public static <V, E> void transitiveClosure(Graph<V, E> g) {
    for (Vertex<V> k : g.vertices())
      for (Vertex<V> i : g.vertices())
        // verify that edge (i,k) exists in the partial closure
        if (i != k && g.getEdge(i, k) != null)
          for (Vertex<V> j : g.vertices())
            // verify that edge (k,j) exists in the partial closure
            if (i != j && j != k && g.getEdge(k, j) != null)
              // if (i,j) not yet included, add it to the closure
              if (g.getEdge(i, j) == null)
                g.insertEdge(i, j, null);
  }

  /**
   * Returns a list of verticies of directed acyclic graph g in topological
   * order.
   */
  public static <V, E> PositionalList<Vertex<V>>
  topologicalSort(Graph<V, E> g) {
    // list of vertices placed in topological order
    PositionalList<Vertex<V>> topo = new LinkedPositionalList<>();
    // container of vertices that have no remaining constraints
    Stack<Vertex<V>> ready = new LinkedStack<>();
    // map keeping track of remaining in-degree for each vertex
    Map<Vertex<V>, Integer> inCount = new ProbeHashMap<>();
    for (Vertex<V> u : g.vertices()) {
      inCount.put(u, g.inDegree(u));
      // initialize with actual in-degree
      if (inCount.get(u) == 0)
        // if u has no incoming edges,
        ready.push(u);
      // it is free of constraints
    }
    while (!ready.isEmpty()) {
      Vertex<V> u = ready.pop();
      topo.addLast(u);
      for (Edge<E> e :
           g.outgoingEdges(u)) { // consider all outgoing neighbors of u
        Vertex<V> v = g.opposite(u, e);
        inCount.put(v, inCount.get(v) - 1);
        // v has one less constraint without u
        if (inCount.get(v) == 0)
          ready.push(v);
      }
    }
    return topo;
  }
}
