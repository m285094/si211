// Sam Pirkl

public class Timer {

    private int seconds;
    public Timer() {
        seconds = 0;
    }

    public void incTime() { seconds++; }
    public int getMM() { return seconds/60; }
    public int getSS() { return seconds%60; }
}