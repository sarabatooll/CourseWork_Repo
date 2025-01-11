package estate.pk;

public class CircularDoublyLinkedList {

    Node head;

    // Node class to represent each element in the circular doubly linked list
    class Node {
        String data;
        Node next;
        Node prev;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Add First - Insert a node at the beginning of the list
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;  // Circular link (points to itself)
            newNode.prev = head;  // Circular link (points to itself)
        } else {
            Node lastNode = head.prev; // Get the last node
            newNode.next = head; // New node points to current head
            newNode.prev = lastNode; // New node's prev points to the last node
            lastNode.next = newNode; // Last node points to the new node
            head.prev = newNode; // Current head's prev points to the new node
            head = newNode; // Update head to the new node
        }
    }

    // Add Last - Insert a node at the end of the list
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;  // Circular link (points to itself)
            newNode.prev = head;  // Circular link (points to itself)
        } else {
            Node lastNode = head.prev; // Get the last node
            lastNode.next = newNode; // Last node points to the new node
            newNode.prev = lastNode; // New node's prev points to the last node
            newNode.next = head; // New node points to the head
            head.prev = newNode; // Head's prev points to the new node
        }
    }

    // Print List - Traverse and print the elements of the circular doubly linked list
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node currNode = head;
        do {
            System.out.print(currNode.data + " <--> ");
            currNode = currNode.next;
        } while (currNode != head);  // Stop when we reach the head again
        System.out.println("(HEAD)");
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
            Node lastNode = head.prev; // Get the last node
            head = head.next; // Update head to the next node
            head.prev = lastNode; // Update new head's prev
            lastNode.next = head; // Update last node's next
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
        } else {
            Node lastNode = head.prev; // Get the last node
            Node secondLast = lastNode.prev; // Get the second last node
            secondLast.next = head; // Update second last node's next to head
            head.prev = secondLast; // Update head's prev to second last node
        }
    }

    // Main method to test the Circular Doubly Linked List
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

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
