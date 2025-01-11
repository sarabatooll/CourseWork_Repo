package estate.pk;

public class CircularSinglyLinkedList {

    Node head;

    // Node class to represent each element in the circular linked list
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add First - Insert a node at the beginning of the list
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular link (points to itself)
        } else {
            Node temp = head;
            while (temp.next != head) { // Traverse to the last node
                temp = temp.next;
            }
            temp.next = newNode; // Last node points to the new node
            newNode.next = head; // New node points to the head
            head = newNode; // Update the head to the new node
        }
    }

    // Add Last - Insert a node at the end of the list
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular link (points to itself)
        } else {
            Node currNode = head;
            while (currNode.next != head) { // Traverse to the last node
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.next = head; // New node points to the head
        }
    }

    // Print List - Traverse and print the elements of the circular linked list
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node currNode = head;
        do {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        } while (currNode != head); // Stop when we reach the head again
        System.out.println("HEAD");
    }

    // Delete First - Delete the node at the beginning of the list
    public void deleteFirst() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.next == head) { // Only one node in the list
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) { // Traverse to the last node
                temp = temp.next;
            }
            head = head.next; // Update head to the next node
            temp.next = head; // Last node points to the new head
        }
    }

    // Delete Last - Delete the node at the end of the list
    public void deleteLast() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.next == head) { // Only one node in the list
            head = null;
            return;
        }
        Node secondLast = head;
        while (secondLast.next.next != head) { // Traverse to the second last node
            secondLast = secondLast.next;
        }
        secondLast.next = head; // Bypass the last node
    }

    // Main method to test the Circular Singly Linked List
    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();

        // Add elements to the list
        list.addFirst("is");
        list.printList();

        list.addLast("List");
        list.printList();

        list.addFirst("This");
        list.printList();

        // Delete elements from the list
        list.deleteFirst();
        list.printList();

        list.deleteLast();
        list.printList();
    }
}
