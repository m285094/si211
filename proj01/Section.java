// Sam Pirkl

public class Section {

    //private vars and constructor
    private String name, id, time1, time2;
    public Section(String name, String id, String time1, String time2) {
        this.name = name;
        this.id = id;
        this.time1 = time1;
        this.time2 = time2;
    }

    public String getName() { return name; }
    public String getID() { return id; }

    //print section in proper format
    public String toString() { return name + " " + id + " " + time1 + " " + time2; }

    public static void printSections(Node L, String s) {

        //loop through list of sections
        for(Node p = L; p != null; p = p.next) {
            if(s.equals(p.data.getName())) //print if it matches target
                System.out.println(p.data);
        }
    }

    public static Section getSection(Node L, String s, String n) {

        for(Node p = L; p != null; p = p.next) {
            if(s.equals(p.data.getName()) && n.equals(p.data.getID()))
                return p.data; //returns true if course name and id are in there
        }

        return null; //returns null if doesn't exist
    }
}