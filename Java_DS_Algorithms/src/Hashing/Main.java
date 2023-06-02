package Hashing;

public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable(7);
        ht.set("nails", 100);
        ht.set("tile", 50);
        ht.set("lumber", 80);
        ht.set("paint", 150);
        ht.set("ball", 75);
        ht.set("bolt", 175);
        ht.set("screw", 500);
        ht.set("washers", 180);
        ht.set("ampules", 30);
        ht.printTable();

        System.out.println(ht.get("nails"));
        System.out.println(ht.get("car"));
        System.out.println(ht.keys());
    }
}
