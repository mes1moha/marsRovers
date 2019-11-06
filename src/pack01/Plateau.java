package pack01;

public class Plateau {
	
	private int max_X;
	private int max_Y;
	
	public Plateau(int max_X, int max_Y) {
		super();
		this.max_X = max_X;
		this.max_Y = max_Y;
	}

	public int getMax_X() {
		return max_X;
	}

	public void setMax_X(int max_X) {
		this.max_X = max_X;
	}

	public int getMax_Y() {
		return max_Y;
	}

	public void setMax_Y(int max_Y) {
		this.max_Y = max_Y;
	}
	
}
