package pack01;

public class DeplacementL implements Deplacement {

	@Override
	public void seDeplacer(Robot r) {
		r.doL();
	}

	@Override
	public String toString() {
		return "L";
	}
}
