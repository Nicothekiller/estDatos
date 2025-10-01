package com.nic.TDA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Concrete implementation of a tree using a node-based, linked
 * structure.
 */
public class LinkedTree<E> {
  //---------------- nested Node class ----------------
  public static class TreeNode<E> implements Position<E> {
    private E element;
    // an element stored at this node
    private TreeNode<E> parent;
    // a reference to the parent node (if any)

    private LinkedPositionalList<TreeNode<E>> nodes;

    /** Constructs a node with the given element and children nodes. */
    public TreeNode(E e, TreeNode<E> above,
                    LinkedPositionalList<TreeNode<E>> nodes) {
      element = e;
      parent = above;
      this.nodes = nodes;
    }

    // accessor methods
    public E getElement() { return element; }
    public TreeNode<E> getParent() { return parent; }

    /** Returns the first node in the list (or null, if empty). */
    public Position<TreeNode<E>> getFirst() { return nodes.first(); }
    public Position<TreeNode<E>> after(Position<TreeNode<E>> node) {
      return nodes.after(node);
    }

    // update methods
    public void setElement(E e) { element = e; }
    public void setParent(TreeNode<E> parentNode) { parent = parentNode; }

    // amount of child nodes
    public int getChildrenSize() { return nodes.size(); }
    public void addNode(E e) {
      nodes.addLast(new TreeNode<E>(e, getParent(),
                                    new LinkedPositionalList<TreeNode<E>>()));
    }
    public void addNode(TreeNode<E> e) { nodes.addLast(e); }
  } //----------- end of nested Node class -----------

  //---------------- nested ElementIterator class ----------------
  /* This class adapts the iteration produced by positions
  () to return elements. */
  private class ElementIterator implements Iterator<E> {
    Iterator<Position<E>> posIterator = positions().iterator();
    public boolean hasNext() { return posIterator.hasNext(); }
    public E next() {
      return posIterator.next().getElement();
    } // return element!
    public void remove() { posIterator.remove(); }
  }

  public boolean isInternal(TreeNode<E> p) { return numChildren(p) > 0; }
  public boolean isExternal(TreeNode<E> p) { return numChildren(p) == 0; }
  public boolean isRoot(Position<E> p) { return p == root(); }
  public boolean isEmpty() { return size() == 0; }

  // LinkedBinaryTree instance variables
  // root of the tree
  protected TreeNode<E> root = null;

  private int size = 0;

  public LinkedTree() {}

  /**
   * Returns an iterable collection of positions of the tree, reported in
   * postorder.
   */
  public Iterable<TreeNode<E>> postorder() {
    List<TreeNode<E>> snapshot = new ArrayList<>();
    if (!isEmpty())
      postorderSubtree(root(), snapshot);
    // fill the snapshot recursively
    return snapshot;
  }

  /**
     Returns an iterable collection of positions of the tree in breadth -
      first order.
   */
  public Iterable<TreeNode<E>> breadthfirst() {
    List<TreeNode<E>> snapshot = new ArrayList<>();
    if (!isEmpty()) {
      Queue<TreeNode<E>> fringe = new LinkedQueue<>();
      fringe.enqueue(root());
      // start with the root
      while (!fringe.isEmpty()) {
        TreeNode<E> p = fringe.dequeue();
        // remove from front of the queue
        snapshot.add(p);
        // report this position
        for (TreeNode<E> c : children(p))
          fringe.enqueue(c);
        // add children to back of queue
      }
    }
    return snapshot;
  }

  /** Overrides positions to make inorder the default order for binary trees. */
  public Iterable<Position<E>> positions() { return preorder(); }
  public Iterable<Position<E>> preorder() {
    java.util.List<Position<E>> snapshot = new java.util.ArrayList<>();
    if (!isEmpty())
      preorderSubtree(root(), snapshot);
    // fill the snapshot recursively
    return snapshot;
  }

  // accessor methods (not already implemented in AbstractBinaryTree)
  /** Returns the number of nodes in the tree. */
  public int size() { return size; }

  /** Returns the root Position of the tree (or null if tree is empty). */
  public TreeNode<E> root() { return root; }

