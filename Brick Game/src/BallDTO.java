import javax.swing.JLabel;


public class BallDTO {
	private int X;
	private int Y;
	private int ballAtBrick;
	
	private int ballPosition;
	
	private int speed;
	
	private boolean move;
	
	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	BallDTO(){
		this.ballPosition=1;
	}
	
	public int getBallPosition() {
		return ballPosition;
	}

	public void setBallPosition(int ballPosition) {
		this.ballPosition = ballPosition;
	}


	public int getBallAtBrick() {
		return ballAtBrick;
	}


	public void setBallAtBrick(int ballAtBrick) {
		this.ballAtBrick = ballAtBrick;
	}


	private JLabel ball;


	public int getX() {
		return X;
	}


	public void setX(int x) {
		X = x;
	}


	public int getY() {
		return Y;
	}


	public void setY(int y) {
		Y = y;
	}


	public JLabel getBall() {
		return ball;
	}


	public void setBall(JLabel ball) {
		this.ball = ball;
	}

}
