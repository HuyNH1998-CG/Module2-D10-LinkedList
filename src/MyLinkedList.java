
public class MyLinkedList<E> implements Cloneable {
    Node head = null;
    Node tail = null;
    int numNodes;

    private static class Node {
        Node next;
        Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public MyLinkedList() {

    }

    public void add(int index, E element) {
        if (index == 0) addFirst(element);
        else if (index > numNodes) addLast(element);
        else {
            Node temp = head;
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            Node holder;
            holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        numNodes++;
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        if (tail == null) {
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        numNodes++;
    }

    public E removeFirst() {
        if (numNodes == 0) return null;
        else {
            Node temp = head;
            head = head.next;
            numNodes--;
            if (head == null) tail = null;
            return (E) temp.data;
        }
    }

    public E removeLast() {
        if (numNodes == 0) return null;
        else if (numNodes == 1) {
            Node temp = head;
            head = tail = null;
            numNodes = 0;
            return (E) temp.data;
        } else {
            Node current = head;

            for (int i = 0; i < numNodes - 2; i++)
                current = current.next;

            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return (E) temp.data;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) return null;
        else if (index == 0) return removeFirst();
        else if (index == numNodes - 1) return removeLast();
        else {
            Node previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return (E) current.data;
        }
    }

    public boolean remove(Node e) {
        if (e == null) {
            for (Node x = head; x != null; x = x.next) {
                if (x.data == null) {
                    remove(x);
                    return true;
                }
            }
        } else {
            for (Node x = head; x != null; x = x.next) {
                if (e.equals(x.data)) {
                    remove(x);
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public E clone() throws CloneNotSupportedException {
        return (E) super.clone();
    }

    public boolean contains(Object o) {
        for (Node x = head; x != null; x = x.next) {
            if (o.equals(x.data)) {
                return true;
            }

        }
        return false;
    }

    public int indexOf(E o) {
        int count = 0;
        for (Node x = head; x != null; x = x.next) {
            if (o.equals(x.data)) {
                count++;
                break;
            }
            count++;
        }
        return count;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public E get(int i) {
        Node temp = head;
        for (int x = 0; x < numNodes; x++) {
            if(x == i){
                break;
            }
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        Node first = head;
        return (E) first.data;
    }

    public E getLast() {
        Node last = tail;
        return (E) last.data;
    }

    public void clear() {
        for (Node x = head; x != null; ) {
            Node next = x.next;
            x.data = null;
            x.next = null;
            x = next;
        }
    }
}
