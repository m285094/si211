// Sam Pirkl

public class Section {

    //private vars and constructor
    private String name, id, time, loc;
    public Section(String name, String id, String time, String loc) {
        this.name = name;
        this.id = id;
        this.time = time;
        this.loc = loc;
    }

    public String getName() { return name; }
    public String getID() { return id; }
    public String getTime() { return time; }

    //print section in proper format
    public String toString() { return name + " " + id + " " + time + " " + loc; }

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