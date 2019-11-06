package pack01;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ordre {
	
	private Point2D ptInit;
	private Orientation orientationDepart;
	private List<Deplacement> suiteDeplacements;
	
	public Ordre(Point2D ptInit, Orientation orientationDepart, List<Deplacement> suiteDeplacements) {
		super();
		this.ptInit = ptInit;
		this.orientationDepart = orientationDepart;
		this.suiteDeplacements = suiteDeplacements;
	}

	public void stringToListOrdre(String listOrdre) {
		List<Ordre> lstOrdre= new ArrayList<Ordre>();
		String[] tabOrdre = listOrdre.split(" ");
		
	}
	
	// Getters and Setters
	public Point2D getPtInit() {
		return ptInit;
	}
	
	public List<Deplacement> getSuiteDeplacements() {
		return suiteDeplacements;
	}

	public Orientation getOrientationDepart() {
		return orientationDepart;
	}

	public void setOrientationDepart(Orientation orientationDepart) {
		this.orientationDepart = orientationDepart;
	}

	@Override
	public String toString() {
		return "Ordre [ptInit=" + ptInit + ", orientationDepart=" + orientationDepart + ", suiteDeplacements="
				+ suiteDeplacements + "]";
	}
	
	
	
}
