import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class TicTacToe extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() 
		
			
					TicTacToe ticTacToe = new TicTacToe();
					ticTacToe.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public TicTacToe() {
		setResizable(false);
getContentPane().setBackground(Color.WHITE);
		
		setBounds(200, 200, 472, 331);
		Container c = getContentPane();
		c.setLayout(null);
		
		
		
		JButton start = new JButton("Start");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startClick();
			}
	});
		start.setFont(new Font("Tahoma", Font.PLAIN, 18));
		start.setToolTipText("Click on Ok");
		start.setBounds(184, 186, 89, 23);
		
		getContentPane().add(start);
		
		JLabel lblTictic = new JLabel("Tic Tac Toe");
		lblTictic.setBackground(Color.YELLOW);
		lblTictic.setFont(new Font("Mukti Narrow", Font.BOLD, 40));
		lblTictic.setBounds(108, 41, 249, 150);
		getContentPane().add(lblTictic);
		
		JLabel lblDevelopedBySunil = new JLabel("Developed by: Sunil");
		lblDevelopedBySunil.setBounds(10, 268, 140, 14);
		getContentPane().add(lblDevelopedBySunil);
}
	protected void startClick()
	{
//		GameStart gameStart=new GameStart();
//		gameStart.setVisible(true);
		
		Tic_Tac_Toe_Start start=new Tic_Tac_Toe_Start();
		start.setVisible(true);
		this.setVisible(false);
	}
}
