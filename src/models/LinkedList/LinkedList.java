package models.LinkedList;

public class LinkedList {
    private Nodo head;

    public LinkedList() {
        this.head = null;
    }

    public void add(String value) {
        Nodo newNode = new Nodo(value);
        if (head == null) {
            head = newNode;
        } else {
            Nodo current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean contains(String value) {
        Nodo current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public String buscar(String name) {
        Nodo current = head;
        while (current != null) {
            if (current.value.contains("Name=" + name)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public Nodo getHead() {
        return head;
    }
}
