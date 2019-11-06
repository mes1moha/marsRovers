package pack01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ParserFileConfig {
	private File fileInputConfig;
	private Scanner scFileConfig;
	
	public ParserFileConfig(String pathFile) throws FileNotFoundException {
		super();
		fileInputConfig = new File(pathFile);
		scFileConfig = new Scanner(fileInputConfig);
	}
	
	public Deplacement charToDeplacement(char carDep) {
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
	
	public Plateau getPlateau() throws Exception {
		Plateau plateau ;
		try {
			return new Plateau( scFileConfig.nextInt(), scFileConfig.nextInt() );
		} catch (InputMismatchException e) {
			throw new Exception("Erreur de lecture des informations du plateau");
		}
	}
	
	public Point2D getPointDepart() throws Exception {
		Point2D ptInit = null;
		int x, y;
		try {
			x = scFileConfig.nextInt();
			y = scFileConfig.nextInt();
			ptInit = new Point2D(x,y);
		} catch (InputMismatchException e) {
			throw new Exception("Erreur de lecture des coordonnées de départ");
		}
		return ptInit;
	}
	
	
	public Orientation getOrientation() throws Exception {
		try {
			String matchedOrientation = this.scFileConfig.next("[NESO]{1}");
			return Orientation.valueOf(matchedOrientation);
		} catch (NoSuchElementException e) {
			throw new Exception("getOrientation : Impossible de récuperer l'orientation");
		}
		
	}
	
	public List<Deplacement> getDeplacements() throws Exception
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
			throw new Exception("getOrientation : Impossible de récuperer l'ensemble des deplacements. Deplacement Inconnue");
		}		
		return lstDep;
	}
	
	public List<Ordre> getListOrder() throws Exception {
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
