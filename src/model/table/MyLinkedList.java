package model.table;

import terminal.Terminal;
import terminal.Terminal.Color;

public class MyLinkedList<K, T> {
  Node<K, T> first;

  public MyLinkedList() {
    first = null;
  }

  public void rebalanceFrequency(Node<K, T> node) {
    if (node != null && node.prev != null && node.prev.frequency < node.frequency) {
      swapNodes(node.prev, node);
      rebalanceFrequency(node.prev);
    }
  }

  public void swapNodes(Node<K, T> firstNode, Node<K, T> secondNode) {
    Node<K, T> temp = firstNode.prev;
    firstNode.prev = secondNode.prev;
    secondNode.prev = temp;
    temp = firstNode.next;
    firstNode.next = secondNode.next;
    secondNode.next = temp;
  }

  public void insert(K key, T value) {
    Node<K, T> newNode = new Node<K, T>(key, value);

    if (first == null) {
      first = newNode;

    } else {
      Node<K, T> current = first;

      if (current.key == key) {
        current.value = value;
        return;
      }

      while (current.next != null) {
        if (current.key == key) {
          current.value = value;
          return;
        }
        current = current.next;
      }

      current.next = newNode;
      newNode.prev = current;
    }
  }

  public T search(K key) {
    return search(first, key).value;
  }

  public Node<K, T> search(Node<K, T> firstNode, K key) {

    for (Node<K, T> curr = firstNode; curr != null; curr = curr.next) {
      if (curr.key.equals(key)) {
        curr.frequency++;
        rebalanceFrequency(curr);
        return curr;
      }
    }
    return new Node<K, T>(null, null);
  }

  public void delete(K key) {
    Node<K, T> current = first;
    Node<K, T> prev = null;
    while (current != null) {
      if (current.key == key) {
        if (prev == null) {
          first = current.next;
        } else {
          prev.next = current.next;
        }
      }
      prev = current;
      current = current.next;
    }
  }

  public void print() {
    Node<K, T> current = first;
    while (current != null) {
      Terminal.println(Color.CYAN_BRIGHT, current.key + " " + current.value);
      current = current.next;
    }
  }
}
