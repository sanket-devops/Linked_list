public class main {
    public static void main(String[] args) {
        MySinglyLinkedList<Integer> list = new MySinglyLinkedList<>();
        list.add(48);
        list.add(50);
        list.add(62);
        list.add(125);
        list.add(12);
        list.displayAll();

        list.remove(); // remove tail element.
        list.displayAll();

        list.deleteGT(50);
        list.displayAll();
    }
}
