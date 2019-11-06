package pack01;

import pack01.exception.OverBoundsException;

public class DeplacementM implements Deplacement{

	@Override
	public void seDeplacer(Robot r) throws OverBoundsException {
		r.doM();
	}

	@Override
	public String toString() {
		return "M";
	}

	
}
