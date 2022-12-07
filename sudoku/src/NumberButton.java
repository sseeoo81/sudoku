import java.awt.event.*;
import javax.swing.*;

public class NumberButton extends JButton implements ActionListener{
	
	private Sudoku sudoku;
	private SudokuWriter writer;
	
	public NumberButton(Sudoku s, SudokuWriter w) {
		sudoku = s; writer = w;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(getText()!="") {
			int number = Integer.parseInt(getText());
			if(sudoku.check(number, sudoku.coordinateX(), sudoku.coordinateY())) {
				writer.update();
				sudoku.countPlusNum(number-1);
				writer.updateNum();
			}
		}
	}
	
	
}
