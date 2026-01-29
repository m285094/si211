public class Queue {

    private Node head;
    private Node tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public void enqueue(String s) {
        Node temp = new Node(s, null);
        if(this.empty()) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public String dequeue() {
        if(head.next == null) {
            head = null;
            return "";
        }

        String s = head.data;
        head = head.next;
        return s;
    }

    public boolean empty() {
        return head == null && tail == null;
    }
}