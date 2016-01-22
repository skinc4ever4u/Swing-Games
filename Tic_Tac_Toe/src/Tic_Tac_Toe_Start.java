


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;



public class Tic_Tac_Toe_Start extends JFrame{
	

	//private JPanel contentPane;
	//private JPanel contentPane2;
	private JLabel lblPlayer1Score = new JLabel("0");
	private JLabel lblPlayer2Score = new JLabel("0");
	
	boolean player=true;
	
	static int player1win=0;
	static int player2win=0;
	JLabel winnerlbl = new JLabel("");
	 
	 public void clear()
	 {
		 btn1.setText("");
		 btn2.setText("");
		 btn3.setText("");
		 btn4.setText("");
		 btn5.setText("");
		 btn6.setText("");
		 btn7.setText("");
		 btn8.setText("");
		 btn9.setText("");
		 
	 }
	 
	 JButton btn1;
	 JButton btn2;
	 JButton btn3;
	 JButton btn4;
	 JButton btn5;
	 JButton btn6;
	 JButton btn7;
	 JButton btn8;
	 JButton btn9;
	 JLabel lblPlayerTurn;
	//private JPanel contentGamePane;
	 
	public Tic_Tac_Toe_Start() {
		setResizable(false);
		lblPlayerTurn = new JLabel("1");
		btn1 = new JButton("");
		btn2 = new JButton("");
		btn3 = new JButton("");
		btn4 = new JButton("");
		btn5 = new JButton("");
		btn6 = new JButton("");
		btn7 = new JButton("");
		btn8 = new JButton("");
		btn9 = new JButton("");
		
		 
		
getContentPane().setBackground(Color.WHITE);
		
		setBounds(400, 300, 473, 324);
		Container c = getContentPane();
		c.setLayout(null);
		
getContentPane().setBackground(Color.WHITE);
		
		setBounds(400, 300, 450, 300);
		Container c2 = getContentPane();
		c2.setLayout(null);
		
		
		JLabel lbl = new JLabel("Wins ");
		lbl.setBounds(10, 243, 50, 15);
		getContentPane().add(lbl);
//		panel.add(lbl);
//		panel.setVisible(true);
		
		JLabel lblPlayer1 = new JLabel("Player 1 : ");
		lblPlayer1.setBounds(70, 243, 60, 15);
		getContentPane().add(lblPlayer1);
		
		
		lblPlayer1Score.setBounds(124, 243, 40, 15);
		getContentPane().add(lblPlayer1Score);
		
		JLabel lblPlayer2 = new JLabel("Player 2 : ");
		lblPlayer2.setBounds(174, 243, 60, 15);
		getContentPane().add(lblPlayer2);
		
		
		lblPlayer2Score.setBounds(231, 243, 40, 15);
		getContentPane().add(lblPlayer2Score);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartClick();
			}
		});
		
		btnRestart.setBounds(271, 189, 95, 25);
		getContentPane().add(btnRestart);
		
		
		btn1.addActionListener(new ActionListener() {
		//clicked
			public void actionPerformed(ActionEvent e) {
				playerClick(e);
			}
		});
		btn1.setBounds(20, 30, 50, 50);
		getContentPane().add(btn1);
		
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClick(e);
			}
		});
		btn2.setBounds(80, 30, 50, 50);
		getContentPane().add(btn2);
		
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClick(e);
			}
		});
		btn3.setBounds(140, 30, 50, 50);
		getContentPane().add(btn3);
		
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClick(e);
			}
		});
		btn4.setBounds(20, 90, 50, 50);
		getContentPane().add(btn4);
		
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClick(e);
			}
		});
		btn5.setBounds(80, 90, 50, 50);
		getContentPane().add(btn5);
		
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClick(e);
			}
		});
		btn6.setBounds(140, 90, 50, 50);
		getContentPane().add(btn6);
		
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClick(e);
			}
		});
		btn7.setBounds(20, 150, 50, 50);
		getContentPane().add(btn7);
		
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClick(e);
			}
		});
		btn8.setBounds(80, 150, 50, 50);
		getContentPane().add(btn8);
		
		
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerClick(e);
			}
		});
		btn9.setBounds(140, 150, 50, 50);
		getContentPane().add(btn9);
		
		JLabel lblPlayerText = new JLabel("Player Turn : ");
		lblPlayerText.setBounds(271, 90, 100, 15);
		getContentPane().add(lblPlayerText);
		
		
		lblPlayerTurn.setBounds(349, 90, 28, 15);
		getContentPane().add(lblPlayerTurn);
		
		
		winnerlbl.setForeground(Color.RED);
		winnerlbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		winnerlbl.setBounds(284, 143, 100, 35);
		getContentPane().add(winnerlbl);
				
}

	
	protected void restartClick()
	{
		lblPlayer1Score.setText("0");
		lblPlayer2Score.setText("0");
		
		lblPlayerTurn.setText("1");
		
		player=true;
		
		
		player1win=0;
		player2win=0;
		winnerlbl.setText("");
		clear();
	}

	
	
	protected void playerClick(ActionEvent e)
	{
		JButton btn=(JButton)e.getSource();
		winnerlbl.setText("");
		if(btn.getText().equals(""))
		{
		if(player)
		{
			btn.setText("X");
			lblPlayerTurn.setText("2");
		}
		else
		{
			btn.setText("O");
			lblPlayerTurn.setText("1");
		}
		if(btn1.getText().equals("") || btn2.getText().equals("")|| btn3.getText().equals("") ||btn4.getText().equals("")||btn5.getText().equals("") ||btn6.getText().equals("")||btn7.getText().equals("")||btn8.getText().equals("")||btn9.getText().equals(""))
		{
		if(checkWin())
		{
			if(player)
			{
				player1win++;
				lblPlayer1Score.setText(""+player1win);
				winnerlbl.setText("Player 1 Win ");
				
				
			}
			else
			{
				player2win++;
				lblPlayer2Score.setText(""+player2win);
				winnerlbl.setText("Player 2 Win ");
			}
			clear();
		}
		}
		else
		{
			winnerlbl.setText("Game Draw");
			clear();
		}
		player=!player;
		
		}
	}

	private boolean checkWin() {
		 
		 //int winSearch[][]={{1,2,3},{1,4,7},{1,5,9},{2,5,8},{3,5,7},{3,6,9},{4,5,6},{7,8,9}};
		 boolean win=false;
		 String selected="X";
		 if(!player)
		 {
			 selected="O";
		 }
		 if(btn1.getText().equals(selected) && btn2.getText().equals(selected) && btn3.getText().equals(selected))
		 {
			 win=true;
		 }
		 if(btn1.getText().equals(selected) && btn4.getText().equals(selected) && btn7.getText().equals(selected))
		 {
			 win=true;
		 }
		 if(btn1.getText().equals(selected) && btn5.getText().equals(selected) && btn9.getText().equals(selected))
		 {
			 win=true;
		 }
		 if(btn2.getText().equals(selected) && btn5.getText().equals(selected) && btn8.getText().equals(selected))
		 {
			 win=true;
		 }
		 if(btn3.getText().equals(selected) && btn5.getText().equals(selected) && btn7.getText().equals(selected))
		 {
			 win=true;
		 }
		 if(btn3.getText().equals(selected) && btn6.getText().equals(selected) && btn9.getText().equals(selected))
		 {
			 win=true;
		 }
		 if(btn4.getText().equals(selected) && btn5.getText().equals(selected) && btn6.getText().equals(selected))
		 {
			 win=true;
		 }
		 if(btn7.getText().equals(selected) && btn8.getText().equals(selected) && btn9.getText().equals(selected))
		 {
			 win=true;
		 }
		 return win;
		 //int conincr=0;
	}
}



