package pack01;

import pack01.exception.OverBoundsException;

public interface Deplacement {
	public void seDeplacer(Robot r) throws OverBoundsException;
}
