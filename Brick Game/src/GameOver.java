import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GameOver extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver frame = new GameOver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public GameOver(String msg,String btn) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 243);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(msg);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(153, 23, 160, 42);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton(btn);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Start start=new Start();
				start.setVisible(true);
				start.startTimers();
				GameOver.this.setVisible(false);
				GameOver.this.dispose();
			}
		});
		btnNewButton.setBounds(55, 99, 130, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameOver.this.dispose();
			}
		});
		btnExit.setBounds(222, 99, 123, 23);
		getContentPane().add(btnExit);
	}
}
