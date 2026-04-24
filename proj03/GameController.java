// Sam Pirkl

public class GameController implements BoardControl { //, GameActions {

    private TimerThread tt;
    private Timer t;
    private boolean started, running, finished;
    private BoardPanel p;
    public GameController() {
        this.started = this.running = this.finished = false;
        // this.p = p;
        tt = new TimerThread(this);
        tt.start();

        t = new Timer();
    }

    public void setPanel(BoardPanel p) {
        this.p = p;
    }

    public boolean isGameRunning() { return running; }
    public boolean isFinished() { return finished; }

    public void toggleRunning() {
        running = !running;
    }

    public void gameWon() {
        running = false;
        finished = true;
        p.showWin();
    }
    public void tick() {
        t.incTime();
        p.setFormatTime(t.getMM(), t.getSS());
    }

    // public void toggleMode() {
    //     toggleRunning();

    //     if(running) p.setRunningText();
    //     else p.setPausedText();
    // }

    // public void exitGame() {
    //     System.exit(0);
    // }
}