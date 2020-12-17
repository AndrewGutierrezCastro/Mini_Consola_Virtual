package controlador;
import java.io.IOException;
import java.net.UnknownHostException;

import comunicacion.Cliente;
import comunicacion.Comando;
import comunicacion.CreadorObjetos;

public class DispositivoEntrada {
	private Cliente cliente;
	
	public DispositivoEntrada() {
		try {
			cliente = new Cliente(ConstantesComunicacion.Controlador_Consola);
			cliente.abrirSocket();
		} catch (UnknownHostException e) {
			System.err.println("Dispositivo entrada: No se encuentra el host");
		} catch (IOException e) {
			System.err.println("Dispositivo entrada: Error de IO");
			e.printStackTrace();
		}
	}
	
	public void enviarComando(Comando comando) {
		String json = CreadorObjetos.getJson(comando);
		cliente.enviarMensaje(json);
	}
	
	
	
}
