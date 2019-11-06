package pack01;


import java.util.List;

public class AppMarsRovers {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ParserFileConfig pfc = new ParserFileConfig("input.txt");
		Plateau p = pfc.getPlateau(); 
		List<Ordre> listOrdres = pfc.getListOrder();
		System.out.println(listOrdres);
	}

}
