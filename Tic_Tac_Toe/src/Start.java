import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;


public class Start extends JFrame {

	Icon iconBg=new ImageIcon(Start.class.getResource("StartPage.png"));
	
	public static void main(String[] args) {
					Start frame = new Start();
					frame.setVisible(true);
	}

	public Start() {
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 575);
		getContentPane().setLayout(null);
		
		JLabel lblQ = new JLabel("Q :");
		lblQ.setForeground(Color.ORANGE);
		lblQ.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblQ.setBounds(49, 348, 48, 44);
		getContentPane().add(lblQ);
		
		JLabel lblD = new JLabel("D :");
		lblD.setForeground(Color.ORANGE);
		lblD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblD.setBounds(382, 502, 23, 28);
		getContentPane().add(lblD);
		
		JLabel lblC = new JLabel("C :");
		lblC.setForeground(Color.ORANGE);
		lblC.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblC.setBounds(63, 502, 23, 28);
		getContentPane().add(lblC);
		
		JLabel lblB = new JLabel("B :");
		lblB.setForeground(Color.ORANGE);
		lblB.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblB.setBounds(382, 440, 23, 28);
		getContentPane().add(lblB);
		
		JLabel lblA = new JLabel("A :");
		lblA.setForeground(Color.ORANGE);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblA.setBounds(63, 440, 23, 28);
		getContentPane().add(lblA);
		
		JLabel optionD = new JLabel("New label");
		optionD.setForeground(Color.WHITE);
		optionD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		optionD.setBounds(411, 502, 211, 30);
		getContentPane().add(optionD);
		
		JLabel optionC = new JLabel("New label");
		optionC.setForeground(Color.WHITE);
		optionC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		optionC.setBounds(92, 502, 217, 30);
		getContentPane().add(optionC);
		
		JLabel optionB = new JLabel("New label");
		optionB.setForeground(Color.WHITE);
		optionB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		optionB.setBounds(411, 439, 211, 30);
		getContentPane().add(optionB);
		
		JLabel optionA = new JLabel("New label");
		optionA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		optionA.setForeground(Color.WHITE);
		optionA.setBounds(92, 439, 217, 30);
		getContentPane().add(optionA);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 700, 550);
		getContentPane().add(background);
		background.setIcon(iconBg);
		
		
	}
}
