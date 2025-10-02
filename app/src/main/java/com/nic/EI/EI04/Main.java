package com.nic.EI.EI04;

import com.nic.TDA.LinkedBinaryTree;
import com.nic.TDA.LinkedTree;
import com.nic.TDA.LinkedTree.TreeNode;

public class Main {
  public static void main(final String[] args) {
    // Perdon por mezclar español e ingles, estaba apurado.
    //
    System.out.println("--- ejemplo de linked tree ---");
    // ejemplo de árbol jerárquico de una compañía
    final var companyTree = new LinkedTree<String>();
    companyTree.addRoot("Jefe");
    companyTree.addChild(companyTree.root(), "Director 1");
    companyTree.addChild(companyTree.root(), "Director 2");
    companyTree.addChild(companyTree.root(), "Director 3");

    // for que añade empleados del 1 al 9, 3 por jefe
    int j = 0;
    for (final TreeNode<String> dir : companyTree.preorder()) {
      for (int i = 1; i < 4; i++) {
        if (dir.getElement().equals(companyTree.root().getElement())) {
          j--;
          break;
        } else {
          companyTree.addChild((TreeNode<String>)dir,
                               String.format("Empleado %d", (j * 3) + i));
        }
      }
      j += 1;
    }

    System.out.println("\n--- preorder ---");
    for (final var val : companyTree.preorder()) {
      System.out.println(val.getElement());
    }
    System.out.println("\n--- postorder ---");
    for (final var val : companyTree.postorder()) {
      System.out.println(val.getElement());
    }
    // Imprime que hay 13 elementos
    System.out.println("Gente en la compañia: " + companyTree.size());

    System.out.println("\n--- ejemplo de linked binary tree ---");
    final var numbersTree = new LinkedBinaryTree<Integer>();
    numbersTree.addRoot(4);
    numbersTree.addLeft(numbersTree.root(), 2);
    numbersTree.addRight(numbersTree.root(), 6);

    final var dos = numbersTree.left(numbersTree.root());
    numbersTree.addLeft(dos, 1);
    numbersTree.addRight(dos, 3);

    final var seis = numbersTree.right(numbersTree.root());
    numbersTree.addLeft(seis, 5);
    numbersTree.addRight(seis, 7);

    System.out.println("Tree size: " + numbersTree.size());
    System.out.println("Return value: " + contains(numbersTree, 5));
    System.out.println("Return value: " + contains(numbersTree, 1));
    System.out.println("Return value: " + contains(numbersTree, 2));
    System.out.println("Return value: " + contains(numbersTree, 9));

    System.out.println("\n--- numbers tree ---");
    System.out.println("\n--- inorder ---");
    for (final var val : numbersTree.inorder()) {
      System.out.println(val.getElement());
    }
    System.out.println("\n--- preorder ---");
    for (final var val : numbersTree.preorder()) {
      System.out.println(val.getElement());
    }
    System.out.println("\n--- postorder ---");
    for (final var val : numbersTree.postorder()) {
      System.out.println(val.getElement());
    }
  }

  /**
   * Funcion que busca un numero en un arbol binario. Asume que el arbol esta
   * ordenado. Imprime el numero de intentos para dar un ejemplo. (Es parte del
   * forntend, por favor no bajar puntos por esto).
   */
  public static boolean contains(final LinkedBinaryTree<Integer> tree,
                                 final Integer element) {
    int tries = 1;
    for (var walk = tree.root(); walk.getElement() != element; tries++) {
      if (tree.isExternal(walk)) {
        System.out.println("Numero no encontrado en " + tries + " intentos.");
        return false;
      }
      if (walk.getElement() > element) {
        walk = tree.left(walk);
      } else if (walk.getElement() < element) {
        walk = tree.right(walk);
      }
    }
    System.out.println("Numero encontrado en " + tries + " intentos.");
    return true;
  }
}
