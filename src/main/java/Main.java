import java.awt.EventQueue;
import Helpers.Tamanno;
import consola.Consola;
import controlador.DispositivoEntrada;
import controlador.Teclado;
import pacman.modelo.Pacman;
import pantalla.controlador.ControladorPantalla;
import spaceInvader.modelo.SpaceInvader;

public class Main {

	public static void main(String[] args) {
		
		main2(args); 
		main3(args);
		
		DispositivoEntrada dp = new Teclado();
		  //DispositivoEntrada dp = new Teclado();
		  //System.out.println("Hola mundo"); 
			
			  
		  
		  
	}

	public static void main2(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorPantalla ctPan = new ControladorPantalla(Tamanno.NORMAL);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main3(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Consola consola = new Pacman();
					Consola consola = new SpaceInvader(Tamanno.NORMAL);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
