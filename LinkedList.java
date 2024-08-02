//Bradley Mogere - 134005: My comments are fun filled and highlight each section.
// I hope that will not take marks away, enjoy!

public class LinkedList {
    private static class Node {
        int data;
        Node next;

        // This here is a Constuctor to create a new node.
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // This is me initialising a new linked list.
    public LinkedList() {
        this.head = null;
    }

    // Guess what this is? A method to insert a node with its data set :)
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public void delete(int data) {
        if (head == null) return;

        // Like me, this is a special case lol.
        // In all seriousness it is a special case deleting the head node :)
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Woooaaahhh, okay back to work. 
        // If the node to be deleted is found
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // And here we search for a node with the given data
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    // Have you ever heard of Method Man? Well this is a...
    // Method to print all nodes in the linked list
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Now that you have heard of Method man this is the...
    //Main method to test the LinkedList class
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // The following will show Test Inserstion/Traversal/search
        // Test insertion
        list.insert(99);
        list.insert(8);
        list.insert(46);

        // Test traversal
        System.out.println("List after insertions:");
        list.traverse();

        // Test search
        System.out.println("Searching for 8: " + list.search(20));
        System.out.println("Searching for 40: " + list.search(40));

        // Test deletion
        list.delete(8);
        System.out.println("List after deleting 8:");
        list.traverse();

        list.delete(99);
        System.out.println("List after deleting 99:");
        list.traverse();

        list.delete(46);
        System.out.println("List after deleting 46:" + list.search(46));
        list.traverse();
    }
}
