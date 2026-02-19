public class Schedule {

    private Section[] schedule;
    private int count;
    private Week week;
    public Schedule() {
        schedule = new Section[10]; //schedule allowing ten classes
        count = 0;
        week = new Week(); //each schedule has its own week grid
    }

    public Week getWeek() { return week; }

    public void addToSchedule(NodeList L, String s, String n) {

        Section section = L.getNode(s, n); //get the section
        if(section == null) { //check if exists
            System.out.println("Error! Section not found!");
            return; //quits if it doesn't
        }

        schedule[count++] = section; //adds it to the schedule if it does
        week.buildWeek(section.getTime()); //add it to the grid
    }

    public void printSchedule() {

        for(int i = 0; i < count; i++) //loop through and print the sections
            System.out.println(schedule[i]);
    }

    public boolean isInSchedule(String s) {

        for(int i = 0; i < count; i++) { //loop through sections in schedule

            if(s.equals(schedule[i].getName())) //returns true if match
                return true;
        }

        return false; //false if course not in schedule
    }   
}