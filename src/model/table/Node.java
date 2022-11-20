package model.table;

public class Node<K, T> {
  T value;
  K key;

  int frequency;

  Node<K, T> next;
  Node<K, T> prev;

  public Node(K k, T v) {
    key = k;
    value = v;
    next = null;
    prev = null;
  }
}
