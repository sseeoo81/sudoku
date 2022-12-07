public class Run extends Thread{

    private SudokuWriter board;
    private int time = 0;
    private int minute = 0;
    private int second = 0;
    private Time class_time;
    public Run(SudokuWriter w, Time t){
        board = w;
        class_time = t;
    }

    public void run(){
        try {
            while(true) {
                Thread.sleep(1000);
                if (board.isGameover()) { board.gameOver(time, minute, second); break; }
                time++;
                minute = time / 60;
                second = time % 60;
                class_time.timeIs(minute < 10 ? "Time : 0" + minute + ":" + (second < 10 ? "0"+second:second) : "Time : " + minute + ":" + (second < 10 ? "0"+second:second));
            }
        }
        catch(Exception e){}
    }
}
