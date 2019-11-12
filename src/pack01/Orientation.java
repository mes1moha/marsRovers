package pack01;

import pack01.exception.OverBoundsException;

public enum Orientation {
	N, E, S, O;
	
	public void testDepacement(int maxPos, int nextPos) throws OverBoundsException
	{
		if(maxPos < nextPos || nextPos < 0) 
			throw new OverBoundsException("Tentative de deplacement vers : "+
					nextPos+" Max = " + maxPos);	
	}
	
	public void changePosition(Robot r) throws OverBoundsException {
		switch (this) {
		case E:	
			testDepacement(r.getPlatToExplor().getMax_X(), r.getPosition().x+1);
			r.getPosition().x++;	
			break;
		case N:	
			testDepacement(r.getPlatToExplor().getMax_Y(), r.getPosition().y+1);
			r.getPosition().y++;	break;
		case O:	
			testDepacement(r.getPlatToExplor().getMax_X(), r.getPosition().x-1);	
			r.getPosition().x--;	break;
		case S:
			testDepacement(r.getPlatToExplor().getMax_Y(), r.getPosition().y-1);
			r.getPosition().y--;	break;
		}
	}
}
