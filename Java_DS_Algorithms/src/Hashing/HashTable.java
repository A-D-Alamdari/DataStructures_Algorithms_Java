package Hashing;

import java.util.ArrayList;

public class HashTable {
    private int size;
    private Node[] dataMap;

    public HashTable(int size) {
        this.size = size;
        dataMap = new Node[size];
    }

    public void set(String key, int data) {
        int index = hash(key);
        Node newNode = new Node(key, data);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }


    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.getKey() == key) {
                return temp.getData();
            }
            temp = temp.getNext();
        }
        return -1;
    }


    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.getKey());
                temp = temp.getNext();
            }
        }
        return allKeys;
    }


    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }


    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ": ");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("  {" + temp.getKey() + " = " + temp.getData() + "}");
                temp = temp.getNext();
            }
        }
    }


}
