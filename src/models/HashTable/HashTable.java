package models.HashTable;
import models.LinkedList.LinkedList;
import models.LinkedList.Nodo;


public class HashTable {
    private LinkedList[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList();
        }
    }

    public int hashDivision(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public int hashMultiplication(String key) {
        double A = 0.618;
        double hashValue = key.hashCode() * A;
        double fracPart = hashValue - Math.floor(hashValue);
        return (int) Math.floor(size * fracPart);
    }

    public void addDivision(String key, String value) {
        int index = hashDivision(key);
        table[index].add(value);
    }

    public void addMultiplicacion(String key, String value) {
        int index = hashMultiplication(key);
        table[index].add(value);
    }
    
    public boolean searchByNameUsingMultiplication(String name) {
    int index = hashMultiplication(name);
    LinkedList list = table[index];
    Nodo current = list.getHead(); 

    while (current != null) {
        String value = current.getValue(); 
        if (value.contains("Name=" + name)) {
            System.out.println("Información asociada al nombre '" + name + "' (usando hash por multiplicación):");
            System.out.println(value);
            return true;
        }
        current = current.getNext(); 
    }
    return false;
}
    public boolean searchByNameUsingDivision(String name) {
        int index = hashDivision(name);
        String result = table[index].buscar(name);
        if (result != null) {
            System.out.println("Información asociada al nombre '" + name + "' (usando hash por división):");
            System.out.println(result);
            return true;
        }
        return false;
    }

    public LinkedList[] getTable() {
        return table;
    }
}
