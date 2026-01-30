// Sam Pirkl

public class Queue {

    //private class for the node
    private static class Node {
        public String data;
        public Node next;
        public Node(String d, Node n) { 
            data = d; 
            next = n;
        }
    }

    private Node head;
    private Node tail;
    public Queue() { //initialize the queue with nothing in it
        head = null;
        tail = null;
    }

    public void enqueue(String s) {

        //new node to be added to back of queue
        Node temp = new Node(s, null); //null pointer bc its at end
        if(this.empty()) { //if queue is empty
            head = temp; //head and tail point to new node 
            tail = temp;
        } else {
            tail.next = temp; //node at tail points to new node
            tail = temp; //tail now points to that new node
        }
    }

    public String dequeue() {
        if(this.empty()) //if the queue is empty return nothing
            return "";

        String s = head.data; //otherwise get the string at front of queue
        if(head.next == null) { //if there's one item left in queue
            head = null; //nullify head and tail
            tail = null;
            return s; //return last string
        }

        head = head.next; //point to next node if there is one
        return s; //return popped string
    }

    public boolean empty() { //checks if node list is empty
        return head == null && tail == null;
    }
}