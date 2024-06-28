package models.LinkedList;

public class Nodo {
    public String value;
    public Nodo next;

    public Nodo(String value) {
        this.value = value;
        this.next = null;
    }

    public String getValue() {
        return value;
    }
    public Nodo getNext() {
    return next;
}

public void setNext(Nodo next) {
    this.next = next;
}
}


