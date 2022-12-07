import java.awt.*;
import javax.swing.*;

public class SudokuWriter extends JFrame {

    private Sudoku sudoku;
    private SudokuButton[][] button_board;
    private NumberButton[] numbers;
    
    private int[] count_number;
    
    private boolean gameover = false;
    
    private final int SIZE = 550;

    public SudokuWriter(Sudoku s) {
        sudoku = s;
        button_board = new SudokuButton[9][9];
        numbers = new NumberButton[9];
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        //p1 : 시간
        JPanel p1 = new JPanel(new FlowLayout());
        JLabel time = new Time(this);
        p1.add(time);

        //p2 : 스도쿠보드
        JPanel p2 = new JPanel(new GridLayout(11, 1));
        for(int i=0; i<9; i++) {
            JPanel p2_board = new JPanel(new GridLayout(1, 9));
        	for(int j=0; j<9; j++) {
        		button_board[i][j] = new SudokuButton(sudoku, this);
        		p2_board.add(button_board[i][j]);
        	}
            p2.add(p2_board);
        }
        JLabel div_lin = new JLabel();
        div_lin.setText("===================================");
        p2.add(div_lin);

        JPanel p2_num = new JPanel(new GridLayout(1, 9));
        for(int i=0; i<9; i++) {
            numbers[i] = new NumberButton(sudoku, this);
            p2_num.add(numbers[i]);
        }
        p2.add(p2_num);


        //p3 : 게임 종료 버튼
        JPanel p3 = new JPanel(new GridLayout(1, 5));
        p3.add(new ExitButton(this));
        for(int i=0; i<5; i++) {
            p3.add(new JLabel());
        }

        //좌우 빈 공간
        JLabel west = new JLabel();
        west.setText("                        ");
        JLabel east = new JLabel();
        east.setText("                        ");

        cp.add(p1, BorderLayout.NORTH);
        cp.add(p2, BorderLayout.CENTER);
        cp.add(p3, BorderLayout.SOUTH);
        //cp.add(p4, BorderLayout.SOUTH);
        cp.add(west, BorderLayout.EAST);
        cp.add(east, BorderLayout.WEST);
        update();
        updateNum();
        setTitle("Sudoku");
        setSize(SIZE, SIZE-60);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public void update() {
    	int puzzle_board[][] = sudoku.getPuzzleBoard();
    	int num;
    	for(int i=0; i<9; i++) {
    		for(int j=0; j<9; j++) {
    			num = puzzle_board[i][j];
    			if(num != 0)
    				button_board[i][j].setText(Integer.toString(num));
    			else
    				button_board[i][j].setText("");
    		}
    	}
    }

    private boolean tmp_gameover = false;
    public void updateNum() {
    	count_number = sudoku.getcountNumber();
    	for(int i=0; i<9; i++) {
    		if(count_number[i]<9) numbers[i].setText(Integer.toString(i+1));
    		else numbers[i].setText("");
    	}

        tmp_gameover = true;
        for(int i=0; i<9; i++){
            if(count_number[i]<9) {
                tmp_gameover = false;
                break;
            }
        }
        if(tmp_gameover) gameover = true;
    }

    public void sudokuExit(){
        dispose();
    }
    public boolean isGameover(){ return gameover; }

    public void gameOver(int time, int minute, int second){
        sudoku.saveTime(time);
        JOptionPane.showMessageDialog(null, "기록 : " + (minute < 10 ? "0" + minute + ":" + (second < 10 ? "0"+second:second) : minute + ":" + (second < 10 ? "0"+second:second)));
        sudokuExit();
        //time 받아서 반환
    }
    
    public SudokuButton[][] buttonBoardReturn(){
    	return button_board;
    }
}
