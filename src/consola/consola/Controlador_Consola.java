package consola;

import java.io.IOException;
import java.util.ArrayList;
import comunicacion.Servidor;

public class Controlador_Consola implements Runnable{

	public ArrayList<String> colaRawComandos;
	public Servidor servidor;
	
	
	
	public Controlador_Consola(ArrayList<String> colaRawComandos, Servidor servidor) {
		super();
		this.colaRawComandos = colaRawComandos;
		this.servidor = servidor;
	}



	@Override
	public void run() {
		// TODO escuchar lo que venga del controlador y meterlo a RawComandos

		while(true) {		
			try {
				Thread.sleep(10);
				
				recibirInformacion();
				//System.out.println(colaRawComandos.get(0));
				
			} catch (InterruptedException e) {
				System.out.println("No se pudo ejecutar el comando");
			}
		}
	}
	
	private void recibirInformacion() {
		//servidor.aceptarCliente();
		servidor.esperarMensaje();
		//servidor.cerrarCliente();
		colaRawComandos.add(servidor.getMensaje());
	}

}
