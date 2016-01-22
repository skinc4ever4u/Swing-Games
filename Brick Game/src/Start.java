import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Start extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
					Start frame = new Start();
					frame.setVisible(true);
					frame.startTimers();
				
			}

	Icon brickRedIcon=new ImageIcon(Start.class.getResource("red.jpg"));
	Icon brickGreenIcon=new ImageIcon(Start.class.getResource("green.jpg"));
	Icon brickYellowIcon=new ImageIcon(Start.class.getResource("yellow.jpg"));
	Icon brickBlueIcon=new ImageIcon(Start.class.getResource("blue.jpg"));
	Icon ballIcon=new ImageIcon(Start.class.getResource("ball.png"));
	Icon bucketIcon=new ImageIcon(Start.class.getResource("bucket.png"));
	
	JLabel brick1;
	JLabel brick2;
	JLabel brick3;
	JLabel brick4;
	JLabel brick5;
	JLabel brick6;
	JLabel brick7;
	JLabel brick8;
	JLabel ball;
	JLabel bucket;
	
	//int ballX[]=new int[1];
	
	BallDTO ballObj;
	BrickDTO brick1obj;
	BrickDTO brick2obj;
	BrickDTO brick3obj;
	BrickDTO brick4obj;
	BrickDTO brick5obj;
	BrickDTO brick6obj;
	BrickDTO brick7obj;
	BrickDTO brick8obj;
	

	Timers timer1;
	Timers timer2;
	Timers timer3;
	Timers timer4;
	Timers timer5;
	Timers timer6;
	Timers timer7;
	Timers timer8;
	Timers timerBall;
	
	public Start() {
		setResizable(false);
		ballObj=new BallDTO();
		ballObj.setX(0);
		ballObj.setY(20);
		ballObj.setBallAtBrick(1);
		ballObj.setMove(true);
		brick1obj=new BrickDTO();
		brick1obj.setX(0);
		brick1obj.setY(50);
		brick2obj=new BrickDTO();
		brick2obj.setX(100);
		brick2obj.setY(100);
		brick3obj=new BrickDTO();
		brick3obj.setX(280);
		brick3obj.setY(150);
		brick4obj=new BrickDTO();
		brick4obj.setX(230);
		brick4obj.setY(200);
		brick5obj=new BrickDTO();
		brick5obj.setX(80);
		brick5obj.setY(250);
		brick6obj=new BrickDTO();
		brick6obj.setX(200);
		brick6obj.setY(300);
		brick7obj=new BrickDTO();
		brick7obj.setX(370);
		brick7obj.setY(350);
		brick8obj=new BrickDTO();
		brick8obj.setX(20);
		brick8obj.setY(400);
		
		
		
		
		timer1=new Timers(true);
		timer2=new Timers(false);
		timer3=new Timers(true);
		timer4=new Timers(false);
		timer5=new Timers(true);
		timer6=new Timers(false);
		timer7=new Timers(true);
		timer8=new Timers(false);
		timerBall=new Timers(true);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int a=e.getKeyCode();
				if(ballObj.isMove()){
				if(a==39){
					
					ballObj.setX(ballObj.getX()+5);
					check();
					
				}
				if(a==37){
					ballObj.setX(ballObj.getX()-5);
					check();
					
				}
				}
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		getContentPane().setLayout(null);
		
		ball = new JLabel();
		ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
		ball.setIcon(ballIcon);
		getContentPane().add(ball);
		
		brick1 = new JLabel();
		brick1.setBounds(brick1obj.getX(), brick1obj.getY(), 80, 14);
		brick1.setIcon(brickRedIcon);
		getContentPane().add(brick1);
		
		brick2 = new JLabel();
		brick2.setBounds(brick2obj.getX(), brick2obj.getY(), 80, 14);
		brick2.setIcon(brickYellowIcon);
		getContentPane().add(brick2);
		
		brick3 = new JLabel();
		brick3.setBounds(brick3obj.getX(), brick3obj.getY(), 80, 14);
		brick3.setIcon(brickGreenIcon);
		getContentPane().add(brick3);
		
		
		brick4 = new JLabel();
		brick4.setBounds(brick4obj.getX(), brick4obj.getY(), 80, 14);
		brick4.setIcon(brickBlueIcon);
		getContentPane().add(brick4);
		
		brick5 = new JLabel();
		brick5.setBounds(brick5obj.getX(), brick5obj.getY(), 80, 14);
		brick5.setIcon(brickRedIcon);
		getContentPane().add(brick5);
		
		brick6 = new JLabel();
		brick6.setBounds(brick6obj.getX(), brick6obj.getY(), 80, 14);
		brick6.setIcon(brickYellowIcon);
		getContentPane().add(brick6);
		
		brick7 = new JLabel();
		brick7.setBounds(brick7obj.getX(), brick7obj.getY(), 80, 14);
		brick7.setIcon(brickGreenIcon);
		getContentPane().add(brick7);
		
		brick8 = new JLabel();
		brick8.setBounds(brick8obj.getX(), brick8obj.getY(), 80, 14);
		brick8.setIcon(brickBlueIcon);
		getContentPane().add(brick8);
		
		bucket = new JLabel();
		bucket.setBounds(230,443, 40, 30);
		bucket.setIcon(bucketIcon);
		getContentPane().add(bucket);
	}
	
	public void check(){
		if(ballObj.getBallPosition()==1)
		{
		if(ballObj.getX()>(brick1obj.getX()+70) ||ballObj.getX()<(brick1obj.getX()-20) )
		{
			fall();
		}
		else{
			//ballObj.setBallAtBrick(1);
		ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
		}
		}
		else if(ballObj.getBallPosition()==2)
		{
		if(ballObj.getX()>(brick2obj.getX()+70) ||ballObj.getX()<(brick2obj.getX()-20) )
		{
			fall();
		}
		else{
			//ballObj.setBallAtBrick(1);
		ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
		}
		}
		else if(ballObj.getBallPosition()==3)
		{
		if(ballObj.getX()>(brick3obj.getX()+70) ||ballObj.getX()<(brick3obj.getX()-20) )
		{
			fall();
		}
		else{
			//ballObj.setBallAtBrick(1);
		ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
		}
		}
		else if(ballObj.getBallPosition()==4)
		{
		if(ballObj.getX()>(brick4obj.getX()+70) ||ballObj.getX()<(brick4obj.getX()-20) )
		{
			fall();
		}
		else{
			//ballObj.setBallAtBrick(1);
		ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
		}
		}
		
		else if(ballObj.getBallPosition()==5)
		{
		if(ballObj.getX()>(brick5obj.getX()+70) ||ballObj.getX()<(brick5obj.getX()-20) )
		{
			fall();
		}
		else{
			//ballObj.setBallAtBrick(1);
		ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
		}
		}
		
		else if(ballObj.getBallPosition()==6)
		{
		if(ballObj.getX()>(brick6obj.getX()+70) ||ballObj.getX()<(brick6obj.getX()-20) )
		{
			fall();
		}
		else{
			//ballObj.setBallAtBrick(1);
		ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
		}
		}
		
		else if(ballObj.getBallPosition()==7)
		{
		if(ballObj.getX()>(brick7obj.getX()+70) ||ballObj.getX()<(brick7obj.getX()-20) )
		{
			fall();
		}
		else{
			//ballObj.setBallAtBrick(1);
		ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
		}
		}
		
		else if(ballObj.getBallPosition()==8)
		{
		if(ballObj.getX()>(brick8obj.getX()+70) ||ballObj.getX()<(brick8obj.getX()-20) )
		{
			fall();
		}
		else{
			//ballObj.setBallAtBrick(1);
		ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
		}
		}
		
		/*if(ballObj.getBallPosition()==9)
		{
		if(ballObj.getX()>=230 ||ballObj.getX()<=270 )
		{
			fall();
		}
		else{
			//ballObj.setBallAtBrick(1);
		ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
		}
		}*/
	}
	public void gameOver(){
		timer1.stopTimer();
		timer2.stopTimer();
		timer3.stopTimer();
		timer4.stopTimer();
		timer5.stopTimer();
		timer6.stopTimer();
		timer7.stopTimer();
		timer8.stopTimer();
		timerBall.stopTimer();
		timer1.startTimer(brick1obj);
		timer2.startTimer(brick2obj);
		timer3.startTimer(brick3obj);
		timer4.startTimer(brick4obj);
		timer5.startTimer(brick5obj);
		timer6.startTimer(brick6obj);
		timer7.startTimer(brick7obj);
		timer8.startTimer(brick8obj);
		
	}
	public void fall(){
		ballObj.setMove(false);
		ballObj.setBallPosition(ballObj.getBallPosition()+1);
		startTimers2();
		if(ballObj.getBallPosition()==2){
			//ballObj.setSpeed(1);
			ballObj.setSpeed(brick2obj.getSpeed());
			timerBall.ballFallStart(ballObj,brick2obj,this);
			
			
		}
		
		if(ballObj.getBallPosition()==3){
			ballObj.setSpeed(brick3obj.getSpeed());
			timerBall.condition=true;
			timerBall.ballFallStart(ballObj,brick3obj,this);
			}
		
		if(ballObj.getBallPosition()==4){
			ballObj.setSpeed(brick4obj.getSpeed());
			timerBall.condition=true;
			timerBall.ballFallStart(ballObj,brick4obj,this);
			}
		
		if(ballObj.getBallPosition()==5){
			ballObj.setSpeed(brick5obj.getSpeed());
			timerBall.condition=true;
			timerBall.ballFallStart(ballObj,brick5obj,this);
			}
		
		if(ballObj.getBallPosition()==6){
			ballObj.setSpeed(brick6obj.getSpeed());
			timerBall.condition=true;
			timerBall.ballFallStart(ballObj,brick6obj,this);
			}
		
		if(ballObj.getBallPosition()==7){
			ballObj.setSpeed(brick7obj.getSpeed());
			timerBall.condition=true;
			timerBall.ballFallStart(ballObj,brick7obj,this);
			}
		if(ballObj.getBallPosition()==8){
			ballObj.setSpeed(brick8obj.getSpeed());
			timerBall.condition=true;
			timerBall.ballFallStart(ballObj,brick8obj,this);
			}
		
		
		if(ballObj.getBallPosition()==9){
			if(ballObj.getX()>=230 && ballObj.getX()<=270){
				ballObj.setX(235);
				ballObj.setY(445);
				ball.setBounds(ballObj.getX(), ballObj.getY(), 30, 30);
				//System.out.println("You Win");
				this.dispose();
				GameOver game=new GameOver("You Win","New Game");
				game.setVisible(true);
				}
					else {
						//System.out.println("Game over");
						this.dispose();
						GameOver game=new GameOver("Game Over","Play Again");
						game.setVisible(true);
					}
			}
		//ballObj.setBallAtBrick(2);
		
	}
	public void startTimers()
	{
		
		brick1obj.setSpeed(10);
		brick1obj.setBrick(brick1);
		brick2obj.setSpeed(1);
		brick2obj.setBrick(brick2);
		brick3obj.setSpeed(5);
		brick3obj.setBrick(brick3);
		brick4obj.setSpeed(7);
		brick4obj.setBrick(brick4);
		brick5obj.setSpeed(3);
		brick5obj.setBrick(brick5);
		brick6obj.setSpeed(9);
		brick6obj.setBrick(brick6);
		brick7obj.setSpeed(2);
		brick7obj.setBrick(brick7);
		brick8obj.setSpeed(8);
		brick8obj.setBrick(brick8);
		
		ballObj.setBall(ball);
		
		
		//timer1.startTimer(brick1obj);
		if(ballObj.getBallPosition()==1 && ballObj.isMove()){
			//timer1.stopTimer();
		timer1.startTimerWithBall(brick1obj,ballObj);
		}
		
		else{
			timer1.stopTimer();
			timerBall.stopTimer();
			timer1.startTimer(brick1obj);
		}
		if(ballObj.getBallPosition()==2 && ballObj.isMove()){
			//timer2.stopTimer();
			timer2.startTimerWithBall(brick2obj,ballObj);
			}
			else{
				timer2.stopTimer();
				timerBall.stopTimer();
				timer2.startTimer(brick2obj);
		}
		if(ballObj.getBallPosition()==3 && ballObj.isMove()){
			//
			timer3.startTimerWithBall(brick3obj,ballObj);
			}
			else{
				timer3.stopTimer();
				timer3.startTimer(brick3obj);
			}
		if(ballObj.getBallPosition()==4 && ballObj.isMove()){
			//timer4.stopTimer();
			timer4.startTimerWithBall(brick4obj,ballObj);
			}
		else{
			timer4.stopTimer();
			timer4.startTimer(brick4obj);
			}
		
		if(ballObj.getBallPosition()==5 && ballObj.isMove()){
			//timer1.stopTimer();
		timer5.startTimerWithBall(brick5obj,ballObj);
		}
		
		else{
			timer5.stopTimer();
			timerBall.stopTimer();
			timer5.startTimer(brick5obj);
		}
		
		if(ballObj.getBallPosition()==6 && ballObj.isMove()){
			//timer1.stopTimer();
		timer6.startTimerWithBall(brick6obj,ballObj);
		}
		
		else{
			timer6.stopTimer();
			timerBall.stopTimer();
			timer6.startTimer(brick6obj);
		}
		
		if(ballObj.getBallPosition()==7 && ballObj.isMove()){
			//timer1.stopTimer();
		timer7.startTimerWithBall(brick7obj,ballObj);
		}
		
		else{
			timer7.stopTimer();
			timerBall.stopTimer();
			timer7.startTimer(brick7obj);
		}
		if(ballObj.getBallPosition()==8 && ballObj.isMove()){
			//timer1.stopTimer();
		timer8.startTimerWithBall(brick8obj,ballObj);
		}
		
		else{
			timer8.stopTimer();
			timerBall.stopTimer();
			timer8.startTimer(brick8obj);
		}
		
	}
	
	public void startTimers2()
	{
		
		brick1obj.setSpeed(10);
		brick1obj.setBrick(brick1);
		brick2obj.setSpeed(1);
		brick2obj.setBrick(brick2);
		brick3obj.setSpeed(5);
		brick3obj.setBrick(brick3);
		brick4obj.setSpeed(7);
		brick4obj.setBrick(brick4);
		brick5obj.setSpeed(3);
		brick5obj.setBrick(brick5);
		brick6obj.setSpeed(9);
		brick6obj.setBrick(brick6);
		brick7obj.setSpeed(2);
		brick7obj.setBrick(brick7);
		brick8obj.setSpeed(8);
		brick8obj.setBrick(brick8);
		
		ballObj.setBall(ball);
		
		switch (ballObj.getBallPosition()) {
		case 1:
			if(ballObj.getBallPosition()==1 && ballObj.isMove()){
				//timer1.stopTimer();
			timer1.startTimerWithBall(brick1obj,ballObj);
			}
			
			else{
				timer1.stopTimer();
				timerBall.stopTimer();
				timer1.startTimer(brick1obj);
			}
			break;
		case 2:
			if(ballObj.getBallPosition()==2 && ballObj.isMove()){
				//timer2.stopTimer();
				timer2.startTimerWithBall(brick2obj,ballObj);
				}
				else{
					timer2.stopTimer();
					timerBall.stopTimer();
					timer2.startTimer(brick2obj);
			}
			break;
		case 3:
			if(ballObj.getBallPosition()==3 && ballObj.isMove()){
				//
				timer3.startTimerWithBall(brick3obj,ballObj);
				}
				else{
					timer3.stopTimer();
					timer3.startTimer(brick3obj);
				}
			break;
		case 4:
			if(ballObj.getBallPosition()==4 && ballObj.isMove()){
				//timer4.stopTimer();
				timer4.startTimerWithBall(brick4obj,ballObj);
				}
			else{
				timer4.stopTimer();
				timer4.startTimer(brick4obj);
				}
			break;
		case 5:
			if(ballObj.getBallPosition()==5 && ballObj.isMove()){
				//timer1.stopTimer();
			timer5.startTimerWithBall(brick5obj,ballObj);
			}
			
			else{
				timer5.stopTimer();
				timerBall.stopTimer();
				timer5.startTimer(brick5obj);
			}
			break;
		case 6:
			if(ballObj.getBallPosition()==6 && ballObj.isMove()){
				//timer1.stopTimer();
			timer6.startTimerWithBall(brick6obj,ballObj);
			}
			
			else{
				timer6.stopTimer();
				timerBall.stopTimer();
				timer6.startTimer(brick6obj);
			}
			break;
		case 7:
			if(ballObj.getBallPosition()==7 && ballObj.isMove()){
				//timer1.stopTimer();
			timer7.startTimerWithBall(brick7obj,ballObj);
			}
			
			else{
				timer7.stopTimer();
				timerBall.stopTimer();
				timer7.startTimer(brick7obj);
			}
			break;
		case 8:
			if(ballObj.getBallPosition()==8 && ballObj.isMove()){
				//timer1.stopTimer();
			timer8.startTimerWithBall(brick8obj,ballObj);
			}
			
			else{
				timer8.stopTimer();
				timerBall.stopTimer();
				timer8.startTimer(brick8obj);
			}
			break;			

		default:
			
				timer8.stopTimer();
				timerBall.stopTimer();
				timer8.startTimer(brick8obj);
			break;
		}
		
		//timer1.startTimer(brick1obj);
		
		
	}
}
