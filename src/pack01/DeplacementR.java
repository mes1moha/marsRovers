package pack01;

public class DeplacementR implements Deplacement{

	@Override
	public void seDeplacer(Robot r) {
		r.doR();
	}
	
	@Override
	public String toString() {
		return "R";
	}

}
