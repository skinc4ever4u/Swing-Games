import javax.swing.JLabel;


public class BrickDTO {
	private JLabel brick;
	
	private int X;
	private int Y;
	private int speed;
	public JLabel getBrick() {
		return brick;
	}
	public void setBrick(JLabel brick) {
		this.brick = brick;
	}
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
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
