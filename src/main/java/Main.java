import java.awt.EventQueue;

import consola.Consola;
import controlador.DispositivoEntrada;
import controlador.Teclado;
import pantalla.controlador.ControladorPantalla;

public class Main {

	public static void main(String[] args) {
		
		
		  main2(args); 
		  DispositivoEntrada dp = new Teclado();
		  System.out.println("Hola mundo"); 
			/*
			 * FileReader file =
			 * ManejoArchivo.readJson(TipoComando.ACTUALIZARPANTALLA.toString()); Comando
			 * comando = CreadorObjetos.getComando(file); String str =
			 * CreadorObjetos.getJson(comando); dp.enviarMensaje(str);
			 */ 
		  
		  
	}

	public static void main2(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ControladorPantalla ctPan = new ControladorPantalla();
					Consola consola = new Consola();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
