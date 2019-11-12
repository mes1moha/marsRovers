package pack01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import pack01.exception.LectureConfigPlatequException;
import pack01.exception.LectureDeplacementException;
import pack01.exception.LectureOrientationException;
import pack01.exception.LecturePtDepartException;

public class ParserFileConfig {
	private File fileInputConfig;
	private Scanner scFileConfig;
	
	public ParserFileConfig(String pathFile) throws FileNotFoundException {
		super();
		fileInputConfig = new File(pathFile);
		scFileConfig = new Scanner(fileInputConfig);
	}
	
	public void closeScanner() {
		this.scFileConfig.close();
	}
	
	public static Deplacement charToDeplacement(char carDep) {
		Deplacement dep = null;
			switch (carDep) {
			case 'M':
				dep= new DeplacementM();	break;
			case 'L':
				dep= new DeplacementL();	break;
			case 'R':
				dep= new DeplacementR();	break;
			}
		return dep;
	}
	
	public Plateau getPlateau() throws LectureConfigPlatequException {
		try {
			return new Plateau( scFileConfig.nextInt(), scFileConfig.nextInt() );
		} catch (InputMismatchException e) {
			throw new LectureConfigPlatequException("Erreur de lecture des "
					+ "informations du plateau");
		}
	}
	
	public Point2D getPointDepart() throws LecturePtDepartException {
		Point2D ptInit = null;
		int x, y;
		try {
			x = scFileConfig.nextInt();
			y = scFileConfig.nextInt();
			ptInit = new Point2D(x,y);
		} catch (InputMismatchException e) {
			throw new LecturePtDepartException("Erreur de lecture des "
					+ "coordonnées de départ");
		}
		return ptInit;
	}
	
	
	public Orientation getOrientation() throws LectureOrientationException {
		try {
			String matchedOrientation = this.scFileConfig.next("[NESO]{1}");
			return Orientation.valueOf(matchedOrientation);
		} catch (NoSuchElementException e) {
			throw new LectureOrientationException("getOrientation : Impossible"
					+ " de récuperer l'orientation");
		}
		
	}
	
	public List<Deplacement> getDeplacements() throws LectureDeplacementException
	{
		List<Deplacement> lstDep = new ArrayList<>();
		try {
			String strDep = scFileConfig.next("[LRM]+");
			
			char[] deplacements;
			
			if(!strDep.isEmpty()) {
				deplacements = strDep.toCharArray();
				for (int i = 0; i < deplacements.length; i++) 
					lstDep.add(charToDeplacement(deplacements[i]));
			}
		} catch (NoSuchElementException e) {
			throw new LectureDeplacementException("getDeplacements : Impossible "
					+ "de récuperer l'ensemble des deplacements. "
					+ "Deplacement Inconnue : "+ scFileConfig.next());
		}		
		return lstDep;
	}
	
	public List<Ordre> getListOrder() throws LecturePtDepartException, LectureOrientationException, LectureDeplacementException  {
		List<Ordre> lstOrdre= new ArrayList<Ordre>();
		Ordre tmpOrdre;
		while(scFileConfig.hasNext())
		{
			tmpOrdre = new Ordre(getPointDepart(),getOrientation(), getDeplacements());
			lstOrdre.add(tmpOrdre);
		}
		return lstOrdre;
	}
	
}
