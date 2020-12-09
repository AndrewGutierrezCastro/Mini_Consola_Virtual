package comunicacion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import controlador.ConstantesComunicacion;

public class Servidor implements ConstantesComunicacion{
	/* Clase: Servidor
	 * La clase para recibir informacion de un cliente
	 * 
	 * */
	private String mensaje; 				//atributo donde el mensaje se va a recibir el mensaje
	protected ServerSocket serverSocket;	//Socket del servidor
	protected Socket clienteSocket; //socket que va a utilizar el cliente
	protected DataOutputStream salidaCliente; //La salida de datos de cliente
	public Servidor(int pPuerto) throws IOException {
		serverSocket = new ServerSocket(pPuerto); //Puerto es un numero constante
		//de la interfaz de constantes para comunicacion.
		clienteSocket = new Socket();
	}
	public void esperarMensaje() {
		//Necesario para recibir el mensaje del cliente
		InputStream inputStream; 
		InputStreamReader inputStreamReader;
		BufferedReader entrada;
		
		try {
			//Aceptar al cliente
			clienteSocket = serverSocket.accept();
			
			
			//enviar una respuesta al cliente que se acepto en el socket
			//TODO revisar enviarRespuesta();
			System.out.println("Respuesta enviada");
			inputStream = clienteSocket.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			entrada = new BufferedReader(inputStreamReader);
			
			String linea;
			mensaje = "";
			while((linea = entrada.readLine()) != null) //Mientras haya lineas desde el cliente
            {
                mensaje += linea;//formar linea a linea el mensaje
                
            }
			System.out.println("mensaje recibido Server");
			
		} catch (IOException e) {
			System.err.println("No se pudo recibir el mensaje del cliente");
		}
		
		
	}
	
	private void enviarRespuesta() throws IOException {
		//obtener el flujo de informacion para enviarle mensajes
		OutputStream outputStream = clienteSocket.getOutputStream();
		salidaCliente = new DataOutputStream(outputStream);
		salidaCliente.writeChars("Mensaje respuesta del puerto: "+serverSocket.getLocalPort());
		
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
