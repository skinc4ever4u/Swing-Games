import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;



public class SplashScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.doProgress();
	}

	/**
	 * Create the frame.
	 */
	int color = 1;
	int progressValue = 1;
	int x = 197;
	boolean isVisible = true;
	JLabel bmpl = new JLabel("Deleveloped by : Sunil");
	Timer timer = null;
	Timer progressTimer = null;
	JProgressBar progressBar = new JProgressBar();
	

	private void doProgress(){

	
		ActionListener l = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(progressValue<progressBar.getMaximum()){
				progressBar.setValue(progressValue);
				progressValue++;
				}
				else
				{
					SplashScreen.this.setVisible(false);
					if(timer!=null){
					timer.stop();
					}
					if(progressTimer!=null){
					progressTimer.stop();
					}
					SplashScreen.this.dispose();
					GameOver home = new GameOver("New Game","Start Game");
					home.setVisible(true);
					//home.startTimers();
				}
				
			}
		};
		progressTimer = new Timer(20,l);
		progressTimer.start();
	}
	
	private  void doAnimation(){
		ActionListener l= (e)->{
			switch(color){
			case 1:
				bmpl.setForeground(Color.RED);
				break;
			case 2:
				bmpl.setForeground(Color.GREEN);
				break;
			case 3:
				bmpl.setForeground(Color.CYAN);
				break;
			case 4:
				bmpl.setForeground(Color.YELLOW);
				break;
			default:
				bmpl.setForeground(Color.BLACK);
				break;
				
			}
			if(x<=250){
				x++;
			}
			else
			{
				x = 197;
			}
			bmpl.setBounds(x, 172, 250, 29);
			if(color<=4){
			color++;
			}
			else
			{
				color= 1;
			}
			bmpl.setVisible(isVisible);
			isVisible = !isVisible;
		};
		timer = new Timer(100,l);
		timer.start();
	}


	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setBounds(100, 100, 600, 400);
		//contentPane = new JPanel();
		getContentPane().setLayout(null);
		
		Icon icon=new ImageIcon(SplashScreen.class.getResource("SplashScreen.jpg"));
		bmpl.setForeground(Color.BLUE);
		
		bmpl.setFont(new Font("Tahoma", Font.BOLD, 16));
		bmpl.setBounds(404, 11, 250, 29);
		getContentPane().add(bmpl);
		

		progressBar.setForeground(Color.BLACK);
		progressBar.setBackground(Color.LIGHT_GRAY);
		progressBar.setBounds(10, 305, 580, 41);
		getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 600, 400);
		lblNewLabel.setIcon(icon);
		getContentPane().add(lblNewLabel);
		
	}

}
