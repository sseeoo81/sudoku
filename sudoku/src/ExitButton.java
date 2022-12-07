import javax.swing.*;
import java.awt.event.*;

public class ExitButton extends JButton implements ActionListener {

    private SudokuWriter board;
    public ExitButton(SudokuWriter w) {
        board = w;
        setText("게임 종료");
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        //창 닫고 메인 화면으로 전환
        board.sudokuExit();
    }
}
