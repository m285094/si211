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

    public void addToSchedule(Node L, String s, String n) {

        Section section = Section.getSection(L, s, n); //get the section
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
}