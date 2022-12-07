import java.awt.event.*;
import javax.swing.*;

public class SudokuButton extends JButton implements ActionListener{
	
	private Sudoku sudoku;
	private SudokuWriter writer;
	private boolean selected = false;
	
	public SudokuButton(Sudoku s, SudokuWriter w) {
		sudoku = s; writer = w;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(getText() == "") {
			selected = true;
			sudoku.selectButton(writer.buttonBoardReturn(), this);
			sudoku.saveCoordinate(sudoku.findSelected(writer.buttonBoardReturn()));
		}
		else {
			selected = false;
			sudoku.initCoordinateX();
			sudoku.initCoordinateY();
		}
	}
	
	public boolean selected() {
		return selected;
	}
	
	public void unselect() {
		selected = false;
	}

}
