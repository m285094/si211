// Sam Pirkl

public class NodeList {

    private class Node {
        public Section data;
        public Node next;
        public Node(Section s, Node n) {
            data = s;
            next = n;
        }
    }

    private Node L;
    public NodeList() {
        L = null;
    }

    public void addToBack(Section s) {
        
        Node temp = new Node(s, null); //create new node to be added
        if(L == null) //if list is empty, just return the new node
            L = temp;
        else {
            Node p = L; 
            while(p.next != null) //get to the end of the list
                p = p.next;

            p.next = temp; //end of list now points to new node
        }
    }

    public void printNodes(String s) {

        //loop through list of nodes
        for(Node p = L; p != null; p = p.next) {
            if(s.equals(p.data.getName())) //print if it matches target
                System.out.println(p.data);
        }
    }

    public Section getNode(String s, String n) {

        for(Node p = L; p != null; p = p.next) {
            if(s.equals(p.data.getName()) && n.equals(p.data.getID()))
                return p.data; //returns true if course name and id are in there
        }

        return null; //returns null if doesn't exist
    }

    private int listLength() {

        int count = 0; //loop through until points to null
        for(Node p = L; p != null; p = p.next)
            count++; //increment every time to find length

        return count;
    }

    public int findNumOccurences(String s) {

        if(s.equals("any")) //if word is any, return nodelist length
            return listLength();

        int count = 0; //otherwise count how many match the course name
        for(Node p = L; p != null; p = p.next)
            if(s.equals(p.data.getName())) count++;

        return count;
    }

    public Section[] getData(String s, int n) {

        Section[] data = new Section[n];
        int index = 0; 
        for(Node p = L; p != null; p = p.next) { //loop through nodelist

            //if they want any, add all, but only add target course names
            if(s.equals("any") || s.equals(p.data.getName())) 
                data[index++] = p.data;
        }

        return data;
    }
}