package com.abvarun226.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by bharghav on 1/27/15.
 */

class MyEntry<K,V> {
    private final K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}

class MyMap<K,V> {
    private int size;
    private int DEFAULT_CAPACITY = 16;

    private MyEntry<K,V>[] values = new MyEntry[DEFAULT_CAPACITY];

    public V get(K key) {
        for (int i=0 ; i<size ; i++){
            if(values[i] != null) {
                if(values[i].getKey().equals(key))
                    return values[i].getValue();
            }
        }
        return null;
    }

    public void put(K key, V value) {
        boolean insert = true;
        for(int i=0 ; i<size ; i++) {
            if(values[i].getKey().equals(key)) {
                values[i].setValue(value);
                insert = false;
            }
        }
        if(insert) {
            ensureCapa();
            values[size++] = new MyEntry<K, V>(key, value);
        }
    }

    private void ensureCapa() {
        if(size == values.length) {
            int newSize = values.length * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }

    public int size() {
        return size;
    }

    public void remove(K key) {
        for (int i=0 ; i<size ; i++) {
            if (values[i].getKey().equals(key)) {
                values[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }

    private void condenseArray(int start) {
        for (int i=start ; i<size ; i++) {
            values[i] = values[i+1];
        }
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (int i=0 ; i<size ; i++) {
            set.add(values[i].getKey());
        }
        return set;
    }
}

public class MyMapTest {
    public static void main(String... args) {
        MyMap<String,Integer> map = new MyMap<String, Integer>();
        map.put("lars", 1);
        map.put("lars", 2);
        map.put("lars", 1);

        assertEquals(map.get("lars"), new Integer(1));

        for (int i=0 ; i<100 ; i++) {
            map.put(String.valueOf(i), i);
        }

        assertEquals(map.size(), 101);

        System.out.println("Map key : 51 , value : " + map.get("51"));
        assertEquals(map.get("51"), new Integer(51));

        Set<String> ss = map.keySet();
        for(String temp : ss) {
            System.out.println("Map key : " + temp + " , value : " + map.get(temp));
        }

    }
}
