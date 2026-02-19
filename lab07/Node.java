public class Node
{
    private Thing data;
    private Node next;
    public Node(Thing data, Node next) {
        this.data = data;
        this.next = next;
    }

    public static void printNodes(Node head) {

        // print out each thing
        for(Node T = head; T != null; T = T.next)
            System.out.println(T.data.getRow() + " " + 
                    T.data.getCol() + " " + 
                    T.data.getLab());
        System.out.println("done");
        System.out.flush();
    } 
}