// Sam Pirkl

public class NodeList {

    public static Node addToBack(Node L, Section s) {
        Node temp = new Node(s, null); //create new node to be added
        // temp.data = s; //data is the new section
        // temp.next = null; //points to nothing because is at back

        if(L == null) //if list is empty, just return the new node
            return temp;
        
        Node p = L; 
        while(p.next != null) //get to the end of the list
            p = p.next;

        p.next = temp; //end of list now points to new node
        return L;
    }
}