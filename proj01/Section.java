// Sam Pirkl

public class Section {

    //private vars and constructor
    private String name, number, time1, time2;
    public Section(String name, String number, String time1, String time2) {
        this.name = name;
        this.number = number;
        this.time1 = time1;
        this.time2 = time2;
    }

    //print section in proper format
    public String toString() { return name + " " + number + " " + time1 + " " + time2; }

    public static void printSections(Section[] sections, String s) {

        //loop through array of sections
        for(int i = 0; i < sections.length; i++) {
            if(s.equals(sections[i].getName())) //print if it matches target
                System.out.println(sections[i]);
        }
    }

    public String getName() { return name; }
}