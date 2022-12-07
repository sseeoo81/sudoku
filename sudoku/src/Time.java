import javax.swing.*;

public class Time extends JLabel {

    private SudokuWriter board;
    private Run r;
    public Time(SudokuWriter w){
        board = w;
        r = new Run(board, this);
        r.start();
    }

    public void timeIs(String time){
        setText(time);
    }


}
