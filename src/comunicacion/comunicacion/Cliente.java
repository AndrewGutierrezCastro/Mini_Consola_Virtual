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
	private OutputStream streamOutput;
	
	public Cliente(int pPuerto) throws UnknownHostException, IOException {
		puerto = pPuerto;	
		
	}
	
	public void enviarMensaje(String pMensaje) {
		//necesario para enviar el mensaje al servidor
		try {
			//enviar el mensaje al servidor
			
			salidaServidor.writeBytes(pMensaje+"\n");
			salidaServidor.flush();
			//System.out.println("Cliente"+pMensaje);
			//System.out.println("Mensaje enviado");
			
			
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
		
		//Instanciar el Output de info
		streamOutput = clienteSocket.getOutputStream();
		salidaServidor = new DataOutputStream(streamOutput);

		System.out.println("Socket abierto");
	}
	
	public void cerrarSocket() throws IOException {
		clienteSocket.close();
	}
	
	public String getRespuesta() {
		return respuesta;
	}
}

