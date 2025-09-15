package com.nic.TDA;

public class DoublyLinkedList<E> {
    public static class DLLNode<E> {
        // reference to the element stored at this node
        private final E element;
        // reference to the previous node in the list
        private DLLNode<E> prev;
        // reference to the subsequent node in the list
        private DLLNode<E> next;

        public DLLNode(final E e, final DLLNode<E> p, final DLLNode<E> n) {
            this.element = e;
            this.prev = p;
            this.next = n;
        }

        public E getElement() {
            return element;
        }

        public DLLNode<E> getPrev() {
            return prev;
        }

        public DLLNode<E> getNext() {
            return next;
        }

        public void setPrev(final DLLNode<E> p) {
            prev = p;
        }

        public void setNext(final DLLNode<E> n) {
            next = n;
        }
    }// ----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    // header sentinel
    private final DLLNode<E> header;
    // trailer sentinel
    private final DLLNode<E> trailer;
    private int size = 0;

    /**
     * Constructs a new empty list.
     */
    public DoublyLinkedList() {
        // create header
        this.header = new DLLNode<>(null, null, null);
        // trailer is preceded by header
        this.trailer = new DLLNode<>(null, header, null);
        // header is followed by trailer
        this.header.setNext(trailer);
    }

    /**
     * Returns the number of elements in the linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list.
     */
    public E first() {
        if (isEmpty())
            return null;
        return header.getNext().getElement();
        // first element is beyond header
    }

    /**
     * Returns (but does not remove) the last element of the list.
     */
    public E last() {
        if (isEmpty())
            return null;
        return trailer.getPrev().getElement();
        // last element is before trailer
    }

    // public update methods
    /** Adds element e to the front of the list. */
    public void addFirst(final E e) {
        addBetween(e, header, header.getNext());
        // place just after the header
    }

    /** Adds element e to the end of the list. */
    public void addLast(final E e) {
        addBetween(e, trailer.getPrev(), trailer);
        // place just before the trailer
    }

    /** Removes and returns the first element of the list. */
    public E removeFirst() {
        if (isEmpty())
            return null;
        // nothing to remove
        return remove(header.getNext());
        // first element is beyond header
    }

    /** Removes and returns the last element of the list. */
    public E removeLast() {
        if (isEmpty())
            return null;
        // nothing to remove
        return remove(trailer.getPrev());
        // last element is before trailer
    }

    // private update methods
    /** Adds element e to the linked list in between the given nodes. */
    public void addBetween(final E e, final DLLNode<E> predecessor, final DLLNode<E> successor) {
        // create and link a new node
        final DLLNode<E> newest = new DLLNode<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /** Removes the given node from the list and returns its element. */
    public E remove(final DLLNode<E> node) {
        final DLLNode<E> predecessor = node.getPrev();
        final DLLNode<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public DLLNode<E> search(final E element) {
        var walk = this.header.getNext();
        while (walk != null) {
            if (walk.getElement() == element) {
                return walk;
            }
            walk = walk.getNext();
        }
        return null;
    }
}
