package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import pack01.Deplacement;
import pack01.DeplacementL;
import pack01.DeplacementM;
import pack01.DeplacementR;
import pack01.Ordre;
import pack01.Orientation;
import pack01.Plateau;
import pack01.Point2D;
import pack01.Robot;
import pack01.exception.OverBoundsException;

public class RobotTest {
	
	Robot robot = new Robot();

	@Test
	public void test1() {
		List<Deplacement> lstDep = Arrays.asList(new DeplacementL(), new DeplacementM(),
				new DeplacementL(),new DeplacementM(),
				new DeplacementL(),new DeplacementM(),
				new DeplacementL(),new DeplacementM(),
				new DeplacementM());
		robot.setPlatToExplor(new Plateau(5, 5));
		Ordre ordre = new Ordre(new Point2D(1, 2), Orientation.N, lstDep);
		try {
			robot.execOrder(ordre);
			assertEquals(robot.getPosition().x,1);
			assertEquals(robot.getPosition().y,3);
			assertEquals(robot.getOrientation(), Orientation.N);
		} catch (OverBoundsException e) {
			System.err.println(e.toString());
		}
	}
	
	@Test
	public void test2() {
		//MMRMMRMRRM
		List<Deplacement> lstDep = Arrays.asList(new DeplacementM(),
				new DeplacementM(),new DeplacementR(),new DeplacementM(),
				new DeplacementM(),new DeplacementR(),
				new DeplacementM(),new DeplacementR(),new DeplacementR(),new DeplacementM());
		robot.setPlatToExplor(new Plateau(5, 5));
		Ordre ordre = new Ordre(new Point2D(3, 3), Orientation.E, lstDep);
		try {
			robot.execOrder(ordre);
			assertEquals(robot.getPosition().x,5);
			assertEquals(robot.getPosition().y,1);
			assertEquals(robot.getOrientation(), Orientation.E);
		} catch (OverBoundsException e) {
			System.err.println(e.toString());
		}
	}

}
