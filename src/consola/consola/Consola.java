package consola;

import java.io.IOException;
import java.util.ArrayList;
import comunicacion.Cliente;
import comunicacion.Comando;
import comunicacion.Servidor;
import controlador.ConstantesComunicacion;

public class Consola {
	
	public ArrayList<String> colaRawComandos;
	protected ArrayList<Comando> colaComandos;
	
	private Servidor servidor;
	private Cliente cliente;
	
	private Controlador_Consola controlador_Consola;
	private Consola_Pantalla consola_Pantalla;
	
	private Thread hilo_Controlador_Consola,
	   			   hilo_Consola_Pantalla;
	
	public Consola() {
		colaRawComandos = new ArrayList<String>();
		colaComandos = new ArrayList<Comando>();
		
		crearComunicaciones();
		
		controlador_Consola = new Controlador_Consola(colaRawComandos, servidor);
		consola_Pantalla = new Consola_Pantalla(colaComandos, cliente);
		
		hilo_Controlador_Consola = new Thread(controlador_Consola);
		hilo_Consola_Pantalla = new Thread(consola_Pantalla);
		
		hilo_Consola_Pantalla.start();
		hilo_Controlador_Consola.start();

	}
	
	private void crearComunicaciones() {
		try {
			servidor = new Servidor(ConstantesComunicacion.Controlador_Consola);		
			cliente = new Cliente(ConstantesComunicacion.Consola_Pantalla);
			
			cliente.abrirSocket();
			servidor.aceptarCliente();
		} catch (IOException e) {
			System.out.println("La consola tuvo un error al intentar establecer conexion con la pantalla o el controlador");
			e.printStackTrace();
		}
		
	}
	
	
	
}
