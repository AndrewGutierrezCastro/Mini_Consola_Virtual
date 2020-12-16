package consola;

import java.util.ArrayList;

import comunicacion.Cliente;
import comunicacion.Comando;
import comunicacion.CreadorObjetos;


public class Consola_Pantalla implements Runnable{
	
	public ArrayList<Comando> colaComandos;
	private Cliente cliente;	
	
	public Consola_Pantalla(ArrayList<Comando> colaComandos, Cliente cliente) {
		super();
		this.colaComandos = colaComandos;
		this.cliente = cliente;
	}

	@Override
	public void run() {
		// TODO revisar lo que en comandos y enviarlo a la pantalla
		String mensaje;
		Comando comando;
		while(true) {		
			try {
				Thread.sleep(1);
				if(colaComandos.size() > 0) {
					comando = colaComandos.remove(0);
					mensaje = CreadorObjetos.getJson(comando);
					cliente.enviarMensaje(mensaje);
					//System.out.println("enviando: "+comando);
				}
			} catch (InterruptedException e) {
				System.out.println("No se pudo ejecutar el comando");
			}
		}
	}

}