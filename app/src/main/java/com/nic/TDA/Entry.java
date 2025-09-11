package com.nic.TDA;

public interface Entry<K, V> {
    // returns the key stored in this entry
    K getKey();

    // returns the value stored in this entry
    V getValue();
}
