import java.awt.EventQueue;

import Helpers.Tamanno;
import consola.Consola;
import controlador.DispositivoEntrada;
import controlador.Teclado;
import pantalla.controlador.ControladorPantalla;
import spaceInvader.modelo.SpaceInvader;

public class Main {

	public static void main(String[] args) {
		
		
		  main2(args); 
		  DispositivoEntrada dp = new Teclado();
		  //System.out.println("Hola mundo"); 
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
					ControladorPantalla ctPan = new ControladorPantalla(Tamanno.NORMAL);
					Consola consola = new SpaceInvader(Tamanno.NORMAL);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
