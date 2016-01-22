import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;


public class Timers {
	
	Timer timer;
	int borderX;
	int borderY;
	boolean condition;
	
	Icon gameOverIcon=new ImageIcon(Start.class.getResource("gameOver.gif"));
	Timers(boolean move)
	{
		this.borderX=0;
		this.borderY=415;
		this.condition=move;
	}
	
	public void startTimer(BrickDTO brick){
		
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(condition){
					
					if(brick.getX()==borderY)
					{
						condition=false;
					}
					brick.setX(brick.getX()+1);
					//x++;
					
					brick.getBrick().setBounds(brick.getX(), brick.getY(), 80, 14);
					
					
				}
				else{
					
					if(brick.getX()==borderX)
					{
						condition=true;
					}
					brick.setX(brick.getX()-1);
					//x--;
					brick.getBrick().setBounds(brick.getX(), brick.getY(), 80, 14);
				}
				
			}
		};
		timer=new Timer(brick.getSpeed(), listener);
		timer.start();
	}
	
public void ballFallStart(BallDTO ball,BrickDTO brick,Start start){
		//borderY=500;
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(condition){
					
					if(ball.getY()==brick.getY()-30)
					{
						condition=false;
					}
					ball.setY(ball.getY()+5);
					
					ball.getBall().setBounds(ball.getX(), ball.getY(), 30, 30);
					
					
				}
				else{
					if(ball.getX()>=brick.getX() && ball.getX()<=brick.getX()+80){
					
				ball.getBall().setBounds(ball.getX(), ball.getY(), 30, 30);
				timer.stop();
				ball.setMove(true);
				start.startTimers();
				
				}
					else {
						
						/*start.dispose();
						GameOver game=new GameOver("You Lose","Play Again");
						game.setVisible(true);*/
						timer.stop();
						gameOver(ball,start);
					}					
				}
				
			}
		};
		timer=new Timer(ball.getSpeed(), listener);
		timer.start();
	}

public void gameOver(BallDTO ball,Start start){
	ActionListener listener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(condition){
				
				if(ball.getY()>=430)
				{
					
					condition=false;
					ball.getBall().setIcon(gameOverIcon);
					ball.getBall().setBounds(ball.getX(), ball.getY()-20, 30, 30);
					timer.stop();
				}
				ball.setY(ball.getY()+5);
				
				ball.getBall().setBounds(ball.getX(), ball.getY(), 30, 30);
				
			}
			else{	
				ball.setY(ball.getY()+5);
				if(ball.getY()>430){
					//System.out.println("Game Over");
					
					ball.getBall().setIcon(gameOverIcon);
					ball.getBall().setBounds(ball.getX(), 445, 30, 30);
					
				}
				if(ball.getY()>1000){
					start.dispose();
					GameOver game=new GameOver("You Lose","Play Again");
					game.setVisible(true);
					timer.stop();
				}
					
			
			//ball.getBall().setIcon(ballBurst);;
			
			}
		}
	};
	timer=new Timer(ball.getSpeed(), listener);
	timer.start();	
}
	
public void startTimerWithBall(BrickDTO brick,BallDTO ball){
		
		if(timer!=null){
			if(timer.isRunning())
			{
				timer.stop();
			}
		//timer.stop();
		}
		
		
		ActionListener listener=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(condition){
					
					if(brick.getX()==borderY)
					{
						condition=false;
					}
					brick.setX(brick.getX()+1);
					brick.getBrick().setBounds(brick.getX(), brick.getY(), 80, 14);
					
					ball.setX(ball.getX()+1);
					ball.getBall().setBounds(ball.getX(), ball.getY(), 30, 30);
					
					
					
					
				}
				else{
					
					if(brick.getX()==borderX)
					{
						condition=true;
					}
					brick.setX(brick.getX()-1);
					ball.setX(ball.getX()-1);
					brick.getBrick().setBounds(brick.getX(), brick.getY(), 80, 14);
					ball.getBall().setBounds(ball.getX(), ball.getY(), 30, 30);
				}
				
			}
		};
		timer=new Timer(brick.getSpeed(), listener);
		if(!timer.isRunning()){
		timer.start();
		}
	}
	

	public void stopTimer()
	{
		if(timer!=null){
		timer.stop();
		}
	}
	
}
