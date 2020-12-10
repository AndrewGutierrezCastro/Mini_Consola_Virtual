package Helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManejoArchivo {
	
	private final static String path = System.getProperty("user.dir")+"//Archivos//";
	
	public static void writeText(String pNombre, String pCuerpo){
		try {
			FileWriter myWriter = new FileWriter(path + pNombre + ".txt");
		    myWriter.write(pCuerpo);
		    myWriter.close();
		    System.out.println("Successfully wrote to the file " + pNombre);
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	public static String readText(String pNombre) {
		String data = "Vacio"; 
		try {
		  File myObj = new File(path + pNombre + ".txt");
		  Scanner myReader = new Scanner(myObj);	
		  data = "";
		  while (myReader.hasNextLine()) {
		    data += myReader.nextLine();
		    }
		  myReader.close();
		} catch (FileNotFoundException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
		 return data;
	}
	
	public static FileReader readJson(String pNombre) {
		FileReader fileReader = null;
		try {
		  fileReader = new FileReader(path+pNombre+".json");
		} catch (FileNotFoundException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
		return fileReader;
	}
}
