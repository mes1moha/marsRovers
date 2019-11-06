package pack01;

import java.util.List;

import pack01.exception.OverBoundsException;

public class Robot {
	
	private Point2D position;
	private Orientation orientation;
	private Plateau platToExplor;
	
	public Robot(Point2D position, String orientation) {
		super();
		this.position = position;
		this.orientation = Orientation.valueOf(orientation);
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}
	
	public Plateau getPlatToExplor() {
		return platToExplor;
	}

	public void setPlatToExplor(Plateau platToExplor) {
		this.platToExplor = platToExplor;
	}

	public void doM() throws OverBoundsException{
		orientation.changePosition(this);
	}
	
	public void doL() {
		int len = Orientation.values().length;
		this.orientation = Orientation.values()[(this.orientation.ordinal()-1+len)%len];
	}
	
	public void doR() {
		int len = Orientation.values().length;
		this.orientation = Orientation.values()[(this.orientation.ordinal()+1)%len];
	}
	
	public void execOrder(Ordre ordre) throws OverBoundsException
	{
		List<Deplacement> tabDeplacement = ordre.getSuiteDeplacements();
		this.position = ordre.getPtInit();
		
		for (Deplacement deplacement : tabDeplacement) {
			deplacement.seDeplacer(this);
		}
	}
	
	@Override
	public String toString()
	{
		return this.position.x +" " + this.position.y + " " +this.orientation;
	}
	
}
