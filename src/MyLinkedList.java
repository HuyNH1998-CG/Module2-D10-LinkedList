
public class MyLinkedList<E extends Comparable<E>> implements Cloneable {
    Node<E> head = null;
    Node<E> tail = null;
    int numNodes;

    private static class Node<E> {
        Node<E> next;
        E data;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return this.data;
        }
    }

    public MyLinkedList() {

    }

    public void add(int index, E element) {
        if (index == 0) addFirst(element);
        else if (index > numNodes) addLast(element);
        else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            Node<E> holder;
            holder = temp.next;
            temp.next = new Node<>(element);
            temp.next.next = holder;
            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        numNodes++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
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
            Node<E> temp = head;
            head = head.next;
            numNodes--;
            if (head == null) tail = null;
            return temp.data;
        }
    }

    public E removeLast() {
        if (numNodes == 0) return null;
        else if (numNodes == 1) {
            Node<E> temp = head;
            head = tail = null;
            numNodes = 0;
            return temp.data;
        } else {
            Node<E> current = head;

            for (int i = 0; i < numNodes - 2; i++)
                current = current.next;

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return temp.data;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) return null;
        else if (index == 0) return removeFirst();
        else if (index == numNodes - 1) return removeLast();
        else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            numNodes--;
            return current.data;
        }
    }

    public boolean remove(E e) {
        Node<E> prev = new Node<>(null);
        prev.next = head;
        Node<E> next = head.next;
        Node<E> temp = head;
        boolean exist = false;
        if (head.data == e){
            head = head.next;
            exist = true;
        }
        while (temp.next != null){
            if(temp.data == e){
                prev.next = next;
                exist = true;
                break;
            }
            prev = temp;
            temp = temp.next;
            next = temp.next;
        }
        if(!exist && temp.data == e){
            prev.next = null;
            exist = true;
        }
        if (exist){
            numNodes--;
        }
        return exist;
    }

    public int size() {
        return numNodes;
    }

    public E clone() throws CloneNotSupportedException {
        return (E) super.clone();
    }

    public boolean contains(Object o) {
        for (Node<E> x = head; x != null; x = x.next) {
            if (o.equals(x.data)) {
                return true;
            }

        }
        return false;
    }

    public int indexOf(E o) {
        int count = 0;
        for (Node<E> x = head; x != null; x = x.next) {
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
        Node<E> temp = head;
        for (int x = 0; x < numNodes; x++) {
            if(x == i){
                break;
            }
            temp = temp.next;
        }
        return temp.data;
    }

    public E getFirst() {
        Node<E> first = head;
        return first.data;
    }

    public E getLast() {
        Node<E> last = tail;
        return last.data;
    }

    public void clear() {
        for (Node<E> x = head; x != null; ) {
            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x = next;
        }
    }
}
