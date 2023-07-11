package TicTacToe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TicTacToe {
	
	
	private static char turn = 'X';
	private static JLabel title2;
	private static ArrayList<JLabel> Labels = new ArrayList<JLabel>();
	private static String winner = " ";
	private static char[][] chars = new char[3][3];
	private static boolean enabled = true; 

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("TIC TAC TOE");
		frame.setBackground(Color.pink);
		frame.setSize(750,750);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("TIC TAC TOE");
		title.setBackground(Color.pink);
		title.setForeground(Color.white);
		title.setOpaque(true);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		title.setFont(new Font("Times New Roman",Font.BOLD, 40));
		frame.add(title,BorderLayout.NORTH);
		
		//BorderLayout arranges the components in the five regions. 
		//Four sides are referred to as north, south, east, and west. 
		//The middle part is called the center.
		//Each region can contain only one component and is identified by a corresponding constant as NORTH, SOUTH, EAST, WEST, and CENTER. 
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(3,3,8,8));
	    panel.setBackground(Color.pink);
	    
	    title2 = new JLabel("Player 1 can start the game.");
	    title2.setForeground(Color.white);
	    title2.setHorizontalAlignment(SwingConstants.CENTER);
	    title2.setBackground(Color.pink);
	    title2.setOpaque(true);
	    title2.setFont(new Font("Times New Roman",Font.BOLD,30));
	    title2.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

	    
	    for(int i=0; i<3; i++) {
	    	for(int j=0 ;j<3; j++) {
	    		JLabel label = new JLabel(" ");
	    		label.setOpaque(true);
	    		label.setBackground(Color.white); //for the squares 
	    		label.setFont(new Font("Times New Roman",Font.BOLD,80));
	    		label.setHorizontalAlignment(SwingConstants.CENTER);
	    		int a = i;
	    		int b = j;
	    		label.addMouseListener(new MouseListener() {
	    			
	    			@Override
	    			public void mouseReleased(MouseEvent e) {}

	    			@Override
					public void mousePressed(MouseEvent e) {}
		
					@Override
					public void mouseEntered(MouseEvent e) {}
				
					@Override
					public void mouseExited(MouseEvent e) {}
				
					@Override
					public void mouseClicked(MouseEvent e) {
						if(enabled) {
							if (label.getText().toString().equals(" ")) {
								label.setText(String.valueOf(turn));
								chars[a][b] = turn;
								if (turn == 'X') {
									label.setForeground(Color.GRAY);
									turn = 'O';
									title2.setText("Player 2 can start the game.");
								} else {
									label.setForeground(Color.black);
									turn = 'X';
									title2.setText("Player 1 can start the game.");
								}
								
							} else {
								title2.setText("Position Taken!");
							}
							if(whoWinner() && winner.equals("X")) {
								title2.setText("Player 1 Won!");
								title2.setForeground(Color.GRAY);
								enabled = false;
							} else if (whoWinner() && winner.equals("O")) {
								title2.setText("Player 2 Won!");
								title2.setForeground(Color.black);
								enabled = false;
							} else if (!draw()) {
								title2.setText("DRAW");
								enabled = false;
							}
						}
			
					}
						
					});

	            Labels.add(label);
	    		panel.add(label);
	    		
	    	}
	    }
	    
	    frame.add(panel,BorderLayout.CENTER);
	    JPanel panel2 = new JPanel();
	    panel2.setLayout(new GridLayout(2,1));
	    panel2.add(title2);

	    
	    JButton button = new JButton("NEW GAME");
	    button.setBackground(Color.GRAY);
	    button.setForeground(Color.pink);
	    button.setFont(new Font("Times New Roman",Font.BOLD,30));
	    button.addActionListener(new ActionListener() {
	    
			@Override
			public void actionPerformed(ActionEvent e) {			
				reboot();
			}
	    });
	    panel2.add(button);
	    frame.add(panel2,BorderLayout.SOUTH);
		frame.setVisible(true);
				
	}
	
	// The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner. 
	
	private static boolean whoWinner() {
		boolean win = false;
		if(chars[0][0] == chars[0][1] && chars[0][0] == chars[0][2] && chars[0][0] != 0) {
			win = true;
			winner = String.valueOf(chars[0][0]);
		} else if(chars[1][0] == chars[1][1] && chars[1][0] == chars[1][2] && chars[1][0] != 0) {
			win = true;
			winner = String.valueOf(chars[1][0]);
		} else if(chars[2][0] == chars[2][1] && chars[2][0] == chars[2][2] && chars[2][0] != 0) {
			win = true;
			winner = String.valueOf(chars[2][0]);
		} else if(chars[0][0] == chars[1][0] && chars[0][0] == chars[2][0] && chars[0][0] != 0) {
			win = true;
			winner = String.valueOf(chars[0][0]);
		} else if(chars[0][1] == chars[1][1] && chars[0][1] == chars[2][1] && chars[0][1] != 0) {
			win = true;
			winner = String.valueOf(chars[0][1]);
		} else if(chars[0][2] == chars[1][2] && chars[0][2] == chars[2][2] && chars[0][2] != 0) {
			win = true;
			winner = String.valueOf(chars[0][2]);
		} else if(chars[0][0] == chars[1][1] && chars[0][0] == chars[2][2] && chars[0][0] != 0) {
			win = true;
			winner = String.valueOf(chars[0][0]);
		} else if(chars[2][0] == chars[1][1] && chars[2][0] == chars[0][2] && chars[2][0] != 0) {
			win = true;
			winner = String.valueOf(chars[2][0]);
		}
		return win;
		
	}
	private static void reboot() {
		chars = new char[3][3];
		winner = " ";
		title2.setText("Player 1 can start the game.");
		title2.setForeground(Color.GRAY);
		turn = 'X';
		enabled = true;
		for(JLabel label : Labels ) {
			label.setText(" ");
		}
	}
	private static boolean draw() {
		boolean draw = false;
		for(char[] a : chars) {
			for(char b : a) {
				if(b==0) {
					draw = true;
					break;
				}
			}
		}
		return draw;
		
	}
	
}
