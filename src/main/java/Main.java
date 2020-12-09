import java.util.Scanner;

import consola.modelo.Tetris;
import controlador.DispositivoEntrada;
import pantalla.vista.Pantalla;

public class Main {

	public static void main(String[] args) {
		Pantalla.main(args);
		// TODO Auto-generated method stub
		
		DispositivoEntrada dp = new DispositivoEntrada();
		System.out.println("Hola mundo");
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		String str;
		while((str = sc.nextLine()) != "q") {
			dp.enviarMensaje(str);
		}
		
		
	}

}
