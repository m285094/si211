import java.util.*;

public class Lab07b {

    // public class Node
    // {
    //     private Thing data;
    //     private Node next;
    //     public Node(Thing data, Node next) {
    //         this.data = data;
    //         this.next = next;
    //     }

    //     public Thing getData() { return data; }

    //     public void printNodes(Node head) {

    //         // print out each thing
    //         for(Node T = head; T != null; T = T.next)
    //             System.out.println(T.data.getRow() + " " + 
    //                     T.data.getCol() + " " + 
    //                     T.data.getLab());
    //         System.out.println("done");
    //         System.out.flush();
    //     }
    // }

    public static void main(String[] args) {
        int N = 200;
        if (args.length != 0) N = Integer.parseInt(args[0]);

        ThingList L = new ThingList();
        int count = 0;
        while(true)
        {
            // every N rounds add another typeA and typeB Thing
            if (count % N == 0)
            {
                // add a typeA thing to the list
                // Thing tA = new Thing(); 
                // tA.row = 45;
                // tA.col = 50;
                // Node nA = new Node(); 
                // nA.data = tA;
                // nA.next = L;
                // Node nA = new Node(tA, L);
                // L = nA;
                L.addToList(new Thing(45, 50));

                // add a typeB thing to the list
                // tB.row = 55;
                // tB.col = 50;
                // tB.lab = 'b';
                // tB.isTypeB = true;
                // Node nB = new Node(); 
                // nB.data = tB;
                // nB.next = L;
                // Node nB = new Node(tB, L);
                // L = nB;
                L.addToList(new ThingB(55, 50, 'b'));
            }

            L.printList();

            // // move each thing
            // for(Node T = L; T != null; T = T.next)
            // {
            //     T.getData().maybeTurn();
            //     T.getData().step();
            // } 
            L.moveThings();

            count++;
        }
    }
}