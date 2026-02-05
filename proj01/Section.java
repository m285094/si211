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
}