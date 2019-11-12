package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


import pack01.Deplacement;
import pack01.DeplacementL;
import pack01.DeplacementM;
import pack01.DeplacementR;
import pack01.Ordre;
import pack01.Orientation;
import pack01.ParserFileConfig;
import pack01.Plateau;
import pack01.Point2D;
import pack01.exception.LectureConfigPlatequException;
import pack01.exception.LectureDeplacementException;
import pack01.exception.LectureOrientationException;
import pack01.exception.LecturePtDepartException;

public class ParsingTest {
	
	ParserFileConfig pfc; 
	Plateau plateau;
	List<Ordre> listOrdres;
	public static final String urlFolder = "jeuxtests";
	
	@Test
	public void testCharToDeplacement() throws FileNotFoundException {
		
		assertEquals(ParserFileConfig.charToDeplacement('M').getClass().getName(), 
				new DeplacementM().getClass().getName());
		assertEquals(ParserFileConfig.charToDeplacement('L').getClass().getName(), 
				new DeplacementL().getClass().getName());
		assertEquals(ParserFileConfig.charToDeplacement('R').getClass().getName(), 
				new DeplacementR().getClass().getName());
		
	}

	@Test
	public void test() {
		Point2D ptDep = null;
		Orientation orientation = null;
		List<Deplacement> lstDepl = null;
		List<Deplacement> tabDep = null ;
		
		try {
			pfc = new ParserFileConfig(urlFolder+"/inputTest.txt");
			
			plateau = pfc.getPlateau();
			assertEquals(plateau.getMax_X(),5);
			assertEquals(plateau.getMax_Y(),4);
			
			ptDep = pfc.getPointDepart();
			assertEquals(ptDep.x, 1);
			assertEquals(ptDep.y, 2);
			
			orientation = pfc.getOrientation();
			assertEquals(orientation, Orientation.N);
			
			lstDepl = pfc.getDeplacements();
			//L M L M L M L M M R M
			tabDep = Arrays.asList(new DeplacementL(), new DeplacementM(),
				new DeplacementL(),new DeplacementM(),
				new DeplacementL(),new DeplacementM(),
				new DeplacementL(),new DeplacementM(),
				new DeplacementM(),new DeplacementR(),
				new DeplacementM());
			assertEquals(lstDepl.toArray().length, tabDep.toArray().length);
		} catch (FileNotFoundException e) {
				System.err.println(e.toString());
		}
		catch (LectureConfigPlatequException e) {
			System.err.println(e.toString());
		}
		catch (LecturePtDepartException e) {
			System.err.println(e.toString());
		}
		catch (LectureOrientationException e) {
			System.err.println(e.toString());
		}
		catch (LectureDeplacementException e) {
			System.err.println(e.toString());
		}
	}

}
