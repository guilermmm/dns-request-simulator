package model.table;

public class MyHashTable<K, T> {
  int size;
  MyLinkedList<K, T>[] table;

  public MyHashTable(int s) {
    size = s;
    table = new MyLinkedList[size];
  }

  public int hash(K key) {
    // h(s)=s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
    int hash = key.hashCode() % size;
    return hash < 0 ? hash * -1 : hash;
  }

  public void insert(K key, T value) {
    if (value == null)
      throw new IllegalArgumentException("Value cannot be null");

    int index = hash(key);

    if (table[index] == null) {
      table[index] = new MyLinkedList<K, T>();
    }
    table[index].insert(key, value);
  }

  public T search(K key) {
    int index = hash(key);

    if (table[index] == null) {
      return null;
    }

    return table[index].search(key);
  }

  public void delete(K key) {
    int index = hash(key);
    if (table[index] != null) {
      table[index].delete(key);
    }
  }

  public void print() {
    for (int index = 0; index < size; index++) {
      if (table[index] != null) {
        table[index].print();
      }
    }
  }
}
