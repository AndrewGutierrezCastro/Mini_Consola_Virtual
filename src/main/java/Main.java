import java.awt.EventQueue;
import java.io.IOException;
import java.util.Scanner;
import controlador.DispositivoEntrada;
import pantalla.controlador.ControladorPantalla;
import pantalla.vista.VistaPantalla;


public class Main {

	public static void main(String[] args) {
		
		main2(args);
		DispositivoEntrada dp = new DispositivoEntrada();
		System.out.println("Hola mundo");
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
		String str;
		str = sc.nextLine();
		dp.enviarMensaje(str);
		while((str = sc.nextLine()) != "q") {
			dp.enviarMensaje(str);
			
		}
		
		
	}

	public static void main2(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorPantalla ctPan = new ControladorPantalla();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
