import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import Sound.PlaySounds;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;


public class GameOver extends JFrame {

	

	public GameOver() {
		//PlaySounds.stop();
		//PlaySounds.stop();
	
			
		getContentPane().setBackground(Color.BLUE);
		setBackground(Color.BLACK);
		getContentPane().setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Congratulation You have won.");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 414, 50);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPlayerName = new JLabel("Player Name :");
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPlayerName.setForeground(Color.WHITE);
		lblPlayerName.setBounds(23, 56, 141, 50);
		getContentPane().add(lblPlayerName);
		
		JLabel lblAmountWin = new JLabel("Amount Win :");
		lblAmountWin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmountWin.setForeground(Color.WHITE);
		lblAmountWin.setBounds(23, 117, 141, 50);
		getContentPane().add(lblAmountWin);
		
		JLabel playerName = new JLabel(""+Player.playerName);
		playerName.setFont(new Font("Tahoma", Font.BOLD, 16));
		playerName.setForeground(Color.WHITE);
		playerName.setBounds(206, 56, 218, 50);
		getContentPane().add(playerName);
		
		JLabel amountWin = new JLabel(""+Player.totalAmountWin);
		amountWin.setFont(new Font("Tahoma", Font.BOLD, 16));
		amountWin.setForeground(Color.WHITE);
		amountWin.setBounds(216, 117, 203, 50);
		getContentPane().add(amountWin);
		
		JButton newGame = new JButton("Play Again");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playAgain();
			}
		});
		newGame.setBounds(235, 193, 126, 35);
		getContentPane().add(newGame);
		
		JButton gameExit = new JButton("Exit");
		gameExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitGame();
			}
		});
		gameExit.setBounds(80, 193, 133, 35);
		getContentPane().add(gameExit);
		
		
	}
	public void playAgain()
	{
		PlaySounds.stop();
		this.setVisible(false);
		Home home=new Home();
		home.setVisible(true);
		this.dispose();
	}
		public void quitGame()
	{
		System.exit(0);
	}
}
