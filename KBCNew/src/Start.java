import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.sql.Time;
import java.time.temporal.JulianFields;

import javax.swing.border.LineBorder;

import Sound.PlaySounds;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Start extends JFrame {
	
	boolean optionEnable=true;
	//skip choice variable
	int skip=0;
	boolean skipChoice=true;
	
	//fifty choice variable
	boolean fiftychoice=true;
	
	//audience choice
	boolean audiencechoice=true;
	
	//from Old
	
	boolean rightAnswer=true;
	
	final int MAXQUESTION=13;
	QuestionClass questions=new QuestionClass();
	Question question;
	RandomNumber randomNumber;
	int Q[];
	 int playerQuestionNo=0;
	 String answer="";
	 Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
	 
	 JButton btnNextQuestion;
	 private JLabel alertLable;
	 int progressValue;
		JProgressBar progressTimerBar;
		Timer timer;
		Timer progressTimer;
		
		JLabel audienceLabel = new JLabel("");
		

		protected void doProgress(){
			
			if(progressValue!=0)
			progressValue=0;
				//int second=0;
			if(timer!=null)
				timer=null;
				if(progressTimer!=null);
				progressTimer=null;
				if(alertLable==null)
				alertLable = new JLabel("");
				if(progressTimerBar==null)
				{
				progressTimerBar=new JProgressBar();
				
				progressTimerBar.setMaximum(60);
				//progressTimerBar.setValue(progressValue);
				getContentPane().add(progressTimerBar);
				}
			
			ActionListener l = new ActionListener() {
				
				@Override
		public void actionPerformed(ActionEvent e) {
			if(progressValue<=60){
			
				progressTimerBar.setValue(progressValue);
			
			
				//System.out.println("progressvalue : "+ progressValue+" timemax value :"+ progressTimerBar.getMaximum());
				//alertLable.setText(  (((progressTimerBar.getMaximum()-progressValue-1)/10)) + " Minutes left..");
				alertLable.setText(  (((progressTimerBar.getMaximum()-progressValue))) + " Second left..");
				if(progressTimerBar.getValue()>54)
				{
				alertLable.setForeground(Color.RED);
				progressTimerBar.setForeground(Color.RED);
				}
			
			progressValue++;
			}
			else
			{
				
				Start.this.setVisible(false);
				if(timer!=null){
				timer.stop();
				}
				if(progressTimer!=null){
				progressTimer.stop();
				}
				if(progressTimerBar!=null)
					progressTimerBar=null;
						
				Start.this.dispose();
				gameOver();
				//GameConsole gc = new GameConsole();
				//gc.setVisible(true);
			}
			
		}
	};
	progressTimer = new Timer(1000,l);
	progressTimer.start();
}
	
	 public void initialize()
		{
		  	Player.totalAmountWin=0;
			randomNumber=new RandomNumber();
			Q=randomNumber.getGetRandom();
			amount_1_bg.setIcon(iconQuestionAmount);
		}
		public void clearControl()
		{
			optionAbg.setIcon(null);
			optionBbg.setIcon(null);
			optionCbg.setIcon(null);
			optionDbg.setIcon(null);
		}
		public void playsound()
		{
			try{
			if(playerQuestionNo==0)
				PlaySounds.playSound("Q1.mp3");
			if(playerQuestionNo==1)
				PlaySounds.playSound("Q2.mp3");
			if(playerQuestionNo==2)
				PlaySounds.playSound("Q3.mp3");
			if(playerQuestionNo==3)
				PlaySounds.playSound("Q4.mp3");
			if(playerQuestionNo==4)
				PlaySounds.playSound("Q5.mp3");
			if(playerQuestionNo==5)
				PlaySounds.playSound("Q6.mp3");
			if(playerQuestionNo==6)
				PlaySounds.playSound("Q7.mp3");
			if(playerQuestionNo==7)
				PlaySounds.playSound("Q8.mp3");
			if(playerQuestionNo==8)
				PlaySounds.playSound("Q9.mp3");
			if(playerQuestionNo==9)
				PlaySounds.playSound("Q10.mp3");
			if(playerQuestionNo==10)
				PlaySounds.playSound("Q11.mp3");
			if(playerQuestionNo==11)
				PlaySounds.playSound("Q12.mp3");
			if(playerQuestionNo==12)
				PlaySounds.playSound("Q13.mp3");
			
			}
			catch(Exception e)
			{
				
			}
		}
		public void nextQuestion() 
		{
			if(playerQuestionNo>=1)
			{
				alertLable.setForeground(Color.GREEN);
				progressTimerBar.setForeground(Color.GREEN);
			PlaySounds.stop();
			}
			
			playsound();
			audienceLabel.setIcon(null);
			check=true;
			doProgress();
			Question allQuestion[]=questions.getQuestion();
			question=allQuestion[Q[playerQuestionNo+skip]-1];
			
			
			optionA.setText(question.getOptionA());
			optionB.setText(question.getOptionB());
			optionC.setText(question.getOptionC());
			optionD.setText(question.getOptionD());
			
			optionA.setVisible(true);
			optionB.setVisible(true);
			optionC.setVisible(true);
			optionD.setVisible(true);
			//lblAmountWin.setText(""+ Player.winAmounts[playerQuestionNo]);
			
			txtQuestion.setText(question.getQuesion());
			answer=question.getAnswer();
			
			btnNextQuestion.setEnabled(false);
			
			//questionNo.setText(""+playerQuestionNo);
		}
		
	Icon iconBg=new ImageIcon(Start.class.getResource("StartPage.png"));
	Icon iconWrongAnswer=new ImageIcon(Start.class.getResource("WrongAnswer.png"));
	Icon iconRightAnswer=new ImageIcon(Start.class.getResource("RightAnswer.png"));
	Icon iconAmountWin=new ImageIcon(Start.class.getResource("amountWin.png"));
	Icon iconQuestionAmount=new ImageIcon(Start.class.getResource("questionAmount.png"));
	Icon iconLifeSkip=new ImageIcon(Start.class.getResource("skip.png"));
	Icon iconLifeFifty=new ImageIcon(Start.class.getResource("fifty.png"));
	Icon iconLifeAudience=new ImageIcon(Start.class.getResource("audience.png"));
	Icon iconLifeChance=new ImageIcon(Start.class.getResource("chance.png"));
	Icon iconLifeLife=new ImageIcon(Start.class.getResource("life.png"));
	Icon iconLifeSkipFinish=new ImageIcon(Start.class.getResource("skipFinish.png"));
	Icon iconLifeFiftyFinish=new ImageIcon(Start.class.getResource("fiftyFinish.png"));
	Icon iconLifeAudienceFinish=new ImageIcon(Start.class.getResource("audienceFinish.png"));
	Icon iconLifeChanceFinish=new ImageIcon(Start.class.getResource("chanceFinish.png"));
	Icon iconLifeLifeFinish=new ImageIcon(Start.class.getResource("lifeFinish.png"));
	Icon iconAudienceA=new ImageIcon(Start.class.getResource("AudienceA.png"));
	Icon iconAudienceB=new ImageIcon(Start.class.getResource("AudienceB.png"));
	Icon iconAudienceC=new ImageIcon(Start.class.getResource("AudienceC.png"));
	Icon iconAudienceD=new ImageIcon(Start.class.getResource("AudienceD.png"));
	
	/*public static void main(String[] args) {
					Start frame = new Start();
					frame.setVisible(true);
	}*/
	
	private JLabel lblQ = new JLabel("Q :");
	private JLabel optionD = new JLabel("New label");
	private JLabel optionC = new JLabel("New label");
	private JLabel optionB = new JLabel("New label");
	private JLabel optionA = new JLabel("New label");
	private JTextArea txtQuestion;
	JLabel optionAbg = new JLabel("");
	JLabel optionBbg = new JLabel("");
	JLabel optionCbg = new JLabel("");
	JLabel optionDbg = new JLabel("");
	private final JPanel panel = new JPanel();
	private final JLabel amount_1 = new JLabel(" 1.                     5,000");
	private final JLabel amount_2 = new JLabel(" 2.                   10,000");
	private final JLabel amount_3 = new JLabel(" 3.                   20,000");
	private final JLabel amount_4 = new JLabel(" 4.                   40,000");
	private final JLabel amount_5 = new JLabel(" 5.                   80,000");
	private final JLabel amount_6 = new JLabel(" 6.                1,60,000");
	private final JLabel amount_7 = new JLabel(" 7.                3,20,000");
	private final JLabel amount_8 = new JLabel(" 8.                6,40,000");
	private final JLabel amount_9 = new JLabel(" 9.              12,50,000");
	private final JLabel amount_10 = new JLabel("10.            25,00,000");
	private final JLabel amount_11 = new JLabel("11.            50,00,000");
	private final JLabel amount_12 = new JLabel("12.         1,00,00,000");
	private final JLabel amount_13 = new JLabel("13.         5,00,00,000");
	private final JLabel amount_1_bg = new JLabel("");
	private final JLabel amount_2_bg = new JLabel("");
	private final JLabel amount_3_bg = new JLabel("");
	private final JLabel amount_4_bg = new JLabel("");
	private final JLabel amount_5_bg = new JLabel("");
	private final JLabel amount_6_bg = new JLabel("");
	private final JLabel amount_7_bg = new JLabel("");
	private final JLabel amount_8_bg = new JLabel("");
	private final JLabel amount_9_bg = new JLabel("");
	private final JLabel amount_10_bg = new JLabel("");
	private final JLabel amount_11_bg = new JLabel("");
	private final JLabel amount_12_bg = new JLabel("");
	private final JLabel amount_13_bg = new JLabel("");
	
	public void initializeControls()
	{
		
		txtQuestion = new JTextArea();
		btnNextQuestion=new JButton("Next Question");
		
	}
	
	public void congratsWindow()
	{
		JOptionPane j=new JOptionPane();
		//j.showMessageDialog(parentComponent, message);
		//JDialog j=new JDialog();
		j.setVisible(true);
	}
	
	
	boolean check=true;
	
	public Start() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(ABORT);
			}
		});
		
		initialize();
		initializeControls();
		nextQuestion();
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 575);
		getContentPane().setLayout(null);
