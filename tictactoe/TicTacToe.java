package tictactoe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
	Random random = new Random();
	JFrame frame= new JFrame();
	JPanel TitlePanel= new JPanel();
	JPanel ButtonPanel= new JPanel();
	JLabel Textfield= new JLabel();
	JButton [] buttons= new JButton[9];
	JButton Restart= new JButton("Restart");
	boolean Player1_turn;
	
	TicTacToe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		Textfield.setBackground(Color.BLACK);
		Textfield.setForeground(Color.RED);
		Textfield.setFont(new Font("Arial", Font.BOLD,80));
		Textfield.setHorizontalAlignment(JLabel.CENTER);
		Textfield.setText("Tic-Tac-Toe");
		Textfield.setOpaque(true);
		
		TitlePanel.setLayout(new BorderLayout());
		TitlePanel.setBounds(0,0,800,100);
		
		ButtonPanel.setLayout(new GridLayout(3,3));
		ButtonPanel.setBackground(Color.gray);
		
		Restart.setFont(new Font("Arial", Font.BOLD,60));
		Restart.setFocusable(false);
		Restart.addActionListener(e-> restart());
		
		frame.add(Restart, BorderLayout.SOUTH);
		
		for(int i=0; i<9; i++) {
			buttons[i]= new JButton();
			ButtonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setOpaque(true);
		}
		TitlePanel.add(Textfield);
		frame.add(TitlePanel, BorderLayout.NORTH);
		frame.add(ButtonPanel);
		FirstTurn();
	}
		
		@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<9;i++) {
			if(e.getSource()== buttons[i]) {
				if(Player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.ORANGE);
						buttons[i].setText("X");
						Player1_turn=false;
						Textfield.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.MAGENTA);
						buttons[i].setText("O");
						Player1_turn=true;
						Textfield.setText("X turn");
						check();
					}
				}
	}
		}
		}
	private void FirstTurn() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if(random.nextInt(2)==0) {
			Player1_turn=true;
			Textfield.setText("X Turn");
		}
		else {
			Player1_turn=false;
			Textfield.setText("O Turn");
		}
	}
	private boolean win() {
		//X WINS
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
			xWins(0,1,2);
			return true;
		}
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
			xWins(3,4,5);
			return true;
		}
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(6,7,8);
			return true;
		}
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
			xWins(0,3,6);
			return true;
		}
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
			xWins(1,4,7);
			return true;
		}
		if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(2,5,8);
			return true;
		}
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(0,4,8);
			return true;
		}
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
			xWins(2,4,6);
			return true;
		}
		
		//O WINS
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
			oWins(0,1,2);
			return true;
		}
		if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
			oWins(3,4,5);
			return true;
		}
		if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(6,7,8);
			return true;
		}
		if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
			oWins(0,3,6);
			return true;
		}
		if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
			oWins(1,4,7);
			return true;
		}
		if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(2,5,8);
			return true;
		}
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(0,4,8);
			return true;
		}
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
			oWins(2,4,6);
			return true;
		}
		return false;
	}
	private void check() {
		if(win()==true) {
			return;
		}
		boolean tie= true;
		for(int i= 0;i<9;i++) {
			if(buttons[i].getText().equals("")) {
				tie=false;
				break;
			}
			if(tie) {
				Textfield.setText("It's a Tie!");
				for(int j=0; j<9;j++) {
					buttons[j].setEnabled(false);
				}
			}
		}
		
	}
		

	private void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for(int i=0; i<9;i++) {
			buttons[i].setEnabled(false);
		}
		Textfield.setText("O WINS");
	}
	private void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for(int i=0; i<9;i++) {
			buttons[i].setEnabled(false);
		}
		Textfield.setText("X WINS");
		
	}
	private void restart() {
		for(int i=0; i<9;i++) {
			buttons[i].setText("");
			buttons[i].setBackground(null);
			buttons[i].setEnabled(true);
		}
		Textfield.setText("Tic-Tac-Toe");
		FirstTurn();
	}
}
