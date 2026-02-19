public class ThingList {

    private class Node
    {
        private Thing data;
        private Node next;
        public Node(Thing data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head, tail;
    public ThingList() {
        this.head = null;
        this.tail = null;
    } 

    public void printList() {

        for(Node T = head; T != null; T = T.next) {
                    System.out.println(T.data.getRow() + " " + 
                    T.data.getCol() + " " + 
                    T.data.getLab());
        }
        System.out.println("done");
        System.out.flush();
    }

    public void addToList(Thing t) {

        if(head == null) head = tail = new Node(t, head);
        else {
            tail.next = new Node(t, null);
            tail = tail.next;
        }
    }

    public void moveThings() {

        for(Node T = head; T != null; T = T.next)
        {
            T.data.maybeTurn();
            T.data.step();
        }  
    }
}