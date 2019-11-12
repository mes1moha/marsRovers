package pack01;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import pack01.exception.LectureConfigPlatequException;
import pack01.exception.LectureDeplacementException;
import pack01.exception.LectureOrientationException;
import pack01.exception.LecturePtDepartException;
import pack01.exception.OverBoundsException;

public class AppMarsRovers {

	public static void main(String[] args) {
		ParserFileConfig pfc = null;
		Plateau p;
		List<Ordre> listOrdres;
		List<Robot> robots = new ArrayList<Robot>();
		Robot robot;
		try {
			pfc = new ParserFileConfig(args[0]);
			p = pfc.getPlateau(); 
			listOrdres = pfc.getListOrder();
			
			for (Ordre ordre : listOrdres) {
				robot = new Robot();
				robot.setPlatToExplor(p);
				robot.execOrder(ordre);
				robots.add(robot);
			}
			
			System.out.println(robots);
		} catch (FileNotFoundException | LectureConfigPlatequException | LecturePtDepartException
				| LectureOrientationException | LectureDeplacementException | OverBoundsException e) {
			System.err.println(e.toString());
		} finally {
			if(pfc!=null) pfc.closeScanner();
		}
	}

}
