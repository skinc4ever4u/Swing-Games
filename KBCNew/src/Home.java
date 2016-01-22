import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.JPasswordField;

import Sound.PlaySounds;

import java.awt.Font;


public class Home extends JFrame {
  private static final long serialVersionUID = 2405172041950251807L;
	private JTextField textField;
	JLabel lblNewLabel = new JLabel("Enter Name First.");
	
	Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
	
	Icon iconHome=new ImageIcon(Home.class.getResource("HomeEdited.jpg"));
	
	Icon iconPlay=new ImageIcon(Home.class.getResource("HomePlay.png"));
	Icon iconPlayUp=new ImageIcon(Home.class.getResource("HomePlayHover.png"));
	Icon iconQuit=new ImageIcon(Home.class.getResource("HomeQuit.png"));
	Icon iconQuitUp=new ImageIcon(Home.class.getResource("HomeQuitHover.png"));
	JLabel lblNewLabel_1 = new JLabel("");
	JLabel btnPlay = new JLabel("Play");
	private final JLabel btnExit = new JLabel("");

	public Home() {

		setResizable(false);
		setBounds(100, 100, 605, 427);
		getContentPane().setLayout(null);
		
		
		btnExit.setBounds(10, 346, 114, 42);
		btnExit.setIcon(iconQuit);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//previousButton.setForeground(Color.BLUE);
				
				
				btnExit.setCursor(cursor);
				btnExit.setIcon(iconQuitUp);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setIcon(iconQuit);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(ABORT);
			}
		});
		getContentPane().add(btnExit);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(216, 275, 200, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		btnPlay.setBounds(475, 346, 114, 42);
		getContentPane().add(btnPlay);
		btnPlay.setIcon(iconPlay);
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//previousButton.setForeground(Color.BLUE);
				
				
				btnPlay.setCursor(cursor);
				btnPlay.setIcon(iconPlayUp);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlay.setIcon(iconPlay);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				quizStart();
			}
		});
		
		JLabel lblEnterPlayerName = new JLabel("Enter Player Name :");
		lblEnterPlayerName.setForeground(Color.ORANGE);
		lblEnterPlayerName.setBounds(88, 266, 118, 50);
		getContentPane().add(lblEnterPlayerName);
		
		
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(428, 278, 148, 26);
		lblNewLabel.setVisible(false);
		getContentPane().add(lblNewLabel);
		
		
		lblNewLabel_1.setBounds(0, 0, 600, 400);
		lblNewLabel_1.setIcon(iconHome);
		getContentPane().add(lblNewLabel_1);
	}
	/*public static void main(String args[])
	{
		Home frame=new Home();
		frame.setVisible(true);
	}*/
	public void quizStart()
	{
		if(!textField.getText().trim().equals(""))
		{
			PlaySounds.stop();
		Player.playerName=textField.getText();
		Start start=new Start();
		start.setVisible(true);
		
		this.setVisible(false);
		}
		else
		{
			lblNewLabel.setVisible(true);
		}
		
		
	}
}
