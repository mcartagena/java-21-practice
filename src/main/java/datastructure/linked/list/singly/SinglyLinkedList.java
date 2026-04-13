package datastructure.linked.list.singly;

import java.util.Objects;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int nodeValue){
        Node node = new Node(nodeValue);
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertInLinkedList(int nodeValue, int location){
        Node node = new Node(nodeValue);
        if(Objects.isNull(head)){
            head = node;
            tail = node;
        } else if (location == 0){
            node.next = head;
            head = node;
        } else if (location >= size){
            tail.next = node;
            tail = node;
        } else {
            int index = 0;
            Node tempNode = head;
            while (index < location - 1){
                tempNode = tempNode.next;
                index++;
            }
            node.next = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    public void traverseSinglyLinkedList(){
        if(Objects.isNull(head)){
            System.out.println("SLL doesn't exist!");
        } else {
            Node nodeToPrint = head;
            for(int i = 0; i < size; i++){
                System.out.print(nodeToPrint.value);
                if(i != size - 1){
                    System.out.print(" -> ");
                }
                nodeToPrint = nodeToPrint.next;
            }
            System.out.println();
        }
    }

    public boolean searchSinglyLinkedList(int nodeValue){
        if(Objects.isNull(head)){
            System.out.println("SLL doesn't exist!");
        } else {
            Node nodeToSearch = head;
            for(int i = 0; i < size; i++){
                if(nodeToSearch.value == nodeValue){
                    System.out.println("Value " + nodeValue + " found in location " + i);
                    return true;
                }
                nodeToSearch = nodeToSearch.next;
            }
        }
        return false;
    }

    public void deleteOfNode(int location){
        if(Objects.isNull(head)){
            System.out.println("SLL doesn't exist!");
        } else if(location == 0){
            head = head.next;
            size--;
            if(size == 0){
                tail = null;
            }
        } else if (location >= size - 1){
            Node beforeLastNode = head;
            for(int i=0; i < size - 2; i++){
                beforeLastNode = beforeLastNode.next;
            }
            if(beforeLastNode == head){
                head = tail = null;
            } else {
                beforeLastNode.next = null;
                tail = beforeLastNode;
            }
            size--;
        } else {
            Node beforeNodeToDelete = head;
            for(int i=0; i < location - 1; i++){
                beforeNodeToDelete = beforeNodeToDelete.next;
            }
            beforeNodeToDelete.next = beforeNodeToDelete.next.next;
            size--;
        }
    }

    public void deleteSLL(){
        head = null;
        tail = null;
        size = 0;
        System.out.println("SLL had been deleted!");
    }

    /***** CODE FOR SLL ***/
    public void push(int nodeValue) {
        // From previous question
        Node node = new Node(nodeValue);
        if(Objects.isNull(head)){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }


    public Node pop() {
        // TODO
        if (Objects.isNull(tail)) {
            System.out.println("The SLL does not exist");
            return null;
        } else if(head == tail){
          Node popNode = head;
          head = tail = null;
          size = 0;
          return popNode;
        } else {
            Node nodePreviousPop = head;
            while(nodePreviousPop.next != tail) {
                nodePreviousPop = nodePreviousPop.next;
            }
            Node popNode = tail;
            tail = nodePreviousPop;
            nodePreviousPop.next = null;
            size--;
            return popNode;
        }
    }
}
