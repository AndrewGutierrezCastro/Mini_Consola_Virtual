package Helpers;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ManejoImagenes {
	
	private static int ancho = 20, alto = 20; //filas y columnas
	
	public static Icon getImagen(String nombreImagen, String extension, int anchoRoot, int altoRoot) {
		
		String path = System.getProperty("user.dir")+"/Imagenes/"+nombreImagen+extension;
		File archivoImagen = new File(path);
		ImageIcon iconoImagen = null;
		Image IconReescalada = null;
		int x,y;
		x = (anchoRoot - ancho*5 )/ ancho;
		y = (altoRoot - alto*5 )/ alto;
		try {
			  
			iconoImagen = new ImageIcon(ImageIO.read(archivoImagen));
			IconReescalada = iconoImagen.getImage();
			Image newimg = IconReescalada.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			iconoImagen = new ImageIcon(newimg);
		} catch (IOException e) {
			System.out.print(e.getMessage());
			System.out.println(" No se pudo cargar la imagen, " + nombreImagen +" "+path );
			
		}
		return iconoImagen;
	}
	public static Icon getImagenResized(String nombreImagen, String extension, int anchoRoot, int altoRoot) {
		
		String path = System.getProperty("user.dir")+"/Imagenes/"+nombreImagen+extension;
		File archivoImagen = new File(path);
		ImageIcon iconoImagen = null;
		Image IconReescalada = null;

		try {	  
			iconoImagen = new ImageIcon(ImageIO.read(archivoImagen));
			IconReescalada = iconoImagen.getImage();
			Image newimg = IconReescalada.getScaledInstance(anchoRoot, altoRoot,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
			iconoImagen = new ImageIcon(newimg);
		} catch (IOException e) {
			System.out.print(e.getMessage());
			System.out.println(" No se pudo cargar la imagen, " + nombreImagen +" "+path );
			
		}
		return iconoImagen;
	}
}
