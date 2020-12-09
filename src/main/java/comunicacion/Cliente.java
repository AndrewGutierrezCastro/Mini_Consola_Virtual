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
			
			//TODO revisar recibirRespuesta();
			//System.out.println(respuesta);
			
			//enviar el mensaje al servidor
			streamOutput = clienteSocket.getOutputStream();
			salidaServidor = new DataOutputStream(streamOutput);
			salidaServidor.writeChars(pMensaje);
			System.out.println("Info enviada");
			clienteSocket.close();
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
		
		//while((linea = response.readLine()) != null) {
		System.out.println("Recibir respuesta Cliente");	
		 System.out.println(response.read());
			
		//}
	}
	
	private void abrirSocket() throws UnknownHostException, IOException {
		if(clienteSocket == null || clienteSocket.isClosed()) {
			clienteSocket = new Socket(HOST, puerto);}
	}
	
	public String getRespuesta() {
		return respuesta;
	}
}
