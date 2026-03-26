// Sam Pirkl and Sean Beckford

public class ThingList {

    // nodes for only the thing class
    private class Node
    {
        private Thing data; // each node has a thing object
        private Node next; // and pointer to another
        public Node(Thing data, Node next) {
            this.data = data; 
            this.next = next;
        }
    }

    private Node head, tail; // head and tail for thinglist
    public ThingList() {
        this.head = null; // start off null for both
        this.tail = null;
    } 

    public void printThings() {

        // loop through nodes in list and print their data
        for(Node T = head; T != null; T = T.next) { 
                    System.out.println(T.data.getRow() + " " + 
                    T.data.getCol() + " " + 
                    T.data.getLab());
        }
        System.out.println("done");
        System.out.flush();
    }

    public void addToList(Thing t) {

        // if the list is empty, head and tail point to new node
        if(head == null) head = tail = new Node(t, null);
        else { // if the list has nodes, current tail points to new node
            tail.next = new Node(t, null);
            tail = tail.next; // new node is new tail
        }
    }

    public void moveThings() {

        // loop through nodes
        for(Node T = head; T != null; T = T.next)
        {
            T.data.maybeTurn(); // turn each node
            T.data.step(); // step each node
        }  
    }
}