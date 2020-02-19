package com.slotvinskiy;

import java.util.Arrays;

public class MyHashSet implements MySet {

    private MyHashMap map = new MyHashMap();

    private final String PLACEHOLDER = "";

    @Override
    public boolean add(String value) {
        map.put(value, PLACEHOLDER);
        return true;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean remove(String value) {
        map.remove(value);
        return true;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean contains(String value) {
        return map.containsKey(value);
    }

    @Override
    public String[] toArray() {
        String[] temp = new String[map.size()];
        int i = 0;
        for (MyMap.Entry entry : map.entrySet()) {
            temp[i] = entry.getKey();
            i++;
        }
        return temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