  /** Returns the Position of p's parent (or null if p is root). */
  public Position<E> parent(Position<E> p) throws IllegalArgumentException {
    TreeNode<E> node = validate(p);
    return node.getParent();
  }

  // update methods supported by this class
  /**
   * Places element e at the root of an empty tree and returns its new
   * Position.
   */
  public Position<E> addRoot(E e) throws IllegalStateException {
    if (!isEmpty())
      throw new IllegalStateException("Tree is not empty");
    root = createNode(e, null, null);
    size = 1;
    return root;
  }

  /**
   * Replaces the element at Position p with e and returns the replaced
   * element.
   */
  public E set(Position<E> p, E e) throws IllegalArgumentException {
    TreeNode<E> node = validate(p);
    E temp = node.getElement();
    node.setElement(e);
    return temp;
  }

  public void addChild(TreeNode<E> p, E e) { p.addNode(e); }

  /** Attaches trees t1 and t2 as left and right subtrees of external p. */
  public void attach(Position<E> p, LinkedTree<E> t1)
      throws IllegalArgumentException {
    TreeNode<E> node = validate(p);
    // if (isInternal(node))
    //   throw new IllegalArgumentException("p must be a leaf");
    size += t1.size();
    if (!t1.isEmpty()) {
      // attach t1 as left subtree of node
      t1.root.setParent(node);
      node.addNode(node);
      t1.root = null;
      t1.size = 0;
    }
  }

  /** Removes the node at Position p and replaces it with its child, if any. */
  public E remove(TreeNode<E> p) throws IllegalArgumentException {
    TreeNode<E> node = validate(p);
    if (numChildren(p) >= 2)
      throw new IllegalArgumentException("p has two or more children");
    TreeNode<E> child =
        (p.getFirst() != null ? p.getFirst().getElement() : null);

    if (child != null)
      child.setParent(
          node.getParent()); // child’s grandparent becomes its parent
    if (node == root)
      root = child;
    // child becomes root
    else {
      TreeNode<E> parent = node.getParent();
      parent.addNode(child);
    }
    size--;
    E temp = node.getElement();
    node.setElement(null);
    // help garbage collection
    node.setParent(node);
    // our convention for defunct node
    return temp;
  }

  /** Returns an iterator of the elements stored in the tree. */
  public Iterator<E> iterator() { return new ElementIterator(); }

  public Iterable<TreeNode<E>> children(TreeNode<E> p) {
    // Array estatico para el iterador, el tamaño no cambia
    var copy = new ArrayList<TreeNode<E>>(p.getChildrenSize());

    for (Position<TreeNode<E>> walk = p.getFirst(); walk != null;
         walk = p.after(walk)) {
      copy.add(walk.getElement());
    }

    return copy;
  }

  public int numChildren(TreeNode<E> p) { return p.getChildrenSize(); }

  /** Factory function to create a new node storing element e. */
  protected TreeNode<E> createNode(E e, TreeNode<E> parent,
                                   LinkedPositionalList<TreeNode<E>> nodes) {
    return new TreeNode<E>(e, parent, nodes);
  }

  // nonpublic utility
  /** Validates the position and returns it as a node. */
  protected TreeNode<E> validate(Position<E> p)
      throws IllegalArgumentException {
    if (!(p instanceof TreeNode))
      throw new IllegalArgumentException("Not valid position type");
    TreeNode<E> node = (TreeNode<E>)p;
    // safe cast
    if (node.getParent() == node)
      // our convention for defunct node
      throw new IllegalArgumentException("p is no longer in the tree");
    return node;
  }

  /**
   * Adds positions of the subtree rooted at Position p to the given snapshot.
   */
  private void postorderSubtree(TreeNode<E> p, List<TreeNode<E>> snapshot) {
    for (TreeNode<E> c : children(p))
      postorderSubtree(c, snapshot);
    snapshot.add(p);
    // for postorder, we add position p after exploring subtrees
  }

  // number of nodes in the tree
  // constructor
  private void preorderSubtree(TreeNode<E> p,
                               java.util.List<Position<E>> snapshot) {
    snapshot.add(p);
    // for preorder, we add position p before exploring subtrees
    for (TreeNode<E> c : children(p))
      preorderSubtree(c, snapshot);
  }
}
