package com.slotvinskiy;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap implements MyMap {

    public static final int DEFAULT_CAPACITY = 16;
    private final double LOAD_FACTOR = 0.75;

    public MyHashMap() {
    }

    private MyHashMap(int size) {
        this.table = new Entry[size];
        this.threshold = (int) (size * LOAD_FACTOR);
    }

    private static class Entry implements MyMap.Entry {

        String key;
        String value;
        Entry next;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String setValue(String value) {
            String oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

    }

    private Entry[] table = new Entry[DEFAULT_CAPACITY];
    private int threshold = (int) (table.length * LOAD_FACTOR);
    private int size = 0;

    @Override
    public String put(String key, String value) {

        if (size > threshold) {
            resize();
        }
        Entry newEntry = new Entry(key, value);
        int index = indexFor(key);
        if (table[index] == null) {
            putEntryInEmptyIndex(newEntry, index);
            return null;
        }
        Entry currentEntry = table[index];
        while (currentEntry != null) {
            if (areEqual(key, currentEntry.key)) {
                String oldKey = currentEntry.getKey();
                currentEntry.value = value;
                return oldKey;
            }
            currentEntry = currentEntry.next;
        }
        putNewEntryInNotEmptyIndex(newEntry, index);
        return null;
    }

    private void putEntryInEmptyIndex(Entry newEntry, int index) {
        table[index] = newEntry;
        size++;
    }

    private void putNewEntryInNotEmptyIndex(Entry newEntry, int index) {
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;
    }

    private int indexFor(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private void resize() {
        MyHashMap newMap = new MyHashMap(this.table.length * 2);
        for (MyMap.Entry entry : this.entrySet()) {
            newMap.put(entry.getKey(), entry.getValue());
        }
        this.size = newMap.size;
        this.threshold = newMap.threshold;
        this.table = newMap.table;
    }

    @Override
    public String get(String key) {
        Entry temp = getEntry(key);
        if (temp != null) {
            return temp.getKey();
        } else {
            return null;
        }
    }

    @Override
    public boolean containsKey(String key) {
        if (getEntry(key) != null) {
            return true;
        } else {
            return false;
        }
    }

    private Entry getEntry(String key) {
        int index = indexFor(key);
        Entry currentEntry = table[index];
        if (currentEntry == null) {
            return null;
        }
        if (areEqual(key, currentEntry.key)) {
            return currentEntry;
        }
        while (currentEntry.next != null) {
            currentEntry = currentEntry.next;
            if (areEqual(key, currentEntry.key)) {
                return currentEntry;
            }
        }
        return null;
    }

    private boolean areEqual(String key1, String key2) {
        return key2.hashCode() == key1.hashCode() && key1.equals(key2);
    }

    @Override
    public void clear() {
        this.size = 0;
        this.table = new Entry[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String remove(String key) {
        Entry delete = getEntry(key);
        if (delete == null) {
            return null;                //если такого ключа нет
        }
        String oldValue = delete.value;
        int index = indexFor(key);
        Entry currentEntry = table[index];
        Entry previous = null;
        while (currentEntry != null) {
            if (areEqual(key, currentEntry.key)) {
                if (previous == null && currentEntry.next == null) {  //удаляемый Entry единственный в ячейке
                    oldValue = currentEntry.value;
                    table[index] = null;
                    break;
                } else if (previous == null) {                      //удаляемый Entry первый в цепочке в ячейке
                    table[index] = currentEntry.next;
                    oldValue = currentEntry.value;
                    break;
                } else {
                    previous.next = currentEntry.next;          //удаляемый Entry в середине или в конце цепочки
                    oldValue = currentEntry.value;
                    break;
                }
            }
            previous = currentEntry;
            currentEntry = currentEntry.next;
        }
        size--;
        return oldValue;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Set<MyMap.Entry> entrySet() {
        Set<MyMap.Entry> result = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            Entry tmpEntry = table[i];
            while (tmpEntry != null) {
                result.add(tmpEntry);
                tmpEntry = tmpEntry.next;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return entrySet().toString();
    }
}
