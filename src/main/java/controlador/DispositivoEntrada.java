package controlador;
import java.io.IOException;
import java.net.UnknownHostException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import comunicacion.Cliente;

public class DispositivoEntrada {
	private Cliente cliente;

	public DispositivoEntrada() {
		try {
			cliente = new Cliente(ConstantesComunicacion.Controlador_Consola);
		} catch (UnknownHostException e) {
			System.err.println("Dispositivo entrada: No se encuentra el host");
		} catch (IOException e) {
			System.err.println("Dispositivo entrada: Error de IO");
			e.printStackTrace();
		}
	}
	
	public void enviarMensaje(String pMensaje) {
		cliente.enviarMensaje(pMensaje);
	}
	
	
}
