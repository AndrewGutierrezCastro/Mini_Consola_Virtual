package comunicacion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import controlador.ConstantesComunicacion;

public class Cliente implements ConstantesComunicacion{
	
	protected Socket clienteSocket; //socket que va a utilizar el cliente
	protected DataOutputStream salidaServidor; //La salida de datos de servidor
	private String respuesta;//respuesta del servidor
	private int puerto;
	public Cliente(int pPuerto) throws UnknownHostException, IOException {
		puerto = pPuerto;
	}
	
	public void enviarMensaje(String pMensaje) {
		//necesario para enviar el mensaje al servidor
		OutputStream streamOutput;
		
		try {
			abrirSocket();
			
			//enviar el mensaje al servidor
			streamOutput = clienteSocket.getOutputStream();
			salidaServidor = new DataOutputStream(streamOutput);
			salidaServidor.writeBytes(pMensaje);
			
			cerrarSocket();
		} catch (IOException e) {
			System.err.println("Error al enviar el mensaje: "+pMensaje);
			System.out.println("Puerto: "+puerto);
		}
		

	}
	
	private void recibirRespuesta() throws IOException {
		//necesario para recibir mensajes del servidor
		InputStream inputStream; 
		InputStreamReader inputStreamReader;
		BufferedReader response;
		
		//Recibir el mensaje de respuesta del servidor
		inputStream = clienteSocket.getInputStream();	
		inputStreamReader = new InputStreamReader(inputStream);
		response = new BufferedReader(inputStreamReader);
		String linea;
		respuesta = "";
		
		while((linea = response.readLine()) != null) {	
			respuesta += linea;
			
		}
	}
	
	public void abrirSocket() throws UnknownHostException, IOException {
		if(clienteSocket == null || clienteSocket.isClosed()) {
			clienteSocket = new Socket(HOST, puerto);}
	}
	
	public void cerrarSocket() throws IOException {
		clienteSocket.close();
	}
	
	public String getRespuesta() {
		return respuesta;
	}
}