alertLable.setForeground(Color.GREEN);

//alertLable.setForeground(Color.RED);
alertLable.setBounds(329, 264, 146, 23);

getContentPane().add(alertLable);
skiplbl.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		if(optionEnable)
		{
			if(skipChoice)
			{
		skipQuestionChoice();
		skiplbl.setIcon(iconLifeSkipFinish);
		skipChoice=false;
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(skipChoice)
		{
		skiplbl.setCursor(cursor);
		}
	}
});


audienceLabel.setForeground(Color.WHITE);
audienceLabel.setBounds(10, 0, 200, 315);
getContentPane().add(audienceLabel);
skiplbl.setBounds(450, 5, 40, 40);
getContentPane().add(skiplbl);
skiplbl.setIcon(iconLifeSkip);

JLabel fiftylbl = new JLabel("");
fiftylbl.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		if(optionEnable)
		{
		if(fiftychoice)
		{
		fiftyChoice();
		fiftylbl.setIcon(iconLifeFiftyFinish);
		fiftychoice=false;
		}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(fiftychoice)
		{
		fiftylbl.setCursor(cursor);
		}
	}
});
fiftylbl.setBounds(400, 5, 40, 40);
getContentPane().add(fiftylbl);
fiftylbl.setIcon(iconLifeFifty);

