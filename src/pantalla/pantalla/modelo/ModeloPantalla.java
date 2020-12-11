package pantalla.modelo;

import java.io.IOException;
import java.util.ArrayList;

import Helpers.Tamanno;
import comunicacion.Comando;
import comunicacion.CreadorObjetos;
import comunicacion.Servidor;
import controlador.ConstantesComunicacion;

public class ModeloPantalla implements Runnable{
	/* Esta clase es el modelo del MVC de la pantalla
	 * */
	public Tablero tablero;
	public ArrayList<String> colaRawComandos;
	public ArrayList<Comando> colaComandos;
	private Thread hilo;//Este hilo se encarga de escuchar solicitudes y sumarlas a la cola
	//recibe informacion entonces debe usar servidor
	public Servidor servidor;
	public ModeloPantalla() {
		tablero = new Tablero(Tamanno.NORMAL);
		colaComandos = new ArrayList<Comando>();
		colaRawComandos = new ArrayList<String>();
		crearServidor();
		//se crea el hilo y se inicia
		hilo = new Thread(this);
		hilo.start();
	}
	
	public void cambiarTamannoTablero(Tamanno tamanno) {
		tablero.crearTablero(tamanno);
	}
	
	private void crearServidor() {
		try {
			servidor = new Servidor(ConstantesComunicacion.Consola_Pantalla);
		} catch (IOException e) {
			System.out.println("No se puede crear el servidor en Modelo de pantalla");
		}
	}
	
	@Override
	public void run() {
		
		while(true) {		
			try {
				Thread.sleep(100);
				recibirInformacion();
			} catch (InterruptedException e) {
				System.out.println("No se puedo instanciar el comando");
				e.printStackTrace();
			}
		}
		
	}
	
	private void recibirInformacion() {
		try {
			servidor.aceptarCliente();
			servidor.esperarMensaje();
			servidor.cerrarCliente();
			colaRawComandos.add(servidor.getMensaje());
		} catch (IOException e) {
			System.out.println("Ocurrio un error recibiendo el mensaje en el Modelo de la Pantalla");
			e.printStackTrace();
		}
	}
	
}
