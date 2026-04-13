package datastructure.linked.list.singly;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();
        Node head = sLL.createSinglyLinkedList(5);

        // System.out.println("Head " + sLL.head.value);

        sLL.insertInLinkedList(6, 1);
        sLL.insertInLinkedList(7, 3);
        sLL.insertInLinkedList(8, 4);
        sLL.insertInLinkedList(9, 0);

        // System.out.println("Head " + sLL.head.value + " size " + sLL.size + " tail " + sLL.head.next.next.value + " " + sLL.tail.value);
        sLL.traverseSinglyLinkedList();
        sLL.searchSinglyLinkedList(6);
        System.out.println("Deleting node 4...");
        sLL.deleteOfNode(4);
        System.out.println("Tail value-> " + sLL.tail.value);
        sLL.traverseSinglyLinkedList();
        System.out.println("Deleting node 2...");
        sLL.deleteOfNode(2);
        sLL.traverseSinglyLinkedList();
        System.out.println("Deleting node 0...");
        sLL.deleteOfNode(0);
        sLL.traverseSinglyLinkedList();
        sLL.deleteSLL();
        sLL.traverseSinglyLinkedList();


        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.push(5);
        singlyLinkedList.push(10);
        singlyLinkedList.traverseSinglyLinkedList();

        System.out.println(singlyLinkedList.pop().value); // 10
        System.out.println(singlyLinkedList.tail.value);  // 5
        System.out.println(singlyLinkedList.size);   // 1
        System.out.println(singlyLinkedList.pop().value); // 5
        System.out.println(singlyLinkedList.size);   // 0
        System.out.println(singlyLinkedList.pop());   // The SLL does not exist
    }
}
