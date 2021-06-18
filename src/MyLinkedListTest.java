public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("TESTING");
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("B");

        list.add(4, "9");
        list.add(4, "9");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
    }
}
