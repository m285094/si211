// Sam Pirkl

public interface BoardControl {

    public boolean isGameRunning();
    public boolean isFinished();
    public void toggleRunning();
    public void tick();
}