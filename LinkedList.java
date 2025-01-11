class SinglyLinkedList {

    Node head;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add First
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add Last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // Print Linked List
    public void printList() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " --> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    // Delete First
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete Last
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    // Traverse Linked List
    public void printList1() {
        Node newNode = head;
        while (newNode != null) {
            System.out.print(newNode.data + " ");
            newNode = newNode.next;
        }
        System.out.println();
    }

    // Search Linked List
    public boolean search(Node head, String x) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(x)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList LL = new SinglyLinkedList();

        LL.addFirst("is");
        LL.printList();

        LL.addLast("List");
        LL.printList();

        LL.addFirst("This");
        LL.printList();

        LL.deleteFirst();
        LL.printList();

        LL.deleteLast();
        LL.printList();

        LL.printList1();

        String searchString = "List"; // Replace with the string you want to search
        boolean found = LL.search(LL.head, searchString);

        // Print the result
        if (found) {
            System.out.println("\nThe string \"" + searchString + "\" was found in the list.");
        } else {
            System.out.println("\nThe string \"" + searchString + "\" was not found in the list.");
        }
    }
}