JLabel audiencelbl = new JLabel("");
audiencelbl.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		if(optionEnable)
		{
		if(audiencechoice)
		{
		audienceChoice();
		audiencelbl.setIcon(iconLifeAudienceFinish);
		audiencechoice=false;
		}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(audiencechoice)
		{
		audiencelbl.setCursor(cursor);
		}
	}
});
audiencelbl.setBounds(350, 5, 40, 40);
getContentPane().add(audiencelbl);
audiencelbl.setIcon(iconLifeAudience);


progressTimerBar = new JProgressBar();
progressTimerBar.setMaximum(60);
progressTimerBar.setBounds(329, 285, 146, 30);
getContentPane().add(progressTimerBar);
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(Color.BLUE, 3, true));
		panel.setBounds(506, 0, 183, 315);
		
		panel.setLayout(null);
		getContentPane().add(panel);
		amount_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_1.setForeground(Color.ORANGE);
		amount_1.setBounds(14, 267, 180, 20);
		
		panel.add(amount_1);
		amount_2.setForeground(Color.ORANGE);
		amount_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_2.setBounds(14, 247, 180, 20);
		
		panel.add(amount_2);
		amount_3.setForeground(Color.ORANGE);
		amount_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_3.setBounds(14, 227, 180, 20);
		
		panel.add(amount_3);
		amount_4.setForeground(Color.ORANGE);
		amount_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_4.setBounds(14, 207, 180, 20);
		
		panel.add(amount_4);
		amount_5.setForeground(Color.WHITE);
		amount_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_5.setBounds(14, 187, 180, 20);
		
		panel.add(amount_5);
		amount_6.setForeground(Color.ORANGE);
		amount_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_6.setBounds(14, 167, 180, 20);
		
		panel.add(amount_6);
		amount_7.setForeground(Color.ORANGE);
		amount_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_7.setBounds(14, 147, 180, 20);
		
		panel.add(amount_7);
		amount_8.setForeground(Color.ORANGE);
		amount_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_8.setBounds(14, 127, 180, 20);
		
		panel.add(amount_8);
		amount_9.setForeground(Color.ORANGE);
		amount_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_9.setBounds(14, 107, 180, 20);
		
		panel.add(amount_9);
		amount_10.setForeground(Color.WHITE);
		amount_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_10.setBounds(14, 87, 180, 20);
		
		panel.add(amount_10);
		amount_11.setForeground(Color.ORANGE);
		amount_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_11.setBounds(14, 67, 180, 20);
		
		panel.add(amount_11);
		amount_12.setForeground(Color.ORANGE);
		amount_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_12.setBounds(14, 47, 180, 20);
		
		panel.add(amount_12);
		amount_13.setForeground(Color.ORANGE);
		amount_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_13.setBounds(14, 27, 180, 20);
		
		panel.add(amount_13);
		amount_1_bg.setForeground(Color.ORANGE);
		amount_1_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_1_bg.setBounds(0, 267, 180, 20);
		
		panel.add(amount_1_bg);
		amount_2_bg.setForeground(Color.ORANGE);
		amount_2_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_2_bg.setBounds(0, 247, 180, 20);
		
		panel.add(amount_2_bg);
		amount_3_bg.setForeground(Color.ORANGE);
		amount_3_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_3_bg.setBounds(0, 227, 180, 20);
		
		panel.add(amount_3_bg);
		amount_4_bg.setForeground(Color.ORANGE);
		amount_4_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_4_bg.setBounds(0, 207, 180, 20);
		
		panel.add(amount_4_bg);
		amount_5_bg.setForeground(Color.ORANGE);
		amount_5_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_5_bg.setBounds(0, 187, 180, 20);
		
		panel.add(amount_5_bg);
		amount_6_bg.setForeground(Color.ORANGE);
		amount_6_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_6_bg.setBounds(0, 167, 180, 20);
		
		panel.add(amount_6_bg);
		amount_7_bg.setForeground(Color.ORANGE);
		amount_7_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_7_bg.setBounds(0, 147, 180, 20);
		
		panel.add(amount_7_bg);
		amount_8_bg.setForeground(Color.ORANGE);
		amount_8_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_8_bg.setBounds(0, 127, 180, 20);
		
		panel.add(amount_8_bg);
		amount_9_bg.setForeground(Color.ORANGE);
		amount_9_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_9_bg.setBounds(0, 107, 180, 20);
		
		panel.add(amount_9_bg);
		amount_10_bg.setForeground(Color.ORANGE);
		amount_10_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_10_bg.setBounds(0, 87, 180, 20);
		
		panel.add(amount_10_bg);
		amount_11_bg.setForeground(Color.ORANGE);
		amount_11_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_11_bg.setBounds(0, 67, 180, 20);
		
		panel.add(amount_11_bg);
		amount_12_bg.setForeground(Color.ORANGE);
		amount_12_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_12_bg.setBounds(0, 47, 180, 20);
		
		panel.add(amount_12_bg);
		amount_13_bg.setForeground(Color.ORANGE);
		amount_13_bg.setFont(new Font("Tahoma", Font.BOLD, 15));
		amount_13_bg.setBounds(0, 27, 180, 20);
		
		panel.add(amount_13_bg);
		
		
		optionC.setForeground(Color.WHITE);
		optionC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		optionC.setBounds(92, 502, 217, 30);
		getContentPane().add(optionC);
		optionC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				optionC.setCursor(cursor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(check)
				{
				if(checkAnswer(e))
				{
					//CongratultionWindow cong=new CongratultionWindow();
					//cong.setVisible(true);
					optionCbg.setIcon(iconRightAnswer);
					//btnNextQuestion.setEnabled(true);
					//JDialog dialog=new JDialog(JFrame frame, "open");
				}
				else
				{
					optionCbg.setIcon(iconWrongAnswer);
					
				}
			}
			}
		});
		
		
		optionB.setForeground(Color.WHITE);
		optionB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		optionB.setBounds(411, 439, 211, 30);
		getContentPane().add(optionB);
		
		
		optionB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				optionB.setCursor(cursor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(check)
				{
				if(checkAnswer(e))
				{
					//CongratultionWindow cong=new CongratultionWindow();
					//cong.setVisible(true);
					//btnNextQuestion.setEnabled(true);
					optionBbg.setIcon(iconRightAnswer);
					
				}
				else
				{
					optionBbg.setIcon(iconWrongAnswer);
					
				}
			}
			}
		});
		
		
		optionD.setForeground(Color.WHITE);
		optionD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		optionD.setBounds(411, 502, 211, 30);
		getContentPane().add(optionD);
		optionD.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				optionD.setCursor(cursor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(check)
				{
				
				
				if(checkAnswer(e))
				{
					//CongratultionWindow cong=new CongratultionWindow();
					//cong.setVisible(true);
						
					
					//btnNextQuestion.setEnabled(true);
					
					optionDbg.setIcon(iconRightAnswer);
				}
				else
				{
					optionDbg.setIcon(iconWrongAnswer);
				}
				}
			}
			
		});
		
		
		optionA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		optionA.setForeground(Color.WHITE);
		optionA.setBounds(92, 439, 217, 30);
		getContentPane().add(optionA);
		optionA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				optionA.setCursor(cursor);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(check)
				{
				if(checkAnswer(e))
				{
					//CongratultionWindow cong=new CongratultionWindow();
					//cong.setVisible(true);
					optionAbg.setIcon(iconRightAnswer);
					
					//btnNextQuestion.setEnabled(true);
				}
				else
				{
					optionAbg.setIcon(iconWrongAnswer);
				}
			}
			}
		});
		
		JLabel lblA = new JLabel("A :");
		lblA.setForeground(Color.ORANGE);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblA.setBounds(63, 440, 23, 28);
		getContentPane().add(lblA);
		
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
		
		
		
		
		lblQ.setForeground(Color.ORANGE);
		lblQ.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblQ.setBounds(63, 318, 42, 44);
		getContentPane().add(lblQ);
		
		optionBbg.setBounds(362, 435, 281, 41);
		getContentPane().add(optionBbg);
		
		optionAbg.setBounds(45, 435, 281, 41);
		getContentPane().add(optionAbg);
		
		optionCbg.setBounds(45, 496, 281, 41);
		getContentPane().add(optionCbg);
		
		optionDbg.setBounds(362, 496, 281, 41);
		getContentPane().add(optionDbg);
		
		
		txtQuestion.setEditable(false);
		txtQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtQuestion.setWrapStyleWord(true);
		txtQuestion.setLineWrap(true);
		txtQuestion.setForeground(Color.WHITE);
		txtQuestion.setBackground(Color.BLACK);
		txtQuestion.setBounds(92, 332, 534, 78);
		txtQuestion.setColumns(10);
		txtQuestion.setBorder(null);
		getContentPane().add(txtQuestion);
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 700, 550);
		getContentPane().add(background);
		background.setIcon(iconBg);
	}
	
	int progressValue1;
	Timer timer1;
	Timer progressTimer1;
	private final JLabel skiplbl = new JLabel("");
	
	public void stopTimer()
	{
		if(timer!=null)
		{
		timer.stop();
		timer=null;
		}
		if(progressTimer!=null)
		{
		progressTimer.stop();
		progressTimer=null;
		}
	}
	public void questionUpload(){
		if(progressValue1!=0)
		{
			progressValue1=0;
		}
		stopTimer();
		
		/*if(progressTimerBar!=null)
		{
			
			progressTimerBar=null;
			
		}*/
		if(timer1!=null)
		timer1=null;
		if(progressTimer1!=null)
		progressTimer1=null;
		
		ActionListener l = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						optionEnable=false;
						if(progressValue1<2){
						//progressBar.setValue(progressValue1);
						progressValue1++;
						}
						else
						{
							
							//SplashScreen.this.setVisible(false);
							if(timer1!=null){
							timer1.stop();
							}
							if(progressTimer1!=null){
							progressTimer1.stop();
							}
							if(rightAnswer)
							{
							clearControl();
							if(playerQuestionNo==13)
							{ 
								gameOver();								
							}
							
							nextQuestion();
							optionEnable=true;
							}
							else
							{
								gameOver();
							}
							//SplashScreen.this.dispose();
//							Home home = new Home();
//							home.setVisible(true);
						}
						
					}
				};
				progressTimer1 = new Timer(1000,l);
				progressTimer1.start();
			}
	public boolean checkAnswer(MouseEvent e)
	{
		JLabel btn=(JLabel)e.getSource();
		String clicked=btn.getText();
		
		if(clicked.equals(answer))
		{
			//congratsWindow();
			try{
				PlaySounds.stop();
			PlaySounds.rightAnswer();
			}
			catch(MalformedURLException ex)
			{
				
			}
			playerQuestionNo++;
			setAmountWin(playerQuestionNo);			
			questionUpload();
			check=false;
			
			//disableControls();
			//btnNextQuestion.setEnabled(true);
			
		return true;
		}
		else
		{
			if(optionA.getText().equals(answer))
			{
				optionAbg.setIcon(iconRightAnswer);
			}
			if(optionB.getText().equals(answer))
			{
				optionBbg.setIcon(iconRightAnswer);
			}
			if(optionC.getText().equals(answer))
			{
				optionCbg.setIcon(iconRightAnswer);
			}
			if(optionD.getText().equals(answer))
			{
				optionDbg.setIcon(iconRightAnswer);
			}
			rightAnswer=false;
			questionUpload();
			
			check=false;
			try{
				PlaySounds.stop();
				PlaySounds.playSound("WrongAnswer.mp3");
				}
				catch(Exception ex){}
			
			
			//gameOver();
			return false;
			
			
		}
		
	}
	
	/*public void disableControls(MouseListener e)
	{
		optionA.removeMouseListener(e);
		optionA.setEnabled(false);
		optionB.setEnabled(false);
		optionC.setEnabled(false);
		optionD.setEnabled(false);
	}*/
	public void setAmountWin(int playerQuestionNo)
	{
//		String name;
//		name="amount_"+playerQuestionNo+"_bg";
//		JLabel lbl=new JLabel();
//		
		if(playerQuestionNo==1)
		{
			
			amount_1_bg.setIcon(null);
		//amount_1_bg.setIcon(iconAmountWin);
		amount_2_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==2)
		{
			amount_2_bg.setIcon(null);
		//amount_2_bg.setIcon(iconAmountWin);
		amount_3_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==3)
		{
			amount_3_bg.setIcon(null);
		//amount_3_bg.setIcon(iconAmountWin);
		amount_4_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==4)
		{
			amount_4_bg.setIcon(null);
		//amount_4_bg.setIcon(iconAmountWin);
		amount_5_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==5)
		{
		amount_5_bg.setIcon(null);
		amount_6_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==6)
		{
		amount_6_bg.setIcon(null);
		amount_7_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==7)
		{
		amount_7_bg.setIcon(null);
		amount_8_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==8)
		{
		amount_8_bg.setIcon(null);
		amount_9_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==9)
		{
		amount_9_bg.setIcon(null);
		amount_10_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==10)
		{
		amount_10_bg.setIcon(null);
		amount_11_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==11)
		{
		amount_11_bg.setIcon(null);
		amount_12_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==12)
		{
		amount_12_bg.setIcon(null);
		amount_13_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==13)
		{
		amount_13_bg.setIcon(null);
		//amount_14_bg.setIcon(iconQuestionAmount);
		}
		/*if(playerQuestionNo==14)
		{
		amount_14_bg.setIcon(null);
		amount_15_bg.setIcon(iconQuestionAmount);
		}
		if(playerQuestionNo==15)
		{
		amount_15_bg.setIcon(null);
		//amount_15_bg.setIcon(iconQuestionAmount);
		}*/
		Player.totalAmountWin=Player.winAmounts[playerQuestionNo];
	}
	public void gameOver()
	{
		PlaySounds.stop();
		stopTimer();
		this.dispose();
		GameOver gameOver=new GameOver();
		gameOver.setVisible(true);
		//PlaySounds.stop();
		//this.setVisible(false);
		
		if(Player.totalAmountWin==500000000)
		{
			try{
				PlaySounds.playSound("Winner.mp3");
			}
			catch(Exception ex)
			{
				System.out.println("player wrror"+ex.toString());
			}
		}

	}
	public void skipQuestionChoice()
	{
		if(skipChoice)
		{
		skip++;
		stopTimer();
		nextQuestion();
		}
		
	}
	public void fiftyChoice()
	{
		RandomNumberFifty random=new RandomNumberFifty();
		int randomNumber[]=random.getGetRandom();
		int a=0;
		for(int r:randomNumber)
		{
			if(r==1)
			{
			if(!optionA.getText().equals(answer))
			{
				a++;
				//optionA.setText("");
				optionA.setVisible(false);
			}
			}
			else if(r==2)
			{
				if(!optionB.getText().equals(answer))
				{
					a++;
					//optionB.setText("");
					optionB.setVisible(false);
				}
			}
			else if(r==3)
			{
				if(!optionC.getText().equals(answer))
				{
					a++;
					//optionC.setText("");
					optionC.setVisible(false);
				}
			}
			else if(r==4)
			{
				if(!optionD.getText().equals(answer))
				{
					a++;
					//optionD.setText("");
					optionD.setVisible(false);
				}
			}
			if(a==2)
			{
				break;
			}
		}		
	}
	public void audienceChoice()
	{
		if(answer.equals(optionA.getText()))
		{
			audienceLabel.setIcon(iconAudienceA);
		}
		if(answer.equals(optionB.getText()))
		{
			audienceLabel.setIcon(iconAudienceB);
		}
		if(answer.equals(optionC.getText()))
		{
			audienceLabel.setIcon(iconAudienceC);
		}
		if(answer.equals(optionD.getText()))
		{
			audienceLabel.setIcon(iconAudienceD);
		}
	}
}
