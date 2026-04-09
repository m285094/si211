// Sam Pirkl

public class Countdown {

    private int time;
    public Countdown(int start) {
        this.time = start;
    }

    // methods to get the current time and decrease it
    public int getTime() { return time; }
    public void decTime() { time--; }
}